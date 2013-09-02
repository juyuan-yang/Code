package Helper;

import java.util.HashSet;

public class Tester {

	// one example to use local test
	public static void main(String[] args) {
		WordLadder.Solution s = new WordLadder.Solution();
		HashSet<String> set = new HashSet<String>();
		set.add("a");
		set.add("b");
		set.add("c");
		
		int res = s.ladderLength("a", "c", set);
		System.out.println(res);
	}

}
