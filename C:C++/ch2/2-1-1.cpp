#include <iostream>
using namespace std;

void plus_num(int & number){
    number += 1;
}

int main(){
    int num = 4;
    plus_num(num);
    cout << num << endl;
}