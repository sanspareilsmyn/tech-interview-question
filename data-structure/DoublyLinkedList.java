{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class DoublyLinkedList<E> \{\
    private Node<E> head;\
    private Node<E> tail;\
    private int size = 0;\
\
    public class Node<E>\{\
        E item;\
        Node<E> next;\
        Node<E> prev;\
\
        public Node(E item)\{\
            this.item = item;\
        \}\
\
        public String toString()\{\
            return String.valueof(item);\
        \}\
    \}\
\
    public void insertAtHead(E value)\{\
        Node<E> newNode = new Node<E>(value);\
        if (head == null)\{\
            newNode.next = null;\
            newNode.prev = null;\
            head = newNode;\
            tail = newNode;\
            size++;\
        \} else \{\
            newNode.next = head;\
            newNode.prev = null;\
            head.prev = newNode;\
            head = newNode;\
            size++;\
        \}\
    \}\
\
    public void insertAtTail(E value)\{\
        Node<E> newNode = new Node<E>(value);\
        if (tail == null)\{\
            newNode.next = null;\
            newNode.prev = null;\
            head = newNode;\
            tail = newNode;\
            size++;\
        \} else \{\
            tail.next = newNode;\
            newNode.prev = tail;\
            newNode.next = null;\
            tail = newNode;\
            size++;\
        \}\
    \}\
\
    public void insertAtPosition(E value, int position)\{\
        if (position < 0 || position > size)\{\
            throw new IllegalArgumentException("Position is Invalid");\
        \}\
        if (position == 0)\{\
            insertAtHead(value);\
        \} else if (position == size - 1) \{\
            insertAtTail(value);\
        \} else \{\
            Node<E> currentNode = head;\
            for (int i=0; i<position; i++)\{\
                currentNode = currentNode.next;\
            \}\
            Node<E> previousNode = currentNode.prev;\
            Node<E> newNode = new Node<E>(value);\
            newNode.next = currentNode;\
            newNode.prev = previousNode;\
            currentNode.prev = newNode;\
            previousNode.next = newNode;\
            size++;\
        \}\
\
    \}\
\
    public void traverseForward()\{\
        Node<E> temp = head;\
        while (temp != null)\{\
            System.out.println(temp.item);\
            temp = temp.next;\
        \}\
    \}\
\
    public void traverseBackward()\{\
        Node<E> temp = tail;\
        while (temp != null)\{\
            System.out.println(temp.item);\
            temp = temp.prev;\
        \}\
    \}\
\
    public int size()\{\
        return size;\
    \}\
\
    public boolean isEmpty() \{\
        return size == 0;\
    \}\
\
    public Node<E> searchByIndex(int index)\{\
        if (index < 0 || index >= size) \{\
            throw new IndexOutOfBoundsException("Invalid index passed while searching for a value");\
        \}\
        Node<E> temp = head;\
        for (int i=0; i < index; i++)\{\
            temp = temp.next;\
        \}\
        return temp;\
    \}\
\
    public Node<E> searchByValue(E value)\{\
        Node<E> temp = head;\
        while (temp.next != null && temp.item != value)\{\
            temp = temp.next;\
        \}\
        if (temp.item == value)\{\
            return temp;\
        \}\
        return null;\
    \}\
\
    public void deleteFromHead() \{\
        if (head == null) return;\
        Node<E> temp = head;\
        head = temp.next;\
        head.prev = null;\
        size--;\
    \}\
\
    public void deletefromTail()\{\
        if (tail == null) return;\
        Node<E> temp = tail;\
        tail = temp.prev;\
        tail.next = null;\
        size--;\
    \}\
l\
    public void deleteFromPosition(int position)\{\
        if (position < 0 || position >= size) \{\
            throw new IllegalArgumentException("Position is Invalid");\
        \}\
        Node<E> nodeToBeDeleted = head;\
        for (int i=0; i<position; i++)\{\
            nodeToBeDeleted = nodeToBeDeleted.next;\
        \}\
        Node<E> previousNode = nodeToBeDeleted.prev;\
        Node<E> nextNode = nodeToBeDeleted.next;\
        previousNode.next = nextNode;\
        nextNode.prev = previousNode;\
        size--;\
    \}\
\
    public Object[] toArray()\{\
        Object[] result = new Object[size];\
        int i=0;\
        for (Node<E> x = head; x != null; x = x.next)\{\
            result[i++] = x.item;\
        \}\
        return result;\
    \}\
\}\
}