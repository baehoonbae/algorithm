#include<iostream>
using namespace std;

char Hamburger[20001];
int n, k, MaxCnt, cnt;

int main()
{
	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		cin >> Hamburger[i];
	}
	for (int i = 0; i < n; i++)
	{
		if (Hamburger[i] == 'P')
		{
			for (int j = i - k; j <= i + k; j++)
			{
				if (j > n)
					break;
				if (Hamburger[j] == 'H')
				{
					cnt++;
					Hamburger[j] = 0;
					break;
				}
			}
			MaxCnt = max(MaxCnt, cnt);
		}
	}
	cout << MaxCnt;
	return 0;
}