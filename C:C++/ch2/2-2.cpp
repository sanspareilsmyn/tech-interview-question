#include <iostream>
using namespace std;

int main(){
    const int num = 12;
    const int* ptr = &num;
    cout << ptr << endl;
    cout << *ptr << endl;
    cout << &ptr << endl;
    cout << &num << endl;

    const int & ref = *ptr;
    cout << ref << endl;
}