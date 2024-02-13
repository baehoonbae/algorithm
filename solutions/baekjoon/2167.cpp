#include<iostream>
using namespace std;

int arr[301][301];
int result;

int main()
{
	int n, m, k;
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
	{
		for (int j = 1; j <= m; j++)
		{
			cin >> arr[i][j];
		}
	}
	cin >> k;
	for (int i = 0; i < k; i++)
	{
		int a, b, c, d;
		cin >> a >> b >> c >> d;
		result = 0;
		for (int I = a; I <= c; I++)
		{
			for (int J = b; J <= d; J++)
			{
				result += arr[I][J];
			}
		}
		cout << result << endl;
	}

	return 0;
}