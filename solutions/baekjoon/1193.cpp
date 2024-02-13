#include<iostream>
using namespace std;

int main()
{
	bool check = false;
	int x, n = 2, idx = 2;
	cin >> x;
	while (1)
	{
		if (x == 1)
		{
			cout << 1 << '/' << 1;
			break;
		}
		if (idx % 2 == 0)
		{
			int j = idx;
			for (int i = 1; i <= idx; i++)
			{
				if (n == x)
				{
					cout << i << '/' << j;
					check = true;
					break;
				}
				j--;
				n++;
			}
		}
		else
		{
			int j = 1;
			for (int i = idx; i >= 1; i--)
			{
				if (n == x)
				{
					cout << i << '/' << j;
					check = true;
					break;
				}
				j++;
				n++;
			}
		}
		if (check)
			break;
		idx++;
	}
	
	return 0;
}