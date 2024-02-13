#include<iostream>
using namespace std;

int main()
{
	int Sum = 0;
	for (int i = 0; i < 5; ++i)
	{
		int Num;
		cin >> Num;
		Sum += Num;
	}
	cout << Sum;

	return 0;
}