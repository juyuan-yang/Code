/*
 * Author: Juyuan Yang
 * Date: Sep. 18, 2013
 * Purpose: To solve the deck shuffle problems
 */

package DeckShuffle;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DeckShuffle {
	/*
	 * General description:
	 *   Provide a function that shuffle the cards once
	 *   Build a map based on this one round shuffle, showing how will each card move
	 *   So each time we need to shuffle, we just re-use the map, and don't need to simulate again
	 *   
	 * Simple Simulate:
	 *   Just repeat shuffle again and again, until back to original version
	 * 
	 * Smart Simulate:
	 *   Based on the map, find several circles.
	 *   For each circle, if we want back to original version, we need shuffle n * length of circle times
	 *   (n = 1, 2, 3...)
	 *   So it's much easier by just calculating the least common multiply for all the length of circles
	 */
	public static void main(String[] args) {
		DeckShuffle deckShuffle = new DeckShuffle();
		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String input = br.readLine();
			
			int num = Integer.parseInt(input);
			if(num <= 0)
				System.out.println("The input number could not be negative");
			else
				System.out.println("We need " + deckShuffle.calculateRounds(num) + " rounds of shuffle");
		}catch(Exception io){
			io.printStackTrace();
		}	
	}
	
	public int calculateRounds(int num) {
		int[] cards = new int[num];
		for(int i = 0; i < cards.length; i++){
			cards[i] = i;
		}
		int[] newSeq = shuffle(cards);
		Map<Integer, Integer> orig2dest = getShuffleMap(newSeq);
		
		return smartSimulate(orig2dest);
	}
	
	// Based on the shuffle map, try to find all the circles
	// Then compute the lease common multiply for all the length of circles, that's the answer!
	public int smartSimulate(Map<Integer, Integer> orig2dest) {
		ArrayList<Integer> circlesLength = new ArrayList<Integer>();
		boolean[] visited = new boolean[orig2dest.size()];
		
		for(int i = 0; i < orig2dest.size(); i++) {
			if(!visited[i]) {
				int cur = i, count = 0;
				do{ // this do-while will find one circle
					visited[cur] = true;
					cur = orig2dest.get(cur);
					count++;
				} while(cur != i);
				circlesLength.add(count);
			}
		}
		
		if(circlesLength.size() == 1) return circlesLength.get(0);
		else {
			int num = circlesLength.get(0);
			// calculate the lease common multiply for all the lengths of circles
			for(int i = 1; i < circlesLength.size(); i++) {
				int gcd = gcd(num, circlesLength.get(i));
				int lcm = num * circlesLength.get(i) / gcd;
				num = lcm;
			}
			return num;
		}
	}
	
	// just repeat shuffle again and again, using the index map 
	public int simpleSimulate(Map<Integer, Integer> orig2dest) {
		// initialize the deck
		int[] cards = new int[orig2dest.size()];
		for(Map.Entry<Integer, Integer> entry : orig2dest.entrySet()) {
			cards[entry.getValue()] = entry.getKey();
		}

		int count = 1;
		while(true) {
			// check whether it's in original order
			boolean found = true;
			for(int i = 0; i < cards.length; i++) {
				if(cards[i] != i) {
					found = false;
					break;
				}
			}
			if(found) {
				return count;
			}
			
			// shuffle use the map, so it's faster
			int[] newCards = new int[cards.length];
			for(Map.Entry<Integer, Integer> entry : orig2dest.entrySet()) {
				newCards[entry.getValue()] = cards[entry.getKey()];
			}
			cards = newCards;
			count++;
		}
	}
	
	// Build a map, to record how cards are shuffled. 
	// For each pair <i1, i2>, i1 is the card's original position, i2 is the new position after shuffle
	public Map<Integer, Integer> getShuffleMap(int[] cards) {
		Map<Integer, Integer> orig2dest = new HashMap<Integer, Integer>();
		for(int i = 0; i < cards.length; i++) {
			orig2dest.put(cards[i], i);
		}
		return orig2dest;
	}
	
	// Do shuffle for the deck, just simulate one round
	public int[] shuffle(int[] cards) {
		if(cards == null || cards.length == 0) return null;
		int[] newSeq = new int[cards.length]; // to store new order
		boolean[] moved = new boolean[cards.length]; // whether the card is moved to new deck
		
		int pos = cards.length-1, index = 0; // pos is for new deck, index is to iterate old deck
		boolean move = true; // whether we need to take current card
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
			if(index == cards.length) index = 0;
		}
		return newSeq;
	}
	
	// return greatest common divisor
	public int gcd(int n1, int n2) {
		while(n1 != 0 && n2 != 0) {
			int temp = n2;
			n2 = n1 % n2;
			n1 = temp;
		}
		return n1 + n2;
	}
}
