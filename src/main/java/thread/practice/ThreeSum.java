package thread.practice;

import javax.print.attribute.EnumSyntax;
import java.util.*;
import java.util.stream.Collectors;

public class ThreeSum {

    public int threeSum(int[] nums, int target) {
        Set<List<Integer>> finalList = new HashSet<>();


        for (int i = 0; i < nums.length; i++) {
            Set<Integer> set = new HashSet<>();

            for (int j = i + 1; j < nums.length; j++) {
                if (set.contains(-(nums[i] + nums[j]))) {
                    List<Integer> uniqueList = new ArrayList<>();
                    uniqueList.add(nums[i]);
                    uniqueList.add(nums[j]);
                    uniqueList.add(-(nums[i] + nums[j]));
                    Collections.sort(uniqueList);
                    finalList.add(uniqueList);
                } else {
                    set.add(nums[j]);
                }
            }

        }
        return 1;
    }

    public static void main(String[] args) {
        int inp[] = {-1, 0, 1, 2, -1, -4};
        System.out.println(new ThreeSum().threeSum(inp));
    }
}
