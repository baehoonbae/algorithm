#include<iostream>
using namespace std;

int lamp[100001];

int main()
{
	int height = 0;
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < m; i++)
		cin >> lamp[i];
	if (m == 1)
		height = max(lamp[0], n - lamp[0]);
	else if (m == 2 && (lamp[1] - lamp[0]) % 2 != 0)
		height = max(max((lamp[1] - lamp[0] + 1) / 2, n - lamp[1]), lamp[0]);
	else if (m == 2 && (lamp[1] - lamp[0]) % 2 == 0)
		height = max(max((lamp[1] - lamp[0]) / 2, n - lamp[1]), lamp[0]);
	else if (m >= 3)
	{
		for (int i = 0; i < m; i++)
		{
			if (i == 0)
				height = max(height, lamp[i]);
			else if (i == m - 1)
				height = max(height, n - lamp[i]);
			else
			{
				if ((lamp[i + 1] - lamp[i]) % 2 != 0)
					height = max(height, (lamp[i + 1] - lamp[i] + 1) / 2);
				if ((lamp[i + 1] - lamp[i]) % 2 == 0)
					height = max(height, (lamp[i + 1] - lamp[i]) / 2);
			}
		}
	}
	cout << height;
	return 0;
}