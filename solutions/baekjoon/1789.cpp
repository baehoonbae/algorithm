#include<iostream>
using namespace std;

int a[200001];

int main()
{
	int cnt = 0;
	long long int sum = 0;
	long long int s;
	cin >> s;
	for (int i = 0; i < 200000; i++)
		a[i] = i + 1;
	for (int i = 0; i < 200000; i++)
	{
		sum += a[i];
		if (sum > s)
			break;
		cnt++;
	}
	cout << cnt;
	return 0;
}