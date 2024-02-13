#include<iostream>
#include<algorithm>
#include<vector>
#include<string>
#include<map>
using namespace std;

map<string, int>dic;
vector<pair<string, int>> v;

bool cmp(const pair<string, int>& a, const pair<string, int>& b)
{
	if (a.second == b.second)
	{
		if (a.first.length() == b.first.length())
			return a.first < b.first;
		return a.first.length() > b.first.length();
	}
	return a.second > b.second;
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n, m;
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		string s;
		cin >> s;
		if (s.size() < m)
			continue;
		if (dic[s])
			dic[s]++;
		else
			dic[s] = 1;
	}
	for (auto it = dic.begin(); it != dic.end(); it++)
		v.push_back(*it);
	sort(v.begin(), v.end(), cmp);
	for (int i = 0; i < v.size(); i++)
		cout << v[i].first << '\n';
	return 0;
}