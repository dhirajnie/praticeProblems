package arrayRotation;

import java.util.ArrayList;
import java.util.List;

public class UniqueElement {

    public static void main(String[] args) {
        int a[]={12,3,6,6,7,12,12,12,12,12,12,109};
        int temp[] = new int[1000];

        for(int i= 0;i<a.length;i++){
            if(temp[a[i]]==0){

                temp[a[i]]=1;
            }
        }
        for(int i=0;i<temp.length;i++){
            if(temp[i]==1){
                System.out.println(i);
            }
        }


    }
}
