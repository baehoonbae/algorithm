#include<iostream>
#include<cmath>
using namespace std;

int num;
int n, r, c;

void div(int r, int c, int n) {
	int temp = pow(n, 2) / 4;
	int y = n / 2;
	int x = n / 2;
	// 1
	if (r + 1 <= y && c + 1 <= x) {
		num += temp * 0;
		if (temp == 1) return;
		div(r, c, n / 2);
	}

	// 2
	if (r + 1 <= y && c + 1 > x) {
		num += temp * 1;
		if (temp == 1) return;
		div(r, c - x, n / 2);
	}

	// 3
	if (r + 1 > y && c + 1 <= x) {
		num += temp * 2;
		if (temp == 1) return;
		div(r - y, c, n / 2);
	}

	// 4
	if (r + 1 > y && c + 1 > x) {
		num += temp * 3;
		if (temp == 1) return;
		div(r - y, c - x, n / 2);
	}
}

int main() {
	int N;
	cin >> n >> r >> c;

	N = pow(2, n);

	div(r, c, N);

	cout << num;

	return 0;
}