#include<iostream>
using namespace std;

int isSqr[1000021];

int main() {
	ios::sync_with_stdio(0);
	cin.tie(0);

	long long min, max;
	cin >> min >> max;

	long long cnt = max - min + 1;

	for (long long i = 2; i * i <= max; i++) {
		long long ret = min / (i * i);
		if (min % (i * i) != 0)
			ret++;
		while (ret * (i * i) <= max) {
			if (isSqr[ret * (i * i) - min] == false) {
				isSqr[ret * (i * i) - min] = true;
				cnt--;
			}
			ret++;
		}
	}

	cout << cnt;


	return 0;
}