#include<iostream>
#include<algorithm>
#include<queue>
#define MAX 26
using namespace std;

struct Pos { int y, x; };
Pos front[4] = {
	Pos {-1,0},	// UP
	Pos {0,-1},	// LEFT
	Pos {+1,0},	// DOWN
	Pos {0,+1},	// RIGHT
};

int N, cnt;
vector<int>cnt_apart;

bool discovered[MAX][MAX];
char apart[MAX][MAX];

queue<Pos>q;

void Bfs(int y, int x) {
	Pos pos;
	pos.y = y;
	pos.x = x;

	discovered[y][x] = true;
	q.push(pos);
	cnt++;

	while (q.empty() == false) {
		pos = q.front();
		q.pop();

		if (pos.y == N && pos.x == N)
			break;

		for (int dir = 0; dir < 4; dir++) {
			Pos nextPos;
			nextPos.y = pos.y + front[dir].y;
			nextPos.x = pos.x + front[dir].x;

			if (nextPos.y >= 0 && nextPos.x >= 0	&&
				nextPos.y <= N && nextPos.x <= N	&&
				apart[nextPos.y][nextPos.x] == '1'	&&
				discovered[nextPos.y][nextPos.x] == false) 
			{
				discovered[nextPos.y][nextPos.x] = true;
				q.push(nextPos);
				cnt++;
			}
		}
	}
}

int main() {
	cin >> N;

	for (int y = 0; y < N; y++)
		for (int x = 0; x < N; x++)
			cin >> apart[y][x];

	for (int y = 0; y < N; y++)
		for (int x = 0; x < N; x++)
			if (apart[y][x] == '1' && discovered[y][x] == false) {
				cnt = 0;
				Bfs(y, x);
				cnt_apart.push_back(cnt);
			}

	sort(cnt_apart.begin(), cnt_apart.end());
	cout << cnt_apart.size() << endl;

	for (int i = 0; i < cnt_apart.size(); i++)
		cout << cnt_apart[i] << endl;

	return 0;
}