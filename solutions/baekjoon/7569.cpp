#include<iostream>
#include<tuple>
#include<queue>
#define MAX 101
using namespace std;

int front_z[6] = { 0,0,0,0,-1,1 };
int front_y[6] = { -1,1,0,0,0,0 };
int front_x[6] = { 0,0,-1,1,0,0 };

queue<tuple<int, int, int>>pos;
int tomato[MAX][MAX][MAX];
int dist[MAX][MAX][MAX];
int visited[MAX][MAX][MAX];
int m, n, h;

// 시작해야하는 정점(vertex)들을 큐에 넣어주는 함수
// bfs 를 각 정점들마다 번갈아가면서 하게 만들어 줌.
void vertex(int z, int y, int x) {
	pos.push(make_tuple(z, y, x));
}

void bfs(int here_z, int here_y, int here_x) {
	visited[here_z][here_y][here_x] = true;
	vertex(here_z, here_y, here_x);
	dist[here_z][here_y][here_x] = 0;

	while (pos.empty() == false) {
		if (!visited[here_z][here_y][here_x])
			visited[here_z][here_y][here_x] = true;
		here_z = get<0>(pos.front());
		here_y = get<1>(pos.front());
		here_x = get<2>(pos.front());
		pos.pop();

		for (int dir = 0; dir < 6; dir++) {
			int next_z = here_z + front_z[dir];
			int next_y = here_y + front_y[dir];
			int next_x = here_x + front_x[dir];

			if (next_z < 0 || next_y < 0 || next_x < 0)
				continue;
			if (next_z >= h || next_y >= n || next_x >= m)
				continue;
			if (tomato[next_z][next_y][next_x] == -1)
				continue;
			if (tomato[next_z][next_y][next_x] == 1)
				continue;
			if (visited[next_z][next_y][next_x])
				continue;

			visited[next_z][next_y][next_x] = true;
			vertex(next_z, next_y, next_x);
			dist[next_z][next_y][next_x] = dist[here_z][here_y][here_x] + 1;
			tomato[next_z][next_y][next_x] = 1;
		}
	}
}

int main() {
	bool isPossible = false;
	bool isZero = true;
	int k, i, j;
	cin >> m >> n >> h;
	
	for (k = 0; k < h; k++)
		for (i = 0; i < n; i++)
			for (j = 0; j < m; j++) {
				cin >> tomato[k][i][j];
				if (tomato[k][i][j] != 0)
					isZero = false;
				if (tomato[k][i][j] == -1)
					visited[k][i][j] = -1;
				if (tomato[k][i][j] == 1)
					vertex(k, i, j);
			}

	if (!isZero)
		bfs(get<0>(pos.front()), get<1>(pos.front()), get<2>(pos.front()));

	for (k = 0; k < h; k++) {
		for (i = 0; i < n; i++) {
			for (j = 0; j < m; j++)
				if (visited[k][i][j] == 0) {
					isPossible = true;
					break;
				}
			if (isPossible)
				break;
		}
		if (isPossible) {
			cout << -1;
			break;
		}
	}

	if (!isPossible) {
		int max = 0;
		for (k = 0; k < h; k++)
			for (i = 0; i < n; i++)
				for (j = 0; j < m; j++)
					if (max < dist[k][i][j])
						max = dist[k][i][j];
		cout << max;
	}

	return 0;
}

//5 3 2
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0
//0 0 0 0 0

//5 3 2
//-1 -1 -1 -1 -1
//-1 -1 -1 -1 -1
//-1 -1 -1 -1 -1
//-1 -1 -1 -1 -1
//-1 -1 -1 -1 -1
//-1 -1 -1 -1 -1