/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LeetCodeProblems;

/**
 *
 * @author Hadoop
 */
public class MajorityElement {

    public static void main(String[] args) {
        MajorityElement me = new MajorityElement();
        int[] i = {1,1,2};
        int[] j = {2,1,1,1,4};
        int[] k = {2,2};
        int[] l = {3,6,7,6,6,6,6,9,5};
        int[] m = {2};
        System.out.println(me.majorityElement(i));//1
        System.out.println(me.majorityElement(j));//1
        System.out.println(me.majorityElement(k));//2
        System.out.println(me.majorityElement(l));//6
        System.out.println(me.majorityElement(m));//2
    }

    
    
    public int majorityElement(int[] nums)  {
        int votes = 1;
        int elem = nums[0];
        for (int i = 1; i < nums.length; i++){
            if (nums[i]==elem){
                votes+=1;
            }else if (votes >0){
                votes--;
            }else{
                elem = nums[i];
                votes = 1;
            }
        }
        
        return elem;
    }
}
