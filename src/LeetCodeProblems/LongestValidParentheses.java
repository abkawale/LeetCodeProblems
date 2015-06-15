/*
 Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

 For "(()", the longest valid parentheses substring is "()", which has length = 2.

 Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 */
package LeetCodeProblems;

import java.util.Stack;

/**
 *
 * @author Hadoop
 */
public class LongestValidParentheses {

    public static void main(String[] args) {
        LongestValidParentheses lvp = new LongestValidParentheses();
        System.out.println(lvp.longestValidParentheses(")"));
    }

    
    /**
     * Time complexity is O(n)
     * Idea is 
     *        when you encounter ( push to stack
     *        when you encounter )
     *              check if stack is empty, initialize last.
     *              else, stack.pop, check if stack is empty then update max length
     *                               else just update max len by peek
     * @param s
     * @return 
     */
    public int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int last = -1;
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {

            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    last = i;
                } else {
                    stack.pop();
                    if (stack.isEmpty()) {
                        maxlen = Math.max(maxlen, i - last);
                    } else {
                        maxlen = Math.max(maxlen, i - stack.peek());
                    }
                }
            }
        }
        return maxlen;
    }
}
