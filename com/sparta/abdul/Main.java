package com.sparta.abdul;
import com.sparta.abdul.binaryTree.BinaryTreeSearch;
import com.sparta.abdul.exceptions.ChildNotFoundException;
import com.sparta.abdul.sort.BubbleSort;
import com.sparta.abdul.printing.Printer;
import com.sparta.abdul.sort.MergeSort;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        int[] numberArray = {2,8,3,9,1,6,5,6,7,4};
        //Using bubble sort class created...........................................................
        try {
            System.out.println("Bubble Sort:");
            BubbleSort bubbleSortObject = new BubbleSort();
            Printer.printSortOrder(bubbleSortObject.sortArray(null));
        }catch (NullPointerException npe){
            System.out.printf("%s%n",npe.getMessage());
        }catch (ArrayIndexOutOfBoundsException aioobe){
            System.out.printf("%s%n",aioobe.getMessage());
        }

        //Using merge sort class created............................................................
        try {
            System.out.println("Merge Sort:");
            MergeSort mergeSort = new MergeSort();
            Printer.printSortOrder(mergeSort.sortArray(numberArray));
        }catch (NullPointerException npe){
            System.out.printf("%s%n",npe.getMessage());
        }
        catch (ArrayIndexOutOfBoundsException aioobe){
            System.out.printf("%s%n",aioobe.getMessage());
        }
        //Using binary tree..........................................................................
        BinaryTreeSearch binaryTree = new BinaryTreeSearch();
        int[] elements = {2,3,7,13};
        //adding elements to the binary tree
        binaryTree.addElement(0);
        binaryTree.addElement(6);
        binaryTree.addElement(30);
        binaryTree.addElement(9);
        binaryTree.addElement(11);
        binaryTree.addElements(elements);

        System.out.println("elements in ascending order:");
        binaryTree.getSortedTreeAsc();
        System.out.println();
        System.out.println("elements in descending order:");
        binaryTree.getSortedTreeDesc();
        System.out.println();
        System.out.println("The root node is "+binaryTree.getRootElement()+".");
        System.out.println("The number of nodes available is "+binaryTree.getNumberOfElements()+".");
        System.out.println("Does the value 30 exist = "+binaryTree.findElement(30));
        try {
            System.out.println("right child of 0 is " + binaryTree.getRightChild(0));
        }catch (ChildNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }

        try {
            System.out.println("left child of 30 is " + binaryTree.getLeftChild(30));
        }catch (ChildNotFoundException cnfe){
            System.out.println(cnfe.getMessage());
        }catch (IllegalArgumentException iae){
            System.out.println(iae.getMessage());
        }
    }
}
