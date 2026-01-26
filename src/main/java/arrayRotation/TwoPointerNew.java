package arrayRotation;

import com.sun.xml.internal.ws.addressing.WsaActionUtil;

import java.util.*;
import java.util.stream.Collectors;

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

  static   public String minWindow(String s, String t) {
       int iMin = 0;
       int jMin =s.length();
    for(int i =0;i<s.length();i++) {
        int tindex = 0;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == t.charAt(tindex)) {
                ++tindex;
            }
            if (tindex == t.length() && (jMin-iMin)>(j-i)) {
                System.out.println(tindex+" is equal and i:"+i+" "+j);
                jMin= j;
                iMin=i;
                break;
            }
        }

    }
    return s.substring(iMin,jMin);
    }


   static public boolean canConstruct(String s, String t) {
        Map<Integer,Integer> sCount = constructCountOfCount(s);
       Map<Integer,Integer> tCount = constructCountOfCount(t);

       for(Map.Entry<Integer,Integer> entry : sCount.entrySet()){
           if(!tCount.containsKey(entry.getKey()) || tCount.get(entry.getKey())!=entry.getValue().intValue()){
               return false;
           }
       }
       return true;

    }

   static Map<Integer,Integer> constructCountOfCount(String inp){
        Map<Character,Integer> charCount = new HashMap<>();
        Map<Integer,Integer> sCounter = new HashMap<>();
        for(char c: inp.toCharArray()){
            charCount.put(c,charCount.getOrDefault(c,0)+1);
        }

        for(Integer count : charCount.values()){
            sCounter.put(count,sCounter.getOrDefault(count,0)+1);
        }
        return sCounter;
    }


   static public boolean isIsomorphic(String s, String t) {


        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Character> charMapping = new HashMap<>();
        Set<Character > usedStr = new HashSet<>();
        for(int i = 0;i<s.length();i++){
            if(charMapping.containsKey(s.charAt(i)) && charMapping.get(s.charAt(i))!=t.charAt(i)){
                return false;
            }
            else if(!charMapping.containsKey(s.charAt(i) ) &&  usedStr.contains(t.charAt(i))){
               return false;
            }
            else{
                charMapping.put(s.charAt(i),t.charAt(i));
                usedStr.add(t.charAt(i));
            }

        }
        return true;
    }


    static public boolean wordPattern( String s,String pattern) {

        /*
        a-> cat
        a-> ele
        b->dog
        c->dog
         */
        String[] words= pattern.split(" ");
        if(words.length!=s.length()){
            System.out.println("Here");
            return false;
        }
        Map<Character,String> charWordMap = new HashMap<>();
        Set<String> mappedWord = new HashSet<>();
        for(int i =0;i<words.length;i++){
            if(charWordMap.containsKey(s.charAt(i)) && !( charWordMap.get(s.charAt(i)).equals(words[i]))){
                return false;
            }
            else if(!charWordMap.containsKey(s.charAt(i)) && mappedWord.contains(words[i]) ){
                return false;
            }
            else{
                charWordMap.put(s.charAt(i),words[i]);
                mappedWord.add(words[i]);
            }

        }
        return true;

    }

  static   public boolean containsNearbyDuplicate(int[] nums, int k) {

        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            if(map.containsKey(nums[i]) && ( i -  map.get(nums[i]))<=k){
                return true;
            }
            else {
                map.put(nums[i],i);
            }

        }
        return false;
    }
static   public boolean isAnagram(String s, String t) {


        if(s.length()!=t.length()){
            return false;
        }
        Map<Character,Integer> sCharMap = new HashMap<>();

        for(Character ch : s.toCharArray()){
            sCharMap.put(ch,sCharMap.getOrDefault(ch,0)+1);
        }

    Map<Character,Integer> tCharMap = new HashMap<>();
    for(Character c : t.toCharArray()){
        tCharMap.put(c,tCharMap.getOrDefault(c,0)+1);
    }



    for(Map.Entry<Character,Integer> entry : tCharMap.entrySet()){
        if(!sCharMap.containsKey(entry.getKey()) &&  entry.getValue().intValue()!=sCharMap.get(entry.getKey()).intValue()) {
            return false;
        }

    }
    return true;

    }


  static   public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> groupMap = new HashMap<>();

        for(String word:strs) {
            groupMap.computeIfAbsent(getKey(word),k-> new ArrayList<>()).add(word);
        }

    return groupMap.values().stream().collect(Collectors.toList());

    }


   static String getKey(String word) {

        short[] wordCount = new short[26];
        for(char c : word.toCharArray()) {
            ++wordCount[c-'a'];
        }

        StringBuilder key = new StringBuilder();
        for (int i = 0; i < wordCount.length; i++) {
            key.append(wordCount[i]+",");

        }
            return key.toString();
    }

    public int longestConsecutive(int[] nums) {


return 0;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        int startNumber = nums[0];
        int endNumber = nums[0];
        for(int i =1;i<nums.length;i++){
            if(endNumber+1==nums[i]){
                ++endNumber;
            }
            else{
                if(startNumber!=endNumber){
                    result.add(startNumber+"->"+endNumber);
                }
                else{
                    result.add(startNumber+"");
                }
                startNumber=endNumber=nums[i];
            }
        }
        if(startNumber!=endNumber){
            result.add(startNumber+"->"+endNumber);
        }
        else{
            result.add(startNumber+"");
        }
        return result;
    }


    public int findMinArrowShots(int[][] points) {

        if(points==null || points.length==0){
            return 0;
        }
        int result =1;
        int overlapStart =points[0][0];
        int overlapEnd = points[0][1];
        for(int i =1;i<points.length;i++){
            if(isOverlap(overlapStart,overlapEnd,points[i])){
                overlapStart = Math.max(overlapStart,points[i][0]);
                overlapEnd= Math.max(overlapEnd,points[i][1]);
            }
            else{
                ++result;
                overlapStart= points[i][0];
                overlapEnd= points[i][1];
            }

    }
        System.out.println(result);
        return result;
}

    private boolean isOverlap(int overlapStart, int overlapEnd, int[] point) {

        int oStart = Math.max(overlapStart,point[0]);
        int oEnd = Math.max(overlapEnd,point[1]);
        return oStart < oEnd;

    }


    static     public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int startInterval =intervals[0][0];
        int endInterval  = intervals[0][1];
        List<List<Integer>> result = new ArrayList<>();

        for( int i =1;i<intervals.length;i++){
                if(startInterval<= intervals[i][0] && intervals[i][0]<=endInterval){
                  if(endInterval<intervals[i][1])
                    endInterval=  intervals[i][1];
                }
                else{
                    List<Integer> newInterval = new ArrayList<>();
                    newInterval.add(startInterval);
                    newInterval.add(endInterval);
                    result.add(newInterval);
                    startInterval= intervals[i][0];
                    endInterval= intervals[i][1];
                }
        }

    List<Integer> newInterval = new ArrayList<>();
    newInterval.add(startInterval);
    newInterval.add(endInterval);
    result.add(newInterval);

    int[][] finalResult  = new int[result.size()][2];

    for(int i =0;i<result.size();i++){
        finalResult[i][0]= result.get(i).get(0);
        finalResult[i][1]= result.get(i).get(1);
    }

    System.out.println( result);
    return finalResult;
    }


public static void main(String[] args) {
        int[][] input = new int[][]{{1,3},{2,6},{5,20},{8,10},{15,18}};
    System.out.println(merge(input));

    }
    }


