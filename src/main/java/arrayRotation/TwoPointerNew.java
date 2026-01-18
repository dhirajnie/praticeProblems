package arrayRotation;

import java.util.*;

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


  static   public boolean isValidSudoku(char[][] board) {

        Map<String, Set<Character>> squareMap = new HashMap<>();
        Map<String, Set<Character>> rowMap = new HashMap<>();
        Map<String, Set<Character>> columnMap = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                char ch = board[i][j];
                if (ch!= '.') {
                    String rowKey = i + "R" + j;
                    String colKey = i + "C" + j;
                    String sqaureKey = (i / 3) + "S" + (j / 3);

                    Set<Character> squareSet = squareMap.getOrDefault(sqaureKey, new HashSet<>());
                    if(containsDup(squareSet,ch)){
                        return false;
                    }
                    squareMap.put(sqaureKey,squareSet);

                    Set<Character> rowSet = rowMap.getOrDefault(rowKey, new HashSet<>());
                    if(containsDup(rowSet,ch)){
                        return false;
                    }
                    rowMap.put(rowKey,rowSet);

                    Set<Character> colSet = columnMap.getOrDefault(colKey, new HashSet<>());
                    if(containsDup(colSet,ch)){
                        return false;
                    }
                    columnMap.put(colKey,colSet);

                }
            }
        }
        return true;
    }

    static   boolean containsDup(Set<Character> set, Character ch ){
            if(set.contains(ch)){
                return true;
            }
            set.add(ch);
            return false;
        }





public static void main(String[] args) {
      String input[][]= new String[][]{{"5","3",".",".","7",".",".",".","."}
              ,{"6","5",".","1","9","5",".",".","."}
              ,{".","9","8",".",".",".",".","6","."}
              ,{"8",".",".",".","6",".",".",".","3"}
              ,{"4",".",".","8",".","3",".",".","1"}
              ,{"7",".",".",".","2",".",".",".","6"}
              ,{".","6",".",".",".",".","2","8","."}
              ,{".",".",".","4","1","9",".",".","5"}
              ,{".",".",".",".","8",".",".","7","9"}};

    System.out.println(isValidSudoku(input));

    }

}
