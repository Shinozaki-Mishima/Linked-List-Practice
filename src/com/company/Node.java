package com.company;

public class Node {
    // create 2 fields 1: data type, 2: Node
    private int data;
    private Node next;
    private char charData;
    // constructor
    public Node(int data)
    {
        this.data = data;
        this.next = null;
    }
    // constructor for Nodes with a char data type
    public Node(char charData)
    {
        this.charData=charData;
        this.next=null;
    }
    // getters and setters for private fields
    public int getData()
    {
        return this.data;
    }
    public void setData(int data)
    {
        this.data = data;
    }
    public Node getNext() {
        return this.next;
    }
    public void setNext(Node next)
    {
        this.next = next;
    }

    public char getCharData()
    {
        return this.charData;
    }
    public void setCharData(char charData)
    {
        this.charData = charData;
    }

    // toString for integers
    public String toString()
    {
        return "Data:" + data;
    }
    // toString for char
    public String charToString()
    {
        return "Data: "+this.charData;
    }
    // function to compare two nodes
    public int compareTo (Node n)
    {
        if(this.data == n.data)  // if the data in the node = n
        {
            return 0;  // return zero
        }
        else if(this.data < n.data)  // if the data is less than n.data, return -1
        {
            return -1;
        }else  // if the data is greater than n.data, return 1
        {
            return 1;
        }
    }
}  //end of Node Class