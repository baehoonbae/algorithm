#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int main() {
	int N, M;
	cin >> N >> M;
	
	vector<int>v;
	
	for (int i = 1; i <= N; i++) 
		v.push_back(i);
	
	for (int i = 0; i < M; i++) {
		int start, end;
		cin >> start >> end;
		reverse(v.begin() + (start - 1), v.begin() + end);
	}

	for (int i = 0; i < N; i++)
		cout << v[i]<<" ";

	return 0;
}