package arrayRotation;

public class SortTwoArray {

    public static void main(String[] args) {

        int a[]= {1,2,5,0,0,0};
        int b[] = {3,8,10};

        int i = 2;
        int j = b.length-1;
        int n = a.length-1;

        while(i>=0 && j>= 0){
            if(a[i]> b[j]){
                a[n]=a[i];
                --n;
                --i;
                System.out.println("Moved first");
            }
            else{
                a[n]=b[j];
                --n;
                --j;
                System.out.println("Moved Second");
            }
            System.out.println("i"+i+"j"+j+"n"+n);
        }

        if(j>=0){
            System.out.println("Coptiny");
            for(int k =0;k<=j;k++){
                a[k]= b[k];
            }
        }
        print(a);
//        System.out.println(b);
    }

    public static void print(int a[]){
        for(int i =0;i<a.length;i++){
            System.out.println(a[i]+" ");
        }
    }
}
