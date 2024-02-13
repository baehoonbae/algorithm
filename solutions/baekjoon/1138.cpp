#include <iostream>
using namespace std;

int Line[11];
int SortedLine[11];
int N;

int main()
{
	cin >> N;
	for (int i = 0; i < N; ++i)
	{
		cin >> Line[i];
	}
	for (int i = 0; i < N; ++i)
	{
		for (int j = 0;; ++j)
		{
			if (SortedLine[j] != 0)
			{
				Line[i]++;
				continue;
			}
			if (j == Line[i])
			{
				SortedLine[j] = i + 1;
				break;
			}
			if (SortedLine[j] == 0)
			{
				continue;
			}
		}
	}
	for (int i = 0; i < N; i++)
	{
		cout << SortedLine[i] << " ";
	}
	return 0;
}