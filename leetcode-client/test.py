import requests
import json
import time

def get_leetcode_cookies():
    return {
        "LEETCODE_SESSION": ("eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhY2NvdW50X3ZlcmlmaWVkX2VtYWlsIjpudWxsLCJhY2NvdW50X3VzZXIiOiJhM2xqZyIsIl9hdXRoX3VzZXJfaWQiOiIxNjk2NDA0NCIs"
                            "Il9hdXRoX3VzZXJfYmFja2VuZCI6ImFsbGF1dGguYWNjb3VudC5hdXRoX2JhY2tlbmRzLkF1dGhlbnRpY2F0aW9uQmFja2VuZCIsIl9hdXRoX3VzZXJfaGFzaCI6IjkxNThjNjdiZmNmMDU5"
                            "ZjlmNzk3MmZkNzg2NzRkYjg2ZjA2MmJmMjg0NGQwNmM4MmVhNTBjMGZlMDczMDQ3NjgiLCJzZXNzaW9uX3V1aWQiOiJmNGVmNzFlOCIsImlkIjoxNjk2NDA0NCwiZW1haWwiOiJvZmZp"
                            "Y2lhbGtyeXRoZXhAZ21haWwuY29tIiwidXNlcm5hbWUiOiJsZWV0LXZpc2lvbiIsInVzZXJfc2x1ZyI6ImxlZXQtdmlzaW9uIiwiYXZhdGFyIjoiaHR0cHM6Ly9hc3NldHMubGVl"
                            "dGNvZGUuY29tL3VzZXJzL2RlZmF1bHRfYXZhdGFyLmpwZyIsInJlZnJlc2hlZF9hdCI6MTc0MTUwNDE3MywiaXAiOiI3NS4xNzIuODAuODIiLCJpZGVudGl0eSI6ImI4MDFkNDk0ZjEy"
                            "Mjc5M2IwNjEyNjM2YmZhMjM0YjljIiwiZGV2aWNlX3dpdGhfaXAiOlsiOWYyZjQ5NmU3NWIxOWVhMWM4ZjI1NmIwMjgyNDkxOTkiLCI3NS4xNzIuODAuODIiXX0.8X474uHlhbsUemD_"
                            "Vooi7CX57aLSlAzSLnOEleyQFpE"),
        "cf_clearance": ("5HRdBeTcsu.erh0qdNywchtd9ES5jXdm89BIb3psRds-1741504156-1.2.1.1-gEDqIhraBW6d8lrU8I.9nL195nuEXFqHLp0jCC8KxdbswiuaZZDnBNdMiOnZHXiMgMZZtB648vBPA8iYKYaN"
                        "ynVMK3d4R.i0GVXqSt9JOvDOTO4xG3iznPIZbXUtMkVUUkZFd_UJPKLsO3NnyLNwlA.j5B97wLvrrLoTGKdwtXDnakfaDc841KpRTo_eej3PuAvmG0_tQJAfQrFTeXYzV4OVK3NePskdihr0VR93IWadeZu98chhCX0fI7xgLIR4kHPoK5UwBVbehQehqaQ2TMhZz3w2mmCR0nOaCix9N43I425HAxslUFw1ls3WyVrQqzSflpUHwMvPLmkWwuLk3Ebfp9raTTt9YAiN1y6lG6pmv9xU0Gec7WumXbh01tuP8dOqv6_ASB3mqXpw3PSMlEjs9GnmOsgzbzAHU542edH598PeUreMms.7sDk7oXbxE5HSv1O_vfNlR9j1kwa5tA"),
        "csrftoken": "DOvzdRHELV68Zu5Wdorx6JQajZwsZgkPTM3cclW5ol1em5qLZn9UFbHwqHQW4NLh",
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


solution_id = submit_solution(
                "two-sum", 1, "java",
                "class Solution {\n"
                " public int[] twoSum(int[] nums, int target) {\n"
                " Map<Integer, Integer> seen = new HashMap<>();\n\n"
                " for (int i = 0; i < nums.length; i++) {\n"
                " int complement = target - nums[i];\n"
                " if (seen.containsKey(complement)) {\n"
                " return new int[] { seen.get(complement), i };\n"
                " }\n"
                " seen.put(nums[i], i);\n"
                " }\n\n"
                " throw new RuntimeException(); // hello world \n"
                " }\n"
                "}")

time.sleep(5)
view_solution(solution_id)
