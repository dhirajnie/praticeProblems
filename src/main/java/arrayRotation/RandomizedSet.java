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
        int[] inp=new int[]{1,0,2};
        System.out.println(candy(inp));
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
