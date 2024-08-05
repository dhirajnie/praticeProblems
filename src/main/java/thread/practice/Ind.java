package thread.practice;

public class Ind {
   static public int strStr(String haystack, String needle) {
        int currIndex = 0;
        int foundIndex = -1;
        int matchCount =0;
        for(int i =0;i<haystack.length();i++){
            if(currIndex<needle.length() && haystack.charAt(i)==needle.charAt(currIndex)){
                ++currIndex;
                ++matchCount;
//                foundIndex=i;
            }
            else{
                i = i-currIndex;
                currIndex=0;
                foundIndex=-1;
                matchCount=0;
            }

            if(matchCount==1 && foundIndex==-1){
                foundIndex=i;
            }
            if(currIndex==needle.length()){
                return foundIndex;
            }

        }
        return -1;
    }


    public static void main(String[] args) {

        System.out.println( strStr("mississippi","issip"));
/*

sadbutsad
sad
 */
    }
}
