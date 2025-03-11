import requests
import json
import re

from .scraper_constants import *

class QuestionScraper():
    def __init__(self):
        self.regular_questions = {}
        self.premium_questions = {}
        self.total_questions = 0
        self.last_question = 'two-sum'

    def scrape_questions(self):
        print(f'Scraping all LeetCode questions...')
        while True:
            response = requests.post(LEETCODE_GRAPHQL_URL, 
                json = {
                    "query": panelQuestionList_query, 
                    "variables": {
                        "currentQuestionSlug": self.last_question
                    }
                },
                headers = HEADERS)
            
            if response.status_code == 200:
                data = response.json()
                questions = data['data']['panelQuestionList']['questions']

                for q in questions:
                    is_premium = q['paidOnly']
                    name = q['titleSlug']
                    id = int(q['id'])
                    self.last_question = name

                    if name in self.premium_questions or name in self.regular_questions:
                        continue
                    # header = scrape_question_header(name)
                    # if header is None:  # question header could not be found => question is a db question
                    #     continue
                    
                    if is_premium:
                        self.premium_questions[name] = (id)
                    else:
                        self.regular_questions[name] = (id)
                    
                    print(f'Scraped {name}, id: {id}')
                
                previous_questions = self.total_questions
                self.total_questions = len(self.regular_questions) + len(self.premium_questions)
                if previous_questions == self.total_questions:
                    self.regular_questions = dict(sorted(self.regular_questions.items()))
                    self.premium_questions = dict(sorted(self.premium_questions.items()))
                    print('Done!')
                    break
            else:
                print(f'Request failed with status code {response.status_code}: {response.text}')

    def dump_questions(self):
        print(f'Regular questions ({len(self.regular_questions)}):')
        print(', '.join(f'{q}:{header}' for q, header in self.regular_questions.items()))
        print(f'Premium questions ({len(self.premium_questions)}):')
        print(', '.join(f'{q}:{header}' for q, header in self.premium_questions.items()))

def scrape_question_header(question_name):
    response = requests.post(LEETCODE_GRAPHQL_URL, 
        json = {
            "query": consolePanelConfig_query, 
            "variables": {
                "titleSlug": question_name
            }
        },
        headers = HEADERS)
    
    if response.status_code == 200:
        data = response.json()
        metadata = data['data']['question']['metaData']
        metadata = re.sub(r'[\x00-\x1F]+', '', metadata)
        metadata_json = json.loads(metadata)
        if 'database' in metadata_json and metadata_json['database']:
            return None
        if 'manual' in metadata_json and metadata_json['manual']:
            return None
        if 'name' in metadata_json:
            return metadata_json['name']
        if 'classname' in metadata_json:
            return metadata_json['classname']
        else:
            return None
    else:
        print(f'Request failed with status code {response.status_code}: {response.text}')

def main():
    scraper = QuestionScraper()
    scraper.scrape_questions()
    scraper.dump_questions()

if __name__ == "__main__":
    main()