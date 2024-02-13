#include<iostream>
#include<algorithm>
using namespace std;

int arr[1001];

struct Country
{
	int mem = 0;
	int score = 0;
	int cnt = 0;
	int spare = 0;
};


int main()
{
	Country country[1001];
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		int temp = 1;
		int ranking = 0;
		int minnum = 1111111;
		int n;
		cin >> n;
		for (int i = 1; i <= n; i++)
		{
			arr[i] = 0;
			country[i] = { 0,0,0,0 };
		}
		for (int i = 1; i <= n; i++)
		{
			cin >> arr[i];
			country[arr[i]].mem++;
		}
		for (int i = 1; i <= n; i++)
		{
			if (country[arr[i]].mem == 6)
			{
				if (country[arr[i]].cnt == 4)
				{
					country[arr[i]].cnt++;
					country[arr[i]].spare = temp;
					temp++;
					continue;
				}
				if (country[arr[i]].cnt == 5)
				{
					temp++;
					continue;
				}
				country[arr[i]].score += temp;
				country[arr[i]].cnt++;
				temp++;
				continue;
			}
		}
		for (int i = 1; i <= n; i++)
		{
			if (country[i].mem == 0)
				break;
			if (country[i].mem >= 6)
			{
				if (minnum > country[i].score)
				{
					minnum = country[i].score;
					ranking = i;
				}
				if (minnum == country[i].score)
					if (country[ranking].spare > country[i].spare)
					{
						minnum = country[i].score;
						ranking = i;
					}
			}
		}
		cout << ranking << endl;
	}
	return 0;
}