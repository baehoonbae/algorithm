#include<iostream>
using namespace std;

bool arr[110];
enum {
	MAN = 1,
	WOMAN = 2
};

int main()
{
	int n, m;
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> arr[i];

	cin >> m;
	for (int i = 1; i <= m; i++)
	{
		int sex, num;
		cin >> sex >> num;
		if (sex == MAN)
			for (int i = num; i <= n; i += num)
				arr[i] = (arr[i] + 1) % 2;
		if (sex == WOMAN)
			for (int i = num;; i--)
			{
				int j = num * 2 - i;
				if (i < 1 || j > n)
				{
					for (int k = i + 1; k <= j - 1; k++)
						arr[k] = (arr[k] + 1) % 2;
					break;
				}
				if (arr[i] != arr[j])
				{
					for (int k = i + 1; k <= j - 1; k++)
						arr[k] = (arr[k] + 1) % 2;
					break;
				}
			}
	}
	
	for (int i = 1; i <= n; i++)
	{
		if (i % 20 == 0)
			cout << arr[i] << endl;
		else
			cout << arr[i] << ' ';
	}

	return 0;
}