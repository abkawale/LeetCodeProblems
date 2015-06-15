/*
 Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Abhay Kawale
 */
public class CombinationSum {

    public static void main(String[] args) {
        CombinationSum cs = new CombinationSum();
        cs.testCases();
    }

    public void testCases(){
       
        /**
         * Test Case 1
         */
        int[] arr = {1,2,3};
        int target = 3;
        List<List<Integer>> li = combinationSum( arr, target);
        for (List<Integer> l : li) {
            for (int i : l) {
                System.out.print(i + " ");
            }
            System.out.println("");
        }
        /**
         * Test Case 2
         */
        
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.EMPTY_LIST;
        }
        
        List<List<Integer>> myList = new ArrayList<List<Integer>>();
        int[] l = new int[target];
        Arrays.sort(candidates);
        printSeq(target, l, 0, 0, candidates,myList);
        return myList;
    }
    
    /**
     * Helper Function : -
     *      DFS to compute the Lists. At each iteration the current sum is num = num -arr[i]
     * @param num - current sum
     * @param a - temp array to store combinations
     * @param len - length of a
     * @param s - Start index
     * @param candidates - input array
     * @param result - list to return
     */
    private void printSeq(int num, int[] a, int len, int s, int[] candidates, List<List<Integer>> result) {
        if (num == 0) {
            List<Integer> li = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                System.out.print(a[i]+" ");
                li.add(a[i]);
            }
            result.add(li);
            System.out.println();
            return;
        }

        /**
         * DFS
         */
        for (int i = s; i < candidates.length && candidates[i] <=num; i++) {
            a[len] = candidates[i];
            printSeq(num - candidates[i], a, len + 1, i,candidates,result);
        }
    }   
}
