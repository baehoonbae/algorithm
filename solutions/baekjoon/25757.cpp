#include<iostream>
#include<set>
using namespace std;

set<string>s;

int main()
{
	int n;
	char c;
	cin >> n >> c;

	for (int i = 0; i < n; i++)
	{
		string str;
		cin >> str;
		s.insert(str);
	}

	if (c == 'Y')
		cout << s.size();
	else if (c == 'F')
		cout << s.size() / 2;
	else
		cout << s.size() / 3;

	return 0;
}