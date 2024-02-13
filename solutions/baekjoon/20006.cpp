#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

struct Queue
{
	vector<pair<string, int>>Info;
	int StandardLevel;
	int CurrentCapacity = 0;
};
vector<Queue>Matching;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int Case, MaxAdmit;
	cin >> Case >> MaxAdmit;
	for (int i = 0; i < Case; ++i)
	{
		int Level;
		string Nickname;
		Queue Temp;

		cin >> Level >> Nickname;
		if (Matching.empty())
		{
			Temp.Info.push_back({ Nickname,Level});
			Temp.StandardLevel = Level;
			Temp.CurrentCapacity++;
			Matching.push_back(Temp);
			continue;
		}
		for (int j = 0; j <= Matching.size(); ++j)
		{
			if (j == Matching.size())
			{
				Temp.Info.push_back({ Nickname,Level });
				Temp.StandardLevel = Level;
				Temp.CurrentCapacity++;
				Matching.push_back(Temp);
				break;
			}
			if (Matching[j].CurrentCapacity == MaxAdmit)
			{
				continue;
			}
			if (Level < Matching[j].StandardLevel - 10 || Level > Matching[j].StandardLevel + 10)
			{
				continue;
			}
			else
			{
				Matching[j].CurrentCapacity++;
				Matching[j].Info.push_back({ Nickname,Level });
				break;
			}
		}
	}
	for (int i = 0; i < Matching.size(); ++i)
	{
		sort(Matching[i].Info.begin(),Matching[i].Info.end());
		if (Matching[i].CurrentCapacity == MaxAdmit)
		{
			cout << "Started!" << '\n';
			for (int j = 0; j < Matching[i].Info.size(); ++j)
			{
				cout << Matching[i].Info[j].second << " "
					<< Matching[i].Info[j].first << '\n';
			}
		}
		else
		{
			cout << "Waiting!" << '\n';
			for (int j = 0; j < Matching[i].Info.size(); ++j)
			{
				cout << Matching[i].Info[j].second << " "
					<< Matching[i].Info[j].first << '\n';
			}
		}
	}
	return 0;
}