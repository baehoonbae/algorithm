#include<iostream>
#include<cmath>
using namespace std;

bool a[300000];

void era(int x)
{
	for (int i = 2; i <= sqrt(x); i++)
	{
		for (int j = 2; i * j <= x; j++)
		{
			if (a[i])
				break;
			if (a[i * j])
				continue;
			else
				a[i * j] = true;
		}
	}
}
int main()
{
	ios::sync_with_stdio(0);
	cin.tie(0);

	while (1)
	{
		int num, cnt = 0;
		cin >> num;
		int max = num * 2;
		if (num == 0)
			break;
		else
		{
			era(max);
			for (int i = num + 1; i <= max; i++)
			{
				if (!a[i])
					cnt++;
			}
		}
		cout << cnt << '\n';
	}

	return 0;
}