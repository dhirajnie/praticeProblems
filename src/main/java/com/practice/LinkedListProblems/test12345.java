package com.practice.LinkedListProblems;

import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.nashorn.internal.runtime.JSONFunctions;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class test12345
{
    public static void main( String args[] ) throws ParseException
    {

        List<String > list= new ArrayList<>();
        List<String> newList = Collections.unmodifiableList(list);
        newList.add("as");
        System.out.println(newList);

        List<String> newList1 = new ArrayList<>();
        newList1.add("ass");
        newList1.add("assd");
        newList1.add("asse");



    }

}
