/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

import java.util.Stack;

/**
 *
 * @author Hadoop
 */
public class ValidParenthesis {

    Stack<Character> parenthesisStack = new Stack<>();

    public static void main(String[] args) {
        ValidParenthesis vp = new ValidParenthesis();
        vp.testCases();
    }

    public void testCases() {
        System.out.println(isValid("{}"));
        System.out.println(isValid("{()}"));
        System.out.println(isValid("}[]"));
        System.out.println(isValid("[{(})]"));
        System.out.println(isValid("{"));

    }

    public boolean isValid(String s) {

        if (s == null || s == "") {
            return false;
        }

        if (s.charAt(0) == ')' || s.charAt(0) == ']' || s.charAt(0) == '}') {
            return false;
        }

        parenthesisStack.add(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {

            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                parenthesisStack.add(s.charAt(i));
            } else {
                if (parenthesisStack.isEmpty()) {
                    return false;
                }
                if (s.charAt(i) == ')' && parenthesisStack.peek() != '(') {
                    return false;
                }
                if (s.charAt(i) == '}' && parenthesisStack.peek() != '{') {
                    return false;
                }
                if (s.charAt(i) == ']' && parenthesisStack.peek() != '[') {
                    return false;
                }
                parenthesisStack.pop();
            }
        }
        return parenthesisStack.isEmpty();
    }
}
