#include<iostream>
using namespace std;

int cache[1001];

enum
{
	SK = 0,
	CY = 1,
};

int main()
{
	int n;
	cin >> n;
	cache[1] = SK;
	cache[2] = CY;
	cache[3] = SK;
	for (int i = 4; i <= n; i++)
		cache[i] = (cache[i - 1] + 1) % 2;
	if (cache[n] == SK)
		cout << "SK";
	else
		cout << "CY";
	return 0;
}