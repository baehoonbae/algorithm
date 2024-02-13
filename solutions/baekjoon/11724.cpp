#include<iostream>
#include<vector>
using namespace std;

vector<bool>visited(1001,false);
vector<int>graph[1001];

void CreateGraph(int ver) {
	for (int i = 0; i < ver; i++) {
		int u, v;
		cin >> u >> v;
		graph[u].push_back(v);
		graph[v].push_back(u);
	}
}

void dfs(int here) {
	visited[here] = true;
	for (int i = 0; i < graph[here].size(); i++) {
		int there = graph[here][i];
		if (!visited[there])
			dfs(there);
	}
}

int main() {
	int cnt = 0;
	int n, m;
	cin >> n >> m;

	CreateGraph(m);

	for (int i = 1; i <= n; i++) {
		if (!visited[i])
			cnt++;
		dfs(i);
	}

	cout << cnt;

	return 0;
}