package Chapter1;

import java.util.Arrays;
import java.util.Stack;

public class SolutionJava {
    public static void main(String args[]) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
    }
    
    public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            // if the stack is not empty and the temperature of the current day is greater than or equal to the temperature of the day on the top of the stack
            while (!st.isEmpty() && temperatures[i] >= temperatures[st.peek()]) {
                // remove the day on the top of the stack
                st.pop();
            }
            // if the stack is empty, set the value to 0
            // otherwise, the value is the difference between the current day and the day on top of the stack
            ans[i] = st.isEmpty() ? 0 : st.peek() - i;
            // push the current day onto the stack
            st.push(i);
            System.out.println("Day " + i + ": " + Arrays.toString(ans));
        }
        return ans;
    }
}
