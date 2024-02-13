#include<iostream>
#include<string>
using namespace std;

int main()
{
	while (1)
	{
		bool gat = false;	// 모음 들어가 있는지
		bool notcont = true;	// 모음 3개나 자음 3개 연속이 없는지
		bool notsame = true;	// 같은 글자 2개 연속 없는지
		string s;
		cin >> s;
		if (s == "end")
			break;
		for (int i = 0; i < s.size(); i++)
		{
			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
				gat = true;

			if (s[i] == 'a' || s[i] == 'e' || s[i] == 'i' || s[i] == 'o' || s[i] == 'u')
				if (i < s.size() - 1 && (s[i + 1] == 'a' || s[i + 1] == 'e' || s[i + 1] == 'i' || s[i + 1] == 'o' || s[i + 1] == 'u'))
					if (i < s.size() - 2 && (s[i + 2] == 'a' || s[i + 2] == 'e' || s[i + 2] == 'i' || s[i + 2] == 'o' || s[i + 2] == 'u'))
					{
						notcont = false;
						continue;
					}
						
			if (s[i] != 'a' && s[i] != 'e' && s[i] != 'i' && s[i] != 'o' && s[i] != 'u')
				if (i < s.size() - 1 && (s[i + 1] != 'a' && s[i + 1] != 'e' && s[i + 1] != 'i' && s[i + 1] != 'o' && s[i + 1] != 'u'))
					if (i < s.size() - 2 && (s[i + 2] != 'a' && s[i + 2] != 'e' && s[i + 2] != 'i' && s[i + 2] != 'o' && s[i + 2] != 'u'))
					{
						notcont = false;
						continue;
					}

			if (i < s.size() - 1 && s[i] != 'e' && s[i] != 'o' && s[i] == s[i + 1])
			{
				notsame = false;
				continue;
			}
		}
		if (gat && notcont && notsame)
			cout << '<' << s << "> is acceptable." << '\n';
		else
			cout << '<' << s << "> is not acceptable." << '\n';
	}


	return 0;
}