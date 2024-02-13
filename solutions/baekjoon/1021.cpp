#include<iostream>
#include<deque>
using namespace std;

deque<int>d;
deque<int>temp;
int a[51];
int num1, num2;

void left()
{
	d.push_back(d.front());
	num1++;
	d.pop_front();
	return;
}
void right()
{
	temp.push_front(temp.back());
	num2++;
	temp.pop_back();
	return;
}

int main()
{
	int cnt = 0;
	int n, m;
	cin >> n >> m;
	for (int i = 1; i <= n; i++)
		d.push_back(i);
	for (int i = 0; i < m; i++)
		cin >> a[i];

	for (int i = 0; i < m; i++)
	{
		if (d.front() == a[i])
		{
			d.pop_front();
		}
		else
		{
			num1 = 0, num2 = 0;
			temp = d;
			while (1)
			{
				if (d.front() == a[i])
				{
					d.pop_front();
					temp = d;
					cnt += num1;
					break;
				}
				if (temp.front() == a[i])
				{
					temp.pop_front();
					d = temp;
					cnt += num2;
					break;
				}
				left();
				right();
			}

		}
	}
	cout << cnt;
	return 0;
}