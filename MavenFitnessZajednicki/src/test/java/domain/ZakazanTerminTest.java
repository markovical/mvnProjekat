package domain;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Date;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ZakazanTerminTest extends AbstractDomainObjectTest{
	ZakazanTermin zt;

	@BeforeEach
	void setUp() throws Exception {
		ado = new ZakazanTermin();
		zt = new ZakazanTermin();
	}

	@AfterEach
	void tearDown() throws Exception {
		ado = null;
		zt = null;
	}

	@Test
	void testZakazanTermin() {
		zt = new ZakazanTermin();
		assertNotNull(zt);
	}

	@SuppressWarnings("deprecation")
	@Test
	void testZakazanTerminLongDateAdministratorKlijentTreningArrayListOfVezbaZaTermin() {		
		Administrator a = new Administrator(1L, "adminIme", "adminPrezime", "adminKorisnickoIme", "adminLozinka");
		TipKlijenta tk = new TipKlijenta(1L, "tip 1", "opis 1");
		Klijent k = new Klijent(1L, "klijent ime", "klijent prezime", "klijent broj telefona", "klijent email", tk);
		VrstaTreninga vt = new VrstaTreninga(1L, "vrsta 1");
		Trening t = new Trening(1L, "trening 1", vt);		
		zt = new ZakazanTermin(1L, new Date(2021, 9, 9), a, k, t, null);
		
		assertNotNull(zt);
		assertTrue(zt.getZakazanTerminID().equals(1L));
		assertTrue(a.getAdministratorID().equals(zt.getAdministrator().getAdministratorID()));
		assertTrue(k.getKlijentID().equals(zt.getKlijent().getKlijentID()));
		assertTrue(t.getTreningID().equals(zt.getTrening().getTreningID()));
		assertEquals(new Date(2021, 9, 9), zt.getDatumVreme());				
	}

	@Test
	void testSetZakazanTerminID() {
		zt.setZakazanTerminID(2L);
		assertTrue(zt.getZakazanTerminID().equals(2L));
	}

	@SuppressWarnings("deprecation")
	@Test
	void testSetDatumVreme() {
		zt.setDatumVreme(new Date(2021, 9, 9));
		assertEquals(new Date(2021, 9, 9), zt.getDatumVreme());
	}

	@Test
	void testSetAdministrator() {
		Administrator a = new Administrator(1L, "adminIme", "adminPrezime", "adminKorisnickoIme", "adminLozinka");
		zt.setAdministrator(a);
		
		assertTrue(a.getAdministratorID().equals(zt.getAdministrator().getAdministratorID()));
		assertEquals(a.getIme(), zt.getAdministrator().getIme());
		assertEquals(a.getPrezime(), zt.getAdministrator().getPrezime());
		assertEquals(a.getKorisnickoIme(), zt.getAdministrator().getKorisnickoIme());
		assertEquals(a.getLozinka(), zt.getAdministrator().getLozinka());
		
	}

	@Test
	void testSetKlijent() {
		Klijent k = new Klijent(1L, "klijent ime", "klijent prezime", "klijent broj telefona", "klijent email", null);
		zt.setKlijent(k);
		
		assertTrue(k.getKlijentID().equals(zt.getKlijent().getKlijentID()));
		assertEquals(k.getIme(), zt.getKlijent().getIme());
		assertEquals(k.getPrezime(), zt.getKlijent().getPrezime());
		assertEquals(k.getEmail(), zt.getKlijent().getEmail());
		assertEquals(k.getBrojTelefona(), zt.getKlijent().getBrojTelefona());
		
	}

	@Test
	void testSetTrening() {		
		Trening t = new Trening(1L, "trening 1", null);
		zt.setTrening(t);
		
		assertTrue(t.getTreningID().equals(zt.getTrening().getTreningID()));
		assertEquals(t.getNazivTreninga(), zt.getTrening().getNazivTreninga());
	}
}
