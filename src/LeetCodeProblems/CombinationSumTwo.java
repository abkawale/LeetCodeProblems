/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author Abhay Kawale
 */
public class CombinationSumTwo {

    public static void main(String[] args) {
         int[] arr = {10,1,2,7,6,1,5};
        int target = 8;
        CombinationSumTwo cst = new CombinationSumTwo();
            List<List<Integer>> t = cst.combinationSum2(arr, target);
            for (List<Integer> li : t){
                for (int i : li){
                    System.out.print(i+" ");
                }
                System.out.println("");
            }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates == null || candidates.length == 0) {
            return Collections.EMPTY_LIST;
        }
        
        HashSet<List<Integer>> myList = new HashSet<List<Integer>>();
        int[] l = new int[target];
        Arrays.sort(candidates);
        printSeq(target, l, 0, 0, candidates,myList);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        result.addAll(myList);
        return result;
    }
    
    /**
     * Helper Function : -
     *      DFS to compute the Lists. At each iteration the current sum is num = num -arr[i] 
     * @param num
     * @param a
     * @param len
     * @param s
     * @param arr
     * @param result 
     */
    private void printSeq(int num, int[] a, int len, int s, int[] arr, HashSet<List<Integer>> result) {
        if (num == 0) {
            List<Integer> li = new ArrayList<Integer>();
            for (int i = 0; i < len; i++) {
                
                li.add(a[i]);
            }
            result.add(li);
            return;
        }

        /**
         * DFS
         */
        for (int i = s; i < arr.length && arr[i] <=num; i++) {
            a[len] = arr[i];
            printSeq(num - arr[i], a, len + 1, i+1,arr,result);
        }
    }

}
