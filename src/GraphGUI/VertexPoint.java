package GraphGUI;

import java.awt.Point;

public class VertexPoint extends Point{
	private String name;

	public VertexPoint(int x, int y) {
		this.x = x;
		this.y = y;
		this.name = "";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
