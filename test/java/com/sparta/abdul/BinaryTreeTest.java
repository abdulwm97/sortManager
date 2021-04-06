package com.sparta.abdul;
import com.sparta.abdul.binaryTree.BinaryTreeSearch;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BinaryTreeTest {
    @Test
    public void expectAmountOfElements(){
        int[] elements = {8,9,2,3,6,11};
        BinaryTreeSearch binaryTree = new BinaryTreeSearch();
        binaryTree.addElements(elements);
        Assertions.assertEquals(6,binaryTree.getNumberOfElements());
    }
}
