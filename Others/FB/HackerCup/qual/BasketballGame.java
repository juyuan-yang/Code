/*
 * Basketball Game35 points
Download Input File
A group of N high school students wants to play a basketball game. To divide themselves into two teams they first rank all the players in the following way:

Players with a higher shot percentage are rated higher than players with a lower shot percentage.
If two players have the same shot percentage, the taller player is rated higher.
Luckily there are no two players with both the same shot percentage and height so they are able to order themselves in an unambiguous way. Based on that ordering each player is assigned a draft number from the range [1..N], where the highest-rated player gets the number 1, the second highest-rated gets the number 2, and so on. Now the first team contains all the players with the odd draft numbers and the second team all the players with the even draft numbers.

Each team can only have P players playing at a time, so to ensure that everyone gets similar time on the court both teams will rotate their players according to the following algorithm:

Each team starts the game with the P players who have the lowest draft numbers.
If there are more than P players on a team after each minute of the game the player with the highest total time played leaves the playing field. Ties are broken by the player with the higher draft number leaving first.
To replace her the player on the bench with the lowest total time played joins the game. Ties are broken by the player with the lower draft number entering first.
The game has been going on for M minutes now. Your task is to print out the names of all the players currently on the field, (that is after M rotations).

Input
The first line of the input consists of a single number T, the number of test cases.

Each test case starts with a line containing three space separated integers N M P

The subsequent N lines are in the format "<name> <shot_percentage> <height>". See the example for clarification.

Constraints
1 ≤ T ≤ 50
2 * P ≤ N ≤ 30
1 ≤ M ≤ 120
1 ≤ P ≤ 5
Each name starts with an uppercase English letter, followed by 0 to 20 lowercase English letters. There can be players sharing the same name. Each shot percentage is an integer from the range [0..100]. Each height is an integer from the range [100..240]

Output
For each test case i numbered from 1 to T, output "Case #i: ", followed by 2 * P space separated names of the players playing after M rotations. The names should be printed in lexicographical order.

Example
In the first example if you sort all the players by their shot percentage you get the list: [Wai, Purav, Weiyan, Slawek, Lin, Meihong]. This makes the two teams:

[Wai, Weiyan, Lin]
[Purav, Slawek, Meihong]
The game starts with Lin and Meihong sitting on the bench in their respective teams. After the first minute passes it's time for Weiyan and Slawek to sit out since they have the highest draft numbers of the people who played. After the second minute passes Lin and Meihong will keep playing since they only played one minute so far and it's Wai and Purav who have to sit out.

Finally after the third minute Lin and Maihong go back to the bench and all the players currently playing again are:
Purav Slawek Wai Weiyan

Example input · DownloadExample output · Download
5
6 3 2
Wai 99 131
Weiyan 81 155
Lin 80 100
Purav 86 198
Slawek 80 192
Meihong 44 109
7 93 2
Paul 82 189
Kittipat 62 126
Thomas 17 228
Fabien 57 233
Yifei 65 138
Liang 92 100
Victor 53 124
6 62 3
Meihong 33 192
Duc 62 162
Wai 70 148
Fabien 19 120
Bhuwan 48 176
Vlad 30 225
8 59 3
Anil 38 180
Song 7 187
David 65 159
Lin 45 121
Ranjeeth 39 183
Torbjorn 26 181
Clifton 57 158
Phil 3 183
4 72 1
Anh 2 187
Erling 69 226
Purav 0 199
Zejia 29 163
Case #1: Purav Slawek Wai Weiyan
Case #2: Fabien Kittipat Liang Paul
Case #3: Bhuwan Duc Fabien Meihong Vlad Wai
Case #4: Anil Lin Phil Ranjeeth Song Torbjorn
Case #5: Erling Zejia
 */

package FB.HackerCup.qual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class BasketballGame {
	public static void main(String[] args) {
		BasketballGame bg = new BasketballGame();
		bg.process();
	}
	
	public void process() {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("FB_HackerCup/input.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter(new File("FB_HackerCup/output.txt")));
			
			int T = Integer.parseInt(reader.readLine());
			for(int t = 1; t <= T; t++) {
				String temp = reader.readLine().trim();
				String[] strs = temp.split(" ");
				int N = Integer.parseInt(strs[0]);
				int M = Integer.parseInt(strs[1]);
				int P = Integer.parseInt(strs[2]);
				
				ArrayList<Player> players = new ArrayList<Player>();
				for(int i = 0; i < N; i++) {
					Player p = new Player(reader.readLine().trim());
					players.add(p);
				}
				Collections.sort(players);
				
				for(int i = 0; i < N; i++) {
					players.get(i).number = i + 1;
				}
				
				String names = playing(players, M, P);
				writer.println("Case #" + t + ": " + names);
			}
			
			reader.close();
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public String playing(ArrayList<Player> list, int M, int P) {
		// split into two teams
		ArrayList<Player> t1 = new ArrayList<Player>();
		ArrayList<Player> t2 = new ArrayList<Player>();
		
		for(int i = 0; i < list.size(); i++) {
			if(i % 2 == 0) t1.add(list.get(i));
			else t2.add(list.get(i));
		}
		
		// simulate M minutes
		Set<Player> s1 = simulate(t1, M, P);
		Set<Player> s2 = simulate(t2, M, P);
		
		ArrayList<Player> current = new ArrayList<Player>();
		current.addAll(s1);
		current.addAll(s2);
		
		Collections.sort(current, new Comparator<Player>(){
			@Override
			public int compare(Player o1, Player o2) {
				return o1.name.compareTo(o2.name);
			} 
		});
		
		StringBuilder sb = new StringBuilder();
		for(Player p : current) {
			sb.append(p.name + " ");
		}
		sb.deleteCharAt(sb.length() - 1);
		
		return sb.toString();		
	}
	
	public Set<Player> simulate(ArrayList<Player> list, int M, int P) {
		Set<Player> set = new HashSet<Player>();
		for(int i = 0; i < P; i++) {
			set.add(list.get(i));
			list.get(i).timePlusOne();
		}
		
		int m = 1;
		while(m <= M) {
			m++;
			// one from set goes out
			Player max = null;
			for(Player p : set) {
				if(max == null || p.moreTime(max)) max = p;
			}
			
			// one from rest goes in
			Player min = null;
			for(Player p : list) {
				if(!set.contains(p)) {
					if(min == null || p.lessTime(min)) min = p;
				}
			}
			
			// forgot to check null...
			if(max != null && min != null) {
				set.remove(max);
				set.add(min);
			}
			
			for(Player p : set) {
				p.timePlusOne();
			}
		}
		return set;
	}
	
	private class Player implements Comparable<Player>{
		public String name;
		public int height;
		public int precision;
		public int number;
		public int time;
		
		public Player(String str) {
			String[] strs = str.split(" ");
			name = strs[0];
			height = Integer.parseInt(strs[2]);
			precision = Integer.parseInt(strs[1]);
			number = -1;
			time = 0;
		}
		
		public void timePlusOne() {
			time += 1;
		}
		
		@Override
		public int compareTo(Player o) {
			if(this.precision > o.precision) return -1;
			else if(this.precision < o.precision) return 1;
			else if(this.height > o.precision) return -1;
			else return 1;
		}
		
		public boolean moreTime(Player o) {
			if(this.time > o.time) return true;
			else if(this.time < o.time) return false;
			else if(this.number > o.number) return true;
			else return false;
		}
		
		public boolean lessTime(Player o) {
			if(this.time < o.time) return true;
			else if(this.time > o.time) return false;
			else if(this.number < o.number) return true;
			else return false;
		}
		
		public String toString() {
			return name + " time:" + time + " number:" + number; 
		}
	}
}
