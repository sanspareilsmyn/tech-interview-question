{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 import java.util.LinkedList;\
\
public class QueueBasedStack \{\
    private LinkedList<T> queue = null;\
\
    public QueueBasedStack()\{\
        queue = new LinkedList<T>();\
    \}\
\
    public void push(T item)\{\
        queue.add(item);\
        int size = queue.size();\
        while (size > 1) \{\
            queue.add(queue.remove());\
            size--;\
        \}\
    \}\
    \
    public T pop()\{\
        return queue.remove();\
    \}\
    \
    public T peek()\{\
        return queue.peek();\
    \}\
    \
    public int size()\{\
        return queue.size();\
    \}\
    \
    public boolean isEmpty()\{\
        return queue.isEmpty();\
    \}\
\}\
}