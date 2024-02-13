#include<iostream>
#include<vector>
#include<tuple>
#define MAX 100001
using namespace std;

pair<string, string>p[3];
string arr[51][MAX];
int cnt, minnum = 100001;

int main() {
	int t;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int n, minnum = 100001;
		cin >> n;

		for (int j = 0; j < n; j++)
			cin >> arr[i][j];

		if (n >= 33) {
			cout << 0 << endl;
			continue;
		}
		else {
			for (int a = 0; a < n - 2; a++) {
				for (int b = a + 1; b < n - 1; b++) {
					for (int c = b + 1; c < n; c++) {
						cnt = 0;
						p[0] = make_pair(arr[i][a], arr[i][b]);
						p[1] = make_pair(arr[i][b], arr[i][c]);
						p[2] = make_pair(arr[i][a], arr[i][c]);
						for (int idx = 0; idx < 3; idx++) {
							for (int d = 0; d < 4; d++) {
								if (p[idx].first[d] != p[idx].second[d])
									cnt++;
							}
						}
						if (minnum > cnt)
							minnum = cnt;
					}
				}
			}
			cout << minnum << endl;
		}
	}

	return 0;
}