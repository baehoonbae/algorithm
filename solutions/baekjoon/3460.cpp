#include <iostream>
#include <queue>
using namespace std;

int main()
{
	queue<int> Digit;
	int Case, Number;
	cin >> Case;
	for (int i = 0; i < Case; ++i)
	{
		cin >> Number;
		while (Number != 0)
		{
			if (Number % 2 == 1)
			{
				Digit.push(1);
			}
			else
			{
				Digit.push(0);
			}
			Number /= 2;
		}
		int Count = 0;
		while (Digit.empty() == false)
		{
			if (Digit.front() == 1)
			{
				cout << Count << ' ';
				Count++;
				Digit.pop();
			}
			else
			{
				Count++;
				Digit.pop();
			}
		}
		cout << '\n';
	}

	return 0;
}