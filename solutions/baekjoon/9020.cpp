#include<iostream>
#include<cmath>
using namespace std;

bool arr[10001];
pair<int, int>p;
int minnum = 55555;

void era()
{
	for (int i = 2; i<=100; i++)
	{
		for (int j = 2;; j++)
		{
			if (i * j > 10000)
				break;
			if (arr[i * j] == false)
				arr[i * j] = true;
		}
	}
}

int main()
{
	int t;
	cin >> t;
	era();
	for (int i = 0; i < t; i++)
	{
		int check = false;
		int num;
		cin >> num;
		for (int a = 2; a <= num/2; a++)
		{
			if (arr[a] == true)
				continue;
			if (arr[num - a] == true)
				continue;
			if (minnum > (num - a) - a)
				p = { a,num - a };
		}
		cout << p.first << ' ' << p.second << endl;
	}
	return 0;
}