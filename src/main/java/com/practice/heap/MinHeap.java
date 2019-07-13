package com.practice.heap;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;


public class MinHeap
{


    public static void main1( String args[] )
    {
        Heap heap = new Heap();
        heap.addElement( -3 );
        heap.addElement( -13 );
        heap.addElement( -40 );
        heap.addElement( 2 );
        heap.addElement( 0 );
        heap.addElement( 1 );
        System.out.println(heap.peek());
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );
        System.out.println( heap.removeElement() );


    }
    static final Scanner sc = new Scanner( System.in );
    public static void main(String args[]){

        Heap heap = new Heap();

        int testCases= sc.nextInt();
        while ( testCases!=0 ){

            int op= sc.nextInt();
            if(op==1){
                int element= sc.nextInt();

                heap.addElement( element );

            }
            else if(op==2){
                heap.deleteElement(sc.nextInt());
            }
            else{
                System.out.println(heap.peek());
            }

            --testCases;
        }
    }
}



class Heap
{

    int elementData[] = new int[100];
    int size = 0;


    public int removeElement()
    {
        if(size<0){
            throw new NoSuchElementException();

        }
        int minimum_Item =elementData[0];
        if ( size > 1 ) {

            elementData[0] = elementData[size - 1];
            heapDown(0);
        }
        --size;
        System.out.println("Size"+size);
        return minimum_Item;


    }
    public void deleteElement(int element)
    {

        int elementIndex = -1;
        for ( int i = 0; i < size; i++ ) {
            if ( elementData[i] == element ) {
                elementIndex = i;
                break;
            }

        }
        if(elementIndex>-1){
            elementData[elementIndex]=elementData[size-1];
            --size;
            heapDown(elementIndex);
        }
    }


    private void heapDown(int index)
    {


        while ( 2*index+2<size ){
            int elgibleIndex = index;
            if(2*index+1<size && elementData[elgibleIndex]>elementData[2*index+1]){
                elgibleIndex=2*index+1;
            }

            if(2*index+2<size &&  elementData[elgibleIndex]>elementData[2*index+2]){
                elgibleIndex=2*index+2;

            }
            if(elgibleIndex!=index){
                int temp = elementData[elgibleIndex];
                elementData[elgibleIndex]=elementData[index];
                elementData[index]=temp;
                index=elgibleIndex;
            }
            else {
                break;
            }


        }


    }


    public void addElement( int element )
    {

        elementData[size] = element;
        ++size;
        heapifyUp();


    }


    public int peek()
    {
        if ( size > 0 )
            return elementData[0];
        else {
            throw new NoSuchElementException();
        }
    }


    private void heapifyUp()
    {
        int index = size - 1;
        while ( index != 0 ) {
            int secondChilData = elementData[index];
            int firstChildData = elementData[index - 1];
            int parentData = elementData[( index - 1 ) / 2];
            if ( parentData > firstChildData || parentData > secondChilData ) {
                if ( firstChildData > secondChilData || size < 3 ) {
                    int temp = elementData[index];
                    elementData[index] = elementData[( index - 1 ) / 2];
                    elementData[( index - 1 ) / 2] = temp;
                  //  System.out.println( "Heapify" );

                } else {
                    int temp = elementData[index - 1];
                    elementData[index - 1] = elementData[( index - 1 ) / 2];
                    elementData[( index - 1 ) / 2] = temp;
                   // System.out.println( "Heapify" );

                }
                index = ( index - 1 ) / 2;

            } else {
                break;
            }

        }

    }


}

