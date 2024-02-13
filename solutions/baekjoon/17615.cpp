#include <iostream>
using namespace std;

char Ball[500001];
int BallNum;
int MinCount = 111111111;

int main()
{
	int Count = 0;
	int Standard = 0;
	cin >> BallNum;
	cin >> Ball;

	// 왼쪽에 빨간볼
	Count = 0, Standard = 0;
	if (Ball[0] == 'R')
	{
		int ix = 0;
		while (Ball[ix] != 'B')
		{
			Standard++;
			ix++;
		}
	}
	for (int i = Standard; i < BallNum; ++i)
	{
		if (Ball[i] == 'R')
		{
			Count++;
		}
	}
	MinCount = min(MinCount, Count);

	// 오른쪽에 빨간볼
	Count = 0, Standard = BallNum - 1;
	if (Ball[BallNum-1] == 'R')
	{
		int ix = BallNum - 1;
		while (Ball[ix] != 'B')
		{
			Standard--;
			ix--;
		}
	}
	for (int i = Standard; i >= 0; --i)
	{
		if (Ball[i] == 'R')
		{
			Count++;
		}
	}
	MinCount = min(MinCount, Count);

	// 왼쪽에 파란볼
	Count = 0, Standard = 0;
	if (Ball[0] == 'B')
	{
		int ix = 0;
		while (Ball[ix] != 'R')
		{
			Standard++;
			ix++;
		}
	}
	for (int i = Standard; i < BallNum; ++i)
	{
		if (Ball[i] == 'B')
		{
			Count++;
		}
	}
	MinCount = min(MinCount, Count);

	// 오른쪽에 파란볼
	Count = 0, Standard = BallNum - 1;
	if (Ball[BallNum - 1] == 'B')
	{
		int ix = BallNum - 1;
		while (Ball[ix] != 'R')
		{
			Standard--;
			ix--;
		}
	}
	for (int i = Standard; i >= 0; --i)
	{
		if (Ball[i] == 'B')
		{
			Count++;
		}
	}
	MinCount = min(MinCount, Count);
	cout << MinCount;

	return 0;
}