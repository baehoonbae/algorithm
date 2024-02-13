#include<iostream>
#include<algorithm>
using namespace std;

enum {
	ONLY_PACKAGE	= 0,
	ONLY_PIECE		= 1,
	TOGETHER		= 2,
};

int main() {
	int N, M;
	cin >> N >> M;
	
	int cnt = N / 6;

	int result[3];
	int P_package_6[51];
	int P_piece[51];

	int Package_min	= 1001;
	int Piece_min	= 1001;

	for (int i = 0; i < M; i++) {
		cin >> P_package_6[i] >> P_piece[i];

		if (Package_min > P_package_6[i])
			Package_min = P_package_6[i];
		if (Piece_min > P_piece[i])
			Piece_min = P_piece[i];
	}
	
	result[ONLY_PACKAGE]	= Package_min * (cnt+1);
	result[ONLY_PIECE]		= Piece_min * N;
	result[TOGETHER]		= (Package_min * cnt) + (Piece_min * (N%6));

	cout << *min_element(result, result + 3);

	return 0;
}