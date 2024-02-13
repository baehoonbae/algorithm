#include <iostream>
using namespace std;

int Arr[1001];

int main()
{
	int Start, End, Result = 0;
	int ix = 1;
	int Number = 1;
	while (ix <= 1000)
	{
		int Count = 0;
		while(1)
		{
			Arr[ix] = Number;
			ix++;
			Count++;
			if (Count == Number)
			{
				Number++;
				break;
			}
		}
	}
	cin >> Start >> End;
	for (int i = Start; i <= End; ++i)
	{
		Result += Arr[i];
	}
	cout << Result;
	return 0;
}