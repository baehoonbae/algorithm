#include<iostream>
#include<vector>
#include<algorithm>
using namespace std;

vector<long long>coord;
vector<long long>cpy;

int main() {
	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int val;
		cin >> val;
		coord.push_back(val);
		cpy.push_back(val);
	}

	sort(cpy.begin(), cpy.end());
	cpy.erase(unique(cpy.begin(), cpy.end()),cpy.end());

	for (int i = 0; i < N; i++) {
		auto val = lower_bound(cpy.begin(), cpy.end(), coord[i])-cpy.begin();
		coord[i] = val;
	}
	for (int i = 0; i < N; i++) {
		cout << coord[i] << " ";
	}

	return 0;
}