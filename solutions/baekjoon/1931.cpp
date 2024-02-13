#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

vector<pair<int, int>>t_table;
vector<pair<int, int>>best;

int main() {
	int cnt = 0;
	int idx = 0;
	int n;
	cin >> n;
	
	best.resize(100010,make_pair(-1,-1));

	for (int i = 0; i < n; i++) {
		pair<int, int>time;
		cin >> time.first >> time.second;
		t_table.push_back(time);
	}

	sort(t_table.begin(), t_table.end());

	best[0] = t_table[0];

	for (int i = 1; i < n; i++) {
		int best_time = best[idx].second - best[idx].first;
		int table_time = t_table[i].second - t_table[i].first;
		if (t_table[i].first >= best[idx].second) {
			idx++;
			best[idx] = t_table[i];
		}
		if (table_time <= best_time && 
			t_table[i].second <= best[idx].second) 
		{
			best[idx] = t_table[i];
		}
	}
	for (cnt = 0; best[cnt].first != -1; cnt++);
	cout << cnt;
	return 0;
}