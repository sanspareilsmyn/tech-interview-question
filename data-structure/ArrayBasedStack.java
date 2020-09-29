{\rtf1\ansi\ansicpg949\cocoartf2513
\cocoatextscaling0\cocoaplatform0{\fonttbl\f0\fswiss\fcharset0 Helvetica;}
{\colortbl;\red255\green255\blue255;}
{\*\expandedcolortbl;;}
\paperw11900\paperh16840\margl1440\margr1440\vieww10800\viewh8400\viewkind0
\pard\tx566\tx1133\tx1700\tx2267\tx2834\tx3401\tx3968\tx4535\tx5102\tx5669\tx6236\tx6803\pardirnatural\partightenfactor0

\f0\fs24 \cf0 public class ArrayBasedStack \{\
    private Object[] array;\
    private int size = 0;\
\
    public ArrayBasedStack(int capacity)\{\
        array = new Object[capacity];\
    \}\
\
    public void push(Object item)\{\
        if (size == array.length)\{\
            throw new IllegalStateException("Cannot insert on full Stack");\
        \}\
        array[size++] = item;\
    \}\
\
    public Object pop()\{\
        if (size == 0)\{\
            throw NoSuchElementException("Cannot delete from an empty Stack");\
        \}\
        Object result = array[size-1];\
        array[size-1] = null;\
        size--;\
        return result;\
    \}\
\
    public Object peek()\{\
        if (size == 0)\{\
            throw NoSuchElementException("Cannot delete from an empty Stack");\
        \}\
        return array[size-1];\
    \}\
\
    public int size()\{\
        return size; \
    \}\
\
    public boolean isEmpty()\{\
        return size == 0;\
    \}\
\}\
}