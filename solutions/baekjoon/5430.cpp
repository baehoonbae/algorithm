#include<iostream>
#include<deque>
#include<algorithm>
#include<cctype>
#include<cstring>
using namespace std;

bool abc, R;
int num;

deque<int>d;
string p;
string n;

void init()
{
	cin >> p;
	cin >> num;
	cin >> n;
	for (int j = 0;; j++)
	{
		bool check = false;
		if (d.size() == num)
			break;
		if (n[j] >= 48 && n[j] <= 57)
		{
			if (n[j + 1] >= 48 && n[j + 1] <= 57)
				if (n[j - 1] == '[' || n[j + 1] == ']' || n[j - 1] == ',')
				{
					d.push_back((n[j] - '0') * 10 + (n[j + 1] - '0'));
					check = true;
				}
			if (((n[j - 1] == ',' && n[j + 1] == ']') || (n[j - 1] == '[' && n[j + 1] == ',') || (n[j - 1] == ',' && n[j + 1] == ',') || (n[j - 1] == '[' && n[j + 1] == ']')) && !check)
				d.push_back(n[j] - '0');
		}
		else
			continue;
	}
}

void D()
{
	if (d.empty())
	{
		if(!abc)
		{
			abc = true;
			cout << "error" << '\n';
		}
		return;
	}
	else if (R && !d.empty())
		d.pop_back();
	else if (!R && !d.empty())
		d.pop_front();
}

int main()
{
	int t;
	cin >> t;

	for (int i = 0; i < t; i++)
	{
		num = 0; abc = false, R = false;
		d.clear();
		p.clear();
		n.clear();
		init();
		for (int j = 0; j < p.size(); j++)
		{
			if (!R && p[j] == 'R')
				R = true;
			else if (R && p[j] == 'R')
				R = false;
			else
				D();
		}
		if (!abc && R)
		{
			cout << '[';
			if (!d.empty())
			{
				while (1)
				{
					cout << d.back();
					d.pop_back();
					if (d.empty())
					{
						cout << ']';
						break;
					}
					else
						cout << ',';
				}
				cout << '\n';
			}
			else
				cout << ']' << '\n';
		}
		if (!abc && !R)
		{
			cout << '[';
			if (!d.empty())
			{
				while (1)
				{
					cout << d.front();
					d.pop_front();
					if (d.empty())
					{
						cout << ']';
						break;
					}
					else
						cout << ',';
				}
				cout << '\n';
			}
			else
				cout << ']' << '\n';
		}
	}
	return 0;
}