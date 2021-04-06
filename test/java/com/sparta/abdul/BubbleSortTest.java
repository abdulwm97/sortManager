package com.sparta.abdul;
import com.sparta.abdul.sort.BubbleSort;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortTest {
    @Test
    public void sortedAnswer(){
        int[] arrayToSort = {2,8,3,9,1,6,5,6,7,4};
        int[] expectedArray = {1,2,3,4,5,6,6,7,8,9};
        BubbleSort bubbleSort = new BubbleSort();
        Assertions.assertArrayEquals(expectedArray, bubbleSort.sortArray(arrayToSort));
    }
    @Test
    public void expectNullException(){
        BubbleSort bubbleSort = new BubbleSort();
        Assertions.assertThrows(NullPointerException.class, () -> {
            bubbleSort.sortArray(null);
        });
    }
    @Test
    public void expectEmptyStringException(){
        BubbleSort bubbleSort = new BubbleSort();
        Assertions.assertThrows(ArrayIndexOutOfBoundsException.class, () -> {
            bubbleSort.sortArray(new int[0]);
        });
    }
}
