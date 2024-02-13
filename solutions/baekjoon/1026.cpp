#include<iostream>
#include<algorithm>
using namespace std;

int N;
int A[51];
int B[51];

int main() {
	int result = 0;

	cin >> N;
	for (int i = 0; i < N; i++) { cin >> A[i]; }
	for (int i = 0; i < N; i++) { cin >> B[i]; }

	sort(A, A + N, greater<int>());	// 내림차순
	sort(B, B + N, less<int>());	// 오름차순

	for (int i = 0; i < N; i++) {
		int temp = 1;
		temp = A[i] * B[i];
		result += temp;
	}

	cout << result;

	return 0;
}