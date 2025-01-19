from enum import Enum

class Language(Enum):
    JAVA = 1
    CPP = 2
    C = 3
    CSHARP = 4
    PYTHON = 5
    JS = 6
    TS = 7
    GO = 8

    def __str__(self):
        return self.name.lower()

LANGUAGE_MAPPINGS = {
    "java []": Language.JAVA,
    "c++ []": Language.CPP,
    "cpp []": Language.CPP,
    "c []": Language.C,
    "clang []": Language.C,
    "csharp []": Language.CSHARP,
    "c# []": Language.CSHARP,
    "python3 []": Language.PYTHON,
    "python []": Language.PYTHON,
    "javascript []": Language.JS,
    "js []": Language.JS,
    "typescript []": Language.TS,
    "ts []": Language.TS,
    "go []": Language.GO,
    "golang []": Language.GO
}

SOLUTION_DIR = "../solutions/"
REGULAR_QUESTIONS = "../questions/regular_questions.txt"
PREMIUM_QUESTIONS = "../questions/premium_questions.txt"

LEETCODE_GRAPHQL_URL = "https://leetcode.com/graphql/"

HEADERS = {
    "Content-Type": "application/json",
    "User-Agent": "Mozilla/5.0",
    "Origin": "https://leetcode.com"
}

panelQuestionList_query = """
query panelQuestionList($currentQuestionSlug: String!, $categorySlug: String, $envId: String, $envType: String, $filters: QuestionListFilterInput) {
  panelQuestionList(
    currentQuestionSlug: $currentQuestionSlug
    categorySlug: $categorySlug
    envId: $envId
    envType: $envType
    filters: $filters
  ) {
    questions {
      id
      paidOnly
      titleSlug
    }
  }
}
"""

communitySolution_query = """
query communitySolution($topicId: Int!) {
  topic(id: $topicId) {
    post {
      content
    }
  }
}
"""

communitySolutions_query = """
query communitySolutions($questionSlug: String!, $skip: Int!, $first: Int!, $query: String, $orderBy: TopicSortingOption, $languageTags: [String!], $topicTags: [String!]) {
  questionSolutions(
    filters: {questionSlug: $questionSlug, skip: $skip, first: $first, query: $query, orderBy: $orderBy, languageTags: $languageTags, topicTags: $topicTags}
  ) {
    solutions {
      id
    }
  }
}
"""