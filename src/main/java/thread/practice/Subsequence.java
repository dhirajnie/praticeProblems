package thread.practice;

public class Subsequence {


    public int[] twoSum(int[] numbers, int target) {
        if(numbers==null || numbers.length==1){
            return new int[]{0};
        }
        else{
            int i =0;
            int j = numbers.length-1;
            while (i<j){
                if(numbers[i]+numbers[j]==target){
                    return new int[]{i,j};
                }
                else if(numbers[i]+numbers[j]>target){
                    --j;
                }
                else{
                    ++i;
                }
            }
        }
        return new int[]{-1,-1};
    }

    public static void main(String[] args) {
        int num[]={2,7,11,15};
        int target = 9;
        System.out.println(new Subsequence().twoSum(new int[]{5,25,75},100));
    }
}
