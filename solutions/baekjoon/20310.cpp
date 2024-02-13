#include <iostream>
#include <string>
using namespace std;

int main()
{
	int OneCount = 0;
	int ZeroCount = 0;
	string Str;
	cin >> Str;
	for (int i = 0; i < Str.size(); i++)
	{
		if (Str[i] == '0')
		{
			ZeroCount++;
		}
		else
		{
			OneCount++;
		}
	}
	int TargetOneCount = OneCount / 2;
	int TargetZeroCount = ZeroCount / 2;
	for (int i = 0; i < Str.size(); i++)
	{
		if (Str[i] == '1')
		{
			Str[i] = 'N';
			OneCount--;
			if (TargetOneCount == OneCount)
			{
				break;
			}
		}
	}
	for (int i = Str.size() - 1; i > 0; i--)
	{
		if (Str[i] == '0')
		{
			Str[i] = 'N';
			ZeroCount--;
			if (TargetZeroCount == ZeroCount)
			{
				break;
			}
		}
	}
	for (int i = 0; i < Str.size(); i++)
	{
		if (Str[i] != 'N')
		{
			cout << Str[i];
		}
	}
	return 0;
}