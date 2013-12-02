import java.util.ArrayList;
import java.util.List;

public class Vertex {
	private String name;
	private List<Edge> edges = new ArrayList<Edge>();

	public Vertex(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void connectTo(Vertex target, int distance) {
		edges.add(new Edge(target, distance));
	}

	public List<Edge> getEdges() {
		return edges;
	}

	public Edge findEdgeByTargetName(String to){
		for(Edge edge: edges){
			if (edge.getTarget().getName().equals(to)){
				return  edge;
			}
		}
		return null;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Vertex vertex = (Vertex) o;

		if (!edges.equals(vertex.edges)) return false;
		if (!name.equals(vertex.name)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = name.hashCode();
		result = 31 * result + edges.hashCode();
		return result;
	}
}
