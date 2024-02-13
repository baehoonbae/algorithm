#include <iostream>
#include <map>
using namespace std;

int n, m;
multimap<int, string>Style;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < n; i++)
	{
		string s;
		int num;
		cin >> s >> num;
		Style.insert({ num,s });
	}

	for (int i = 0; i < m; i++)
	{
		int Target;
		cin >> Target;
		cout << (Style.lower_bound(Target)->second) << '\n';
	}

	return 0;
}