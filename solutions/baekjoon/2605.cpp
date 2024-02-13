#include<iostream>
using namespace std;

int student[101];
int order[101];
int point;

int main() {
	int n;
	cin >> n;
	
	for (int i = 0; i < n; i++) 
		cin >> student[i];
	for (int i = 0; i < n; i++) 
		order[i]=i+1;

	for (int i = 0; i < n; i++) {
		if (student[i] == 0)
			continue;
		else {
			point = i;
			for (int j = 0; j < student[i]; j++) {
				swap(order[point], order[point - 1]);
				point--;
			}
		}
	}

	for (int i = 0; i < n; i++)
		cout << order[i]<<" ";


	return 0;
}