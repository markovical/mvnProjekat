package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AdministratorTest extends AbstractDomainObjectTest{
	
	Administrator a ;	
	
	@BeforeEach
	void setUp() throws Exception {
		a = new Administrator();
		ado = new Administrator();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		a = null;
	}

	@Test
	void testAdministrator() {
		a = new Administrator();
		assertNotNull(a);
	}

	@Test
	void testAdministratorLongStringStringStringString() {
		a = new Administrator(2l,"Aleksandar" ,"Markovic" , "aca", "aca123");
		assertNotNull(a);
		assertTrue(a.getAdministratorID().equals(2l));
		assertEquals("Aleksandar", a.getIme());	
		assertEquals("Markovic", a.getPrezime());	
		assertEquals("aca", a.getKorisnickoIme());
		assertEquals("aca123", a.getLozinka());
	}

	@Test
	void testSetAdministratorID() {
		a.setAdministratorID(1L);
	    assertEquals(1l, a.getAdministratorID());
	}
	@ParameterizedTest
	@CsvSource({
		"1, Aleksandar, Markovic, aca, aca123, 1, Aleksandar, Markovic, aca, aca123, true",
		"1, Aleksandar, Markovic, aca, aca123, 1, Aleksandar, Markovic, aca, aca1234, false",
		"1, Aleksandar, Markovic, aca, aca123, 1, Aleksandar, Markovic, aca1, aca123, false",
	})
	void testEqualsObject(Long aID, String ime, String prezime, String korisnickoIme1,
			String lozinka1, Long aID2, String ime2, String prezime2, String korisnickoIme2, String lozinka2, boolean equals) {
		 Administrator a1 = new Administrator(aID, ime, prezime, korisnickoIme1, lozinka1);
	     Administrator a2 = new Administrator(aID2, ime2 , prezime2, korisnickoIme2, lozinka2);
	     assertEquals(a1.equals(a2), equals);	
	     }

	@Test
	void testSetPrezime() {
		  a.setPrezime("Markovic");
	      assertEquals("Markovic", a.getPrezime());
	}

	@Test
	void testSetKorisnickoIme() {
		a.setKorisnickoIme("KorisnickoIme");
        assertEquals("KorisnickoIme", a.getKorisnickoIme());
	}

	@Test
	void testSetLozinka() {
		a.setLozinka("aca123");
        assertEquals("aca123", a.getLozinka());
	}

	@Test
	void testSetIme() {
		a.setIme("Aleksandar");
        assertEquals("Aleksandar", a.getIme());
	}
}
