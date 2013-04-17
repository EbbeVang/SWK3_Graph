import Graph.Graph;


public class TestGraph {
	
	public static void main(String[] args) {
		
		// create graph
		Graph<String> graph = new Graph<String>();
		
		graph.addVertex("Rønne");
		graph.addVertex("Hasle");
		graph.addVertex("Allinge");
		graph.addVertex("Aakirkeby");
		graph.addVertex("Gudhjem");
		
		graph.addEdge("Rønne", "Aakirkeby", 15);
		graph.addEdge("Aakirkeby", "Gudhjem", 18);
		graph.addEdge("Rønne", "Hasle", 10);
		graph.addEdge("Hasle", "Allinge", 13);
		graph.addEdge("Allinge", "Gudhjem", 15);
		
		System.out.println("Vertices: " + graph.getAllVertices());
		System.out.println("Edges: " + graph.getAllEdges());
		
		System.out.println("Rønne and Gudhjem are connected: " + graph.isAdjecentVertices("Rønne", "Gudjhem"));
		System.out.println("Rønne and Aakirkeby are connected: " + graph.isAdjecentVertices("Rønne", "Aakirkeby"));
	}
}
