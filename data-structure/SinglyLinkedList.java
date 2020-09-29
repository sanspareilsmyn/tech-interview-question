{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class SinglyLinkedList<E> \{\
    private Node<E> head;\
    private int size = 0;\
\
    public void insertAtHead(E value) \{\
        Node<E> newNode = new Node<E>(value);\
        newNode.next = head;\
        head = newNode;\
        size++;\
    \}\
\
    public void insertAtTail(E value) \{\
        Node<E> newNode = new Node<E>(value);\
        newNode.next = null;\
        if (null == head) \{\
            head = newNode;\
        \} else \{\
            Node<E> tempNode = head;\
            while (null != tempNode.next) \{\
                tempNode = tempNode.next;\
            \}\
            tempNode.next = newNode;\
        \}\
        size++;\
    \}\
\
    public void insertAtPosition(E value, int position)\{\
        if(position < 0 || position > size)\{\
            throw new IllegalArgumentException("Position is Invalid");\
        \}\
        Node<E> newNode = new Node<E>(value);\
        if(position==0)\{\
            newNode.next = head;\
        \}\
        else\{\
            Node<E> tempNode = head;\
            for (int i=0; i<position - 1; i++)\{\
                tempNode = tempNode.next;\
            \}\
            Node<E> nodeNextToNewNode = tempNode.next;\
            tempNode.next = newNode;\
            newNode.next = nodeNextToNewNode;\
        \}\
        size++;\
    \}\
\
    public void traverse()\{\
        Node<E> temp = head;\
        while (temp != null)\{\
            System.out.println(temp.item);\
            temp = temp.next;\
        \}\
    \}\
\
    public int size()\{\
        return size;\
    \}\
\
    public boolean isEmpty()\{\
        return size == 0;\
    \}\
\
    public Node<E> searchByIndex(int index)\{\
        if (index < 0 || index >= size)\{\
            throw new IndexOutOfBoundsException("Invalid index passed while searchign for a value");\
        \}\
        Node<E> temp = head;\
        for (int i=0; i<index; i++)\{\
            temp = temp.next;\
        \}\
        return temp;\
    \}\
\
    public Node<E> searchByValue(E value)\{\
        Node<E> temp = head;\
        while (null != temp.next && temp.item != value)\{\
            temp = temp.next;\
        \}\
        if (temp.item == value)\{\
            return temp;\
        \}\
        return null;\
    \}\
\
    public void deleteFromHead()\{\
        if(head == null) return;\
        head = head.next;\
        size--;\
    \}\
\
    public void deleteFromTail()\{\
        if (head == null) return;\
        Node<E> currentNode = head;\
        Node<E> nextNode = currentNode.next;\
        while(currentNode.next != null && nextNode.next != null)\{\
            currentNode = currentNode.next;\
            nextNode = nextNode.next;\
        \}\
        currentNode.next = null;\
        size--;\
    \}\
\
    public void deleteFromPosition(int position)\{\
        if(position < 0 || position > size)\{\
            throw new IllegalArgumentException("Position is Invalid");\
        \}\
        Node<E> nodeToBeDeleted = head;\
        for (int i=0; i<position; i++)\{\
            nodeToBeDeleted = nodeToBeDeleted.next;\
        \}\
        if (nodeToBeDeleted.next == null)\{\
            deleteFromTail();\
        \} else \{\
            nodeToBeDeleted.item = nodeToBeDeleted.next.item;\
            nodeToBeDeleted.next = nodeToBeDeleted.next.next;\
        \}\
    \}\
\
    public Object[] toArray()\{\
        Object[] result = new Object[size];\
        int i = 0;\
        for (Node<E> x = head; x != null; x=x.next)\{\
            result[i++] = x.item;\
        \}\
        return result;\
    \}\
\
    public class Node<T>\{\
        T item;\
\
        Node<T> next;\
\
        public Node(T item)\{\
            this.item = item;\
        \}\
\
        public String toString()\{\
            return "Data Item = " + item;\
        \}\
\
    \}\
\}}