package com.rag.practicals.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GraphFirst<T> {

	private Map<T, List<T>> map = new HashMap<>();

	public void addVertex(T s) {
		map.put(s, new LinkedList<T>());
	}

	public void addEdge(T source, T destination, boolean bidirectional) {
		if (!map.containsKey(source)) {
			addVertex(source);
		}
		if (!map.containsKey(destination)) {
			addVertex(destination);
		}
		map.get(source).add(destination);
		if (bidirectional == true) {
			map.get(destination).add(source);
		}
	}

	public void getVertexCount() {
		System.out.println("The graph has " + map.keySet().size());
	}

	public void hasEdge(T source, T destination) {
		if (map.get(source).contains(destination)) {
			System.out.println("The graph has an edge between " + source + " and " + destination + " ");
		} else {
			System.out.println("The graph has no edge between " + source + " and " + destination + " ");
		}
	}

	// This function gives whether
	// a vertex is present or not.
	public void hasVertex(T s) {
		if (map.containsKey(s)) {
			System.out.println("The graph contains " + s
					+ " as a vertex.");
		} else {
			System.out.println("The graph does not contain "
					+ s + " as a vertex.");
		}
	}

	public void getEdgesCount(boolean bidirection) {
		int count = 0;

		for (T v : map.keySet()) {
			count += map.get(v).size();
		}
		if (bidirection == true) {
			count = count / 2;
		}

	}

	public void neighbours(T s) {
		if (!map.containsKey(s)) {
			return;
		}

		System.out.println("Neight of " + s + " are ");
		for (T w : map.get(s)) {
			System.out.print(w + ",");
		}
	}

	public static void main(String[] args) {
		// Object of graph is created.
		GraphFirst<Integer> g = new GraphFirst<Integer>();

		// edges are added.
		// Since the graph is bidirectional,
		// so boolean bidirectional is passed as true.
		g.addEdge(0, 1, true);
		g.addEdge(0, 4, true);
		g.addEdge(1, 2, true);
		g.addEdge(1, 3, true);
		g.addEdge(1, 4, true);
		g.addEdge(2, 3, true);
		g.addEdge(3, 4, true);

		System.out.println("Graph:\n" + g.toString());

		// Gives the no of vertices in the graph.
		g.getVertexCount();

		// Gives the no of edges in the graph.
		g.getEdgesCount(true);

		// Tells whether the edge is present or not.
		g.hasEdge(3, 4);

		// Tells whether vertex is present or not
		g.hasVertex(5);
		g.neighbours(1);

	}

}
