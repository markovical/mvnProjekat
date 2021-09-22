package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TipKlijentaTest extends AbstractDomainObjectTest {
	TipKlijenta tk;

	@BeforeEach
	void setUp() throws Exception {
		ado = new TipKlijenta();
		tk = new TipKlijenta();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		tk = null;		
	}

	@Test
	void testTipKlijenta() {
		tk = new TipKlijenta();		
		assertNotNull(tk);
	}

	@Test
	void testTipKlijentaLongStringString() {
		tk = new TipKlijenta(1L, "test tip klijenta", "test opis");
		assertNotNull(tk);
		assertTrue(tk.getTipKlijentaID().equals(1L));
		assertEquals("test tip klijenta", tk.getNazivTipaKlijenta());
		assertEquals("test opis", tk.getOpis());
	}

	@Test
	void testSetTipKlijentaID() {
		tk.setTipKlijentaID(3L);
		assertTrue(tk.getTipKlijentaID().equals(3L));
	}

	@Test
	void testSetNazivTipaKlijenta() {
		tk.setNazivTipaKlijenta("Tip klijenta 1");
		assertEquals("Tip klijenta 1", tk.getNazivTipaKlijenta());
	}

	@Test
	void testSetOpis() {
		tk.setOpis("Test opis");
		assertEquals("Test opis", tk.getOpis());
	}
}
