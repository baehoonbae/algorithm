#include <iostream>
using namespace std;


int main()
{
	int TotalBookPrice;
	cin >> TotalBookPrice;
	for (int i = 0; i < 9; i++)
	{
		int BookPrice;
		cin >> BookPrice;
		TotalBookPrice -= BookPrice;
	}
	cout << TotalBookPrice;
	return 0;
}