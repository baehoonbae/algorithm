#include<iostream>
#include<cmath>
#include<algorithm>
using namespace std;

int a[999999];

int main() {
	int start, end;
	double sum = 0;
	double result;
	int n;
	cin >> n;
	if (n > 0) {
		for (int i = 0; i < n; i++)
			cin >> a[i];

		sort(a, a + n);
		start = round(n * 0.15);
		end = n - start;

		for (int i = start; i < end; i++)
			sum += a[i];

		result = round(sum / (n - start * 2));
		cout << result;
	}
	else
		cout << 0;
	return 0;
}