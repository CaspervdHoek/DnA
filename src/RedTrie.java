import java.util.ArrayList;
import java.util.HashMap;

import interfaces.Trie;

public class RedTrie implements Trie { // Watch me whip

	private TrieNode root;
	
	public RedTrie(){
		root = new TrieNode(' ');
	}
	
	public class TrieNode {
		
		private char c;
		private boolean isLeaf;
		private ArrayList<TrieNode> children = new ArrayList<TrieNode>();
		private Object data;
		
		public TrieNode(){
			
		}
		
		public TrieNode(char c){
			this.c = c;
		}
	}

	@Override
	public void insert(String word, Object data) {
		ArrayList<TrieNode> children = root.children;
		
		for(int i = 0; i < word.length(); i++){
			char c = word.charAt(i);
			
			TrieNode t;
			
			if(children.contains(c)){
				t = children.get(c);
			} else {
				t = new TrieNode(c);
				children.add(t);
			}
			
			children = t.children;
			
			if(i == (word.length() - 1)){
				t.isLeaf = true;
				t.data = data;
			}
		}
	}

	@Override
	public Object[] search(String word) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(String word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toDOTString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append("digraph mijngraaf {\n");
		
		// Collect all the nodes
		ArrayList<TrieNode> lookup = new ArrayList<TrieNode>();
		lookup.add(root);
		for (int i = 0; i < lookup.size(); i++) {
			TrieNode currentNode = lookup.get(i);
			for (TrieNode child : currentNode.children) {
				if (!lookup.contains(child)) {
					lookup.add(child);
				}
			}
		}
		
		// Create nodes
		for (int i = 0; i < lookup.size(); i++) {
			sb.append(String.format("n%d [label=\"%s\"];\n", i, lookup.get(i).c));
		}
		
		// Create edges
		for (int i = 0; i < lookup.size(); i++) {
			TrieNode node = lookup.get(i);
			for (TrieNode child : node.children) {
				sb.append(String.format("n%d -> n%d;\n", i, lookup.indexOf(child)));
			}
		}
		
		sb.append("}");
		return sb.toString();
	}
}
