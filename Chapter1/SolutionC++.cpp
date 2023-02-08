#include <vector>
#include <stack>

class Solution {
public:
    std::vector<int> dailyTemperatures(std::vector<int>& temperatures) {
        int n = temperatures.size();
        std::vector<int> ans(n);
        std::stack<int> st;
        for (int i = n - 1; i >= 0; i--) {
            // 1. Pop elements from the stack until the top element is greater than or equal to the current temperature.
            while (!st.empty() && temperatures[i] >= temperatures[st.top()]) {
                st.pop();
            }
            // 2. If the stack is empty, then there is no warmer day, so the answer is 0.
            // Otherwise, the answer is the distance from the current index to the top element of the stack.
            ans[i] = st.empty() ? 0 : st.top() - i;
            // 3. Push the current index to the stack.
            st.push(i);
        }
        return ans;
    }
};
