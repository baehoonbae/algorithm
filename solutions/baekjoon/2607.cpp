#include<iostream>
#include<algorithm>
#include<string>
using namespace std;

int n;
string Origin, Comp;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	cin >> n;
	cin >> Origin;

	int Count = 0;
	int Alphabet[26] = { 0, };
	int OriLen = Origin.size();

	for (int i = 0; i < OriLen; i++)
	{
		Alphabet[Origin[i] - 'A'] += 1;
	}
	for (int i = 0; i < n - 1; i++)
	{
		Comp.clear();
		cin >> Comp;
		int Same = 0;
		int CompLen = Comp.size();
		int CompAlphabet[26];
		copy(Alphabet, Alphabet + 26, CompAlphabet);
		for (int i = 0; i < CompLen; i++)
		{
			if (CompAlphabet[Comp[i] - 'A'] > 0)
			{
				CompAlphabet[Comp[i] - 'A']--;
				Same++;
			}
		}
		if (OriLen == CompLen)
		{
			if (Same == OriLen || Same == OriLen - 1)
			{
				Count++;
			}
		}
		else if (OriLen - 1 == CompLen && Same == OriLen - 1)
		{
			Count++;
		}
		else if (OriLen + 1 == CompLen && Same == OriLen)
		{
			Count++;
		}
		else
		{
			continue;
		}
	}
	cout << Count;
	return 0;
}