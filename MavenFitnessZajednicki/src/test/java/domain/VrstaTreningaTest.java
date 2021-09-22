package domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class VrstaTreningaTest extends AbstractDomainObjectTest{
	VrstaTreninga vt;
	
	@BeforeEach
	void setUp() throws Exception {
		ado = new VrstaTreninga();
		vt = new VrstaTreninga();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		vt = null;
	}

	@Test
	void testVrstaTreninga() {
		vt = new VrstaTreninga();
		assertNotNull(vt);
	}

	@Test
	void testVrstaTreningaLongString() {
		vt = new VrstaTreninga(1L, "vrsta treninga");
		assertNotNull(vt);
		assertTrue(vt.getVrstaTreningaID().equals(1L));
		assertEquals("vrsta treninga", vt.getNazivVrsteTreninga());
	}

	@Test
	void testSetVrstaTreningaID() {
		vt.setVrstaTreningaID(2L);
		assertTrue(vt.getVrstaTreningaID().equals(2L));
	}

	@Test
	void testSetNazivVrsteTreninga() {
		vt.setNazivVrsteTreninga("vrsta treninga 2");
		assertEquals("vrsta treninga 2", vt.getNazivVrsteTreninga());
	}

}
