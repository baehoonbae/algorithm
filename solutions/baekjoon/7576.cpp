#include<iostream>
#include<queue>
using namespace std;

int front_y[4] = { -1,1,0,0 };
int front_x[4] = { 0,0,-1,1 };

queue<pair<int, int>>pos;
int tomato[1001][1001];
int dist[1001][1001];
int visited[1001][1001];
int m, n;

// 시작해야하는 정점(vertex)들을 큐에 넣어주는 함수
// bfs 를 각 정점들마다 번갈아가면서 하게 만들어 줌.
void vertex(int y, int x) {
	pos.push(make_pair(y, x));
}

void bfs(int here_y, int here_x) {
	visited[here_y][here_x] = true;
	pos.push(make_pair(here_y, here_x));
	dist[here_y][here_x] = 0;

	while (pos.empty() == false) {
		if (!visited[here_y][here_x])
			visited[here_y][here_x] = true;
		here_y = pos.front().first;
		here_x = pos.front().second;
		pos.pop();

		for (int dir = 0; dir < 4; dir++) {
			int next_y = here_y + front_y[dir];
			int next_x = here_x + front_x[dir];

			if (next_y < 0 || next_x < 0)	continue;
			if (next_y >= n || next_x >= m)	continue;
			if (tomato[next_y][next_x] == -1)continue;			
			if (tomato[next_y][next_x] == 1)continue;
			if (visited[next_y][next_x])	continue;

			visited[next_y][next_x] = true;
			pos.push(make_pair(next_y, next_x));
			dist[next_y][next_x] = dist[here_y][here_x] + 1;
			tomato[next_y][next_x] = 1;
		}
	}
}

int main() {
	bool isPossible = false;
	bool isZero = true;
	int i, j;
	cin >> m >> n;

	for (i = 0; i < n; i++)
		for (j = 0; j < m; j++) {
			cin >> tomato[i][j];
			if (tomato[i][j] != 0)	isZero = false;
			if (tomato[i][j] == -1) visited[i][j] = -1;
			if (tomato[i][j] == 1)	vertex(i, j);
		}
	
	if(!isZero)
		bfs(pos.front().first, pos.front().second);

	for (i = 0; i < n; i++) {
		for (j = 0; j < m; j++)
			if (visited[i][j] == 0) { isPossible = true; break; }
		if (isPossible) { cout << -1; break; }
	}

	if (!isPossible) {
		int max = 0;
		for (i = 0; i < n; i++) 
			for (j = 0; j < m; j++) 
				if (max < dist[i][j])
					max = dist[i][j];
		cout << max;
	}

	return 0;
}