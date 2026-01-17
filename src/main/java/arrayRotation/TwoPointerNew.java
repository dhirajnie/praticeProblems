package arrayRotation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoPointerNew {
    static public int minSubArrayLen(int target, int[] nums) {

        int curSum = 0;
        int left = 0;
        int minWindow = Integer.MAX_VALUE;
        for (int right = 0; right < nums.length; right++) {
            curSum += nums[right];
            while (curSum >= target && left <= right) {
                if ((right - left + 1) < minWindow) {
                    System.out.println("left" + left + ": right" + right);
                    minWindow = right - left + 1;
                    System.out.println(" length:" + minWindow);
                }

                curSum -= nums[left];
                ++left;
                System.out.print("CurSum" + curSum);

            }

        }
        return minWindow == Integer.MAX_VALUE ? 0 : minWindow;
    }

    static public int lengthOfLongestSubstring(String s) {

        int left = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        for (int right = 0; right < s.length(); right++) {
            Character ch = s.charAt(right);
            while (set.contains(ch) && left < right) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(ch);
            System.out.println("left:"+left+" right:"+right);
            result = Math.max(right - left + 1, result);
        }
        return result;

    }


    public boolean isSubsequence(String s, String t) {

        int sIndex =0;
        for(int tIndex =0;tIndex<t.length() && sIndex<s.length();tIndex++){
            if(s.charAt(sIndex)== t.charAt(tIndex)){
                ++tIndex;
            }
        }
        return sIndex==t.length();
    }



    public static void main(String[] args) {
        int inp[] = new int[]{1, 2, 3, 4, 5};

        Set<List<Integer>> setOfList = new HashSet<>();
        setOfList.add(new ArrayList<>());
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }

}
