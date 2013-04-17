package GraphGUI;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

import Graph.Edge;
import Graph.Graph;


public class GraphPanel extends JPanel{

	Graph<VertexPoint> graph;
	
	public GraphPanel(Graph<VertexPoint> graph) {
		this.graph = graph;
	} 
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		//draw all vertices
		for (VertexPoint point: graph.getVerticesAsLinkedList()){
			g.fillOval((int)point.getX()-5, (int)point.getY()-5, 10, 10);
			g.drawString(point.getName(), point.x-5, point.y-10);
		}
		
		//draw all edges
		for (Edge<VertexPoint> edge: graph.getAllEdgesAsLinkedList()){
			g.drawLine(edge.getFromVertex().x, edge.getFromVertex().y, edge.getToVertex().x, edge.getToVertex().y);
			int minX = Math.min(edge.getFromVertex().x, edge.getToVertex().x);
			int maxX = Math.max(edge.getFromVertex().x, edge.getToVertex().x);
			int minY = Math.min(edge.getFromVertex().y, edge.getToVertex().y);
			int maxY = Math.max(edge.getFromVertex().y, edge.getToVertex().y);
			g.drawString(""+edge.getWeight(), (maxX/2)+(minX/2), (maxY/2)+(minY/2));
			
		}
		
	}
	
}
