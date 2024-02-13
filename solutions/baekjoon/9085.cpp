#include<iostream>
using namespace std;

int b[101];

int main()
{
	int t;
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		int a, sum = 0;
		cin >> a;
		for (int i = 0; i < a; i++)
		{
			cin >> b[i];
		}
		for (int i = 0; i < a; i++)
		{
			sum += b[i];
		}
		cout << sum << endl;
	}

	return 0;
}