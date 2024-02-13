#include<iostream>
#include<algorithm>
#define MAX 1000
using namespace std;

int FuelArray[MAX][MAX];
int Cache[MAX][MAX][4];
int MinFuel = 11111, n, m;

int Solve(int y, int x, int dir)
{
	if (y == n)
	{
		return 0;
	}
	if (Cache[y][x][dir] != 11111)
	{
		return Cache[y][x][dir];
	}
	if (dir != 0 && x - 1 >= 0)
	{
		Cache[y][x][dir] = min(
			Cache[y][x][dir], 
			Solve(y + 1, x - 1, 0) + FuelArray[y][x]);
	}
	if (dir != 1)
	{
		Cache[y][x][dir] = min(
			Cache[y][x][dir],
			Solve(y + 1, x, 1) + FuelArray[y][x]);
	}
	if (dir != 2 && x + 1 < m)
	{
		Cache[y][x][dir] = min(
			Cache[y][x][dir],
			Solve(y + 1, x + 1, 2) + FuelArray[y][x]);
	}
	return Cache[y][x][dir];
}

int main()
{
	cin >> n >> m;
	for (int i = 0; i < n; i++)
	{
		for (int j = 0; j < m; j++)
		{
			cin >> FuelArray[i][j];
			for (int k = 0; k < 4; k++)
			{
				Cache[i][j][k] = 11111;
			}
		}
	}
	for (int i = 0; i < m; i++)
	{
		MinFuel = min(MinFuel, Solve(0, i, 3));
	}
	cout << MinFuel;
	return 0;
}