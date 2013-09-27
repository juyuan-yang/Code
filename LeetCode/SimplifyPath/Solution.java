/*
 * Simplify Path - AC Rate: 153/679 - My Submissions
Given an absolute path for a file (Unix-style), simplify it.

For example,
path = "/home/", => "/home"
path = "/a/./b/../../c/", => "/c"
click to show corner cases.

Corner Cases:
Did you consider the case where path = "/../"?
In this case, you should return "/".
Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
In this case, you should ignore redundant slashes and return "/home/foo".
 */

package SimplifyPath;

// AC on 4th try :( Always forgot to check sth, and also it's better to maintain a stack myself?
public class Solution {
	// Corner case: not start with '/', too many "..", "///"
	public String simplifyPath(String path) {
		StringBuilder sb = new StringBuilder("/");
		if(path == null || path.length() == 0) return sb.toString();
		
		String[] strs = path.split("/");
		if(strs.length == 0) return sb.toString(); // bug, forgot to check :(
		String[] stack = new String[strs.length];
		int pos = 0;
		
		for(int i = 0; i < strs.length; i++) {
			if(strs[i] == null || strs[i].length() == 0) continue;
			else if(strs[i].equals(".")) continue;
			else if(strs[i].equals("..")) {
				if(pos > 0) pos--;
			} else {
				stack[pos++] = strs[i];
			}
		}
		
		for(int i = 0; i < pos - 1; i++) sb.append(stack[i] + "/");
		if(pos > 0) sb.append(stack[pos - 1]); // bug, forgot to check pos > 0...
		
		return sb.toString();
	}
}
