#include<iostream>
#include<algorithm>
#include<cmath>
using namespace std;

int a[101][101];
pair<int, int>p[101];
int n;
int result;

int main()
{
	cin >> n;

	for (int i = 0; i < n; i++)
		cin >> p[i].first >> p[i].second;

	for (int i = 0; i < n; i++)
		for (int k = p[i].second; k < p[i].second+10; k++)
			for (int j = p[i].first; j < p[i].first + 10; j++)
				a[k][j] = 1;

	for (int i = 1; i <= 100; i++)
		for (int j = 1; j <= 100; j++)
			if (a[i][j] == 1)
				result++;

	cout << result;
	return 0;
}