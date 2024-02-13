#include<iostream>
using namespace std;

int k;
int Lotto[14];
int LottoNum[7];

void Solve(int Start, int Here)
{
	if (Here == 6)
	{
		for (int i = 0; i < 6; i++)
		{
			cout << LottoNum[i] << ' ';
		}
		cout << '\n';
	}
	else
	{
		for (int i = Start; i < k; i++)
		{
			LottoNum[Here] = Lotto[i];
			Solve(i+1,Here + 1);
		}
	}
}

int main()
{
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	while (1)
	{
		cin >> k;
		if (k == 0)
		{
			break;
		}
		for (int i = 0; i < k; i++)
		{
			cin >> Lotto[i];
		}
		Solve(0,0);
		cout << '\n';
	}
	return 0;
}