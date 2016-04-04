package com.twitter.poruke;

/**
 * Ovo je klasa koja predstavlja Twitter poruku.
 * @author Ilija Pavlovic
 * @version 1.0
 */

public class TwitterPoruka {
	/**
	 * Korisnik Twitter-a.
	 */
	private String korisnik;
	
	/**
	 * Poruka koja se salje putem Twitter-a.
	 */
	private String poruka;
	
	/**
	 * Vraca ime korisnika Twitter-a.
	 * @return ime korisnika
	 */
	public String getKorisnik() {
		return korisnik;
	}
	
	/**
	 * Postavlja novu vrednost za atribut korisnik.
	 * @param korisnik - Nova vrednost za atribut korisnik.
	 * @throws java.lang.RuntimeException ako je uneti korisnik:
	 * <ul>
	 * 	<li>null vrednost
	 * 	<li>prazan string
	 * </ul>
	 */
	public void setKorisnik(String korisnik) {
		if (korisnik==null || korisnik == "")
			throw new RuntimeException(
					"Ime korisnika mora biti uneto");
		this.korisnik = korisnik;
	}
	
	/**
	 * Vraca poruku koja se salje putem Twitter-a.
	 * @return poruka koja se salje
	 */
	public String getPoruka() {
		return "poruka";
	}
	
	/**
	 * Postavlja novu vrednost za atribut poruka.
	 * @param poruka - Poruka koja se salje.
	 * @throws java.lang.RuntimeException ako je uneta poruka:
	 * <ul>
	 * 	<li>null vrednost
	 * 	<li>string duzine vece od 140 karaktera
	 * </ul>
	 */
	public void setPoruka(String poruka) {
		if (poruka==null || this.poruka.length()>140)
			throw new RuntimeException(
					"Poruka mora biti uneta i mora imati najvise 140 znakova");
		this.poruka = poruka;
	}
	
	/**
	 * Vraca informacije o korisniku i poslatoj poruci
	 * @return informacije o poslatoj poruci
	 */
	public String toString(){
		return "KORISNIK:"+korisnik+" PORUKA:"+poruka;
	}

}