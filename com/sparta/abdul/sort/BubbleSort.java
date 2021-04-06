package com.sparta.abdul.sort;
import com.sparta.abdul.sortingInterface.Sorter;
import com.sparta.abdul.check.SortChecker;
public class BubbleSort implements Sorter{

    public int[] sortArray(int[] arrayToSort){
        if(arrayToSort == null){
            throw new NullPointerException("There isn't an array to sort.");
        }
        if(arrayToSort.length==0){
            throw new ArrayIndexOutOfBoundsException("Array can't be empty.");
        }
        for (int i = 0; i < arrayToSort.length; i++) {// Maximum possible comparisons possible
            int noOfComparisons = arrayToSort.length - 1 - i;
            for (int j = 0; j < noOfComparisons; j++) { // Number of comparisons
                if (arrayToSort[j] > arrayToSort[j + 1]) {// Switches values if the first one is greater
                    int tempValue = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + 1];
                    arrayToSort[j + 1] = tempValue;
                }
            }

            //Commented code can be used to see array is being sorted in each itteration
//            for (int nums:arrayToSort) {
//                System.out.print(nums+" ");
//
//            }
//            System.out.println("");
            if (SortChecker.isSorted(arrayToSort)) {
                break;
            }
        }
        return arrayToSort;
    }
}
