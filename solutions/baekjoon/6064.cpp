#include<iostream>
using namespace std;

int main() {
	int t;
	int M, N, X, Y;
	cin >> t;
	for (int i = 0; i < t; i++) {
		int x = 1, y = 1, cnt = 1;
		cin >> M >> N >> X >> Y;
		while (1) {
			if (X <= 1 || Y <= 1)
				break;
			cnt++;
			X--;
			Y--;
		}
		while (1) {
			if (x == X && y == Y) {
				cout << cnt << endl;
				break;
			}

			if (M - x < N - y) {
				cnt += (M - x) + 1;
				y += (M - x) + 1;
				x += (M - x) + 1;
			}
			else {
				cnt += (N - y) + 1;
				x += (N - y) + 1;
				y += (N - y) + 1;
			}

			if (x > M && y > N) {
				cout << -1 << endl;
				break;
			}
			else if (x > M)
				x = 1;
			else
				y = 1;
			
		}
	}
	return 0;
}