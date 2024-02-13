#include<iostream>
#include<algorithm>
using namespace std;

int a[500001];
int b[500001];

int main()
{
	int n, m;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cin >> m;
	for (int i = 0; i < m; i++)
		cin >> b[i];
	sort(a, a + n);
	for (int i = 0; i < m; i++)
	{
		if (*lower_bound(a, a + n - 1, b[i]) != b[i])
			cout << 0 << ' ';
		else
			cout << 1 << ' ';
	}
	return 0;
}