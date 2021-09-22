package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KlijentTest extends AbstractDomainObjectTest{
	Klijent k;
		
@BeforeEach
	void setUp() throws Exception {
		ado = new Klijent();
		k = new Klijent();
	}

	@AfterEach
	void tearDown() throws Exception {
		k = null;
		ado = null;
	}

	@Test
	void testKlijent() {
		k = new Klijent();
		assertNotNull(k);
	}

	@Test
	void testKlijentLongStringStringStringStringTipKlijenta() {
		TipKlijenta tk = new TipKlijenta(1L, "tip klijenta", "opis");
		k = new Klijent(11L, "Aleksandar", "Markovic", "063111222", "mejladresa@gmail.com", tk);
		assertNotNull(k);
		assertTrue(k.getKlijentID().equals(11L));
		assertEquals("Aleksandar", k.getIme());
		assertEquals("Markovic", k.getPrezime());
		assertEquals("063111222", k.getBrojTelefona());
		assertEquals("mejladresa@gmail.com", k.getEmail());
		assertTrue(tk.getTipKlijentaID().equals(k.getTipKlijenta().getTipKlijentaID()));
		assertTrue(tk.getNazivTipaKlijenta().equals(k.getTipKlijenta().getNazivTipaKlijenta()));
		assertTrue(tk.getOpis().equals(k.getTipKlijenta().getOpis()));		
	}

	@Test
	void testSetKlijentID() {
		k.setKlijentID(2L);
		assertTrue(k.getKlijentID().equals(2L));
	}

	@Test
	void testSetIme() {
		k.setIme("Aleksandar");
		assertEquals("Aleksandar", k.getIme());
	}

	@Test
	void testSetPrezime() {
		k.setPrezime("Markovic");
		assertEquals("Markovic", k.getPrezime());
	}

	@Test
	void testSetBrojTelefona() {
		k.setBrojTelefona("063111222");
		assertEquals("063111222", k.getBrojTelefona());
	}

	@Test
	void testSetEmail() {
		k.setEmail("test@test.rs");
		assertEquals("test@test.rs", k.getEmail());
	}

	@Test
	void testSetTipKlijenta() {
		TipKlijenta tk = new TipKlijenta(2L, "Test tip klijenta", "test opis");
		k.setTipKlijenta(tk);		
		assertTrue(tk.getTipKlijentaID().equals(k.getTipKlijenta().getTipKlijentaID()));
		assertTrue(tk.getNazivTipaKlijenta().equals(k.getTipKlijenta().getNazivTipaKlijenta()));
		assertTrue(tk.getOpis().equals(k.getTipKlijenta().getOpis()));		
		
	}
}
