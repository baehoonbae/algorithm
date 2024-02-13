#include<iostream>
#include<queue>
using namespace std;

queue<pair<int, int>>pos;
bool visited[100001];
int n, k;

void bfs(int start) {
	pos.push(make_pair(start, 0));
	visited[start] = true;
	while (!pos.empty()) {
		int here = pos.front().first;
		int time = pos.front().second;
		pos.pop();
		if (here == k) {
			cout << time;
			break;
		}
		if (here + 1 >= 0 && here + 1 <= 100000)
			if (!visited[here + 1]) {
				visited[here + 1] = true;
				pos.push(make_pair(here + 1, time + 1));
			}
		if (here - 1 >= 0 && here - 1 <= 100000) 
			if (!visited[here - 1]) {
				visited[here - 1] = true;
				pos.push(make_pair(here - 1, time + 1));
			}
		if (here * 2 >= 0 && here * 2 <= 100000) 
			if (!visited[here * 2]) {
				visited[here * 2] = true;
				pos.push(make_pair(here * 2, time + 1));
			}
	}
}

int main() {
	cin >> n >> k;
	bfs(n);



	return 0;
}