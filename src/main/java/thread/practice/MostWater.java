package thread.practice;

public class MostWater {

    public int maxArea(int[] height) {

        int i =0;
        int j = height.length-1;
        int globalMax =0;
        while(i<j){
            int leftHeight = height[i];
            int rightHeight = height[j];
            int area = Integer.min(leftHeight,rightHeight)*(j-i);
            globalMax= Integer.max(globalMax,area);
            if(leftHeight<rightHeight){
                ++i;
            }
            else{
                --j;
            }
        }
        return globalMax;
    }



    public static void main(String[] args) {

    }
}
