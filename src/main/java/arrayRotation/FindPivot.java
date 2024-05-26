package arrayRotation;

public class FindPivot
{

    public static void main(String ars[]){


        int inp[]={0,1,3,4,5,6,77,98,100,101,102,-2,-1,0,1,2,3,4,5,6};

        System.out.println(findPivot(inp,0,inp.length-1));





    }


    private static int findPivot( int[] inp,int low,int high )
    {
        if(low>high)
        {
            return -1;
        }
        else{
            int mid = (low+high)/2;
            if(mid>0 && mid<inp.length-1 && inp[mid]<inp[mid-1] &&inp[mid]<inp[mid+1] ){
                return mid;
            }
            else if(inp[mid]>=inp[low] && inp[mid]>=inp[high]){
              return   findPivot( inp,mid+1,high );
            }

            else {
                return findPivot( inp, low, mid - 1 );
            }

        }

    }


}
