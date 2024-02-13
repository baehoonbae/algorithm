#include <iostream>
#include <algorithm>
using namespace std;

int t;
int TeamEa, ProbEa, TeamId, EntryEa;

struct team
{
	int Id;
	int FinalSubmitTime;
	int SubmitCount = 0;
	int FinalScore = 0;
	int ProblemScore[101] = { 0, };
};
team Team[101];

void Init()
{
	for (int i = 0; i < TeamEa; i++)
	{
		Team[i].SubmitCount = 0;
		Team[i].FinalScore = 0;
		for (int j = 1; j <= ProbEa; j++)
		{
			Team[i].ProblemScore[j] = 0;
		}
	}
}

bool Cmp(const team& t1, const team& t2)
{
	if (t1.FinalScore == t2.FinalScore)
	{
		if (t1.SubmitCount == t2.SubmitCount)
		{
			return t1.FinalSubmitTime < t2.FinalSubmitTime;
		}
		return t1.SubmitCount < t2.SubmitCount;
	}
	return t1.FinalScore > t2.FinalScore;
}

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		cin >> TeamEa >> ProbEa >> TeamId >> EntryEa;
		Init();
		for (int j = 0; j < EntryEa; j++)
		{
			int id, ProblemId, Score;
			cin >> id >> ProblemId >> Score;
			id -= 1;
			Team[id].Id = id + 1;
			Team[id].FinalSubmitTime = j + 1;
			Team[id].SubmitCount++;
			if (Score > Team[id].ProblemScore[ProblemId])
			{
				Team[id].FinalScore -= Team[id].ProblemScore[ProblemId];
				Team[id].FinalScore += Score;
				Team[id].ProblemScore[ProblemId] = Score;
			}
		}
		sort(Team, Team + TeamEa, Cmp);
		for (int j = 0; j < TeamEa; j++)
		{
			if (Team[j].Id == TeamId)
			{
				cout << j + 1 << '\n';
				break;
			}
		}
	}
	return 0;
}