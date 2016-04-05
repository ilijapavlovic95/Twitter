/**
 * 
 */
package com.twitter.poruke;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.twitter.poruke.TwitterPoruka;

/**
 * @author Ilija Pavlovic
 *
 */
public class TwitterPorukaTest {

	private TwitterPoruka tp;

	/**
	 * Pravi novi objekat klase TwitterPoruka pre svakog testa i dodeljuje atributu tp.
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		tp = new TwitterPoruka();
	}

	/**
	 * Postavlja vrednost atributa tp na null nakon svakog testa.
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		tp = null;
	}

	@Test
	public void testSetKorisnikSveOk(){
		String imeKorisnika = "Bob Marley";

		tp.setKorisnik(imeKorisnika);

		assertEquals(imeKorisnika, tp.getKorisnik());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikNull(){
		tp.setKorisnik(null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetKorisnikPrazanString(){
		tp.setKorisnik("");
	}

	@Test
	public void testGetKorisnik(){
		tp.setKorisnik("Bob Marley");

		assertEquals("Bob Marley", tp.getKorisnik());
	}

	@Test
	public void testSetPorukaSveOk(){
		String poruka = "Cause every little thing gonna be all right.";

		tp.setPoruka(poruka);

		assertEquals(poruka, tp.getPoruka());
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaNull(){
		tp.setPoruka(null);
	}

	@Test (expected = java.lang.RuntimeException.class)
	public void testSetPorukaPredugacakString(){
		tp.setPoruka("Rise up this mornin', Smiled with the risin' sun, Three little birds. "
				+ "Pitch by my doorstep. Singin' sweet songs. Of melodies pure and true, "
				+ "Sayin': This is my message to you-ou-ou. Singin': Don't worry 'bout a thing,"
				+ "'Cause every little thing gonna be all right. Singin': "
				+ "Don't worry (don't worry) 'bout a thing, 'Cause every little thing gonna be all right!");
	}

	@Test
	public void testGetPoruka(){
		tp.setPoruka("Cause every little thing gonna be all right.");

		assertEquals("Cause every little thing gonna be all right.", tp.getPoruka());
	}
	
	@Test
	public void testToString(){
		tp.setKorisnik("Bob Marley");
		tp.setPoruka("Cause every little thing gonna be all right.");
		
		assertEquals("KORISNIK:"+"Bob Marley"+" PORUKA:"+"Cause every little thing gonna be all right.", tp.toString());
	}

}
