#include<iostream>
using namespace std;

long long int divide(int c,int n,int mod) {
	if (n == 1)
		return c;
	else {
		long long int x = divide(c, n / 2, mod);
		if (n % 2 == 0)
			return ((x%mod) * (x%mod)) % mod;
		else
			return ((x%mod) * (x%mod) * (c%mod)) % mod;
	}
}

int main() {
	long long int a, b, c;
	cin >> a >> b >> c;

	long long int ret = divide(a, b, c);

	cout << ret;

	return 0;
}