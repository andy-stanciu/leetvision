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