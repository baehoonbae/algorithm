#include<iostream>
#include<algorithm>
using namespace std;

int arr[501][501];
int dp[501][501];

int main() {
	int n, max_num = 0;
	cin >> n;

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= i; j++)
			cin >> arr[i][j];

	dp[1][1] = arr[1][1];
	dp[2][1] = dp[1][1] + arr[2][1];
	dp[2][2] = dp[1][1] + arr[2][2];

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= i; j++) {
			if (j == 1)
				dp[i][1] = dp[i - 1][1] + arr[i][1];
			else if (j == i)
				dp[i][j] = dp[i - 1][i - 1] + arr[i][j];
			else
				dp[i][j] = max(dp[i - 1][j - 1], dp[i - 1][j]) + arr[i][j];
			max_num = max(max_num, dp[i][j]);
		}
	}

	cout << max_num;

	return 0;
}