#include <iostream>
#include <vector>
using namespace std;

int Score[6];
int MaxScore;
int Ranking;

int main()
{
	for (int i = 1; i <= 5; ++i)
	{
		for (int j = 1; j <= 5; ++j)
		{
			if (i == j)
			{
				continue;
			}
			int Num;
			cin >> Num;
			Score[i] += Num;
		}
		if (MaxScore < Score[i])
		{
			Ranking = i;
			MaxScore = Score[i];
		}
	}
	cout << Ranking << " " << MaxScore;
	return 0;
}