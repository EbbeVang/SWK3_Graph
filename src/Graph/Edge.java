package Graph;
public class Edge<T>{
	
	T fromVertex;
	T toVertex;
	int weight;
	
	public String toString(){
		return "<"+ toVertex + "-" + weight + "-" + fromVertex + ">";
	}
	
	public T getFromVertex() {
		return fromVertex;
	}
	public void setFromVertex(T fromVertex) {
		this.fromVertex = fromVertex;
	}
	public T getToVertex() {
		return toVertex;
	}
	public void setToVertex(T toVertex) {
		this.toVertex = toVertex;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
}
