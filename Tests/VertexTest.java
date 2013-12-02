import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class VertexTest {
	@Test
	public void findEdgeByTargetName(){
		Vertex paris = new Vertex("Paris");
		Vertex lyon = new Vertex("Lyon");
		paris.connectTo(lyon, 465);

		assertEquals(new Edge(lyon,465),paris.findEdgeByTargetName("Lyon"));
		assertEquals(null,paris.findEdgeByTargetName("Le Mans") );
	}
}
