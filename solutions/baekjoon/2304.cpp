#include <iostream>
#include<algorithm>
using namespace std;

int NumOfPillar;
int ContainerArea;
int Container[1001];
int MaxHeight, StandardX;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	cin >> NumOfPillar;
	int X, Y;
	int LeftMaxHeight = 0;
	int RightMaxHeight = 0;
	for (int i = 0; i < NumOfPillar; ++i)
	{
		cin >> X >> Y;
		Container[X] = Y;
		if (MaxHeight < Y)
		{
			StandardX = X;
			MaxHeight = Y;
		}
	}
	for (int i = 1; i < StandardX; ++i)
	{
		LeftMaxHeight = max(LeftMaxHeight, Container[i]);
		ContainerArea += LeftMaxHeight;
	}
	for (int i = 1000; i > StandardX; --i)
	{
		RightMaxHeight = max(RightMaxHeight, Container[i]);
		ContainerArea += RightMaxHeight;
	}
	cout << ContainerArea + MaxHeight;
	return 0;
}