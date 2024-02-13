#include<iostream>
#include<string>
using namespace std;

int main()
{
	int t;
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		double a;
		string s;
		cin >> a;
		getline(cin, s);
		for (int i = 0; i < s.size(); i++)
		{
			if (s[i] == '@')
				a *= double(3);
			if (s[i] == '%')
				a += double(5);
			if (s[i] == '#')
				a -= double(7);
		}
		printf("%.2f\n", a);
	}
	return 0;
}