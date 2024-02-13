#include <iostream>
#include <deque>
#include <unordered_map>
using namespace std;

int Element[200001];
int ElementCount[100001];

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);
	int Result = 0;
	int Start = 0;
	int End = 0;
	int N, K;
	cin >> N >> K;
	for (int i = 1; i <= N; ++i)
	{
		cin >> Element[i];
		ElementCount[Element[i]]++;
		while (ElementCount[Element[i]] > K)
		{
			Start++;
			ElementCount[Element[Start]]--;
		}
		Result = max(Result, i - Start);
	}
	cout << Result;
	return 0;
}