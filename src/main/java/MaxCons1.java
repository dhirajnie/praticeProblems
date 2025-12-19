import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class MaxCons1 {
/*
  public int longestOnes(int




  k=2
  max = 3
  {0,1,0},0,1,0,1

  k=2
    {1,0,0},0,1,0,1

*/

    public int longestOnes(int[] nums, int k) {

        int result=0;
        int flipCount =0;
        if(k==0){
            int currMax=0;
            for(int i =0;i<nums.length;i++){
                if(nums[i]==1){
                    ++currMax;
                }
                else{
                    currMax=0;
                }
                if(currMax>result){
                    result=currMax;
                }
            }
            return result;
        }

        for(int i =0;i<nums.length;i++) {
            Deque<Integer> deque = new ArrayDeque<>();

            if (nums[i] == 0) {
                if (flipCount >= k) {
                    if (deque.size()>0 && deque.peek() == 0) {
                        System.out.println("Removed one element from queue");
                        deque.remove();
                    } else {
                        System.out.println("Queue reset at "+i);
                       while(deque.size() >0 && deque.peek()!=0){
                           deque.remove();
                       }
                       deque.remove();
                    }
                } else {
                    ++flipCount;
                }
            }

            deque.add(nums[i]);
            if(deque.size()>result){
                result= deque.size();
            }
            System.out.println("I:"+i+" FLIPCOUNT"+flipCount+" Queue: "+deque.size());

        }
        return result;
    }
    public static void main(String[] args) {
        int test[] = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(new MaxCons1().longestOnes(test,2));
    }
}
