/*
 * Square Detector20 points
Download Input File
You want to write an image detection system that is able to recognize different geometric shapes. In the first version of the system you settled with just being able to detect filled squares on a grid.

You are given a grid of N×N square cells. Each cell is either white or black. Your task is to detect whether all the black cells form a square shape.

Input
The first line of the input consists of a single number T, the number of test cases.

Each test case starts with a line containing a single integer N. Each of the subsequent N lines contain N characters. Each character is either "." symbolizing a white cell, or "#" symbolizing a black cell. Every test case contains at least one black cell.

Output
For each test case print YES if all the black cells form a completely filled square with edges parallel to the grid of cells. Otherwise print NO.

Constraints
1 ≤ T ≤ 20
1 ≤ N ≤ 20

Example
Test cases 1 and 5 represent valid squares. Case 2 has an extra cell that is outside of the square. Case 3 shows a square not filled inside. And case 4 is a rectangle but not a square.

Example input · DownloadExample output · Download
5
4
..##
..##
....
....
4
..##
..##
#...
....
4
####
#..#
#..#
####
5
#####
#####
#####
#####
.....
5
#####
#####
#####
#####
#####
Case #1: YES
Case #2: NO
Case #3: NO
Case #4: NO
Case #5: YES
 */

package FB.HackerCup.qual;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

public class SquareDetector {
	public static void main(String[] args) {
		try{
			BufferedReader reader = new BufferedReader(new FileReader(new File("FB_HackerCup/input.txt")));
			PrintWriter writer = new PrintWriter(new FileWriter(new File("FB_HackerCup/output.txt")));
			SquareDetector sd = new SquareDetector();
			
			String temp = reader.readLine();
			int T = Integer.parseInt(temp.trim());
			for(int i = 1; i <= T; i++) {
				int N = Integer.parseInt(reader.readLine().trim());
				ArrayList<String> list = new ArrayList<String>();
				for(int j = 0; j < N; j++) {
					list.add(reader.readLine());
				}
				if(sd.allSquare(N, list)) {
					writer.println("Case #" + i + ": YES");
				} else {
					writer.println("Case #" + i + ": NO");
				}
			}
			
			reader.close();
			writer.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean allSquare(int N, ArrayList<String> list) {
		char[][] chs = new char[N][N];
		int minI = 0, minJ = 0, minTotal = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			String str = list.get(i);
			for(int j = 0; j < N; j++) {
				if(str.charAt(j) == '#') {
					chs[i][j] = '#';
					if(i + j < minTotal) {
						minI = i;
						minJ = j;
						minTotal = i + j;
					}
				} else {
					chs[i][j] = '.';
				}
			}
		}
		
		// no #
		if(minTotal == Integer.MAX_VALUE) return false;
		int eI = minI + 1, eJ = minJ + 1;
		while(eI < N && chs[eI][minJ] == '#') eI++;
		while(eJ < N && chs[minI][eJ] == '#') eJ++;
		
		if(eI - minI != eJ - minJ) return false;
		
		for(int i = minI; i < eI; i++)
			for(int j = minJ; j < eJ; j++) {
				if(chs[i][j] == '#') {
					chs[i][j] = '.';
				} else return false;
			}
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				if(chs[i][j] == '#') return false;
			}
		
		return true;
	}
}
