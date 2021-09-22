package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TreningTest extends AbstractDomainObjectTest {
	Trening t;

	@BeforeEach
	void setUp() throws Exception {
		ado = new Trening();
		t = new Trening();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		t = null;
	}

	@Test
	void testTrening() {
		t = new Trening();
		assertNotNull(t);
	}

	@Test
	void testTreningLongStringVrstaTreninga() {
		VrstaTreninga vt = new VrstaTreninga(1L, "vrsta treninga 1");
		t = new Trening(1L, "trening 1", vt);
		assertNotNull(t);
		assertTrue(t.getTreningID().equals(1L));
		assertEquals("trening 1", t.getNazivTreninga());
		assertTrue(vt.getVrstaTreningaID().equals(t.getVrstaTreninga().getVrstaTreningaID()));
		assertEquals(vt.getNazivVrsteTreninga(), t.getVrstaTreninga().getNazivVrsteTreninga());		
	}

	@Test
	void testSetVrstaTreninga() {
		VrstaTreninga vt = new VrstaTreninga(2L, "vrsta treninga 2");
		t.setVrstaTreninga(vt);
		assertTrue(vt.getVrstaTreningaID().equals(t.getVrstaTreninga().getVrstaTreningaID()));
		assertEquals(vt.getNazivVrsteTreninga(), t.getVrstaTreninga().getNazivVrsteTreninga());	
	}

	@Test
	void testSetTreningID() {
		t.setTreningID(2L);
		assertTrue(t.getTreningID().equals(2L));
	}

	@Test
	void testSetNazivTreninga() {
		t.setNazivTreninga("trening 2");
		assertEquals("trening 2", t.getNazivTreninga());
	}

}
