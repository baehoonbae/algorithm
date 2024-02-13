#include<iostream>
using namespace std;

int arr[100001];

int main()
{
	int num = 2;
	int idx = 0;
	int n;
	cin >> n;
	while (1)
	{
		if (n % num == 0)
		{
			n = n / num;
			arr[idx] = num;
			idx++;
		}
		if (n % num != 0)
			num++;
		if (n == 1)
			break;
		for (int i = 0;i<idx; i++)
		{
			if (num <= arr[i])
				break;
			if (num % arr[i] == 0)
				num++;
		}
	}
	for (int i = 0; i < idx; i++)
		cout << arr[i] << '\n';
	return 0;
}