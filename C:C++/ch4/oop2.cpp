#include <iostream>
#include <cstring>

using namespace std;
const int NAME_LEN = 20;

void ShowMenu(void);        // 메뉴 출력
void MakeAccount(void);     // 계좌 개설
void DepositMoney(void);    // 입금
void WithdrawMoney(void);   // 출금
void ShowAllAccInfo(void);  // 잔액 조회

enum {MAKE=1, DEPOSIT, WITHDRAW, INQUIRE, EXIT};

class Account{
    private:
        int accID; // 계좌번호
        int balance; // 잔액
        char * cusName; // 고객이름

    public:
        Account(int ID, int money, char * name) : accID(ID), balance(money) // 생성자
        {
            cusName = new char[strlen(name)+1];
            strcpy(cusName, name);
        }

        int GetAccID() { return accID; }

        void Deposit(int money){
            balance += money;
        }

        int Withdraw(int money){
            if(balance <= money)
                return 0;
            
            balance -= money;
            return money;
        }

        void ShowAccInfo(){
            cout << "계좌ID: " << accID << endl;
            cout << "이름: " << cusName << endl;
            cout << "잔액: " << balance << endl;
        }

        ~Account(){
            delete []cusName;
        }
};

Account * accArr[100];
int accNum = 0;

int main(void){
    int choice;

    while(1){
        ShowMenu();
        cout << "선택: ";
        cin >> choice;
        cout << endl;

        switch(choice){
            case MAKE:
                MakeAccount();
                break;
            case DEPOSIT:
                DepositMoney();
                break;
            case WITHDRAW:
                WithdrawMoney();
                break;
            case INQUIRE:
                ShowAllAccInfo();
                break;
            case EXIT:
                for(int i=0; i<accNum; i++)
                    delete accArr[i];
                return 0;
            default:
                cout << "Illegal selection.." << endl;
        }
    }
    return 0;
}

void ShowMenu(void){
    cout << "----- Menu -----" << endl;
    cout << "1. 계좌개설" << endl;
    cout << "2. 입금" << endl;
    cout << "3. 출금" << endl;
    cout << "4. 계좌정보 전체 출력" << endl;
    cout << "5. 프로그램 종료" << endl;
}

void MakeAccount(void){
    int id;
    char name[NAME_LEN];
    int balance;

    cout << "[계좌개설]" << endl;
    cout << "계좌 ID : "; cin >> id;
    cout << "이름 : "; cin >> name;
    cout << "입금액 : "; cin >> balance;
    cout << endl;

    accArr[accNum++] = new Account(id, balance, name);
}

void DepositMoney(void){
    int money;
    int id;
    cout << "[입금]" << endl;
    cout << "계좌ID: "; cin >> id;
    cout << "입금액: "; cin >> money;

    for(int i=0; i<accNum; i++)
    {
        if(accArr[i] -> GetAccID() == id)
        {
            accArr[i] -> Deposit(money);
            cout << "입금 완료" << endl << endl;
            return;
        }
    }
    cout << "유효하지 않은 ID입니다." << endl << endl;
}