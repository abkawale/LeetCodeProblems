/*
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

 For example, 
 Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 */
package LeetCodeProblems;

/**
 *
 * @author Abhay Kawale
 */
public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater trw = new TrappingRainWater();
        trw.testCases();
    }

    public void testCases(){
        
        /**
         * Test Case 1
         * exp op 2
         */
        int[] arr = {2, 0, 2};
        System.out.println(trap(arr));
        
        /**
         * Test Case 2
         * exp op 4
         */
        int[] arr1 = {2,0,0,2};
        System.out.println(trap(arr1));
    }
    
    
    /**
     * Idea is to find min and max points for each i
     * @param A
     * @return 
     */
    public int trap(int[] A) {
        if (A == null || A.length <= 2) {
            return 0;
        }

        int capacity = 0;

        int[] min = new int[A.length];
        int[] max = new int[A.length];

        min[0] = 0;
        for (int i = 1; i < min.length; i++) {
            min[i] = Math.max(min[i - 1], A[i - 1]);
        }

        max[A.length - 1] = 0;
        for (int i = max.length - 2; i >= 0; i--) {
            max[i] = Math.max(A[i + 1], max[i + 1]);
        }

        for (int i = 0; i < A.length; i++) {
            if (Math.min(max[i], min[i]) - A[i] > 0) {
                capacity += Math.min(max[i], min[i]) - A[i];
            }
        }

        return capacity;

    }

}
