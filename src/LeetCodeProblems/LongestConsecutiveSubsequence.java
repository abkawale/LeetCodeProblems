/**
 * Given an unsorted array of integers, find the length of the longest
 * consecutive elements sequence.
 *
 * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements
 * sequence is [1, 2, 3, 4]. Return its length: 4.
 *
 * Your algorithm should run in O(n) complexity.
 */
package LeetCodeProblems;

import java.util.HashMap;

/**
 *
 * @author Abhay Kawale
 */
public class LongestConsecutiveSubsequence {

    public static void main(String[] args) {
        LongestConsecutiveSubsequence lcs = new LongestConsecutiveSubsequence();
        lcs.testCases();
    }

    private void testCases() {
        /**
         * Test Case 1 ex op 6
         */
        int[] numbers = {100, 4, 200, 1, 3, 2, 101, 102, 103, 105, 104};
        System.out.println(longestConsecutiveSequence(numbers));

        /**
         * Test Case 2 ex op 5
         */
        int[] numbers1 = {1, 4, 2, 5, 3, 8};
        System.out.println(longestConsecutiveSequence(numbers1));

        /**
         * Test Case 2 ex op 2
         */
        int[] numbers2 = {-1, 4, -2, -5, 3, -8};
        System.out.println(longestConsecutiveSequence(numbers2));

        /**
         * Test Case 2 ex op 1
         */
        int[] numbers3 = {1, 3, 5, 7, 9};
        System.out.println(longestConsecutiveSequence(numbers3));

        /**
         * Test Case 2 ex op -1
         */
        int[] numbers4 = {};
        System.out.println(longestConsecutiveSequence(numbers4));

    }

    /**
     * Find longest sequence
     *
     * @param numbers
     * @return string with longest sequence
     */
    public int longestConsecutiveSequence(int[] numbers) {

        if (numbers.length < 1) {
            return -1;
        }

        if (numbers.length == 1) {
            return 1;
        }

        HashMap<Integer, Boolean> visitMap = new HashMap<>();

        int longestSequence = 0;
        int tempLongestSequence = 0;

        /**
         * Initialize hash map
         */
        for (int i = 0; i < numbers.length; i++) {
            visitMap.put(numbers[i], false);
        }

        /**
         * Traverse the array
         */
        for (int j = 0; j < numbers.length; j++) {

            if (!visitMap.get(numbers[j])) {

                visitMap.put(numbers[j], true);
                tempLongestSequence++;

                /**
                 * Check sequence forwards
                 */
                int tempNum = numbers[j] + 1;
                while (visitMap.containsKey(tempNum) && !visitMap.get(tempNum)) {

                    visitMap.put(tempNum, true);
                    tempLongestSequence++;
                    tempNum++;
                }

                /**
                 * Check sequence backwards
                 */
                tempNum = numbers[j] - 1;
                while (visitMap.containsKey(tempNum) && !visitMap.get(tempNum)) {

                    visitMap.put(tempNum, true);
                    tempLongestSequence++;
                    tempNum--;
                }

                /**
                 * re initialize longestSequence if temp is greater.
                 */
                if (longestSequence < tempLongestSequence) {
                    longestSequence = tempLongestSequence;
                }
                tempLongestSequence = 0;
            }
        }
        return longestSequence;
    }
}
