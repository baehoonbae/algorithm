#include<iostream>
using namespace std;



int main()
{
	int result;
	int h, w, n, m;
	int y = 0, x = 0;
	cin >> h >> w >> n >> m;

	int num = 1;
	while (num <= h)
	{
		y++;
		num += n + 1;
	}
	num = 1;
	while (num <= w)
	{
		x++;
		num += m + 1;
	}

	cout << x * y;

	return 0;
}