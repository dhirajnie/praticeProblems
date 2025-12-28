package arrayRotation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class NGE2 {

  static   public int[] nextGreaterElements(int[] nums2) {
        int result[] = new int[nums2.length];

        Stack<Integer> increasingStack = new Stack<>();
        result[nums2.length - 1]= -1;

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (i >= 0 && !increasingStack.isEmpty() && increasingStack.peek() <= nums2[i]) {
                increasingStack.pop();
            }
            if (increasingStack.size() == 0) {
                result[i]= -1;
            } else {
                result[i]= increasingStack.peek();
            }
            increasingStack.push(nums2[i]);
        }

      System.out.println(increasingStack);
        for (int i = nums2.length - 1; i >= 0; i--) {
            if(result[i]==-1) {
                while (i >= 0 && !increasingStack.isEmpty() && increasingStack.peek() <= nums2[i]) {
                    increasingStack.pop();
                }
                if (increasingStack.size() == 0) {
                    result[i] = -1;
                } else {
                    result[i] = increasingStack.peek();
                }
                increasingStack.push(nums2[i]);
            }
        }
return result;

    }

    public static void main(String[] args) {
        int test[] = new int[]{1,8,-1,-100,-1,222,1111111,-111111};

        print(nextGreaterElements(test));
    }

    public static void print(int arr[]){
      for(int i =0;i< arr.length;i++){
          System.out.println(arr[i]+",");

      }
        System.out.println();
    }
}
