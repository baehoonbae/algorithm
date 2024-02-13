#include<iostream>
#include<algorithm>
using namespace std;

int a[4];
int main() {
	for (int i = 0; i < 3; i++)
		cin >> a[i];
	sort(a, a + 3);
	cout << a[1];


	return 0;
}