#include<iostream>
using namespace std;

int main()
{
	int cnt = 0;
	int dis = 1000;
	int n;
	cin >> n;
	dis -= n;
	cnt += dis / 500;
	dis %= 500;
	cnt += dis / 100;
	dis %= 100;
	cnt += dis / 50;
	dis %= 50;
	cnt += dis / 10;
	dis %= 10;
	cnt += dis / 5;
	dis %= 5;
	cnt += dis / 1;
	dis %= 1;

	cout << cnt;

	return 0;
}