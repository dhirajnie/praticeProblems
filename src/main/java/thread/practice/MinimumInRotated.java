package thread.practice;

public class MinimumInRotated {

    boolean boundCheck(int index, int maxLenght) {
        return index + 1 < maxLenght && index - 1 >= 0;
    }

    int recur(int nums[], int low, int high) {
        if (low >= nums.length || high < 0 || low > high) {
            return -1;
        } else {
            System.out.println("Low" + low + "high" + high);
            int index = -1;
            int mid = (low + high) / 2;
            if (boundCheck(mid, nums.length) && nums[mid] < nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                return mid;
            }
            if (mid != high && mid != low) {
                if (boundCheck(mid, nums.length) && nums[mid] > nums[mid - 1] && nums[mid] < nums[mid + 1]) {
                    index = recur(nums, low, mid);
                    if (index == -1) {
                        index = recur(nums, mid, high);
                    }
                } else if (boundCheck(mid, nums.length) && nums[mid + 1] < nums[mid] && nums[mid - 1] < nums[mid]) {
                    // go right
                    index = recur(nums, mid, high);
                } else {
                    // go left
                    index = recur(nums, low, mid);
                }
            }


            return index;
        }
    }

    public int findMin(int[] nums) {
        int pivot =  recur(nums, 0, nums.length - 1);
        if(pivot>-1){
            return nums[pivot];
        }
        else{
            if(nums[0]<nums[nums.length-1]){
                return nums[0];
            }
            else
                return nums[nums.length-1];
        }
    }


    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 6, 7, 1, 2};
        System.out.println(new MinimumInRotated().findMin(nums));
    }
}
