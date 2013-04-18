package GraphGUI;
import graph.Edge;
import graph.Graph;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Event;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.MouseInputListener;

public class graphGUI extends JFrame implements MouseInputListener{
	
	Point mousePressed;
	Point mouseReleased;
	
	Graph<VertexPoint> graph = new Graph<VertexPoint>();
	GraphPanel graphPanel = new GraphPanel(graph);
	
	public static void main(String[] args) {
		new graphGUI();
	}
	
	public graphGUI(){
		graphPanel.addMouseListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(600, 400);
		setTitle("VisualGraph");
		add(graphPanel);
		
		//add 'complete button'-button
		Button buttonCompleteGraph = new Button("Complete Graph");
		add(buttonCompleteGraph, BorderLayout.NORTH);
		buttonCompleteGraph.addActionListener(new ActionListener() {
	
			@Override
			public void actionPerformed(ActionEvent e) {
				completeGraph();
				repaint();
				
			}
		});
		setVisible(true);
		
	}

	/*
	 * add edges between all vertices
	 */
	public void completeGraph() {
		for (VertexPoint vertexOuter: graph.getVerticesAsLinkedList()){
			for (VertexPoint vertexInner: graph.getVerticesAsLinkedList()){
				if(!vertexInner.equals(vertexOuter)){
					int distance = (int) Point.distance(vertexInner.x, vertexInner.y, vertexOuter.x, vertexOuter.y);
					graph.addEdge(vertexOuter, vertexInner, distance);
				}
			}
		}
		
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
		mouseReleased = e.getPoint();
		//System.out.println("Released:"+e.getPoint());
		
		//right click -> delete Vertex
		if (e.getButton() == MouseEvent.BUTTON3){
			System.out.println("Right click");
			for (VertexPoint vertex: graph.getVerticesAsLinkedList()){
				if (Math.abs(vertex.x-mouseReleased.x) <5 && Math.abs(vertex.y-mouseReleased.y) <5){
					System.out.println(vertex);
					graph.removeVertex(vertex);
					repaint();
					
				}
			}
		}
		
		// mouse dragged -> add edge
		else if (Math.abs(mousePressed.x-mouseReleased.x) >= 10 && Math.abs(mousePressed.y-mouseReleased.y) >= 10) {
			
			VertexPoint start = null;
			VertexPoint end = null;
			
			System.out.println("dragged");
			for (VertexPoint point: graph.getVerticesAsLinkedList()){
				if (Math.abs(point.x-mousePressed.x) <5 && Math.abs(point.y-mousePressed.y) <5){
					start = point;
					
				}
				if (Math.abs(point.x-mouseReleased.x) <5 && Math.abs(point.y-mouseReleased.y) <5){
					end = point;
				}
			}
			
			
			if (start != null && end != null){
				int distance = (int) Point.distance(start.x, start.y, end.x, end.y);
				graph.addEdge(start, end, distance);
			}	
			repaint();
			
		}
		
		// mouse clicked -> add vertex or name vertex
		else if (Math.abs(mousePressed.x-mouseReleased.x) < 20 && Math.abs(mousePressed.y-mouseReleased.y) < 20) {
			boolean VertexExists = false;
			for (VertexPoint vertex: graph.getVerticesAsLinkedList()){
				if (Math.abs(vertex.x-mouseReleased.x) <5 && Math.abs(vertex.y-mouseReleased.y) <5){
					String name = "";
					name = JOptionPane.showInputDialog(this, "Vertex name");
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
