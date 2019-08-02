package hackerrank;

public class PrimeChecker {
        static int  size=1000;

        public static boolean primeMap[]=new boolean[size];
        static {
            buildMap();
        }

        public static void buildMap(){
            System.out.println("Prime map calcuation");
            for(int  i=2;i<size/2;i++){
                int j= i+i;
                if(!primeMap[i]){
                    while (j<size){
                        primeMap[j]=true;
                        j=j+i;
                    }
                }
            }
        }
        void print(int n ){
            for(int i =2;i<n;i++){
               if(!primeMap[i]){
                   System.out.println(n+" ");
               }
            }
        }

    }
