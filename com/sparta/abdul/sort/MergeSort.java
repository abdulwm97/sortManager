package com.sparta.abdul.sort;
import com.sparta.abdul.sortingInterface.Sorter;
import com.sparta.abdul.check.SortChecker;

public class MergeSort implements Sorter{

    public int[] sortArray(int[] arrayToSort){
        if(arrayToSort == null){
            throw new NullPointerException("There isn't an array to sort.");
        }
        if(arrayToSort.length==0){
            throw new ArrayIndexOutOfBoundsException("Array can't be empty.");
        }
        if(arrayToSort.length==1 || SortChecker.isSorted(arrayToSort)) {
            return arrayToSort;
        }

        int midPoint = arrayToSort.length/2;
        int[] leftArray = new int[midPoint];
        int[] rightArray = new int[arrayToSort.length - midPoint];

        for(int i = 0; i<midPoint;i++){
            leftArray[i] = arrayToSort[i];
        }

        int positionOfSecondArray = 0;
        for(int j = midPoint; j < arrayToSort.length;j++){
            rightArray[positionOfSecondArray] = arrayToSort[j];
            positionOfSecondArray++;
        }


        sortArray(leftArray);
        sortArray(rightArray);
        int[] sorted = merge(leftArray,rightArray,arrayToSort);
        return sorted;
    }


    public int[] merge(int[] leftArray,int[] rightArray,int[] arrayToSort){
        int leftArrayPosition = 0;
        int rightArrayPosition = 0;
        int mergedArrayPosition = 0;
        while(leftArrayPosition<leftArray.length && rightArrayPosition<rightArray.length) {
            if (leftArray[leftArrayPosition] < rightArray[rightArrayPosition]) {
                arrayToSort[mergedArrayPosition] = leftArray[leftArrayPosition];
                leftArrayPosition++;
                mergedArrayPosition++;
            } else if (leftArray[leftArrayPosition] > rightArray[rightArrayPosition]) {
                arrayToSort[mergedArrayPosition] = rightArray[rightArrayPosition];
                rightArrayPosition++;
                mergedArrayPosition++;
            } else {
                arrayToSort[mergedArrayPosition] = leftArray[leftArrayPosition];
                leftArrayPosition++;
                mergedArrayPosition++;
                arrayToSort[mergedArrayPosition] = rightArray[rightArrayPosition];
                rightArrayPosition++;
                mergedArrayPosition++;
            }
        }
        while(leftArrayPosition<leftArray.length){
            arrayToSort[mergedArrayPosition] = leftArray[leftArrayPosition];
            mergedArrayPosition++;
            leftArrayPosition++;
        }
        while(rightArrayPosition<rightArray.length){
            arrayToSort[mergedArrayPosition] = rightArray[rightArrayPosition];
            mergedArrayPosition++;
            rightArrayPosition++;
        }
        return arrayToSort;
    }
}
