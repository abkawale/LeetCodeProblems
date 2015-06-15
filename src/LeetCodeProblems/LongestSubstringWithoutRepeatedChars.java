/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

/**
 *
 * @author Abhay Kawale
 */
public class LongestSubstringWithoutRepeatedChars {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatedChars LSWRC = new LongestSubstringWithoutRepeatedChars();
        LSWRC.testCases();
    }

    public void testCases(){
        System.out.println(lengthOfLongestSubstring("pwwkew"));//3
        System.out.println(lengthOfLongestSubstring(""));//0
        System.out.println(lengthOfLongestSubstring("www"));//1
    }
    
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.compareTo("") == 0) {
            return 0;
        }

        if (s.length() == 1) {
            return 1;
        }

        int len = 0;
        int start = 0;
        int end = 0;
        boolean[] charSet = new boolean[256];

        while (start < s.length() && end < s.length()) {
            char c = s.charAt(end);
            if (charSet[c] == false) {
                charSet[c] = true;
                len = Math.max(len, end - start + 1);
                end++;
            } else if (charSet[c] == true) {
                len = Math.max(len, end - start);
                charSet[s.charAt(start)] = false;
                start++;
            }
        }

        return len;
    }
}
