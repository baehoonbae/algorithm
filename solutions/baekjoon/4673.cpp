#include<iostream>
using namespace std;

bool self[10002];

void d(int n) {
	int ret = n;
	int div = 1000;
	while (div > 0) {
		ret += n / div;
		if (n / div != 0)
			n %= div;
		div /= 10;
	}
	self[ret] = true;
}

int main() {
	for (int i = 1; i <= 10000; i++) {
		d(i);
	}
	for (int i = 1; i <= 10000; i++) {
		if (self[i] == false)
			cout << i <<endl;
	}
	

	return 0;
}