package com.sparta.abdul.printing;

public class Printer {
    public static void printSortOrder(int[] numberList){// Prints out the sorted array
        System.out.print("Sorted: ");
        for(int number:numberList){
            System.out.print(number+" ");
        }
        System.out.println();
    }
}
