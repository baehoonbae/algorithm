#include<iostream>
#include<string>
#include<stack>
using namespace std;

stack<char>s;
stack<char>dot;
string str;

int main()
{
	int cnt = 0;
	cin >> str;
	for (int i = 0; i < str.size(); i++)
	{
		if (str[i] == '(')
		{
			s.push(str[i]);
			continue;
		}
		else
		{
			if (str[i - 1] == '(')
			{
				s.pop();
				cnt += s.size();
			}
			else
			{
				s.pop();
				cnt++;
			}
		}
	}
	cout << cnt;
	return 0;
}