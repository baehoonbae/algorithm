#include<iostream>
#include<deque>
#include<queue>
using namespace std;

bool arr[101][101];
bool body[101][101];
queue<pair<int, char>>d;
deque<pair<int, int>>len;
int t;
int n, k, l;

struct pos
{
	int y;
	int x;
};
pos front[4]{
	{0,1},
	{1,0},
	{0,-1},
	{-1,0}
};

void bfs(int here_y, int here_x)
{
	int idx = 0;
	queue<pair<int, int>>q;
	q.push({ here_y,here_x });
	len.push_front({ here_y,here_x });
	body[here_y][here_x] = true;
	while (q.empty() == false)
	{
		t++;
		int y = q.front().first;
		int x = q.front().second;
		q.pop();
		int next_y = y + front[idx].y;
		int next_x = x + front[idx].x;
		if (next_y < 1 || next_x < 1 || next_y > n || next_x > n || body[next_y][next_x])
			return;
		if (d.empty() == false && t == d.front().first)
		{
			if (d.front().second == 'D')
				idx = (idx + 1) % 4;
			else
				idx = (idx + 3) % 4;
			d.pop();
		}
		if (arr[next_y][next_x] == true)
		{
			len.push_front({ next_y,next_x });
			body[next_y][next_x] = true;
			arr[next_y][next_x] = false;
		}
		else
		{
			len.push_front({ next_y,next_x });
			body[next_y][next_x] = true;
			body[len.back().first][len.back().second] = false;
			len.pop_back();
		}
		q.push({ next_y,next_x });
	}
}

int main()
{
	cin >> n >> k;
	for (int i = 0; i < k; i++)
	{
		int a, b;
		cin >> a >> b;
		arr[a][b] = true;
	}
	cin >> l;
	for (int i = 0; i < l; i++)
	{
		int a;
		char b;
		cin >> a >> b;
		d.push({ a,b });
	}
	bfs(1, 1);
	cout << t;


	return 0;
}