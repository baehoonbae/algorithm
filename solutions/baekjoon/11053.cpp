#include<iostream>
using namespace std;

int a[1001];
int d[1001];
int num;

int main()
{
	int n;
	cin >> n;

	for (int i = 1; i <= n; i++)
		cin >> a[i];

	d[0] = 0;

	for (int i = 1; i <= n; i++)
	{
		for (int j = 0; j < i; j++)
		{
			if (a[i] > a[j])
			{
				d[i] = max(d[i], d[j] + 1);
				if (num < d[i])
					num = d[i];
			}
		}
	}

	cout << num;

	return 0;
}