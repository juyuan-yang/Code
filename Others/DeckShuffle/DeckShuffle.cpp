// File name: DeckShuffle.cpp
// Author: Juyuan Yang (juyuan@gatech.edu)
// Date: Sep. 18, 2013
// Purpose: To solve the deck shuffle problems

#include <iostream>
#include <stdlib.h>
using namespace std;

// Just one round of shuffle. It's in-placed.
void shuffle(int* cards, int length)
{
	int newSeq[length];
	bool moved[length];
	for(int i = 0; i < length; i++) moved[i] = false;

	int pos = length - 1, index = 0;
	bool move = true;
	while(pos >= 0) {
		if(!moved[index]) {
			if(move) {
				newSeq[pos--] = cards[index];
				moved[index] = true;
				move = false;
			} else {
				move = true;
			}
		}
		index++;
		if(index == length) index = 0;
	}

	for(int i = 0; i < length; i++) cards[i] = newSeq[i];
}

// Calculate the greatest common divisor
int gcd(int n1, int n2) 
{
	while(n1 != 0 && n2 != 0) {
		int temp = n2;
		n2 = n1 % n2;
		n1 = temp;
	}
	return n1 + n2;
}

/*
 A simple way to calculate how many rounds of shuffle we need

 After one shuffle, we know the card will move from ith to jth, based on this,
  we could find a circle, that the card begin from ith, ......, and finally gets to ith again
 So we try to find all the circles here, and then calculate the least common multiply of the lengths of all circles
*/ 
int smartSimulate(int* cards, int length) 
{
	int res = -1;
	bool visited[length];

	for(int i = 0; i < length; i++) visited[i] = false;

	for(int i = 0; i < length; i++) {
		if(!visited[i]) {
			int cur = i, count = 0;
			do{
				visited[cur] = true;
				cur = cards[cur];
				count++;
			} while(cur != i);
			if(res == -1) res = count;
			else {
				res = res * count / gcd(res, count);
			}
		}
	}

	return res;
}

// check stdin, and output the result
int main(int argc, char* argv[])
{
	if(argc != 2) {
		cerr << "Usage: " << argv[0] << " [Number of cards]" << endl;
		return 1;
	}
	int num = atoi(argv[1]);
	if(num <= 0) {
		cerr << "The number of cards should be bigger than 0" << endl;
		return 1;
	}

	int cards[num];
	for(int i = 0; i < num; i++) cards[i] = i;

	shuffle(cards, num);

	cout << "We need " << smartSimulate(cards, num) << " rounds of shuffle." << endl;
	return 0;
}
