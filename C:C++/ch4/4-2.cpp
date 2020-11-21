#include <iostream>
using namespace std;

class Point{
    private:
        int xpos, ypos;
    public:
        void Init(int x, int y){
            xpos = x;
            ypos = y;
        }
        void ShowPointInfo() const{
            cout << "[" << xpos << ", " << ypos << "]" << endl;
        }
};

class Circle{
    private:
        int rad;
        Point center;
    public:
        void Init(int x, int y, int r){
            rad = r;
            center.Init(x, y);
        }
        
        void ShowCircleInfo() const{
            cout << "radius : " << rad << endl;
            center.ShowPointInfo();
        }
};

class Ring{
    private:
        Circle inCircle;
        Circle outCircle;
    public:
        void Init(int p1x, int p1y, int p1r, int p2x, int p2y, int p2r){
            inCircle.Init(p1x, p1y, p1r);
            outCircle.Init(p2x, p2y, p2r);
        }
        void ShowRingInfo() const{
            cout << "Inner Circle Info ..." << endl;
            inCircle.ShowCircleInfo();
            cout << "Outer Circle Info ..." << endl;
            outCircle.ShowCircleInfo();
        }
};

int main(void){
    Ring ring;
    ring.Init(1, 1, 4, 2, 2, 9);
    ring.ShowRingInfo();
    return 0;
}