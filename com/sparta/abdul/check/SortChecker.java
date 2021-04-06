package com.sparta.abdul.check;

public class SortChecker {
    public static boolean isSorted(int[] numberArray){
        boolean sortCheck = false;
        int sortCount = 0;
        for (int j = 0; j < numberArray.length-1; j++) { // Number of comparisons
            if (numberArray[j] <= numberArray[j + 1]) {// Count increases if one index of the arya is less than the one after
                sortCount++;
            }
        }
        if(sortCount == numberArray.length-1){//If it is sorted true is returned
            sortCheck = true;
        }
        return sortCheck;

    }
}
