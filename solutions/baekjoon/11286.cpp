#include<iostream>
#include<cmath>
#include<queue>
using namespace std;

// first => 절댓값
// second => 원래값
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>>pq;

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) {
		int x;
		cin >> x;
		if (x == 0) {
			if (pq.empty())
				cout << 0 << endl;
			else {
				cout << pq.top().second << endl;
				pq.pop();
			}
		}
		else {
			pq.push(make_pair(abs(x),x));
		}
	}

	return 0;
}