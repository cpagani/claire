
import java.util.*;

public class Graph {
	private List<Vertex> vertices = new ArrayList<Vertex>();
	private Map<String, Integer> finalDistance = new HashMap<String, Integer>();
	private Map<String, Integer> inProgress = new HashMap<String, Integer>();


	public Graph(Vertex... vertices) {
		this.vertices.addAll(Arrays.asList(vertices));
	}

	public int getDistance(String from, String to) {
		Vertex start = findVertexByName(from);
		String point = start.getName();
		finalDistance.put(from, 0);

		while(!point.equals(to)){
			Vertex currentPoint = findVertexByName(point);
			lookAtTheNeighbors(currentPoint);
			point = newVertexByName();
			updateMap(point);

		}



		return finalDistance.get(to);
	}

	public Vertex findVertexByName(String name) {
		for (Vertex vertex : vertices) {
			if (vertex.getName().equals(name)) {
				return vertex;
			}
		}

		return null;
	}

	private String newVertexByName(){
		String refKey =null;
		for (String key : inProgress.keySet()){
			if(refKey == null) {
				refKey = key;
			}
			if (inProgress.get(refKey) > inProgress.get(key)){
				refKey =key;
			}

		}
		return refKey;
	}

	private void updateMap(String refKey){
		finalDistance.put(refKey, inProgress.get(refKey));
		inProgress.remove(refKey);
	}

	private void lookAtTheNeighbors(Vertex currentPoint){
		for (Edge edgeFromStart : currentPoint.getEdges()) {
			if (!inProgress.containsKey(edgeFromStart.getTarget().getName()) || inProgress.get(edgeFromStart.getTarget().getName()) > edgeFromStart.getDistance()+ finalDistance.get(currentPoint.getName())) {
				inProgress.put(edgeFromStart.getTarget().getName(), edgeFromStart.getDistance()+ finalDistance.get(currentPoint.getName()));
			}
        }
	}
}