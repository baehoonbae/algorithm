#include<iostream>
using namespace std;

int n, k;
int gold[1001];
int silver[1001];
int bronze[1001];
int ran = 1;

int main()
{
	cin >> n >> k;
	for (int i = 0; i < n; i++)
	{
		int idx;
		cin >> idx;
		cin >> gold[idx] >> silver[idx] >> bronze[idx];
	}
	for (int i = 1; i <= n; i++)
	{
		if (gold[i] > gold[k])
			ran++;
		else if (gold[i] == gold[k])
		{
			if (silver[i] > silver[k])
				ran++;
			else if (silver[i] == silver[k])
			{
				if (bronze[i] > bronze[k])
					ran++;
			}
		}
	}

	cout << ran;

	return 0;
}