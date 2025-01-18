import requests

from scraper_constants import *

class QuestionScraper():
    def __init__(self):
        self.regular_questions = set()
        self.premium_questions = set()
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
                    if is_premium:
                        self.premium_questions.add(name)
                    else:
                        self.regular_questions.add(name)
                    self.last_question = name
                
                previous_questions = self.total_questions
                self.total_questions = len(self.regular_questions) + len(self.premium_questions)
                if previous_questions == self.total_questions:
                    print('Done!')
                    break
            else:
                print(f'Request failed with status code {response.status_code}: {response.text}')

    def dump_questions(self):
        print(f'Regular questions ({len(self.regular_questions)}):')
        print(', '.join(question for question in sorted(self.regular_questions)))
        print(f'Premium questions ({len(self.premium_questions)}):')
        print(', '.join(question for question in sorted(self.premium_questions)))


def main():
    scraper = QuestionScraper()
    scraper.scrape_questions()
    scraper.dump_questions()

if __name__ == "__main__":
    main()