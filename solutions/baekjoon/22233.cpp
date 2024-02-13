#include <iostream>
#include <map>
using namespace std;

map<string, bool> Keyword;
string NumOfKeywords[11];
int KeywordEa, DeleteEa;
int Index;

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> KeywordEa >> DeleteEa;
	for (int i = 0; i < KeywordEa; i++)
	{
		string s;
		cin >> s;
		Keyword[s] = true;
	}
	for (int i = 0; i < DeleteEa; i++)
	{
		Index = 0;
		string Str;
		cin >> Str;
		for (int j = 0; j < Str.size(); j++)
		{
			if (Str[j] == ',')
			{
				Index++;
				continue;
			}
			NumOfKeywords[Index] += Str[j];
		}
		for (int j = 0; j <= Index; j++)
		{
			Keyword.erase(NumOfKeywords[j]);
			NumOfKeywords[j].clear();
		}
		cout << Keyword.size() << '\n';
	}

	return 0;
}