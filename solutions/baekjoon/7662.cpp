#include<iostream>
#include<map>
#include<vector>
#include<queue>
using namespace std;

priority_queue<int, vector<int>, less<int>>pq1;		// max
priority_queue<int, vector<int>, greater<int>>pq2;	// min
map<int, int>cnt;

int main()
{
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		while (pq1.empty() == false) pq1.pop();
		while (pq2.empty() == false) pq2.pop();
		cnt.clear();

		int a;
		cin >> a;

		for (int j = 0; j < a; j++)
		{
			char b;	int c;
			cin >> b >> c;
			if (b == 'I')
			{
				pq1.push(c);
				pq2.push(c);
				cnt[c]++;
			}
			else
			{
				if (c == -1 && pq2.empty() == false)
				{
					while (pq2.empty() == false && cnt[pq2.top()] == 0)
					{
						pq2.pop();
						continue;
					}
					if (pq2.empty() == false)
					{
						cnt[pq2.top()]--;
						pq2.pop();
					}
				}
				if (c == 1 && pq1.empty() == false)
				{
					while (pq1.empty() == false && cnt[pq1.top()] == 0)
					{
						pq1.pop();
						continue;
					}
					if (pq1.empty() == false)
					{
						cnt[pq1.top()]--;
						pq1.pop();
					}
				}
			}
		}
		while (pq1.empty() == false && cnt[pq1.top()] == 0)
		{
			pq1.pop();
			continue;
		}
		while (pq2.empty() == false && cnt[pq2.top()] == 0)
		{
			pq2.pop();
			continue;
		}
		if (pq1.empty() || pq2.empty())
			cout << "EMPTY" << endl;
		else
			cout << pq1.top() << " " << pq2.top() << endl;
	}
	return 0;
}