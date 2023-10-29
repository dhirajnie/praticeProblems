package arrayRotation;

import java.util.ArrayList;
import java.util.List;

public class MaxNumber {

    public static void main(String[] args) {
        System.out.println(maximumSwap(98368));
    }

    public static int maximumSwap(int num) {

        List<Integer> nums = new ArrayList<>();
        int originalNum = num;
        int maxPosition = 0;
        while (num > 0) {
            int carry = num % 10;
            nums.add(carry);
            num = num / 10;
            if (nums.get(nums.size() - 1) > nums.get(maxPosition)) {
                maxPosition = nums.size() - 1;
            }
        }
        int lastIndex = nums.size() - 1;
        if (maxPosition == lastIndex) {
            return originalNum;
        } else {
            //swap
            while (nums.get(maxPosition) == nums.get(lastIndex)) {
                --lastIndex;
            }
            if (lastIndex > 0 &&  lastIndex> maxPosition) {
                int a = nums.get(lastIndex);
                nums.set(lastIndex, nums.get(maxPosition));
                nums.set(maxPosition, a);
            }
        }
        int res = 0;

        for (int i = nums.size() - 1; i >= 0; i--) {
            res = res*10+nums.get(i);
        }
        return res;
    }

}
