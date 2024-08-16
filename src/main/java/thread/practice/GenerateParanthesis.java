package thread.practice;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {


    List<String> result = new ArrayList<>();
    void recur( String currParanthesis, int open,int max,int close) {
        if(currParanthesis.length()==2*max ) {
            System.out.println(currParanthesis);
            result.add(currParanthesis);
            return;
        }
        else{
            if(open<max){
                recur(currParanthesis+"(",open+1,max,close);
            }
            if(close<open)
                recur(currParanthesis+")",open,max,close+1);
        }
    }

    public List<String> generateParenthesis(int n) {
        recur("",0, 2,0);
        return result;
    }



    public static void main(String[] args) {
        System.out.println(new GenerateParanthesis().generateParenthesis(2));
    }
}
