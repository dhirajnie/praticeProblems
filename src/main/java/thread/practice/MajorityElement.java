package thread.practice;

public class MajorityElement {

    static public int majorityElement(int[] nums) {

        int m = 0;
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[m] == nums[i]) {
                ++count;
            } else {
                --count;
            }
            if (count == 0) {
                m = i;
                count = 1;
            }
        }
        System.out.print(nums[m]);

        int majorElement = nums[m];
        int counter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (majorElement == nums[i])
                ++counter;
        }
        if (counter > nums.length / 2) {
            return majorElement;
        }

        return 0;

    }

    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5, 6, 7};
        rotate(nums, 1);
    }

    static void swap(int startIndex, int endIndex, int nums[]) {
        while (startIndex < endIndex) {
            int temp = nums[startIndex];
            nums[startIndex] = nums[endIndex];
            nums[endIndex] = temp;
            ++startIndex;
            --endIndex;
        }
    }

    static public void rotate(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return;
        } else {
            if (k > nums.length) {
                k = k % nums.length;
            }
            int pivot = nums.length - k;
            int i = 0;
            int j = pivot - 1;

            swap(0, pivot - 1, nums);
            swap(pivot, nums.length - 1, nums);
            swap(0, nums.length - 1, nums);
        }

    }

}
