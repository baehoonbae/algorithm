#include<iostream>
using namespace std;

int ranking[51];

int main() {

	int n;			// 점수의 개수
	int score;		// 태수의 새로운 점수
	int r;			// 랭킹 범위

	int cnt = 0;
	int rank_count = 1;

	cin >> n >> score >> r;

	// 배열 -1로 초기화
	for (int i = 0; i < r; i++) { ranking[i] = -1; }
	
	// 랭킹 리스트 입력 받기
	for (int i = 0; i < n; i++) { cin >> ranking[i]; }

	for (int i = 0; i < n; i++) {
		// 1. 랭킹을 순회할 때 기존 점수보다 새로운 점수가 작으면 +1
		// 2. 점수가 같으면 랭크 유지
		if		(score < ranking[i])	{ rank_count++; }
		else if (score == ranking[i])	{ rank_count = rank_count; }
		else break;
		cnt++;
	}

	// 배열 범위에 안들어가면 -1
	// 랭킹에 점수가 아무것도 없다면 1
	if (cnt == r)	rank_count = -1;
	if (n == 0)		rank_count = 1;

	cout << rank_count;

	return 0;
}