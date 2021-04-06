package com.sparta.abdul;
import com.sparta.abdul.sort.MergeSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MergeSortTest {
    @Test
    public void sortedAnswer(){
        int[] arrayToSort = {2,8,3,9,1,6,5,6,7,4};
        int[] expectedArray = {1,2,3,4,5,6,6,7,8,9};
        MergeSort mergeSort = new MergeSort();
        Assertions.assertArrayEquals(expectedArray, mergeSort.sortArray(arrayToSort));
    }
    @Test
    public void expectNullException(){
        MergeSort mergeSort = new MergeSort();
        Assertions.assertThrows(NullPointerException.class, () -> {
            mergeSort.sortArray(null);
        });
    }
    @Test
    public void expectEmptyStringException(){
        MergeSort mergeSort = new MergeSort();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            mergeSort.sortArray(new int[0]);
        });
    }
}
