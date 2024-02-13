#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

int a[10];
int sum;
pair<int, int>p;
vector<int>v;

int main() {
	for (int i = 0; i < 9; i++) {
		cin >> a[i];
		sum += a[i];
	}
	for (int i = 0; i < 9; i++) {
		bool check = false;
		for (int j = i + 1; j < 9; j++) {
			p.first = a[i];
			p.second = a[j];
			if (sum - (p.first + p.second) == 100) {
				int num = 0;
				while (1) {
					for (int k = 0; k < 9; k++) {
						if (a[k] == p.first || a[k] == p.second) {
							a[k] = 0;
							num++;
							if (num == 2) {
								check = true; break;
							}
						}
					}
					if (check)	break;
				}
			}
			if (check)	break;
		}
		if (check)	break;
	}
	for (int i = 0; i < 9; i++) {
		if (a[i] != 0)
			v.push_back(a[i]);
	}
	sort(v.begin(), v.end());
	for (int i = 0; i < 7; i++) {
		cout << v[i] << endl;
	}


	return 0;
}