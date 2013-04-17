package Graph;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;


public class Graph<T> implements Iterable<T>{
	
	//My vertices
	LinkedList<T> vertices = new LinkedList<T>();

	//My Edges
	LinkedList<Edge> edges = new LinkedList<Edge>();

	public void addVertex(T vertex){
		vertices.add(vertex);
	}
	
	public T getVertex(String string){
		for (T vertex: vertices){
			if (vertex.toString().equals(string)) return vertex;
		}
		return null;
	}
	
	public void removeVertex(T vertex){
		vertices.remove(vertex);
	}
	
	public void addEdge(T from, T to, int weight){
		Edge edge = new Edge();
		edge.setFromVertex(from);
		edge.setToVertex(to);
		edge.setWeight(weight);
		edges.add(edge);
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public String getAllVertices() {
		// TODO Auto-generated method stub
		return vertices.toString();
	}
		
	public LinkedList<T> getVerticesAsLinkedList(){
		return vertices;
	}
	
	public LinkedList<Edge> getAllEdgesAsLinkedList() {
		return edges;
	}
	
	public String getAllEdges(){
		StringBuilder builder = new StringBuilder();
		for (Edge edge: edges){
			builder.append(edge.toString());
		}
		return builder.toString();
	}
	
	public boolean isAdjecentVertices(T vertex1, T vertex2){
		for (Edge edge: edges){
			if (edge.getFromVertex().equals(vertex1) && edge.getToVertex().equals(vertex2)){
				return true;
			}
			if (edge.getFromVertex().equals(vertex2) && edge.getToVertex().equals(vertex1)){
				return true;
			}
		}
		return false;
	}
	
	// an iterator  that uses Depth-First-Search
	private class GraphIterator implements Iterator<T>{

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
		
	}	
}

	