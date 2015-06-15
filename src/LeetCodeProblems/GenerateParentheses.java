/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 "((()))", "(()())", "(())()", "()(())", "()()()"
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Abhay Kawale
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        gp.testCases();
    }

    private void testCases() {
       
        /**
         * Test Case 1
         * Exp output
         * (())
         * ()()
         */
        List<String> result = generateParenthesis(2);
        for (String s : result) {
            System.out.println(s);
        }
        
        /**
         * Test Case 1
         */
        List<String> result1 = generateParenthesis(-1);
        for (String s : result1) {
            System.out.println(s);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        generateParenthesisWorker(n, 0, 0, "", result);
        return result;
    }

    /**
     * 
     * @param n
     * @param left
     * @param right
     * @param str
     * @param result 
     */
    private void generateParenthesisWorker(int n, int left, int right, String str, List<String> result) {
        if (left > n) {
            return;
        }
        if (left == n && right == n) {
            result.add(str);
        } else {
            generateParenthesisWorker(n, left + 1, right, str + "(", result);
            if (right < left) {
                generateParenthesisWorker(n, left, right + 1, str + ")", result);
            }
        }
    }
}
