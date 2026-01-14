package arrayRotation;

public class TwoPointerNew {
  static   public int minSubArrayLen(int target, int[] nums) {

      int curSum =0;
      int left =0;
      int minWindow = Integer.MAX_VALUE;
      for(int right =0;right<nums.length;right++){
          curSum+=nums[right];
          while(curSum>target && left<=right){
              curSum-=nums[left];
              ++left;
          }
          System.out.println("CurSum"+curSum);
          if((right-left+1)<minWindow  && curSum >= target){
                System.out.println("left"+left+": right"+right);
              minWindow=right-left+1;
          }
      }
      return minWindow==Integer.MAX_VALUE?0:minWindow;
    }




    public static void main(String[] args) {
        int inp[]=new int[]{1,2,3,4,5};
        System.out.println(minSubArrayLen(11,inp));
    }

}
