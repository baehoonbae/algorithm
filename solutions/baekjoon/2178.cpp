#include<iostream>
#include<queue>
#define MAX 101
using namespace std;

struct Pos { int y, x; };
Pos front[4] = {
	Pos {-1,0},	// UP
	Pos {0,-1},	// LEFT
	Pos {+1,0},	// DOWN
	Pos {0,+1},	// RIGHT
};

int N, M;
bool discovered[MAX][MAX];
char miro[MAX][MAX];
int dist[MAX][MAX];
queue<Pos>q;

void Bfs(int y,int x) {
	Pos pos;
	pos.y = y;
	pos.x = x;

	discovered[y][x] = true;
	q.push(pos);
	dist[y][x] = 1;

	while (q.empty() == false) {
		pos = q.front();
		q.pop();

		if (pos.y == N && pos.x == M)
			break;
		
		for (int dir = 0; dir < 4; dir++) {
			Pos nextPos;
			nextPos.y = pos.y + front[dir].y;
			nextPos.x = pos.x + front[dir].x;

			if (nextPos.y < 1 || nextPos.x < 1)
				continue;
			if (nextPos.y > N || nextPos.x > M)
				continue;
			if (miro[nextPos.y][nextPos.x] == 48)
				continue;
			if (discovered[nextPos.y][nextPos.x])
				continue;

			discovered[nextPos.y][nextPos.x] = true;
			q.push(nextPos);
			dist[nextPos.y][nextPos.x] = dist[pos.y][pos.x] + 1;
		}
	}
}

int main() {
	cin >> N >> M;

	for (int y = 1; y <= N; y++)
		for (int x = 1; x <= M; x++)
			cin >> miro[y][x];

	Bfs(1, 1);
	cout << dist[N][M];
	
	return 0;
}