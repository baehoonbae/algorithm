#include<iostream>
#include<algorithm>
#include<map>
using namespace std;

map<int, int>m;

int main() {
	long long int sum = 0;
	int height = 1;
	int n;
	cin >> n;

	for (int i = 0; i < n; i++) {
		int a;
		cin >> a;
		if (m.empty()) {
			m.insert(make_pair(a, height));
			height++;
			sum += m[a];
			continue;
		}
		else if (m.size() == 1) {
			m.insert(make_pair(a, height));
			sum += m[a];
			continue;
		}
		else {
			auto it = m.lower_bound(a);
			auto pit = it--;
			if (it == m.end()) {
				m[a] = max(0, pit->second) + 1;
				sum += m[a];
			}
			else if (pit == m.end()) {
				m[a] = max(0, it->second) + 1;
				sum += m[a];
			}
			else {
				m[a] = max(it->second, pit->second) + 1;
				sum += m[a];
			}
		}
	}
	cout << sum;

	return 0;
}