from model_constants import *
from solution_classifier.scraper.question_scraper import QuestionScraper

def main():
    scraper = QuestionScraper()
    scraper.scrape_questions()

    question_ids = {}
    supported_questions = set(QUESTIONS)
    for question_name, id in scraper.regular_questions.items():
        if question_name in supported_questions:
            question_ids[question_name] = id
    
    with open("output.txt", "w") as file:
        for k, v in question_ids.items():
            file.write(f"\"{k}\": {v},\n")

if __name__ == "__main__":
    main()