#include<iostream>
using namespace std;

int paper[129][129];
int cnt_white;
int cnt_blue;

bool issame(int y,int x,int n) {
	int num = paper[y][x];

	for (int i = y; i < y + n; i++)
		for (int j = x; j < x + n; j++)
			if (num != paper[i][j])
				return false;

	return true;
}

void div(int y, int x, int n) {
	if (issame(y, x, n)) {
		if (paper[y][x] == 0)
			cnt_white++;
		if (paper[y][x] == 1)
			cnt_blue++;
	}
	else {
		int vol = n / 2;

		for (int i = 0; i < 2; i++)
			for (int j = 0; j < 2; j++)
				div(vol * i + y, vol * j + x, vol);
	}
}

int main() {
	int n;
	cin >> n;
	for (int i = 0; i < n; i++) 
		for (int j = 0; j < n; j++) 
			cin >> paper[i][j];

	div(0, 0, n);

	cout << cnt_white << '\n' << cnt_blue;

	return 0;
}