import requests
import json
import time
from constants import *

def get_leetcode_cookies():
    return {
        "LEETCODE_SESSION" : LEETCODE_SESSION,
        "cf_clearance": CF_CLEARANCE,
        "csrftoken": CSRFTOKEN
    }

def submit_solution(question, question_id, language, code):
    url = f"https://leetcode.com/problems/{question}/submit/"

    headers = {
        "sec-ch-ua-platform": '"macOS"',
        "x-csrftoken": "DOvzdRHELV68Zu5Wdorx6JQajZwsZgkPTM3cclW5ol1em5qLZn9UFbHwqHQW4NLh",
        "User-Agent": "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/133.0.0.0 Safari/537.36",
        "sec-ch-ua": '"Not(A:Brand";v="99", "Google Chrome";v="133", "Chromium";v="133"',
        "content-type": "application/json",
        "sec-ch-ua-mobile": "?0",
        "Accept": "*/*",
        "Sec-Fetch-Site": "same-origin",
        "Sec-Fetch-Mode": "cors",
        "Sec-Fetch-Dest": "empty",
        "host": "leetcode.com",
        "Referer": f"https://leetcode.com/problems/{question}/submit/",
        "Accept-Encoding": "gzip, deflate, br",
        "Connection": "keep-alive",
    }

    payload = {
        "lang": language,
        "question_id": f"{question_id}",
        "typed_code": code
    }

    response = requests.post(url, headers=headers, cookies=get_leetcode_cookies(), json=payload)
    print("Status Code:", response.status_code)
    response = response.json()
    id = int(response['submission_id'])
    print(f"submission id: {id}")
    return id

def view_solution(solution_id):
    url = "https://leetcode.com/graphql/"

    headers = {
        "sec-ch-ua-platform": '"macOS"',
        "x-csrftoken": "AapDpxVYCZtFYly3dANHwmJQKtNGta4eKGiJHF2WugTOFAtkdlemyPdazjJDZeLu",
        "authorization": "",
        "uuuserid": "9f2f496e75b19ea1c8f256b028249199",
        "sec-ch-ua": '"Not(A:Brand";v="99", "Google Chrome";v="133", "Chromium";v="133"',
        "sec-ch-ua-mobile": "?0",
        "User-Agent": ("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) "
                    "AppleWebKit/537.36 (KHTML, like Gecko) "
                    "Chrome/133.0.0.0 Safari/537.36"),
        "content-type": "application/json",
        "random-uuid": "7e224b52-9dc0-885a-cfe7-6abed0a2c788",
        "Accept": "*/*",
        "Sec-Fetch-Site": "same-origin",
        "Sec-Fetch-Mode": "cors",
        "Sec-Fetch-Dest": "empty",
        "host": "leetcode.com",
        "Accept-Encoding": "gzip, deflate, br",
        "Connection": "keep-alive",
    }

    payload = {
        "query": "\n query submissionDetails($submissionId: Int!) {\n submissionDetails(submissionId: $submissionId) {\n runtime\n runtimeDisplay\n runtimePercentile\n runtimeDistribution\n memory\n memoryDisplay\n memoryPercentile\n memoryDistribution\n code\n timestamp\n statusCode\n user {\n username\n profile {\n realName\n userAvatar\n }\n }\n lang {\n name\n verboseName\n }\n question {\n questionId\n titleSlug\n hasFrontendPreview\n }\n notes\n flagType\n topicTags {\n tagId\n slug\n name\n }\n runtimeError\n compileError\n lastTestcase\n codeOutput\n expectedOutput\n totalCorrect\n totalTestcases\n fullCodeOutput\n testDescriptions\n testBodies\n testInfo\n stdOutput\n }\n}\n ",
        "variables": {
            "submissionId": solution_id
        },
        "operationName": "submissionDetails"
    }

    response = requests.post(url, headers=headers, cookies=get_leetcode_cookies(), json=payload)
    print("Status Code:", response.status_code)
    response = response.json()
    print(json.dumps(response, indent=4))


# solution_id = submit_solution(
#                 "two-sum", 1, "java",
#                 "class Solution {\n"
#                 " public int[] twoSum(int[] nums, int target) {\n"
#                 " Map<Integer, Integer> seen = new HashMap<>();\n\n"
#                 " for (int i = 0; i < nums.length; i++) {\n"
#                 " int complement = target - nums[i];\n"
#                 " if (seen.containsKey(complement)) {\n"
#                 " return new int[] { seen.get(complement), i };\n"
#                 " }\n"
#                 " seen.put(nums[i], i);\n"
#                 " }\n\n"
#                 " throw new RuntimeException(); // hello world \n"
#                 " }\n"
#                 "}")

# time.sleep(5)
# view_solution(solution_id)
