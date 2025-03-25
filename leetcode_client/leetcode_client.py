import requests
import json

class LeetCodeClient():
    def __init__(self, leetcode_session=None, cf_clearance=None, csrftoken=None):
        self.LEETCODE_SESSION = leetcode_session
        self.CF_CLEARANCE = cf_clearance
        self.CSRFTOKEN = csrftoken

    def set_leetcode_cookies(self, leetcode_session, cf_clearance, csrftoken):
        self.LEETCODE_SESSION = leetcode_session
        self.CF_CLEARANCE = cf_clearance
        self.CSRFTOKEN = csrftoken

    def _get_leetcode_cookies(self):
        return {
            "LEETCODE_SESSION" : self.LEETCODE_SESSION,
            "cf_clearance": self.CF_CLEARANCE,
            "csrftoken": self.CSRFTOKEN
        }

    def submit_solution(self, question, question_id, language, code, verbose=False):
        url = f"https://leetcode.com/problems/{question}/submit/"

        headers = {
            "sec-ch-ua-platform": '"macOS"',
            "x-csrftoken": self.CSRFTOKEN,
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

        response = requests.post(url, headers=headers, cookies=self._get_leetcode_cookies(), json=payload)
        if verbose:
            print("Status Code:", response.status_code)

        if response.status_code != 200:
            response = response.json()
            return (False, response)
        else:
            response = response.json()
            id = int(response['submission_id'])
            if verbose:
                print(f"submission id: {id}")
            return (True, id)

    def view_solution(self, solution_id, verbose=False):
        url = "https://leetcode.com/graphql/"

        headers = {
            "sec-ch-ua-platform": '"macOS"',
            "x-csrftoken": self.CSRFTOKEN,
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

        response = requests.post(url, headers=headers, cookies=self._get_leetcode_cookies(), json=payload)
        if verbose:
            print("Status Code:", response.status_code)
        
        if response.status_code != 200:
            response = response.json()
            return (False, response)
        else:
            response = response.json()
            if verbose:
                print(json.dumps(response, indent=4))
            return (True, response)
