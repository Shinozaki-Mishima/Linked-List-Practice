package com.company;

public class charLinkedListTester {

    public static void main(String[] args)
    {
        // testing class for character linked list

        // make instance of the character list class
        charLinkedList list = new charLinkedList();
        // add nodes to list
        list.addNode('s');
        list.addNode('e');
        list.addNode('c');
        list.addNode('n');
        list.addNode('e');
        list.addNode('r');
        list.addNode('r');
        list.addNode('u');
        list.addNode('c');
        list.addNode('c');
        list.addNode('o');

        // print list
        System.out.println(list);
        // replace an occurrence of a character in the list
        list.replaceNode('c', 'k');
        System.out.println("List after replace: "+list);

        list.deleteOccurrences('k');
        System.out.println("List after the occurrences of k is deleted: "+list);

        charLinkedList n = new charLinkedList();
        n.addNode('t');
        n.addNode('c');
        n.addNode('o');
        System.out.println("List 'n' to lowercase:"+n.lowerCase());

        charLinkedList n1 = new charLinkedList();
        n1.addNode('s');
        n1.addNode('u');
        n1.addNode('p');
        n1.addNode('o');
        n1.addNode('t');
        n1.addNode('c');
        n1.addNode('o');
        if(n1.isSubstring(n.getFirstLink()))
        {
            System.out.println("LIST FOUND");
        }
        else
        {
            System.out.println("LIST NOT FOUND");
        }
    }
}
