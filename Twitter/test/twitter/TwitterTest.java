package twitter;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.Twitter;
import com.twitter.poruke.TwitterPoruka;

public class TwitterTest {
	
	private Twitter t;
	
	@Before
	public void setUp() throws Exception {
		t = new Twitter();
	}

	@After
	public void tearDown() throws Exception {
		t = null;
	}
	
	@Test
	public void testVratiSvePoruke(){
		t.unesi("Bob Marley", "Every little thing is gonna be alright.");
		
		assertEquals(1, t.vratiSvePoruke().size());
		assertEquals("Bob Marley", t.vratiSvePoruke().getFirst().getKorisnik());
		assertEquals("Every little thing is gonna be alright.", t.vratiSvePoruke().getFirst().getPoruka());
	}
	
	@Test
	public void testUnesi(){
		TwitterPoruka tp1 = new TwitterPoruka();
		tp1.setKorisnik("Pera");
		tp1.setPoruka("Hello world!");
		
		LinkedList<TwitterPoruka> poruke = new LinkedList<TwitterPoruka>();
		poruke.add(tp1);
		
		t.unesi("Pera", "Hello world!");
		
		assertEquals(1, t.vratiSvePoruke().size());
		
		assertEquals(poruke.get(0).getKorisnik(), t.vratiSvePoruke().get(0).getKorisnik());
		assertEquals(poruke.get(0).getPoruka(), t.vratiSvePoruke().get(0).getPoruka());
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukeNullTag(){
		t.vratiPoruke(50, null);
	}
	
	@Test (expected = java.lang.RuntimeException.class)
	public void vratiPorukePrazanTag(){
		t.vratiPoruke(50, "");
	}
	
	@Test
	public void vratiPorukeMaxBrojNijePozitivan(){
		assertEquals(100, t.vratiPoruke(0, "tag").length);
	}
	
	@Test
	public void vratiPorukeSveOk(){
		TwitterPoruka[] reper = new TwitterPoruka[2];
		reper[0] = new TwitterPoruka();
		reper[0].setKorisnik("Sasa");
		reper[0].setPoruka("Vinjak je pice.");
		reper[1] = new TwitterPoruka();
		reper[1].setKorisnik("Ilic");
		reper[1].setPoruka("Rakija je pice.");
		
		t.unesi("Sasa", "Vinjak je pice.");
		t.unesi("Ilic", "Rakija je pice.");
		
		TwitterPoruka[] testNiz = t.vratiPoruke(2, "pice");
		assertEquals(reper[0].getKorisnik(), testNiz[0].getKorisnik());
		assertEquals(reper[0].getPoruka(), testNiz[0].getPoruka());
		assertEquals(reper[1].getKorisnik(), testNiz[1].getKorisnik());
		assertEquals(reper[1].getPoruka(), testNiz[1].getPoruka());
	}

}
