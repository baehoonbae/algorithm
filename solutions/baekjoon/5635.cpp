#include <iostream>
#include <string>
using namespace std;

int main()
{
	string MaxMan, MinMan;
	int MaxYear = 0, MaxMonth = 0, MaxDate = 0;
	int MinYear = 9999, MinMonth = 13, MinDate = 35;
	int ManCnt;
	cin >> ManCnt;

	for (int i = 0; i < ManCnt; i++)
	{
		string Name;
		int Date, Month, Year;
		cin >> Name >> Date >> Month >> Year;
		if (Year > MaxYear)
		{
			MaxMan = Name;
			MaxYear = Year;
		}
		else if (Year==MaxYear && Month > MaxMonth)
		{
			MaxMan = Name;
			MaxMonth = Month;
		}
		else if (Month==MaxMonth && Year == MaxYear && Date > MaxDate)
		{
			MaxMan = Name;
			MaxDate = Date;
		}

		if (Year < MinYear)
		{
			MinMan = Name;
			MinYear = Year;
		}
		else if (Year == MinYear && Month < MinMonth)
		{
			MinMan = Name;
			MinMonth = Month;
		}
		else if (Month == MaxMonth && Year == MinYear && Date < MinDate)
		{
			MinMan = Name;
			MinDate = Date;
		}
	}
	cout << MaxMan << endl << MinMan;
	return 0;
}