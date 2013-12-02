
public class Edge {
	private final Vertex target;
	private int distance;

	public Edge(Vertex target, int distance) {
		this.target = target;
		this.distance = distance;
	}

	public Vertex getTarget() {
		return target;
	}

	public int getDistance() {
		return distance;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		Edge edge = (Edge) o;

		if (distance != edge.distance) return false;
		if (!target.equals(edge.target)) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = target.hashCode();
		result = 31 * result + distance;
		return result;
	}
}
