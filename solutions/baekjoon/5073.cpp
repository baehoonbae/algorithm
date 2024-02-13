#include<iostream>
using namespace std;



int main()
{
	while (1)
	{
		int a, b, c;
		cin >> a >> b >> c;
		if (a == 0 && b == 0 && c == 0)
			break;
		if (max(max(a, b), c) >= (a + b + c) - max(max(a, b), c))
		{
			cout << "Invalid" << endl;
			continue;
		}
		if (a == b && b == c && a == c)
		{
			cout << "Equilateral" << endl;
			continue;
		}
		if (a != b && b != c && a != c)
		{
			cout << "Scalene" << endl;
			continue;
		}
		if (a == b && a != c)
		{
			cout << "Isosceles" << endl;
			continue;
		}
		if (a == c && a != b)
		{
			cout << "Isosceles" << endl;
			continue;
		}
		if (b == c && b != a)
		{
			cout << "Isosceles" << endl;
			continue;
		}
	}

	return 0;
}