package com.company;

public class charLinkedList
{
    private Node firstLink;  // initialize node
    // getters and setters
    public Node getFirstLink()
    {
        return this.firstLink;
    }
    public void setFirstLink(Node firstLink)
    {
        this.firstLink=firstLink;
    }
    public boolean isEmpty()
    {
        return this.firstLink==null;
    }
    public String toString()
    {
        String contents="{";
        Node current=this.firstLink;
        while(current!=null)
        {
            contents+= current.getCharData()+" ";
            current=current.getNext();
        }
        contents+="}";
        return contents;
    }
    public void addNode(char character)
    {
        Node newNode = new Node(character);
        newNode.setNext(firstLink);
        firstLink=newNode;
    }
    public void replaceNode (char c1, char c2)
    {
        if(isEmpty())
        {
            return;
        }
        Node current = firstLink;
        while(current!=null)
        {
            if(current.getCharData()==c1)
            {
                current.setCharData(c2);
            }
            current=current.getNext();
        }
    }
    // delete node function used within our delete occurrence function:
    public void deleteNode(Node n)
    {
        if(isEmpty())
        {
            return;
        }
        Node current = firstLink;
        Node previous = null;
        while(current!=null && current.getCharData() != n.getCharData())
        {
            previous = current;
            current = current.getNext();
        }
        if(current!=null)
        {
            if(previous!=null)
            {
                previous.setNext(current.getNext());
            }
            else
            {
                firstLink = firstLink.getNext();
            }
        }
    }
    public void deleteOccurrences(char a)
    {
        if(isEmpty())
        {
            return;
        }
        Node current = firstLink;
        while(current!=null)
        {
            if(current.getCharData()==a)
            {
                deleteNode(current);
            }
            current = current.getNext();
        }
    }

    public void addInPlace(char character)
    {
        Node n = new Node(character);
        Node current = firstLink;
        Node previous = null;

        while (current != null && current.getCharData() > n.getCharData())
        {
            previous = current;
            current = current.getNext();
        }
        n.setNext(current);
        if (previous != null)
        {
            previous.setNext(n);
        } else
        {
            firstLink = n;
        }
    }
    public void reverse()
    {
        Node p1,p2,p3;
        if(this.firstLink==null||this.firstLink.getNext()==null)
        {
            return;
        }
        p1=firstLink;
        p2=p1.getNext();
        p1.setNext(null);
        while(p2!=null)
        {
            p3=p2.getNext();
            p2.setNext(p1);
            p1=p2;
            p2=p3;
        }
        firstLink=p1;
    }
    public charLinkedList lowerCase()
    {
        charLinkedList newList = new charLinkedList();
        Node current=this.firstLink;
        while(current!=null)
        {
            newList.addInPlace(Character.toLowerCase(current.getCharData()));
            current = current.getNext();
        }
        newList.reverse();
        return newList;
    }
    public boolean isSubstring(Node first)
    {
        Node second;
        Node node1 = first;
        Node node2 = second = this.firstLink;
        // If both linked lists are empty, return true
        if (first == null && second == null)
        {
            return true;
        }
        // if one is empty and other is not return false
        if (first == null || (first != null && second == null))
        {
            return false;
        }
        // Traverse the second list by picking nodes one by one
        while (second != null)
        {
            // Initialize ptr2 with
            // current node of second
            node2 = second;

            // Start matching first list
            // with second list
            while (node1 != null)
            {
                // If second list becomes empty and
                // first not then return false
                if (node2 == null)
                {
                    return false;
                } // If data part is same, go to next
                // of both lists
                else if (node1.getCharData() == node2.getCharData())
                {
                    node1 = node1.getNext();
                    node2 = node2.getNext();
                } // If not equal then break the loop
                else
                {
                    break;
                }
            }
            // Return true if first list gets traversed
            // completely that means it is matched.
            if (node1 == null)
            {
                return true;
            }
            // Initialize ptr1 with first again
            node1 = first;
            // And go to next node of second list
            second = second.getNext();
        }
        return false;
    }
}
