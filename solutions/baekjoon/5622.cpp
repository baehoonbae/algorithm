#include<iostream>
#include<string>
using namespace std;

string s;

int main()
{
	int cnt = 0;
	cin >> s;
	for (int i = 0; i < s.size(); i++)
	{
		if (s[i] == 'A' || s[i] == 'B' || s[i] == 'C')cnt += 3;
		if (s[i] == 'D' || s[i] == 'E' || s[i] == 'F')cnt += 4;
		if (s[i] == 'G' || s[i] == 'H' || s[i] == 'I')cnt += 5;
		if (s[i] == 'J' || s[i] == 'K' || s[i] == 'L')cnt += 6;
		if (s[i] == 'M' || s[i] == 'N' || s[i] == 'O')cnt += 7;
		if (s[i] == 'P' || s[i] == 'Q' || s[i] == 'R' || s[i] == 'S')cnt += 8;
		if (s[i] == 'V' || s[i] == 'T' || s[i] == 'U')cnt += 9;
		if (s[i] == 'W' || s[i] == 'X' || s[i] == 'Y' || s[i] == 'Z')cnt += 10;
	}
	cout << cnt;
	return 0;
}