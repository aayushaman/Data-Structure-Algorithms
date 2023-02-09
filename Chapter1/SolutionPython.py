from collections import deque

class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0] * n
        st = deque()
        for i in range(n - 1, -1, -1):
            # If the temperature at the top of the stack is 
            # smaller than the temperature at the current position, 
            # we can pop the element.
            while st and temperatures[i] >= temperatures[st[-1]]:
                st.pop()
            # If the stack is not empty, the distance between the 
            # current position and the top of the stack is the 
            # number of days to wait.
            if st:
                ans[i] = st[-1] - i
            st.append(i)
        return ans
