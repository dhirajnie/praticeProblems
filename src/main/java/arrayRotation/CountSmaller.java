package arrayRotation;

import com.practice.Utils;

import java.util.*;

public class CountSmaller {
    static public int removeElement(int[] nums) {

        int write = -1;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count < 1 || nums[write] != nums[i]) {
                ++write;
                nums[write] = nums[i];
                if (write > 0 && nums[write] == nums[write - 1]) {
                    ++count;
                } else {
                    count = 0;
                }


            }

        }
        return write;
    }


    public static void main(String[] args) {


        int inp[] = new int[]{1,2};
        System.out.println((removeElement(inp)));
        Utils.print(inp);
    }
}
