#include<iostream>
using namespace std;

int a;
int num;

int main()
{
	for (int i = 0; i < 10; i++)
	{
		int x, y;
		cin >> x >> y;
		if (x > 0)
			a -= x;
		if (y > 0)
			a += y;
		if (num < a)
			num = a;
	}

	cout << num;
	return 0;
}