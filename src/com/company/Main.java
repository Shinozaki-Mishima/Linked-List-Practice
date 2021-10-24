package com.company;
import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        // create new linked list object
        LinkedList i = new LinkedList();
        // add nodes
        i.addNode(5);
        i.addNode(6);
        i.addNode(8);
        i.addNode(9);
        i.addInPlace(7);
        i.addLastNode(56);
        System.out.println("Linked List: "+i+"\n");  // print list 'i'
        System.out.println("Length of list: "+i.getCount()+"\n");  // print the length of the list.
        System.out.println("First Node: "+i.getFirstLink()+"\n");  // print the first node
        System.out.println("Last Node: "+i.getLast()+"\n");  // print the last node in the list

        Node n = new Node(5);
        i.deleteNode(n);
        System.out.println("List 'i' after 5 was deleted: "+i);
        System.out.println("List 'i' count: "+i.getCount()+"\n");

        // make second list
        LinkedList j = new LinkedList();
        // add nodes
        j.addNode(5);
        j.addNode(6);
        j.addNode(8);
        j.addNode(9);
        j.addInPlace(7);
        j.addLastNode(56);

        System.out.println("Is list 'i' equal to 'j': "+i.isEqual(j));  // print the returning value

        Node n1 = new Node(5);
        j.deleteNode(n1);  // delete node n1
        // compare both lists again to check if it's equal
        System.out.println("Is list 'i' equal to 'j' after 5 is deleted: "+i.isEqual(j));

        System.out.println("List: "+i);  // print list i
        i.reverseList();  //  call reverse function and reverse list 'i'
        System.out.println("Reverse: "+i);  // print the reversed list

        System.out.println("Copy of list: "+i.copyList()+"\n");  // print a copy of the list 'i'

        /* create new list, ask user for input to populate the newly created list.
        create another list, copy the data of the 1st lis over to it, if the lists are palindrome
        make an appropriate notification to the user.*/
        Scanner sc = new Scanner(System.in);  // initialize Scanner
        LinkedList list = new LinkedList();  // create a new linked list instance
        System.out.println("Enter 5 numbers");  // prompt the user for 5 numbers
        int temp=0;  // store user input in temp
        for(int t =0; t<5; t++)  // create for loop to prompt 5 times
        {
            temp = sc.nextInt();  // store input
            list.addNode(temp);  // add input to list
        }
        System.out.println("List 1: "+list);  // print list 1
        LinkedList list2 = new LinkedList();  // create a new linked list instance
        list2 = list.copyList();  // copy the contents of list1 into list2
        System.out.println("List2: "+list2);  // print list 2
        list2.reverseList();  // reverse list2
        if(list.isEqual(list2))   // condition, if both lists are equal
        {
            // print the following notification
            System.out.println("List1 and List2 are palindrome");
        }
        else
        {
            // if not, print the following notification
            System.out.println("List1 and List2 aren't a palindrome");
        }
        System.out.println();
        // make a new list in ascending order to test isSort function
        LinkedList sortTest = new LinkedList();
        sortTest.addNode(-9);
        sortTest.addNode(2);
        sortTest.addNode(40);
        sortTest.addNode(4);
        // check to see if list A is sorted in
        System.out.println("LinkedList A is in Ascending order: "+sortTest.isSortedAscending(sortTest.getFirstLink()));
        System.out.println("List before reverse"+sortTest);  // print list before reverse
        System.out.println("Reversed LinkList: "+sortTest.reverseLinkedList(sortTest));  // print reversed list
        System.out.println("Largest Number in List: "+sortTest.getLargestElement(sortTest.getFirstLink())+"\n");

        // create a linked list and sort in descending order
        LinkedList sortAscend = new LinkedList();
        sortAscend.addNode(240);
        sortAscend.addNode(269);
        sortAscend.addNode(54);
        sortAscend.addNode(260);
        System.out.println("List before sort: "+sortAscend);
        sortAscend.sortAscendingTest(sortAscend);
        System.out.println("List after sort: "+sortAscend+"\n");


        // integer to binary
        LinkedList newList = new LinkedList();
        System.out.println("Enter a decimal number to convert to binary: ");
        int decimal = sc.nextInt();
        newList.addNode(decimal);
        System.out.println("Your decimal, "+decimal+", to binary is: "+newList.integerToBinary(decimal)+"\n");
        //binary to integer
        LinkedList newList1 = new LinkedList();
        newList1.addNode(1);
        newList1.addNode(0);
        newList1.addNode(1);
        newList1.addNode(1);
        System.out.println("The binary: "+newList1+" to integer is:"+newList1.binaryToInteger());
    }  // end of main
}  //  end of class

