#include<iostream>
#include<cstring>
#include<vector>
#include<queue>
#define MAX 101
using namespace std;

int nblind, blind, n;
char a[MAX][MAX];
bool visited[MAX][MAX];
queue<pair<int, int>>q;
struct pos { int x, y; };
pos front[4]{
	{0,-1},	// UP
	{-1,0}, // LEFT
	{0, 1}, // DOWN
	{1, 0}, // RIGHT
};

void bfs(int here_y, int here_x, char z) {
	nblind++;
	visited[here_y][here_x] = true;
	q.push(make_pair(here_y, here_x));
	while (q.empty() == false) {
		here_y = q.front().first;
		here_x = q.front().second;
		q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int next_y = here_y + front[dir].y;
			int next_x = here_x + front[dir].x;
			if (next_y < 0 || next_x < 0)
				continue;
			if (next_y >= n || next_x >= n)
				continue;
			if (visited[next_y][next_x])
				continue;
			if (a[next_y][next_x] != z)
				continue;
			visited[next_y][next_x] = true;
			q.push(make_pair(next_y, next_x));
		}
	}
}
void b_bfs(int here_y, int here_x, char z) {
	blind++;
	visited[here_y][here_x] = true;
	q.push(make_pair(here_y, here_x));
	while (q.empty() == false) {
		here_y = q.front().first;
		here_x = q.front().second;
		q.pop();
		for (int dir = 0; dir < 4; dir++) {
			int next_y = here_y + front[dir].y;
			int next_x = here_x + front[dir].x;
			if (next_y < 0 || next_x < 0)
				continue;
			if (next_y >= n || next_x >= n)
				continue;
			if (visited[next_y][next_x])
				continue;
			if ((z == 'R' || z == 'G') && a[next_y][next_x] == 'B')
				continue;
			if (z == 'B' && (a[next_y][next_x] == 'R' || a[next_y][next_x] == 'G'))
				continue;
			visited[next_y][next_x] = true;
			q.push(make_pair(next_y, next_x));
		}
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++)
			cin >> a[i][j];

	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			if (a[i][j] == 'R' && !visited[i][j])
				bfs(i, j, a[i][j]);
			if (a[i][j] == 'B' && !visited[i][j]) 
				bfs(i, j, a[i][j]);
			if (a[i][j] == 'G' && !visited[i][j]) 
				bfs(i, j, a[i][j]);
		}
	memset(visited, false, sizeof(visited));
	for (int i = 0; i < n; i++)
		for (int j = 0; j < n; j++) {
			if ((a[i][j] == 'R' || a[i][j] == 'G') && !visited[i][j])
				b_bfs(i, j, a[i][j]);
			if (a[i][j] == 'B' && !visited[i][j]) 
				b_bfs(i, j, a[i][j]);
		}

	cout << nblind << " " << blind;

	return 0;
}