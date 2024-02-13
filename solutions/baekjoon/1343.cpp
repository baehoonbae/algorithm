#include<iostream>
#include<algorithm>
using namespace std;

int main() {
	int cnt = 0;

	string	board;
	string	output;

	cin >> board;

	// 보드 순회
	for (int i = 0; i != board.size(); i++) {
		if (board[i] == 'X') { cnt++; }

		if (board[i] == '.') { output += '.';

			if (cnt % 2 != 0) { break; }
			else			{ cnt = 0; }
		}
		
		// 글자수가 2가 되면
		if (cnt == 2 && board[i + 1] != 'X'){
			output += "BB";		cnt = 0;
		}

		// 글자수가 4가 되면
		if (cnt == 4){
			output += "AAAA";	cnt = 0;
		}
	}

	if (cnt % 2 == 1) cout << -1; 
	else			  cout << output;

	return 0;
}