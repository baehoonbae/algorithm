#include<iostream>
using namespace std;

long long int d[101][10];

int main()
{
	int n;
	cin >> n;
	for (int i = 1; i <= 9; i++)
		d[1][i] = 1;

	for (int i = 2; i <= n; i++)
	{
		d[i][0] = d[i - 1][1] % 1000000000;
		d[i][9] = d[i - 1][8] % 1000000000;
		for (int j = 1; j <= 8; j++)
			d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % 1000000000;
	}

	long long int sum = 0;
	for (int i = 0; i <= 9; i++)
		sum += d[n][i] % 1000000000;
	cout << sum % 1000000000;

	return 0;
}