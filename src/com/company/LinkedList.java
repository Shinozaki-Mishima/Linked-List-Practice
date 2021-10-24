package com.company;

public class LinkedList {

    //create private instance off node
    private Node firstLink;

    //getters and setters
    public Node getFirstLink()
    {
        return firstLink;
    }
    public void setFirstLink(Node firstLink)
    {
        this.firstLink = firstLink;
    }
    // create function to test if variable is null
    public boolean isEmpty()
    {
        return this.firstLink == null;
    }
    //create a function to add data into our list
    public void addNode(int data)
    {
        /*create instance of node  &Allocate the data to node*/
        Node newNode = new Node(data);
        //set the current first link to the next link
        newNode.setNext(firstLink);
        //Move the head to point to new Node
        firstLink = newNode;
    }
    //function to add to the end of list
    public Node getLast()
    {
        Node currentNode = firstLink;
        while(currentNode.getNext() != null)
        {
            currentNode = currentNode.getNext();
        }
        return currentNode;
    }
    //function to add node to the last position
    public void addLastNode(int data)
    {
        Node newNode = new Node(data);//make instance of node and store data
        if(isEmpty())//if firstlink is null make the newNode equal to first link
        {
            firstLink = newNode;
        }else
        {//if the list is not null, make a temporary node = to first link
            Node currentNode = firstLink;
            //while the temporary node is NOT null, get the next node
            while(currentNode.getNext() != null)
            {
                currentNode = currentNode.getNext();
            }//after reaching the last node, set next equal to the new Node
            currentNode.setNext(newNode);
        }
    }
    // make a toString method
    public String toString()
    {
        String contents = "{";
        Node currentNode = firstLink;
        while(currentNode!=null)
        {
            contents += currentNode.getData()+" ";
            currentNode=currentNode.getNext();
        }
        contents += "}";
        return contents;
    }
    /* This functions inserts n in its ordered position in a (possibly empty)
	 list pointed to by head, and returns a pointer to the new list*/
    public void addInPlace(int data)
    {
        Node newNode = new Node(data);  // make instance of node and store dataNode previous = null;
        Node currentNode = firstLink;  // make a current node variable and set it = to the first link
        Node previousNode = null;  // create a previous node variable
        // while the current node is not null
        // and current node when compared to new node is greater than 0
        while(currentNode!=null&&currentNode.compareTo(newNode)>0)
        {
            // store current node in previous node
            previousNode = currentNode;
            // make the new current node = to previousNode.getNext
            currentNode = previousNode.getNext();
        }
        newNode.setNext(currentNode);
        if (previousNode != null)
        {
            previousNode.setNext(newNode);
        }else
        {
            firstLink = newNode;
        }
    }

    // make a function to count the number of nodes stored in the list
    public int getCount()
    {
        int count = 0;  // make an integer count
        Node temp = firstLink;  // create a temporary node and set it to first link
        // create while loop
        while(temp != null)  // once node temp is not null,
        {
            count++;  // increment count
            temp = temp.getNext();  // and set temp node equal to the next node in the list
        }
        return count;  // return count
    }
    // function to delete node
    public void deleteNode(Node n)
    {
        if(isEmpty())  // if list is empty
        {
            return;
        }
        else
        {
            Node currentNode = firstLink;  // create temporary node and set it equal too firstlink
            Node previousNode = null;  // create temporary node = null
            // make a while loop, whereby current node  is not null, and current node when compared to
            // node n is not 0 (same)
            while(currentNode != null && currentNode.compareTo(n) != 0)
            {
                previousNode = currentNode;  // set previous to currentNode
                currentNode = currentNode.getNext();  // set currentNode to Next
            }
            if(currentNode != null)  // if current is not null
            {
                if(previousNode!=null)  // and previous is not null
                {
                    // set previous to next link in current node
                    previousNode.setNext(currentNode.getNext());
                }
                else
                {
                    firstLink = firstLink.getNext();  // set firstlink equal to the next link
                }
            }
        }
    }  // end of function

    // function to test if two lists are equal
    public boolean isEqual(LinkedList list)
    {
        Node temp1 = this.firstLink;  //
        Node temp2 = list.firstLink;  //

        while(temp1 != null && temp2 != null)  //
        {
            if(temp1.compareTo(temp2) != 0)  //
            {
                return false;  //
            }
            else  //
            {
                temp1 = temp1.getNext();  //
                temp2 = temp2.getNext();  //
            }
        }
        if(temp1 != null || temp2 != null)  //
        {
            return false;  //
        }
        return true;  //
    }  // end of function

    // function to reverse linked list
    public void reverseList()
    {
        Node p1, p2, p3;  //
        //
        if(firstLink == null || firstLink.getNext() == null)
        {
            return;  //
        }
        p1 = firstLink;  //
        p2 = p1.getNext();  //
        p1.setNext(null);  //
        while(p2 != null)  //
        {
            p3 = p2.getNext();  //
            p2.setNext(p1);  //
            p1=p2;  //
            p2=p3;  //
        }
        firstLink = p1;  //
    }  // end of reverse link function

    // create functions to copy a linked list
    public LinkedList copyList()
    {
        LinkedList temporaryList = new LinkedList();  //
        Node currentNode = this.firstLink;  //
        while(currentNode!=null)  //
        {
            //
            temporaryList.addLastNode(currentNode.getData());
            //
            currentNode = currentNode.getNext();
        }
        return temporaryList;  //
    }  // end of copy list function

    // function to check if linked list is sorted in ascending order
    public boolean isSortedAscending(Node firstLink)
    {
        if(firstLink == null)  // if first node is null
        {
            return true;  // return true
        }
        /* create a for loop, whereby a new node, currentNode is equaled to firstLink;
         *  whereby current node .Next() is not null; and store currentNode.next in current node*/
        for(Node currentNode=firstLink; currentNode.getNext()!=null; currentNode=currentNode.getNext())
        {
            // if currentNode' data is  less than or equal to currentNode
            if(currentNode.getData() >= currentNode.getNext().getData())
            {
                return true;
            }
        }
        return false;
    }  // end if isSortedAscending function
    // function reverses a linked list's and creating a new list; return the new list
    // function to reverse linked list
    public LinkedList reverseLinkedList(LinkedList linkedList) {
        Node previous = null;  // make new node prev equal to null
        Node current = linkedList.firstLink;  // set current equal to the first node in the list
        Node next;  // initialize new node next
        LinkedList newList = new LinkedList();
        while (current != null) {  // while the current node is not null
            next = current.getNext();  // set node next equal to the current.next
            current.setNext(previous);  // set current.next equal to previous
            previous = current;  // set prev equal to current node
            current = next;  // and current equal to next
        }  // end of while loop
        linkedList.firstLink = previous;  // set previous to the first link in the list
        newList = linkedList;
        return newList;  // return the linkedList
    }
    // end of reverse link function

    public void sortAscendingTest(LinkedList list)
    {
        int count=0;
        Node current, max, previous,maxPrevious,startNode,previousNode;;
        Node first;
        int listCount=list.getCount();
        while(count < listCount)
        {
          ;
            startNode=previousNode= list.getFirstLink();
            for(int i=0; i<count;i++) {
                previousNode=startNode;
                startNode = startNode.getNext();
            }
                max=current=startNode;
                previous=maxPrevious=null;
                while(current!=null)
                {
                    if (current.getData() > max.getData()) {
                        maxPrevious = previous;
                        max = current;
                    }
                    previous=current;
                    current = current.getNext();
                }
            System.out.println("Max :"+max.getData());
            if(maxPrevious!=null)System.out.println("Max Previous :"+maxPrevious.getData());

                if(max.getNext()!=null)
                {
                    if(maxPrevious==null) {
                       previousNode.setNext(max.getNext());
                    } else {
                        maxPrevious.setNext(max.getNext());
                    }
                    if(max!=previousNode)max.setNext(getFirstLink());
                }
                else {
                    max.setNext(getFirstLink());
                    if(maxPrevious==null) {
                        previousNode.setNext(null);
                    } else {
                        maxPrevious.setNext(null);
                    }
                }
                count++;
                list.setFirstLink(max);

            System.out.println("Printing List :"+list);
            }
    }

    public int getLargestElement(Node firstLink)
    {
        int max = 0;
        while(firstLink != null)
        {
            if(max<firstLink.getData())
            {
                max = firstLink.getData();
            }
            firstLink = firstLink.getNext();
        }
        return max;
    }

    // num 5.) from practice convert integer to binary and store in linked list
    public LinkedList integerToBinary(int num)
    {
        LinkedList newList = new LinkedList();
        int remainder;
        while(num!=0)
        {
            remainder = num % 2;
            newList.addLastNode(remainder);
            num=num/2;
        }
        return newList;
    }
    // num 6.) from practice convert binary to decimal
    public int binaryToInteger()
    {
        Node current=this.firstLink;
        int sum=0;
        while(current!=null)
        {
            sum=sum*2+current.getData();
            current=current.getNext();
        }
        return sum;
    }
}  // end of LinkedList class
