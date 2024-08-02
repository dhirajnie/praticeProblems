public class RemoveInPlace {


  static   public int removeElement(int[] nums, int val) {

        int j =nums.length-1;
        int i =0;
        int count =0;
        for(int x =0;x<nums.length;x++){
            if(nums[x]==val){
                ++count;
            }
        }
        while (i<j) {
            while(nums[i]!=val && i<nums.length){
                ++i;
            }
            while (nums[j] == val && j >= 0) {
                --j;
            }
            //swap
           if(nums[i]==val && nums[j] != val) {
               int a = nums[i];
               nums[i] = nums[j];
               nums[j] = a;
               ++i;
               --j;
           }
        }
        return nums.length-count;
    }
    public static void main(String[] args) {
      int nums[]={4,5};
        System.out.println(removeElement(nums,5));
        System.out.println();
        for(int i =0;i<nums.length;i++){
            System.out.println(nums[i]);
        }

    }
}
