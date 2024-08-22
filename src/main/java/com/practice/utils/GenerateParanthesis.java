package com.practice.utils;

import java.util.ArrayList;
import java.util.List;

public class GenerateParanthesis {

    void generteEachParanthesis(int maxLength, boolean isOpen, int openCount, String currentStr, List<String> result) {
        System.out.println(currentStr);
        if (currentStr.length() > maxLength * 2) {
            return;
        } else if (openCount == maxLength && currentStr.length() == maxLength * 2) {
            result.add(currentStr);
            return;
        } else if (isOpen == true) {
            generteEachParanthesis(maxLength, true, openCount + 1, currentStr + "(", result);
            generteEachParanthesis(maxLength, false, openCount, currentStr + ")", result);
        } else if (isOpen == false) {
            generteEachParanthesis(maxLength, true, openCount + 1, currentStr + "(", result);
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generteEachParanthesis(n,false,0,"",result);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(new GenerateParanthesis().generateParenthesis(4));
    }
}
