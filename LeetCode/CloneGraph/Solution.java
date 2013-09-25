/*
 * Clone Graph - AC Rate: 29/175 - My Submissions
Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.


OJ's undirected graph serialization:
Nodes are labeled from 0 to N - 1, where N is the total nodes in the graph.

We use # as a separator for each node, and , as a separator for each neighbor of the node.
As an example, consider the serialized graph {1,2#2#2}.

The graph has a total of three nodes, and therefore contains three parts as separated by #.

Connect node 0 to both nodes 1 and 2.
Connect node 1 to node 2.
Connect node 2 to node 2 (itself), thus forming a self-cycle.
Visually, the graph looks like the following:

       1
      / \
     /   \
    0 --- 2
         / \
         \_/
 */

package CloneGraph;

import java.util.HashMap;
import java.util.Map;

import Helper.UndirectedGraphNode;

// AC on 2nd try. Made the mistake that, for edge <a, b>, just need store it for a, not for b..
// But I guess it could be simpler?
public class Solution {
	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return null;
		Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
		Map<Integer, Boolean> visited = new HashMap<Integer, Boolean>();
		
		UndirectedGraphNode newNode = new UndirectedGraphNode(node.label);
		map.put(node.label, newNode);
		visited.put(node.label, false);
		
		visit(newNode, node, map, visited);
		return newNode;
	}
	
	public void visit(UndirectedGraphNode newNode, UndirectedGraphNode orig, 
			Map<Integer, UndirectedGraphNode> map, Map<Integer, Boolean> visited) {
		if(!visited.containsKey(orig.label) || visited.get(orig.label)) return;
		visited.put(orig.label, true);
		
		for(UndirectedGraphNode node : orig.neighbors) {
			UndirectedGraphNode neigh;
			if(!map.containsKey(node.label)) {
				neigh = new UndirectedGraphNode(node.label);
				map.put(node.label, neigh);
				visited.put(node.label, false);
				
				visit(neigh, node, map, visited);
			} else neigh = map.get(node.label);
			newNode.neighbors.add(neigh);
		}
	}
}
