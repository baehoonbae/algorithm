#include<iostream>
#include<set>
using namespace std;

set<int>s;
int main()
{
	int n;
	cin >> n;
	for (int i = 0; i < n; i++)
	{
		int a;
		cin >> a;
		s.insert(a);
	}
	for (auto i = s.begin(); i != s.end(); i++)
		cout << *i << ' ';
	return 0;
}