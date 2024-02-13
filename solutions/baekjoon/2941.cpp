#include<iostream>
using namespace std;

string s[9] = { "c=","c-","d-","lj","nj","s=","z=" };
string c1, c2;
string str;
int cnt;

int main()
{
	cin >> str;
	for (int i = 0; i < str.size();)
	{
		bool check = false;
		c1 += str[i];
		c1 += str[i + 1];
		if (str[i] == 'd' && str[i + 1] == 'z' && str[i + 2] == '=')
		{
			check = true;
			c2 += ';';
			i += 3;
		}
		if (!check)
		{
			for (int j = 0; j < 7; j++)
			{
				if (c1 == s[j])
				{
					check = true;
					c2 += j;
					i += 2;
					break;
				}
			}
		}
		if (!check)
		{
			c2 += str[i];
			i++;
		}
		c1.clear();
	}

	cout << c2.size();

	return 0;
}