#include <iostream>
#include "Rectange.h"
using namespace std;

Rectange::Rectangle(const int &x1, const int &y1, const int &x2, const int &y2)
            :upLeft(x1, y1), lowRight(x2, y2)
{
    // Empty

}

void Rectangle::ShowRecInfo() const{
    // Fill
}