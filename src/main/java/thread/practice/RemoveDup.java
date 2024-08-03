package thread.practice;

public class RemoveDup {

    static public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = i + 1;
        int count = 0;
        while (j < nums.length) {
            while (i+1<nums.length && nums[i] == nums[i + 1] && count < 2) {
                ++i;
                ++count;
            }
            j =i+1;
            while (j < nums.length && nums[i] == nums[j]) {
                nums[j]=Integer.MIN_VALUE;
                ++j;
            }
            if (j - i > 1) {
                nums[i] = nums[j];
            }

            i =j;
            while(i< nums.length && nums[i]==Integer.MIN_VALUE)
                ++i;
            ++j;
            count = 0;
        }
        return i;
    }


    public static void main(String[] args) {

        int temp[] = {0, 0, 0, 0, 1, 1, 1};
        System.out.println(removeDuplicates(temp));
        for (int i = 0; i < temp.length; i++) {
            System.out.println(temp[i] + ",");
        }
        /*
        00001111
        0,0,0,0,1,1,1,2,2,3,3,4


         */
    }
}
