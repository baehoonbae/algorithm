#include<iostream>
#include<algorithm>
#include<vector>
using namespace std;

float map[2][2];
vector<float>result;

void rotate() {
	float ret;
	float copy[2][2];
	copy[0][0] = map[1][0];
	copy[0][1] = map[0][0];
	copy[1][0] = map[1][1];
	copy[1][1] = map[0][1];
	for (int i = 0; i < 2; i++) 
		for (int j = 0; j < 2; j++) 
			map[i][j] = copy[i][j];
	
	result.push_back(
		static_cast<float>(map[0][0] / map[1][0]) +
		static_cast<float>(map[0][1] / map[1][1]));
}

int main() {
	float max = 0;

	for (int i = 0; i < 2; i++)
		for (int j = 0; j < 2; j++)
			cin >> map[i][j];

	result.push_back(
		static_cast<float>(map[0][0] / map[1][0]) + 
		static_cast<float>(map[0][1] / map[1][1]));

	for (int i = 0; i < 3; i++)
		rotate();

	for (int i = 0; i < 4; i++) {
		if (max < result[i])
			max = result[i];
	}
	for (int i = 0; i < 4; i++) {
		if (result[i] == max)
			cout << i;
	}


	return 0;
}