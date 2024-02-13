#include<iostream>
#include<queue>
using namespace std;

int a[1001][1001];
int c, r, k;
int dir = 3;

struct pos
{
	int y;
	int x;
};
pos front[4]
{
	{-1,0},
	{0,1},
	{1,0},
	{0,-1},
};

void bfs(int here_y, int here_x , int target)
{
	a[here_y][here_x] = 1;
	queue<pair<int, int>>q;
	q.push({ here_y,here_x });
	while (q.empty() == false)
	{
		int y = q.front().first;
		int x = q.front().second;
		if (a[y][x] == target)
		{
			cout << y << ' ' << x;
			return;
		}
		int next_y = y + front[dir].y;
		int next_x = x + front[dir].x;
		if (next_y<1 || next_y>c || next_x<1 || next_x>r || a[next_y][next_x] != 0)
		{
			dir = (dir + 1) % 4;
			continue;
		}
		q.pop();
		a[next_y][next_x] = a[y][x] + 1;
		if (a[next_y][next_x] == target)
		{
			cout << next_y << ' ' << next_x;
			return;
		}
		if (a[next_y][next_x] == c * r)
		{
			cout << 0;
			return;
		}
		q.push({ next_y,next_x });
	}
}
int main()
{
	cin >> c >> r;
	cin >> k;
	bfs(1, 1, k);


	return 0;
}