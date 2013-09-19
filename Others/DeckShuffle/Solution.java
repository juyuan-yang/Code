package DeckShuffle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution {

	public static void main(String[] args) {
		Solution s = new Solution();
//		for(int i = 2; i < 100; i++)
			s.testEntry(500);
	}
	
	public void testEntry(int num) {
		int[] cards = new int[num];
		for(int i = 0; i < cards.length; i++) cards[i] = i;
//		print(cards);
		shuffle(cards);
//		print(cards);
		
		Map<Integer, Integer> orig2ds = new HashMap<Integer, Integer>();
		for(int i = 0; i < cards.length; i++) orig2ds.put(cards[i], i);
		
		System.out.println(findAllCircle(orig2ds));
//		System.out.println(stupid(orig2ds));
		
//		if(findAllCircle(orig2ds) != stupid(orig2ds)) {
//			System.out.println("Error: " + num);
//		} else {
//			System.out.println("Pass: " + num);
//		}
	}
	
	public int findAllCircle(Map<Integer, Integer> map) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		boolean[] visited = new boolean[map.size()];
		
		for(int i = 0; i < map.size(); i++) {
			if(!visited[i]) {
				int cur = i, count = 0;
				do{
					visited[cur] = true;
					cur = map.get(cur);
					count++;
				} while(cur != i);
//				System.out.println(count);
				if(count > 1) list.add(count);
			}
		}
		
		if(list.size() == 1) return list.get(0);
		else {
			int num = list.get(0);
			for(int i = 1; i < list.size(); i++) {
				int gcd = gcd(num, list.get(i));
				int lcm = num * list.get(i) / gcd;
				num = lcm;
			}
			return num;
		}
	}
	
	public int gcd(int n1, int n2) {
		while(n1 != 0 && n2 != 0) {
			int temp = n2;
			n2 = n1 % n2;
			n1 = temp;
		}
		return n1 + n2;
	}
	
	public int stupid(Map<Integer, Integer> map) {
		int[] cards = new int[map.size()];
		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			cards[entry.getValue()] = entry.getKey();
		}
		
//		print(cards);
		int count = 1;
		
		while(true) {
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
			
			int[] newCards = new int[cards.length];
			for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
				newCards[entry.getValue()] = cards[entry.getKey()];
			}
			cards = newCards;
			count++;
		}
	}
	
	public void shuffle(int[] cards) {
		if(cards == null || cards.length == 0) return;
		int[] newSeq = new int[cards.length];
		boolean[] moved = new boolean[cards.length];
		
		int pos = 0, index = 0;
		boolean move = true;
		while(pos < cards.length) {
			if(!moved[index]) {
				if(move) {
					newSeq[pos++] = cards[index];
					moved[index] = true;
					move = false;
				} else move = true;
			}
			index++;
			if(index == cards.length) index = 0;
		}
		
		for(int i = 0; i < cards.length; i++) cards[i] = newSeq[cards.length - 1 - i];
	}
	
	public void print(int[] cards) {
		if(cards == null || cards.length == 0) return;
		for(int i = 0; i < cards.length; i++) 
			System.out.print(cards[i] + " ");
		System.out.println();
	}
}
