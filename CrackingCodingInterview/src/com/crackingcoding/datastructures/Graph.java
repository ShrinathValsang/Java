package com.crackingcoding.datastructures;

import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import javax.security.sasl.SaslClient;

public class Graph implements Serializable {
	private HashMap<Integer, Node> graph = new HashMap<>();
	
	private static class Node {
		private int id;
		LinkedList<Node> adjacent = new LinkedList<>();
		
		private Node(int id) {
			this.id = id;
		}
	}
	
	private Node getNode(int node) {return null;}
	public void addEdge(int source, int destination) {}
	
	public boolean hasPathDFS(int source, int destination) throws ClassCastException {
		Node s = getNode(source);
		Node d = getNode(destination);
		HashSet<Integer> visited = new HashSet<>();
		
		return hasPathDFS(s, d, visited);
	}
	
	
	
	private boolean hasPathDFS(Node source, Node dest, HashSet<Integer> visited) {
		if (visited.contains(source.id)) return false;
		visited.add(source.id);
		
		if (source == dest) return true;
		
		for (Node child : source.adjacent) {
			if (hasPathDFS(child, dest, visited)) {
				return true;
			}
		}
		
		return false;
	}
	
	int intersectionSize(int [] A, int [] B) {
		
		return 0;
	}
	
	private boolean hasPathBFS(Node source, Node destination) {
		LinkedList<Node> nextToVisit = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		nextToVisit.add(source);
		
		while (nextToVisit.isEmpty()) {
			Node node = nextToVisit.remove();

			if (node == destination)
				return true;
			
			if (visited.contains(node.id))
				continue;
			
			visited.add(node.id);
			
			for (Node child : node.adjacent) {
				nextToVisit.add(child);
			}
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
