#include<iostream>
using namespace std;

int n, m, cnt;
string s;

int main() {
	cin >> n >> m >> s;
	for (int i = 1; i <= m; i++) 
	{
		int k = 0;
		if (s[i - 1] == 'I') 
		{
			while (s[i] == 'O' && s[i + 1] == 'I') 
			{
				k++;
				if (k == n)
				{
					cnt++;
					k--;
				}
				i += 2;
			}
		}
	}
	cout << cnt;
	return 0;
}