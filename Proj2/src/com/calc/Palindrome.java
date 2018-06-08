package com.calc;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Palindrome {

    public static void main(String[] args) {

        System.out.println("*** Palindrome checker ***");
        System.out.print("Input string: ");

        Scanner scnr = new Scanner(System.in); //Create input scanner
        String input = scnr.nextLine(); //Reads the input
        Queue queue = new LinkedList(); //Creates the queue

        String reversed = "";

        for (int i = input.length() - 1; i >= 0; i--) { // Add chars to queue
            queue.add(input.charAt(i));
        }

        while (!queue.isEmpty()) { //Checking sting char by char
            reversed = reversed + queue.remove();
        }

        if (input.equals(reversed)) { // is string palindrome? Y / N
            System.out.println("Result : " + input + " is a palindrome");
        } else {
            System.out.println("Result : " + input + " is not a palindrome");
        }

    }
}
