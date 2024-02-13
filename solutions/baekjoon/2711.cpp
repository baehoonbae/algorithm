#include<iostream>
#include<string>
using namespace std;

int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		string s;
		int num;
		cin >> num;
		cin >> s;
		for (int j = 0; j < s.size(); j++)
		{
			if (j == num - 1)
				continue;
			cout << s[j];
		}
		cout << endl;
	}

	return 0;
}