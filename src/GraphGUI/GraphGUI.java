package GraphGUI;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

import Graph.Edge;
import Graph.Graph;


public class GraphGUI extends JFrame implements MouseInputListener{
	
	Point mousePressed;
	Point MouseReleased;
	
	Graph<VertexPoint> graph = new Graph<VertexPoint>();
	GraphPanel graphPanel = new GraphPanel(graph);
	
	public static void main(String[] args) {
		new GraphGUI();
	}
	
	public GraphGUI(){
		graphPanel.addMouseListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setTitle("VisualGraph");
		add(graphPanel);
		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		mousePressed = e.getPoint();
		//System.out.println("pressed:"+e.getPoint());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		MouseReleased = e.getPoint();
		//System.out.println("Released:"+e.getPoint());
		
		// mouse dragged -> add edge
		if (Math.abs(mousePressed.x-MouseReleased.x) >= 10 && Math.abs(mousePressed.y-MouseReleased.y) >= 10) {
			
			VertexPoint start = null;
			VertexPoint end = null;
			
			System.out.println("dragged");
			for (VertexPoint point: graph.getVerticesAsLinkedList()){
				if (Math.abs(point.x-mousePressed.x) <5 && Math.abs(point.y-mousePressed.y) <5){
					start = point;
					
				}
				if (Math.abs(point.x-MouseReleased.x) <5 && Math.abs(point.y-MouseReleased.y) <5){
					end = point;
				}
			}
			int distance = (int) Point.distance(start.x, start.y, end.x, end.y);
			graph.addEdge(start, end, distance);
			repaint();
			
		}
		
		// mouse clicked -> add vertex or name vertex
		if (Math.abs(mousePressed.x-MouseReleased.x) < 20 && Math.abs(mousePressed.y-MouseReleased.y) < 20) {
			boolean VertexExists = false;
			for (VertexPoint vertex: graph.getVerticesAsLinkedList()){
				if (Math.abs(vertex.x-MouseReleased.x) <5 && Math.abs(vertex.y-MouseReleased.y) <5){
					String name = JOptionPane.showInputDialog(this, "Vertex name");
					vertex.setName(name);
					repaint();
					VertexExists = true;
				}
			}
		
		if (!VertexExists){
		graph.addVertex(new VertexPoint(e.getX(), e.getY()));
		repaint();
		//System.out.println(graph.getAllVertices());
		}
		}	
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
