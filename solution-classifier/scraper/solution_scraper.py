import os
import re
import requests

from scraper_constants import *

class SolutionScraper():
    def __init__(self, questions):
        with open(questions, 'r') as file:
            self.questions = file.read().strip().split(',')
            self.questions = [q.strip() for q in self.questions]

    def scrape_solutions(self, language, solution_count=10, question_count=-1):
        if question_count == -1 or question_count > len(self.questions):
            question_count = len(self.questions)
        for question in self.questions[:question_count]:
            question_folder = SOLUTION_DIR + f'{str(language)}/{question}'
            if (os.path.exists(question_folder)):
                print(f'Skipped {question}, reason: already scraped')
                continue

            os.makedirs(question_folder)

            i = 0
            page_idx = 0
            solutions = set()
            while i < solution_count:
                original_i = i
                solution_ids = scrape_solution_ids(question, language, 
                                                   skip=page_idx * solution_count * 2, 
                                                   count=solution_count * 2)
                for solution_id in solution_ids:
                    if i == solution_count:
                        break
                    if solution_id in solutions:
                        continue
                    solutions.add(solution_id)
                    for solution in scrape_solution_code(solution_id, language):
                        if i == solution_count:
                            break
                        path = os.path.join(question_folder, f'{question}-{i + 1}.txt')
                        with open(path, "w") as file:
                            file.write(solution)
                        i += 1
                if original_i == i:  # no progress was made => no more solutions remain
                    break
                page_idx += 1
            
            print(f'Scraped {i} LeetCode solutions to {question_folder}')


def scrape_solution_code(solution_id, language):
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
            code_block = code_block.replace("\\n", "\n")  # fix newlines
            code_block = code_block.replace("\\t", "\t")  # fix tabs
            code_block = code_block.replace("\'", "'")  # fix apostrophes
            
            language_header = code_block.splitlines()[0].strip().lower()
            if (language_header in LANGUAGE_MAPPINGS and LANGUAGE_MAPPINGS[language_header] == language):  # language matches
                code_block = re.sub(r'^.*\n', '', code_block, count=1)  # remove first line, i.e. language header
                solutions.append(code_block)
        
        return solutions
    else:
        print(f"Request failed with status code {response.status_code}: {response.text}")


def scrape_solution_ids(question_name, language, skip, count):
    response = requests.post(LEETCODE_GRAPHQL_URL, 
        json = {
            "query": communitySolutions_query, 
            "variables": {
                "query": "",
                "languageTags": str(language),
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
    else:
        print(f"Request failed with status code {response.status_code}: {response.text}")


def main():
    scraper = SolutionScraper(REGULAR_QUESTIONS)
    scraper.scrape_solutions(Language.JAVA, question_count=3)
    scraper.scrape_solutions(Language.CPP, question_count=3)
    scraper.scrape_solutions(Language.C, question_count=3)
    scraper.scrape_solutions(Language.CSHARP, question_count=3)
    scraper.scrape_solutions(Language.PYTHON, question_count=3)
    scraper.scrape_solutions(Language.JS, question_count=3)
    scraper.scrape_solutions(Language.TS, question_count=3)
    scraper.scrape_solutions(Language.GO, question_count=3)

if __name__ == "__main__":
    main()