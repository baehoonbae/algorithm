#include<iostream>
using namespace std;

long long d[1001][1001];

int main()
{
	int n, k;
	cin >> n >> k;

	d[1][0] = 1;
	d[1][1] = 1;

	for (int i = 1; i <= n; i++)
		for (int j = 0; j <= i; j++)
		{
			if (j == 0)
				d[i][j] = 1;
			else if (j == i)
				d[i][j] = 1;
			else
				d[i][j] = (d[i - 1][j - 1] + d[i - 1][j])%10007;
		}

	cout << d[n][k];
	return 0;
}