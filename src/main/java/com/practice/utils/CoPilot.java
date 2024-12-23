package com.practice.utils;

import com.practice.Utils;

public class CoPilot {

//add a method to verify the email string provided is valid or not and also the domain name always ends with
    public boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        //change below regex to accept
            return email.matches("^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$");
    }

    public static void main(String[] args) {
        int nums[]={2,0,0,1,0,1,1,1,2,2};
    new SortColor().sortColors(nums);
         Utils.print(nums);

    }

}
