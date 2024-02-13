#include <iostream>
using namespace std;

int Sushi[30001];
int SushiCount[3001];
int MaxCase, CaseCount;
int Start, End;
bool IsCouponUsed;

int main()
{
	int SushiNum, SushiCase, Continue, Coupon;
	cin >> SushiNum >> SushiCase >> Continue >> Coupon;
	for (int i = 0; i < SushiNum; ++i)
	{
		cin >> Sushi[i];
	}
	for (int i = 0; i < Continue; ++i)
	{
		SushiCount[Sushi[i]]++;
		if (SushiCount[Sushi[i]] > 1)
		{
			continue;
		}
		if (Sushi[i] == Coupon)
		{
			IsCouponUsed = true;
		}
		CaseCount++;
	}
	if (!IsCouponUsed)
	{
		CaseCount++;
	}
	MaxCase = max(MaxCase, CaseCount);
	while (1)
	{
		Start++;
		if (Start == SushiNum)
		{
			break;
		}
		End = (Start + Continue - 1) % SushiNum;
		SushiCount[Sushi[Start - 1]]--;
		if (SushiCount[Sushi[Start - 1]] == 0)
		{
			CaseCount--;
		}
		SushiCount[Sushi[End]]++;
		if (SushiCount[Sushi[End]] == 1)
		{
			CaseCount++;
		}
		if (SushiCount[Coupon] == 0)
		{
			if (!IsCouponUsed)
			{
				CaseCount--;
			}
			IsCouponUsed = false;
			CaseCount++;
		}
		if (SushiCount[Coupon] >= 1)
		{
			if (!IsCouponUsed)
			{
				CaseCount--;
			}
			IsCouponUsed = true;
		}
		MaxCase = max(MaxCase, CaseCount);
	}
	cout << MaxCase;
	return 0;
}