import os
import re
import requests
import time

from scraper_constants import *

class SolutionScraper():
    def __init__(self, questions, max_retries=10, backoff_factor=60):
        self.max_retries = max_retries
        self.backoff_factor = backoff_factor
        with open(questions, 'r') as file:
            self.questions = dict(
                (k.strip(), v.strip())
                for k, v in (item.split(':') for item in file.read().strip().split(', '))
            )

    def question_count(self):
        return len(self.questions)

    def scrape_solutions(self, solution_count=150, question_count=-1, offset=0):
        if question_count == -1 or question_count > len(self.questions):
            question_count = len(self.questions)
        
        question_idx = 0
        for question, header in list(self.questions.items())[offset:]:
            if question_idx == question_count:
                break
            question_folder = SOLUTION_DIR + question
            if (os.path.exists(question_folder)):
                print(f'Skipped question #{question_idx + offset + 1}: {question}')
                question_idx += 1
                continue

            os.makedirs(question_folder)

            i = 0
            page_idx = 0
            solutions = set()
            while i < solution_count:
                original_i = i
                solution_ids = scrape_solution_ids(question, 
                                                   skip=page_idx * solution_count * 2, 
                                                   count=solution_count * 2,
                                                   max_retries=self.max_retries,
                                                   backoff_factor=self.backoff_factor)
                for solution_id in solution_ids:
                    if i == solution_count:
                        break
                    if solution_id in solutions:
                        continue
                    solutions.add(solution_id)
                    for solution in scrape_solution_code(solution_id, 
                                                         header, 
                                                         max_retries=self.max_retries, 
                                                         backoff_factor=self.backoff_factor):
                        if i == solution_count:
                            break
                        path = os.path.join(question_folder, f'{question}-{i + 1}.txt')
                        with open(path, "w") as file:
                            file.write(solution)
                        i += 1
                if original_i == i:  # no progress was made => no more solutions remain
                    break
                page_idx += 1
            
            print(f'Scraped {i} solutions for question #{question_idx + offset + 1}: {question}')
            question_idx += 1


def scrape_solution_code(solution_id, header, max_retries, backoff_factor):
    retries = 0

    while True:
        response = requests.post(LEETCODE_GRAPHQL_URL, 
            json = {
                "query": communitySolution_query, 
                "variables": {
                    "topicId": solution_id
                }
            },
            headers = HEADERS)
        
        if response.status_code == 200:
            data = response.json()
            solution_raw = None
            solutions = []

            if data is None:  # error: the topic doesn't exist
                return solutions

            if data['data'].get('topic') and 'post' in data['data']['topic']:
                solution_raw = data['data']['topic']['post']['content']
            else:
                return solutions

            # Use regular expression to find text between triple backticks (code blocks)
            code_blocks = re.findall(r'```(.*?)```', solution_raw, re.DOTALL)

            for code_block in code_blocks:
                if header.lower() not in code_block.lower(): # not a solution
                    continue
                code_block = re.sub(r'[\x00-\x1F]+', '', code_block) # fix control sequences
                code_block = code_block.replace("\\n", "\n")  # fix newlines
                code_block = code_block.replace("\\t", "\t")  # fix tabs
                code_block = code_block.replace("\\'", "'")  # fix apostrophes
                code_block = code_block.replace("\\\\'", "\\")  # fix backslashes
                
                language_header = code_block.splitlines()[0].strip().lower()
                if (language_header in LANGUAGE_MAPPINGS):  # language header found
                    code_block = re.sub(r'^.*\n', '', code_block, count=1)  # remove first line, i.e. language header
                solutions.append(code_block)
            
            return solutions
        elif response.status_code == 429:
            retries += 1
            if retries > max_retries:
                print("Max retries reached. Exiting.")
                return []
            wait_time = backoff_factor * (2 ** (retries - 1))
            print(f"Rate limit hit. Retrying in {wait_time} seconds...")
            time.sleep(wait_time)
        else:
            print(f"Scraping solution for solution_id = {solution_id} failed with status code {response.status_code}")
            time.sleep(5)


def scrape_solution_ids(question_name, skip, count, max_retries, backoff_factor):
    retries = 0

    while True:
        response = requests.post(LEETCODE_GRAPHQL_URL, 
            json = {
                "query": communitySolutions_query, 
                "variables": {
                    "query": "",
                    "languageTags": "",
                    "topicTags": "",
                    "questionSlug": question_name,
                    "skip": skip,
                    "first": count,
                    "orderBy": "hot"
                }
            },
            headers = HEADERS)

        if response.status_code == 200:
            data = response.json()
            solutions = data['data']['questionSolutions']['solutions']

            solution_ids = []
            for solution in solutions:
                solution_ids.append(solution['id'])
            
            return solution_ids
        elif response.status_code == 429:
            retries += 1
            if retries > max_retries:
                print("Max retries reached. Exiting.")
                return []
            wait_time = backoff_factor * (2 ** (retries - 1))
            print(f"Rate limit hit. Retrying in {wait_time} seconds...")
            time.sleep(wait_time)
        else:
            print(f"Scraping solution ids for {question_name} failed with status code {response.status_code}")
            time.sleep(5)


def main():
    scraper = SolutionScraper(REGULAR_QUESTIONS)
    print(f'Loaded {scraper.question_count()} questions...')
    scraper.scrape_solutions()
    print('Done!')


if __name__ == "__main__":
    main()