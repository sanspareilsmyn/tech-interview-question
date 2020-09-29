{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class LinkedListBasedStack \{\
    private Node top = null;\
\
    private class Node \{\
        private Object item;\
        private Node next;\
\
        public Node(Object item, Node next)\{\
            this.item = item;\
            this.next = next;\
        \}\
    \}\
\
    public void push(Object item) \{\
        top = new Node(item, top);\
    \}\
\
    public Object pop() \{\
        if (top == null)\{\
            throw new IllegalStateException("Cannot pop from an empty stack");\
        \}\
        Object result = peek();\
        top = top.next;\
        return result;\
    \}\
\
    public Object peek()\{\
        if (top == null) \{\
            throw NoSuchElementException("Cannot peek from an empty stack");\
        \}\
        return top.item;\
    \}\
\
    public int size()\{\
        int size = 0;\
        for (Node node = top; node != null; node = node.next)\{\
            size++;\
        \}\
        return size;\
    \}\
\}}