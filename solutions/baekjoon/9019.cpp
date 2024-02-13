#include<iostream>
#include<cstring>
#include<queue>
using namespace std;

bool visited[10001];
int num, dest;

string bfs(int here)
{
	queue<pair<int,string>>q;
	q.push(make_pair(here,""));
	visited[here] = true;
	while (q.empty() == false)
	{
		int x = q.front().first;
		string s = q.front().second;
		q.pop();
		if (x == dest)
			return s;

		int next = x * 2;
		if (next > 9999) next %= 10000;
		if (!visited[next])
		{
			visited[next] = true;
			q.push(make_pair(next, s + 'D'));
		}

		next = x - 1;
		if (next < 0)next = 9999;
		if (!visited[next])
		{
			visited[next] = true;
			q.push(make_pair(next, s + 'S'));
		}

		next = (x % 1000) * 10 + x / 1000;
		if (!visited[next])
		{
			visited[next] = true;
			q.push(make_pair(next, s + 'L'));
		}

		next = (x % 10) * 1000 + x / 10;
		if (!visited[next])
		{
			visited[next] = true;
			q.push(make_pair(next, s + 'R'));
		}
	}
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int t;
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		memset(visited, 0, 10001);
		cin >> num >> dest;
		cout<<bfs(num)<<'\n';
	}

	return 0;
}