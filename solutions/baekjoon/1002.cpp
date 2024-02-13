#include<iostream>
#include<cmath>
using namespace std;

int main() {
	int		x1, y1, r1, x2, y2, r2;
	int		T; cin >> T;
	double	d;
	
	for (int t = 0; t < T; t++) {
		cin >> x1 >> y1 >> r1;
		cin >> x2 >> y2 >> r2;
		d = sqrt(static_cast<double>((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)));

		if (r1 > r2)
			swap(r1, r2);

		if (d == 0) {
			if (r1 == r2)
				cout << -1 << endl;
			else if (r2 > r1)
				cout << 0 << endl;
		}
		else if (d > 0)	{
			if (r2 > d + r1 || d > r1 + r2)
				cout << 0 << endl;
			else if (d == r1 + r2 || d == r2 - r1)
				cout << 1 << endl;
			else if (d < r1 + r2 && r2 - r1 < d)
				cout << 2 << endl;
		}
	}
	
	return 0;
}