#include<iostream>
#include<algorithm>
using namespace std;

int a[10001];
int d[10001];
int n;
int num;

int main()
{
	cin >> n;
	for (int i = 1; i <= n; i++)
	{
		cin >> a[i];
	}

	d[1] = a[1];
	d[2] = d[1] + a[2];
	d[3] = max(d[1] + a[3], a[2] + a[3]);
	num = max({ d[1],d[2],d[3] });

	for (int i = 4; i <= n; i++)
	{
		d[i] = max({ d[i - 2] + a[i], d[i - 3] + a[i - 1] + a[i], d[i - 4] + a[i - 1] + a[i] });
		if (d[i] > num)
			num = d[i];
	}
	cout << num;
	return 0;
}