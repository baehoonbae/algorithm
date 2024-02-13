#include<iostream>
#include<vector>
using namespace std;

int arr[1001][21];

int main()
{
	int cnt = 0;
	int t;
	int p;
	cin >> p;
	for (int i = 0; i < p; i++)
	{
		cnt = 0;
		bool check = false;
		cin >> t;
		for (int i = 0; i < 20; i++)
			cin >> arr[t][i];
		while (check == false)
		{
			int check_cnt = 0;
			for (int i = 0; i < 20; i++)
			{
				if (arr[t][i] > arr[t][i + 1])
				{
					swap(arr[t][i], arr[t][i + 1]);
					cnt++;
				}
				else
				{
					check_cnt++;
					if (check_cnt == 20)
						check = true;
				}
			}
		}
		cout << t << " " << cnt-20 << '\n';
	}

	return 0;
}