#include<iostream>
#include<vector>
#include<queue>
#define MAX 101
using namespace std;


int n;
vector<int>v[MAX];
vector<bool>visit;
bool possible[MAX][MAX];
queue<int>q;

void bfs(int here) {
	q.push(here);
	while (q.empty() == false) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < v[x].size(); i++) {
			if (v[x].size() == 0)
				return;
			if (!visit[v[x][i]]) {
				visit[v[x][i]] = true;
				q.push(v[x][i]);
				possible[here][v[x][i]] = true;
			}
		}
	}
}

int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			int a;
			cin >> a;
			if (a == 1)
				v[i].push_back(j);
		}
	}

	for (int i = 0; i < n; i++) {
		visit = vector<bool>(MAX, false);
		if (v[i].size() == 0)
			continue;
		bfs(i);
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << possible[i][j] << " ";
		cout << endl;
	}

	return 0;
}