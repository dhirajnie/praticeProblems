package arrayRotation;

import com.practice.Utils;

import java.util.*;

public class RandomizedSet {
    private List<Integer> list = new LinkedList<>();
    Random random = new Random();
    private Map<Integer,Integer> map = new HashMap<>();



    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
       list.add(val);
        map.put(val,list.size()-1);
        return true;
    }

    public boolean remove(int val) {
       if( map.containsKey(val)){
           int lastElement = list.get(list.size()-1);
           map.put(lastElement,map.get(val));
           list.add(map.get(val),lastElement);
           list.remove(list.size()-1);
           map.remove(val);
           return true;
       }
       return false;
    }

    public int getRandom() {
            return list.get(random.nextInt(list.size()));

    }


    public static void main(String[] args) {
        String[] inp=new String[]{"aa","ab"};
        System.out.println(longestCommonPrefix(inp));
    }



   static public int trap(int[] height) {

        int leftGreater[] = new int[height.length];
        Stack<Integer> stack = new Stack<>();
        for(int i =height.length-1;i>=0;i--){
            while(!stack.isEmpty() &&  height[i]> stack.peek()){
                    leftGreater[i]=0;
                    stack.pop();
                }
            if(stack.isEmpty()){
                stack.push(height[i]);
                leftGreater[i]= 0;
            }
            else{
                leftGreater[i]=stack.peek();
            }
        }
        int rightGreater[]= new int[height.length];
        stack= new Stack<>();
        for(int i =0;i<height.length;i++){
            while(!stack.isEmpty() &&  height[i]> stack.peek()){
                rightGreater[i]=0;
                stack.pop();
            }
            if(stack.isEmpty()){
                stack.push(height[i]);
                rightGreater[i]= 0;
            }
            else{
                rightGreater[i]=stack.peek();
            }

        }
        Utils.print(leftGreater);
        Utils.print(rightGreater);
        int area = 0;
        for(int i =0;i<height.length;i++){

            int curentArea = Math.min(leftGreater[i], rightGreater[i])-height[i];
            if(curentArea>0){
                area+=curentArea;
            }

        }
       System.out.println("\n");
        return area;
    }


    static public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        String result = strs[0];
        int max = result.length();


        int currIndex =0;

        for(int i =1;i<strs.length;i++){
            String word = strs[i];
            int j =0;
            for(;j<max && j< word.length();j++){
                if(word.charAt(j)!=result.charAt(j)){
                    break;
                }
            }
            max=j;
            if(max==0){
                break;
            }

        }
        return result.substring(0,max);
    }
   static public int candy(int[] ratings) {
       int curMax =1;
       int[] lr = new int[ratings.length];
       lr[0]=1;
       for(int i =1;i<ratings.length;i++){
           if(ratings[i]>ratings[i-1]){
               ++curMax;
           }
           else{
               curMax=1;
           }
           lr[i]=curMax;
       }
       curMax=0;
       int[] rl= new int[ratings.length];
       rl[ratings.length-1]=1;
       for(int i=ratings.length-2;i>=0;i--){
           if(ratings[i]> ratings[i+1]){
               ++curMax;
           }
           else {
               curMax=1;
           }
           rl[i]=curMax;
       }
       int result =0;
       Utils.print(lr);
       System.out.println();
       Utils.print(rl);

       for(int i =0;i<ratings.length;i++){
           result+=Math.max(rl[i],lr[i]);
       }
       return result;
    }


}
