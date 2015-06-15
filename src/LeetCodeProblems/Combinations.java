/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
package LeetCodeProblems;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Abhay Kawale
 */
public class Combinations {

    public static void main(String[] args) {
        
        Combinations c = new Combinations();
        c.testCases();
    }

    private void testCases(){
        try { 
            /**
             * Test Case 1
             */
            List<List<Integer>> result1 = combine(4, 2);
            for (List<Integer> li : result1) {
                for (int i : li) {
                    System.out.print(i + " ");
                }
                System.out.println("");
            }

            
            /**
             * Test Case 2
             * Expect exception
             */
            List<List<Integer>> result2 = combine(0, 2);
            for (List<Integer> li : result2) {
                for (int i : li) {
                    System.out.print(i + " ");
                }
                System.out.println("");
            }
            
        } catch (Exception ex) {
            Logger.getLogger(Combinations.class.getName()).log(Level.SEVERE, ex.getMessage(), ex);
        }
        
    }
    
   
    
    public List<List<Integer>> combine(int n, int k) throws Exception {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();

        if (n <= 0 || n < k) {
            throw new Exception ("Bad Input: n shoubd be > 0 and k should be less than n");
        }

        ArrayList<Integer> item = new ArrayList<Integer>();
        getResults(n, k, 1, item, res); 

        return res;
    }

    /**
     * Helper Function : -
     *      DFS to compute the Lists. At each iteration number gets added to temp list
     * @param n - input 
     * @param k - input
     * @param curr - current start index
     * @param tmp - tmp list
     * @param res - result
     */
    private void getResults(int n, int k, int curr, ArrayList<Integer> tmp, List<List<Integer>> res) {
        if (tmp.size() == k) {
            res.add(new ArrayList<Integer>(tmp));
            return;
        }
        /**
         * DFS
         */
        for (int i = curr; i <= n; i++) {
            tmp.add(i);
            getResults(n, k, i + 1, tmp, res);
            tmp.remove(tmp.size() - 1);
        }
    }

}
