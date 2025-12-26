package arrayRotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NGE1 {


   static public int[] nextGreaterElement(int[] nums1, int[] nums2) {

       Map<Integer,Integer> ngeMap = new HashMap<>();
       Stack<Integer> increasingStack = new Stack<>() ;
       ngeMap.put(nums2[nums2.length-1],-1);

       for(int i = nums2.length-1;i>=0;i--){
           while(i>=0 && !increasingStack.isEmpty() && increasingStack.peek()<= nums2[i]){
               increasingStack.pop();
           }
           if(increasingStack.size()==0){
               ngeMap.put(nums2[i],-1);
           }
           else{
               ngeMap.put(nums2[i],increasingStack.peek());
           }
           increasingStack.push(nums2[i]);
       }

      int result[] = new int[nums1.length];
       for(int i =0;i<nums1.length;i++){
           result[i]= ngeMap.get(nums1[i]);
       }
       return result;
    }

    public static void main(String[] args) {

        int nums1[]= new int[]{4,1,2};
        int nums2[]= new int[]{5,1,3,4,2,5,10};

        System.out.println(nextGreaterElement(nums1,nums2));

    }
}
