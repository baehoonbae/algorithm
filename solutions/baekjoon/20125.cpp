#include<iostream>
using namespace std;

char arr[1001][1001];
int len[5];

int main()
{
	int y, x;
	int n;
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			cin >> arr[i][j];
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			if (arr[i][j] == '*' && arr[i - 1][j] == '*' && arr[i][j - 1] == '*' && arr[i + 1][j] == '*' && arr[i][j + 1] == '*')
			{
				y = i;
				x = j;
				cout << i << ' ' << j << endl;
			}

	// ¿ÞÂÊ ÆÈ
	for (int i = x - 1;; i--)
	{
		if (arr[y][i] == '_' || i < 1)
			break;
		len[0]++;
	}
	// ¿À¸¥ÂÊ ÆÈ
	for (int i = x + 1;; i++)
	{
		if (arr[y][i] == '_' || i > n)
			break;
		len[1]++;
	}
	// Çã¸®
	for (int i = y + 1;; i++)
	{
		if (arr[i][x] == '_')
		{
			y = i;
			break;
		}
		len[2]++;
	}
	// ¿ÞÂÊ ´Ù¸®
	x -= 1;
	for (int i = y;; i++)
	{
		if (arr[i][x] == '_' || i > n)
			break;
		len[3]++;
	}
	// ¿À¸¥ÂÊ ´Ù¸®
	x += 2;
	for (int i = y;; i++)
	{
		if (arr[i][x] == '_' || i > n)
			break;
		len[4]++;
	}
	for (int i = 0; i < 5; i++)
		cout << len[i] << ' ';

	return 0;
}