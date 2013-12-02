import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GraphTest {
	private Vertex lille = new Vertex("Lille");
	private Vertex paris = new Vertex("Paris");
	private Vertex reims = new Vertex("Reims");
	private Vertex nancy = new Vertex("Nancy");
	private Vertex lyon = new Vertex("Lyon");
	private Vertex marseille = new Vertex("Marseille");
	private Vertex lemans = new Vertex("Le Mans");
	private Vertex nantes = new Vertex("Nantes");
	private Vertex bordeaux = new Vertex("Bordeaux");
	private Vertex toulouse = new Vertex("Toulouse");
	private Vertex clermont = new Vertex("Clermont Ferrant");
	private Vertex montpellier = new Vertex("Montpellier");

	@Before
	public void setup() {
		lille.connectTo(reims, 206);
		lille.connectTo(paris, 222);
		lille.connectTo(nancy, 418);

		reims.connectTo(paris, 144);
		reims.connectTo(nancy, 245);
		reims.connectTo(lyon, 489);

		paris.connectTo(lyon, 465);
		paris.connectTo(lemans, 208);
		paris.connectTo(clermont, 423);

		lyon.connectTo(clermont, 166);
		lyon.connectTo(marseille, 313);
		lyon.connectTo(montpellier, 304);

		lemans.connectTo(nantes, 189);
		lemans.connectTo(bordeaux, 443);

		nantes.connectTo(bordeaux, 347);

		bordeaux.connectTo(toulouse, 243);

		toulouse.connectTo(montpellier, 245);

		montpellier.connectTo(marseille, 169);
		montpellier.connectTo(toulouse, 245);

		marseille.connectTo(montpellier, 169);

		clermont.connectTo(lyon, 166);
		clermont.connectTo(montpellier, 333);
		clermont.connectTo(marseille, 474);
	}

	@Test
	public void getDistanceForTwoAdjacentVertices() {
		Graph graph = new Graph(paris, lyon, clermont,montpellier, marseille,reims,nancy,nantes,lille,lemans,bordeaux,toulouse);

		assertEquals(465, graph.getDistance("Paris", "Lyon"));
	}
	@Test
	public void findVertexByName(){
		Graph graph = new Graph(montpellier);
		assertEquals(montpellier, graph.findVertexByName("Montpellier"));
		assertEquals(null, graph.findVertexByName("Paris"));

	}
	@Test
	public void getDistanceForOneIntermediaryVertex(){
		Graph graph = new Graph(paris, nantes, lemans, lyon, clermont) ;
		assertEquals(208+189, graph.getDistance("Paris","Nantes"));
	}
	@Test
	public void directLineIsBetter(){
		Vertex a = new Vertex("a") ;
		Vertex b = new Vertex("b") ;
		Vertex c = new Vertex("c") ;
		a.connectTo(b, 1);
		b.connectTo(c, 1);
		a.connectTo(c, 1);
		Graph graph = new Graph(a, b,c);
		assertEquals(1, graph.getDistance("a","c"));
	}

	@Test
	public void undirectLineIsBetter(){
		Vertex a = new Vertex("a") ;
		Vertex b = new Vertex("b") ;
		Vertex c = new Vertex("c") ;
		a.connectTo(b, 1);
		b.connectTo(c, 1);
		a.connectTo(c, 3);
		Graph graph = new Graph(a, b,c);
		assertEquals(2, graph.getDistance("a","c"));
	}
	 @Test
	 public void getDistanceWithTwoIntermediaryVertex(){
		 Vertex a = new Vertex("a") ;
		 Vertex b = new Vertex("b") ;
		 Vertex c = new Vertex("c") ;
		 Vertex d = new Vertex("d");
		 a.connectTo(b, 1);
		 b.connectTo(c, 1);
		 c.connectTo(d, 1);
		 a.connectTo(d, 10);
		 Graph graph = new Graph ( a, b ,c ,d);
		 assertEquals(3, graph.getDistance("a","d"));
	 }


}