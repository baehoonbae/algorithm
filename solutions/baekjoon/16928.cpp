#include<iostream>
#include<queue>
#define MAX 102
using namespace std;

queue<pair<int, int>>q;
int dist[MAX];
int board[MAX];
bool visited[MAX];
int n, m;

void bfs(int here, int mov) {
	q.push(make_pair(here, mov));
	visited[here] = true;
	dist[here] = mov;
	while (q.empty() == false) {
		int x = q.front().first;
		int mov = q.front().second;
		q.pop();
		for (int d = 1; d <= 6; d++) {
			int next = x + d;
			if (next == 100) {
				cout << mov + 1;
				return;
			}
			if (visited[next])
				continue;

			if (board[next] != 0)
				next = board[next];
			visited[next] = true;
			dist[next] = mov;
			q.push(make_pair(next, mov + 1));
		}
	}
}

int main() {
	int num = 1;
	cin >> n >> m;

	for (int i = 0; i < n + m; i++) {
		int a, b;
		cin >> a >> b;
		board[a] = b;
	}

	bfs(1, 0);

	return 0;
}