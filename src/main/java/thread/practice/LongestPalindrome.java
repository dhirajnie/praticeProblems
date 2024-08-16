package thread.practice;

public class LongestPalindrome {


    String getPalindromForIndex(int leftIndex, int rightIndex, String s) {
        StringBuffer currentPalindrome = new StringBuffer();
            while (leftIndex >= 0 && rightIndex < s.length() && s.charAt(leftIndex) == s.charAt(rightIndex)) {
                if (leftIndex == rightIndex) {
                    currentPalindrome.append(s.charAt(leftIndex));
                } else {
                    currentPalindrome.insert(0, s.charAt(leftIndex));
                    currentPalindrome.insert(currentPalindrome.length() , s.charAt(rightIndex));
                }
                --leftIndex;
                ++rightIndex;
            }

        return currentPalindrome.toString();
    }

    public String longestPalindrome(String s) {


        String maxLengthPalindrome = "";


        for (int i = 0; i < s.length(); i++) {
            String includedMid = getPalindromForIndex(i, i, s);
            String exludedMid = getPalindromForIndex(i , i+1 , s);
            String currentMaxLength = (includedMid.length() > exludedMid.length()) ? includedMid : exludedMid;
            if (currentMaxLength.length() > maxLengthPalindrome.length()) {
                maxLengthPalindrome = currentMaxLength;
            }
            System.out.println(maxLengthPalindrome);
        }

        return maxLengthPalindrome;
    }

    public static void main(String[] args) {

        System.out.println(new LongestPalindrome().longestPalindrome("abba"));
//        System.out.println(new LongestPalindrome().longestPalindrome("aba"));

    }
}
