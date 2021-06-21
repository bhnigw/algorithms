package Easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class test {
	public static void main(String[] args) {
		char c = 'a';
		System.out.println(c - 'a');
		System.out.println(52.09 + 2093.27 + 34.16 + 100.81 + 47.16);
		System.out.println(1667 + 500);

	}

}

class TrieNode {
	char val;
	boolean isWord;
	TrieNode[] children;

	public TrieNode(char x) {
		val = x;
		isWord = false;
		children = new TrieNode[26];
	}

	public boolean detectLoop(int[][] graph) {

		HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();

		for (int i = 0; i < graph.length; i++) {
			if (map.get(graph[i][0]) == null) {
				map.put(graph[i][0], new ArrayList<Integer>());
				map.get(graph[i][0]).add(graph[i][1]);
			} else {
				map.get(graph[i][0]).add(graph[i][1]);
			}
		}

		boolean[] visited = new boolean[graph.length];

		for (int i = 0; i < map.size(); i++) {
			if (isCycle(i, map, visited)) {
				return true;
			}
		}

		return false;
	}

	private boolean isCycle(int cur, HashMap<Integer, ArrayList<Integer>> map, boolean[] visited) {
		if (visited[cur] == true) return true;
		if (map.get(cur) == null) return false;

		List<Integer> temp = new ArrayList<>(map.get(cur));
		visited[cur] = true;

		for (int j = 0; j < temp.size(); j++) {
			if (isCycle(temp.get(j), map, visited)) {
				return true;
			}
		}

		visited[cur] = false;

		return false;
	}

}