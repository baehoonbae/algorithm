#include<iostream>
using namespace std;

int f[21];

int main() {
	int n;
	cin >> n;
	f[0] = 0;	f[1] = 1;
	for (int i = 0; i < n; i++)
		f[i + 2] = f[i] + f[i + 1];
	cout << f[n];
	return 0;
}