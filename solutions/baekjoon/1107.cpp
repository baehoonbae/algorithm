#include<iostream>
using namespace std;

int crash[11] = { -1,-1,-1,-1,-1,-1,-1,-1,-1,-1,-1 };
int s[10];

bool isCrash = false;
bool isAvailable1 = true;
bool isAvailable2 = true;
int I1, I2;
int result, channel, max_i = 0, min_i = 0, n, I;
int subin = 100;

int main() {
	cin >> channel >> n;

	for (int i = 0; i < n; i++)
		cin >> crash[i];
	for (int i = 0; i < 10; i++) {
		if (crash[i] == -1) {
			isCrash = true;
			break;
		}
	}

	if (channel > 0) {
		for (int i = 0; i <= channel; i++) {
			bool check = true;
			int div = 100000;
			int temp = i;
			int idx = 1;

			if (i == 0) {
				s[1] = 0;
				idx++;
			}
			if (i > 0) {
				while (div != 0) {
					if ((temp / div) == 0 && idx <= 1) {
						temp %= div;
						div /= 10;
						continue;
					}
					s[idx] = temp / div;
					temp %= div;
					div /= 10;
					idx++;
				}
			}

			for (int j = 1; j < idx; j++)
				for (int k = 0; k < n; k++)
					if (s[j] == crash[k])
						check = false;
			if (check) {
				max_i = i;
				I1 = idx;
			}
			if (idx == 0)
				isAvailable1 = false;
		}
	}
	for (int i = 999999; i >= channel; i--) {
		bool check = true;
		int div = 100000;
		int temp = i;
		int idx = 1;

		if (i == 0) {
			s[1] = 0;
			idx++;
		}
		if (i > 0) {
			while (div != 0) {
				if ((temp / div) == 0 && idx <= 1) {
					temp %= div;
					div /= 10;
					continue;
				}
				s[idx] = temp / div;
				temp %= div;
				div /= 10;
				idx++;
			}
		}

		for (int j = 1; j < idx; j++)
			for (int k = 0; k < n; k++)
				if (s[j] == crash[k])
					check = false;
		if (check) {
			min_i = i;
			I2 = idx;
		}
		if (idx == 0)
			isAvailable2 = false;
	}

	if (abs(channel - max_i) > abs(channel - min_i) || channel == 0)
		I = I2;
	else
		I = I1;

	if (channel > 0 && isAvailable1)
		result = min(abs(channel - max_i), abs(channel - min_i)) + I - 1;
	else
		result = abs(channel-min_i) + I2 - 1;


	if (channel == subin)
		cout << 0;
	else if (isCrash == false)
		cout << abs(subin - channel);
	else if (abs(subin - channel) <= 3)
		cout << abs(subin - channel);
	else if (result > abs(subin - channel))
		cout << abs(subin - channel);
	else
		cout << result;

	return 0;
}
