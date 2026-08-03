package org.saurabh.ds_basics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        //Stack

        Stack<Integer> myStack = new Stack<>();
        myStack.push(5);

        if(!myStack.empty()){
            System.out.println("Stack element : " + myStack.peek() + " - " + myStack.pop() + " Size : " + myStack.size());
        }

        //List

        // Fast initialization, immutable list
        List<Integer> immutable = List.of(1, 2, 3, 4, 5, 6, 7, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1);

        //Mutable. Copies all elements of immutable list to mutable list
        List<Integer> mutable = new ArrayList<>(immutable);

        mutable.add(5);
        mutable.size();

        //Inplace reversal
        Collections.reverse(mutable);

        System.out.println("Original : " + mutable);



    }
}
