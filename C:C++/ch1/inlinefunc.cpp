#include <iostream>
using namespace std;

template <typename T>
inline T square(T x){
    return x*x;
}

int main(void){
    cout << square(5.5) << endl;
    cout << square(12) << endl;
    return 0;
}