package com.sparta.abdul.binaryTree;
import com.sparta.abdul.exceptions.ChildNotFoundException;

public class BinaryTreeSearch implements BinaryTree{
    Node root;
    int numberOfElements;

    @Override
    public int getRootElement() {
        return root.value;
    }

    @Override
    public int getNumberOfElements() {
        int totalElements = getNumberOfElements(root);
        numberOfElements = 0;
        return totalElements;
    }
    public int getNumberOfElements(Node currentElement){
        if(currentElement != null) {
            getNumberOfElements(currentElement.leftChild);
            numberOfElements++;
            getNumberOfElements(currentElement.rightChild);
        }
        return numberOfElements;
    }

    @Override
    public void addElement(int element) {
        Node newNode = new Node(element);
        if(root == null){
            root = newNode;
        }
        else{
            Node currentNode = root;
            Node parent;
            while(true) {
                parent = currentNode;
                if (element < currentNode.value) {
                    currentNode = currentNode.leftChild;
                    if (currentNode == null) {
                        parent.leftChild = newNode;
                        return;
                    }
                }
                else{
                    currentNode = currentNode.rightChild;
                    if (currentNode == null) {
                        parent.rightChild = newNode;
                        return;
                    }
                }
            }
        }
    }

    @Override
    public void addElements(int[] elements) {
        for(int element:elements){
            addElement(element);
        }
    }

    @Override
    public boolean findElement(int value) {
        Node currentValue = root;
        while(currentValue.value != value){
            if(value<currentValue.value){
                currentValue = currentValue.leftChild;
            }
            else{
                currentValue = currentValue.rightChild;
            }
            if(currentValue == null){
                return false;
            }
        }

        return true;
    }

    @Override
    public int getLeftChild(int element) throws ChildNotFoundException {
        Node currentValue = root;
        while(currentValue.value != element){
            if(element<currentValue.value){
                currentValue = currentValue.leftChild;
            }
            else{
                currentValue = currentValue.rightChild;
            }
            if(currentValue == null){
                throw new IllegalArgumentException("Value doesn't exist.");
            }
        }
        Node leftChild = currentValue.leftChild;
        if(leftChild==null){
            throw new ChildNotFoundException("This value doesn't have a right child.");
        }
        return leftChild.value;
    }

    @Override
    public int getRightChild(int element) throws ChildNotFoundException {
        Node currentValue = root;
        while(currentValue.value != element){
            if(element<currentValue.value){
                currentValue = currentValue.leftChild;
            }
            else{
                currentValue = currentValue.rightChild;
            }
            if(currentValue == null){
                throw new IllegalArgumentException("Value doesn't exist.");
            }
        }
        Node rightChild = currentValue.rightChild;
        if(rightChild==null){
            throw new ChildNotFoundException("This value doesn't have a right child.");
        }

        return rightChild.value;
    }

    @Override
    public int[] getSortedTreeAsc() {
        getSortedTreeAsc(root);
        return new int[0];
    }
    public int[] getSortedTreeAsc(Node currentElement) {
        if(currentElement != null) {
            getSortedTreeAsc(currentElement.leftChild);
            System.out.print(currentElement.value+" ");
            getSortedTreeAsc(currentElement.rightChild);
        }
        return new int[0];
    }

    @Override
    public int[] getSortedTreeDesc() {
        getSortedTreeDesc(root);
        return new int[0];
    }
    public int[] getSortedTreeDesc(Node currentElement) {
        if(currentElement != null) {
            getSortedTreeDesc(currentElement.rightChild);
            System.out.print(currentElement.value +" ");
            getSortedTreeDesc(currentElement.leftChild);

        }
        return new int[0];
    }
    //inner class node
    class Node {
        int value;
        Node leftChild;
        Node rightChild;
        public Node(int value){
            this.value = value;
        }
    }
}
