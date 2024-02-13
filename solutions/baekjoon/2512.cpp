#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<int>v;
int maximum, n, m;

int main()
{
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int num;
		cin >> num;
		v.push_back(num);
	}
	cin >> m;
	sort(v.begin(), v.end());

	int left = 0;
	int right = v[n - 1];
	int maximum, sum;
	
	while (left <= right)
	{
		sum = 0;
		int mid = (left + right) / 2;
		for (int i = 0; i < n; i++)
		{
			sum += min(v[i], mid);
		}
		if (m >= sum)
		{
			maximum = mid;
			left = mid + 1;
		}
		else
		{
			right = mid - 1;
		}
	}
	cout << maximum;
	return 0;
}