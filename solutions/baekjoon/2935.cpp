#include<iostream>
#include<string>
using namespace std;

string result;
char arr1[1001];

int main()
{
	string a, b;
	char c;
	cin >> a >> c >> b;
	for (int i = 0; i < max(a.size(),b.size()); i++)
	{
		if (a.size() < b.size())
		{
			if (b[i] == '1')
				arr1[i] = '1';
			else
				arr1[i] = '0';
		}
		else
		{
			if (a[i] == '1')
				arr1[i] = '1';
			else
				arr1[i] = '0';
		}
	}
	if (c == '+')
	{
		if (a.size() == b.size())
		{
			result += '2';
			for (int i = 1; i < a.size(); i++)
				result += arr1[i];
		}
		else if (a.size() < b.size())
		{
			for (int i = 0; i < b.size() - a.size(); i++)
				result += arr1[i];
			for (int i = 0; i < a.size(); i++)
				result += arr1[i];
		}
		else
		{
			for (int i = 0; i <= a.size() - b.size() - 1; i++)
				result += arr1[i];
			for (int i = 0; i <= b.size()-1; i++)
				result += arr1[i];
		}
	}
	else
	{
		for (int i = 0; i < max(a.size(), b.size()); i++)
			result += arr1[i];
		for (int i = 1; i < min(a.size(), b.size()); i++)
			result += arr1[i];
	}
	cout << result;
	return 0;
}