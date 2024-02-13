#include<iostream>
#include<vector>
#include<string>
using namespace std;

vector<char>v;
string n;
int num, idx;

void Divide(const int DivNum)
{
	v.clear();
	string TempStr = to_string(DivNum);
	for (int i = 0; i < TempStr.size(); i++)
		v.push_back(TempStr[i]);
}

void IsInclude(const string c)
{
	for (int i = 0; i < v.size(); i++)
	{
		if (v[i] == c[idx])
		{
			idx++;
		}
	}
}

int main()
{
	cin >> n;
	for (num = 1; idx < n.size(); num++)
	{
		Divide(num);
		IsInclude(n);
	}
	cout << num - 1;
	return 0;
}