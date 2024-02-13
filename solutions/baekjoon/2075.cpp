#include <iostream>
#include <queue>
using namespace std;

priority_queue<int,vector<int>,greater<>> Order;

int main()
{
	ios::sync_with_stdio(false);
	cin.tie(nullptr);
	cout.tie(nullptr);

	int N;
	cin >> N;
	for (int i = 0; i < N; ++i)
	{
		for (int j = 0; j < N; ++j)
		{
			int Num;
			cin >> Num;
			Order.push(Num);
			if (Order.size() > N)
			{
				Order.pop();
			}
		}
	}
	cout << Order.top();
	return 0;
}