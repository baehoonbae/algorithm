#include<iostream>
#include<algorithm>
using namespace std;

int a[100001];
int d[100001];

int main()
{
	int n;
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
		if (i == 0)
			d[0] = a[0];
		else
			d[i] = max(d[i - 1] + a[i], a[i]);
	}

	cout << *max_element(d, d + n);

	return 0;
}