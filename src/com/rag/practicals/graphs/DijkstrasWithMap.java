package com.rag.practicals.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DijkstrasWithMap<T> {

	private Map<T, List<VertexAndWeight>> map = new HashMap<>();

	// To store the vertex and Weight
	public class VertexAndWeight {
		T vertice;
		int weight;

		public VertexAndWeight(T vertice, int weight) {
			this.vertice = vertice;
			this.weight = weight;
		}

		public T getVertice() {
			return vertice;
		}

		public int getVerticeWeight() {
			return weight;
		}
	}

	public void addVertexWithWitWeight(T s) {
		map.put(s, new LinkedList<VertexAndWeight>());
	}

	public void addEdge(T source, T destination, int weight, boolean bidirectional) {
		if (!map.containsKey(source)) {
			addVertexWithWitWeight(source);
		}
		if (!map.containsKey(destination)) {
			addVertexWithWitWeight(destination);
		}
		map.get(source).add(new VertexAndWeight(destination, weight));
		if (bidirectional == true) {
			map.get(destination).add(new VertexAndWeight(source, weight));
		}
	}

	public int getVertexCount() {
		return map.entrySet().size();
	}

	public Set<T> initializeSpt() {
		Set<T> sptSet = new LinkedHashSet<>();
		for (Map.Entry<T, List<VertexAndWeight>> entry : map.entrySet()) {
			sptSet.add(entry.getKey());

		}
		return sptSet;
	}

	public Map<T, Integer> initializeDistMap(T source) {
		Map<T, Integer> distMap = new HashMap<>();

		for (Map.Entry<T, List<VertexAndWeight>> entry : map.entrySet()) {
			distMap.put(entry.getKey(), Integer.MAX_VALUE);
		}
		distMap.put(source, 0);
		return distMap;
	}

	private T minDistance(Set<T> sptSet, Map<T, Integer> distMap) {
		int min = Integer.MAX_VALUE;
		T min_index = null;

		for (Map.Entry<T, Integer> entry : distMap.entrySet()) {
			if (!sptSet.contains(entry.getKey()) && entry.getValue() < min) {
				// System.out.println("m: minDistance, vertice " + entry.getValue());
				min = entry.getValue();
				min_index = entry.getKey();
			}
		}
		return min_index;
	}

	public void dijkstrasInAction(T source) {
		Set<T> sptSet = new LinkedHashSet<>();
		Map<T, Integer> distMap = initializeDistMap(source);
		// distmap looks like this
		// [{0=>0},{1=>INTEGER.MAX_VALUE},{3=>INTEGER.MAX_VALUE}
		// ,{4=>INTEGER.MAX_VALUE},{7=>INTEGER.MAX_VALUE}]

		// iterate over a the map distmap's elements
		for (Map.Entry<T, Integer> entry : distMap.entrySet()) {
			// the value u shouldn't be
			// in the sptSet
			// has to be the minimum distance in the distmap
			T u = minDistance(sptSet, distMap);
			sptSet.add(u);

			// get the adjanceny vertices of u
			Set<T> adjacencyVerticesOfU = getAdjacencyVertices(u);
			// iterate through the adjancency vertices of U
			for (T t : adjacencyVerticesOfU) {

				// Conditions are
				// adjacency vertex t of U, shouldn't be in the sptSet, !sptSet.contains(t)
				// the weight between U and t, shouldn't be 0, getWeight(u, t) != 0
				// weight of U shouldn't inifinite/Integer.MAX_VALUE value, distMap.get(u) !=
				// Integer.MAX_VALUE
				// Sum of Weight of (U + src) and weight of (U+T), should be lesser than
				// distmap's t's Weight
				// distMap.get(u) + getWeight(u, t) < distMap.get(t)
				if (!sptSet.contains(t)
						&& getWeight(u, t) != 0
						&& distMap.get(u) != Integer.MAX_VALUE
						&& distMap.get(u) + getWeight(u, t) < distMap.get(t)) {
					distMap.put(t, distMap.get(u) + getWeight(u, t));
				}
			}
		}

		System.out.println("final spt " + sptSet);
		System.out.println("final distMap " + distMap);

	}

	public int getWeight(T source, T destination) {
		List<VertexAndWeight> vertices = map.get(source);
		int weight = 0;

		for (VertexAndWeight vertexWeight : vertices) {
			if (vertexWeight.vertice.equals(destination)) {
				weight = vertexWeight.weight;
				break;
			}
		}

		return weight;
	}

	// This function gives whether
	// a vertex is present or not.
	public boolean hasVertex(T s) {
		if (map.containsKey(s)) {
			return true;
		} else {
			return false;
		}
	}

	// gives you a set of adjancency vertices when a Vertext is given
	public Set<T> getAdjacencyVertices(T source) {
		Set<T> set = new HashSet<>();
		if (map.containsKey(source)) {
			List<VertexAndWeight> vertices = map.get(source);

			for (VertexAndWeight vertexWeight : vertices) {
				set.add(vertexWeight.vertice);
			}
		}
		return set;
	}

	// Prints the adjancency list of each vertex.
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();

		for (T v : map.keySet()) {
			builder.append(v.toString() + ": ");
			for (VertexAndWeight w : map.get(v)) {
				System.out.println("adjacency of " + v.toString() + " is " + w.vertice);
				builder.append(w.vertice.toString() + " ");
			}
			builder.append("\n");
		}

		return (builder.toString());
	}

	public static void main(String[] args) {
		DijkstrasWithMap<Integer> g = new DijkstrasWithMap<Integer>();
		g.addEdge(0, 1, 6, false);
		g.addEdge(0, 7, 3, false);
		g.addEdge(1, 4, 1, false);
		g.addEdge(1, 3, 3, false);
		g.addEdge(7, 4, 5, false);
		g.addEdge(4, 3, 6, false);

		// graph representation
		// [n] => weight
		// n=> Vertex
		// **************************
		// * 0---[6]---1---[3]---3 *
		// * |*********|*********| *
		// * |*********|*********| *
		// * [3]******[4]*******[6] *
		// * |*********|*********| *
		// * |*********|*********| *
		// * 7---[5]---4---------| *
		// **************************
		// 0 A, 1 B, 2 C, 3 D, 4 E, 5 F, 6 E, 7 G
		g.dijkstrasInAction(2);
	}

}
