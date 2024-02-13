#include<iostream>
#include<stack>
using namespace std;
string s;
stack<char>l;
stack<char>r;
int main()
{
	int t;
	cin >> s >> t;
	for (int i = 0; i < s.size(); i++)
		l.push(s[i]);
	for (int i = 0; i < t; i++)
	{
		char a;
		cin >> a;
		if (a == 'L')
		{
			if(!l.empty())
			{
				r.push(l.top());
				l.pop();
			}
		}
		if (a == 'D')
		{
			if(!r.empty())
			{
				l.push(r.top());
				r.pop();
			}
		}

		if (a == 'B')
			if(!l.empty())
				l.pop();

		if (a == 'P')
		{
			char b;
			cin >> b;
			l.push(b);
		}
	}
	while (l.empty() == false)
	{
		r.push(l.top());
		l.pop();
	}
	while (r.empty() == false)
	{
		cout << r.top();
		r.pop();
	}
	return 0;
}