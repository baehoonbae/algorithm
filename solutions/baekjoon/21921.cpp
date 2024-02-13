#include<iostream>
#include<deque>
using namespace std;

deque<int>d;
int arr[250001];
int n, x;
int maximum, temp, cnt = 1;

int main()
{
	cin >> n >> x;
	for (int i = 0; i < n; i++)
		cin >> arr[i];
	for (int i = 0; i < n; i++)
	{
		if(d.size()<x)
		{
			d.push_back(arr[i]);
			maximum += arr[i];
			temp += arr[i];
		}
		else
		{
			temp -= d.front();
			d.pop_front();
			d.push_back(arr[i]);
			temp += arr[i];
			if (maximum < temp)
			{
				cnt = 0;
				maximum = max(maximum, temp);
			}
			if (maximum == temp)
			{
				cnt++;
			}
		}
	}
	if (maximum == 0)
		cout << "SAD";
	else
		cout << maximum << '\n' << cnt;
	return 0;
}