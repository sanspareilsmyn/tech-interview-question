#include <iostream>
using namespace std;

void SwapPointer(int * (&ptr1), int * (&ptr2)){
    int * tmp = ptr1;
    ptr1 = ptr2;
    ptr2 = tmp;
}

int main(void){
    int num1 = 5;
    int *ptr1 = &num1;
    int num2 = 10;
    int *ptr2 = &num2;

    cout << "Before changing" << endl;
    cout << *ptr1 << " " << *ptr2 << endl; // 5 10
    cout << &ptr1 << " " << &ptr2 << endl; // 0x7ffee15c16c0 0x7ffee15c16b0
    
    SwapPointer(ptr1, ptr2);
    cout << "After Changing" << endl;
    cout << *ptr1 << " " << *ptr2;
    return 0;
}