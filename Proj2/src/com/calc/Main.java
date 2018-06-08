package com.calc;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        System.out.print("Input postfix equation: ");
        Scanner scnr = new Scanner(System.in);  //Create input scanner
        String input = scnr.nextLine();         //Reads the input

        System.out.print(calcPostFix(input));   //Calculates and prints result
    }

    public static String calcPostFix(String string) {

        Stack<String> stack = new Stack<>();    // Initialize the stack
        ArrayList<String> tokens = new ArrayList<>();   // Create ArrayList


        /*Using the string tokenizer, we are able to separate the string by whitespaces.
         With each string separated individually, the programs adds each to an array list.*/
        StringTokenizer st = new StringTokenizer(string);
        while (st.hasMoreTokens()) {
            tokens.add(st.nextToken());
        }

        Iterator<String> iterator = tokens.iterator();  // Implement iteration over arraylist 'tokens'

        while (iterator.hasNext()) {    // Check for another iteration


            int topStack;       //variable on top of the stack
            int secondStack;    //Variable second to the top-most on the stack

            String var = iterator.next();

            if (var.matches("[0-9]*")) {    //Validate character is between 0 and 9, if it is
                stack.push(var);                  //push variable to the stack
            } else if (var.matches("[+-/*]")) { //Validate character is ''
                if (var.equals("+")) {
                    topStack = Integer.parseInt(stack.pop());
                    secondStack = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(secondStack + topStack));
                } else if (var.equals("-")) {
                    topStack = Integer.parseInt(stack.pop());
                    secondStack = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(secondStack - topStack));
                } else if (var.equals("/")) {
                    topStack = Integer.parseInt(stack.pop());
                    secondStack = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(secondStack / topStack));
                } else if (var.equals("*")) {
                    topStack = Integer.parseInt(stack.pop());
                    secondStack = Integer.parseInt(stack.pop());
                    stack.push(String.valueOf(secondStack * topStack));
                }
            } else {
                return "Error: Only use numbers and operators";
            }
        }
        return stack.pop();
    }
}