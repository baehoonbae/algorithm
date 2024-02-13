#include<iostream>
#include<queue>
#define MAX 601
using namespace std;

char a[MAX][MAX];
bool visited[MAX][MAX];
queue<pair<int, int>>q;
int n, m, cnt;

struct pos {
	int x;
	int y;
};

pos front[4]{
	{0,-1},	// UP
	{-1,0},	// LEFT
	{0,1},	// DOWN
	{1,0},	// RIGHT
};

void bfs(int here_y, int here_x) {
	visited[here_y][here_x] = true;
	q.push(make_pair(here_y, here_x));
	while (q.empty() == false) {
		here_y = q.front().first;
		here_x = q.front().second;
		q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int next_y = here_y + front[dir].y;
			int next_x = here_x + front[dir].x;
			if (visited[next_y][next_x])
				continue;
			if (next_y >= n || next_x >= m)
				continue;
			if (next_y < 0 || next_x < 0)
				continue;
			if (a[next_y][next_x] == 'X')
				continue;
			if (a[next_y][next_x] == 'P')
				cnt++;

			visited[next_y][next_x] = true;
			q.push(make_pair(next_y, next_x));
		}
	}
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			cin >> a[i][j];
	
	for (int i = 0; i < n; i++)
		for (int j = 0; j < m; j++)
			if (a[i][j] == 'I')
				bfs(i,j);
	if (cnt > 0)
		cout << cnt;
	else
		cout << "TT";

	return 0;
}