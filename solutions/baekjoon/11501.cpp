#include <iostream>
using namespace std;

int StockPrice[1000011];
int t;

int main()
{
	cin >> t;
	for (int i = 0; i < t; i++)
	{
		int TotalDay, MaxStockPrice = 0;
		long long TotalStock = 0;
		cin >> TotalDay;
		for (int j = 0; j < TotalDay; j++)
		{
			cin >> StockPrice[j];
		}
		for (int j = TotalDay-1; j >= 0; j--)
		{
			if (StockPrice[j] >= MaxStockPrice)
			{
				MaxStockPrice = StockPrice[j];
				continue;
			}
			if (StockPrice[j] < MaxStockPrice)
			{
				TotalStock += MaxStockPrice - StockPrice[j];
			}
		}
		cout << TotalStock << '\n';
	}

	return 0;
}