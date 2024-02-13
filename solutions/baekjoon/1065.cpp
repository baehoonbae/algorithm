#include<iostream>
#include<string>
#include<cmath>
using namespace std;

int num[4];
int hansu;
string c;
string s;

int main() {
	bool check = false;
	int n;
	cin >> n;
	if (n < 100)
		hansu = n;
	else {
		hansu = 99;
		for (int i = 111; i <= n; i++) {
			if (i == 1000)
				break;
			int j = 0, div = 100, comp = i;
			while (div > 0) {
				num[j] = comp / div;
				comp %= div;
				div /= 10;
				j++;
			}
			if (num[0] - num[1] == num[1] - num[2])
				hansu++;
		}
	}

	cout << hansu;

	return 0;
}