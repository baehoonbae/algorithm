#include<iostream>
using namespace std;

int main() {
	int sum = 0;
	int min = 101;
	for (int i = 0; i < 7; i++) {
		int a;
		cin >> a;
		if (a % 2 == 1) {
			sum += a;
			if (min > a)
				min = a;
		}
	}
	if (sum == 0)
		cout << -1;
	else
		cout << sum << endl << min;

	return 0;
}