#include<iostream>
#include<algorithm>
using namespace std;
int a[100001];
int main()
{
	int maxn = 0;
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	sort(a, a + n);
	int temp = n;
	for (int i = 0; i < n; i++)
	{
		maxn = max(maxn, a[i] * temp);
		temp--;
	}
	cout << maxn;
	return 0;
}