#include<iostream>
#include<queue>
using namespace std;

queue<int>q;

int main()
{
	int n, k;
	cin >> n >> k;
	int cnt = 0;
	for (int i = 1; i <= n; i++)
		q.push(i);
	cout << "<";
	while (q.empty() == false)
	{
		int a = q.front();
		q.pop();
		cnt++;
		if (cnt % k != 0)
			q.push(a);
		else
		{
			if (!q.empty())
				cout << a << ", ";
			else
				cout << a << ">";
		}
	}
	return 0;
}