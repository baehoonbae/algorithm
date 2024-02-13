#include<iostream>
using namespace std;

int main()
{
	int result = 0;
	int k, n, m;
	cin >> k >> n >> m;
	result = k * n - m;
	if (result <= 0)
		cout << 0;
	else
		cout << result;
	return 0;
}