#include<iostream>
#include<vector>
#include<queue>
using namespace std;

int n, m, sum;
vector<bool>visited;
vector<int>v[101];
vector<int>dist;
int bacon[101];
queue<int>q;

void bfs(int here) {
	visited = vector<bool>(n + 1, false);
	q.push(here);
	visited[here] = true;
	dist[here] = 0;
	while (q.empty() == false) {
		int x = q.front();
		q.pop();

		for (int i = 0; i < v[x].size(); i++) {
			int next = v[x][i];
			if (!visited[next]) {
				q.push(next);
				visited[next] = true;
				dist[next] = dist[x] + 1;
			}
		}
	}
}

int main() {
	int min = 9999;
	cin >> n >> m;

	dist = vector<int>(n + 1, -1);

	for (int i = 0; i < m; i++) {
		int a, b;
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	for (int i = 1; i <= n; i++) {
		sum = 0;
		bfs(i);
		for (int j = 1; j <= n; j++) 
			sum += dist[j];
		bacon[i] = sum;
	}

	for (int i = 1; i <= n; i++)
		if (min > bacon[i])
			min = bacon[i];
	for (int i = 1; i <= n; i++)
		if (bacon[i] == min) {
			cout << i;
			break;
		}

	return 0;
}