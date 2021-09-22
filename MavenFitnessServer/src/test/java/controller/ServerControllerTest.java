package controller;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import db.DBBroker;
import domain.Administrator;
import domain.Klijent;
import domain.TipKlijenta;
import domain.Trening;
import domain.VrstaTreninga;
import domain.ZakazanTermin;

class ServerControllerTest {
	private static Administrator a1, a2;
	private static TipKlijenta tk1, tk2;
	private static VrstaTreninga vt1, vt2;
	private static Klijent k1, k2;
	private static Trening t1, t2;
	private static ZakazanTermin zt1;
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tk1 = new TipKlijenta(1L, "tip 1", "opis 1");
		tk2 = new TipKlijenta(2L, "tip 2", "opis 2");
		vt1 = new VrstaTreninga(1L, "vrsta 1");
		vt2 = new VrstaTreninga(2L, "vrsta 2");		
		
		a1 = new Administrator(1L, "admin1 ime", "admin1 prezime", "admin1", "admin1");
		ServerController.getInstance().addAdministrator(a1);		
		
		a2 = new Administrator(2L, "admin2 ime", "admin2 prezime", "admin2", "admin2");
		ServerController.getInstance().addAdministrator(a2);		
		
		k1 = new Klijent(1L, "ime 1", "prezime 1", "061 111 222", "test1@tes.rs", tk1);
		ServerController.getInstance().addKlijent(k1);
		
		k2 = new Klijent(2L, "ime 2", "prezime 2", "061 111 222", "test2@tes.rs", tk2);
		ServerController.getInstance().addKlijent(k2);
		
		t1 = new Trening(1L, "trening 1", vt1);
		ServerController.getInstance().addTrening(t1);
		
		t2 = new Trening(2L, "trening 2", vt2);
		ServerController.getInstance().addTrening(t2);
		
		zt1 = new ZakazanTermin(1L, new Date(), a2, k2, t2, null);
		ServerController.getInstance().addZakazanTermin(zt1);		
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		ServerController.getInstance().deleteAdministrator(a1);
		ServerController.getInstance().deleteKlijent(k1);
		ServerController.getInstance().deleteTrening(t1);
		ServerController.getInstance().deleteZakazanTermin(zt1);		
	}

	@Test
	void testAddAdministrator() throws Exception {		
		Administrator a3 = new Administrator(3L, "admin3 ime", "admin3 prezime", "admin3", "admin3");
		ServerController.getInstance().addAdministrator(a3);
		assertFalse(DBBroker.getInstance().select(a3).isEmpty());
		ServerController.getInstance().deleteAdministrator(a3);
	}

	@Test
	void testAddKlijent() throws Exception {
		Klijent k = new Klijent(3L, "klijent ime", "klijent prezime", "063111222", "test@test.rs", tk1);
		ServerController.getInstance().addKlijent(k);
		assertFalse(DBBroker.getInstance().select(k).isEmpty());
		ServerController.getInstance().deleteKlijent(k);
	}

	@Test
	void testAddTrening() throws Exception {
		Trening t = new  Trening(3L, "trening", vt1);
		ServerController.getInstance().addTrening(t);
		assertFalse(DBBroker.getInstance().select(t).isEmpty());
		ServerController.getInstance().deleteTrening(t);
	}

	@Test
	void testAddZakazanTermin() throws Exception {
	    Date date = new Date();
		ZakazanTermin zt = new  ZakazanTermin(2L, date, a1, k1, t1, null);
		ServerController.getInstance().addZakazanTermin(zt);
		assertFalse(DBBroker.getInstance().select(zt).isEmpty());
		ServerController.getInstance().deleteZakazanTermin(zt);
	}
	
	@Test
	void testDeleteAdministrator() throws Exception{
		ServerController.getInstance().deleteAdministrator(a2);
		assertTrue(DBBroker.getInstance().select(a2).isEmpty());
	}

	@Test
	void testDeleteKlijent() throws Exception {
		ServerController.getInstance().deleteKlijent(k2);
		assertTrue(DBBroker.getInstance().select(k2).isEmpty());
	}

	@Test
	void testDeleteTrening() throws Exception {
		ServerController.getInstance().deleteTrening(t2);
		assertTrue(DBBroker.getInstance().select(t2).isEmpty());
	}

	@Test
	void testDeleteZakazanTermin() throws Exception {
		ServerController.getInstance().deleteZakazanTermin(zt1);
		assertTrue(DBBroker.getInstance().select(zt1).isEmpty());
	}	

	@Test
	void testEditAdministrator() throws Exception {
		Administrator a = ServerController.getInstance().getAllAdministrator().get(0);
		a.setIme("izmenjeno ime");
		ServerController.getInstance().editAdministrator(a);
		Administrator aNakonIzmene = ServerController.getInstance().getAllAdministrator().get(0);
		assertEquals("izmenjeno ime", aNakonIzmene.getIme());		
	}

	@Test
	void testEditKlijent() throws Exception {
		Klijent k = ServerController.getInstance().getAllKlijent().get(0);
		k.setIme("izmenjeno ime");
		ServerController.getInstance().editKlijent(k);
		Klijent kNakonIzmene = ServerController.getInstance().getAllKlijent().get(0);
		assertEquals("izmenjeno ime", kNakonIzmene.getIme());	
	}

	@Test
	void testEditTrening() throws Exception {
		Trening t = ServerController.getInstance().getAllTrening().get(0);
		t.setNazivTreninga("izmenjen naziv");
		ServerController.getInstance().editTrening(t);
		Trening tNakonIzmene = ServerController.getInstance().getAllTrening().get(0);
		assertEquals("izmenjen naziv", tNakonIzmene.getNazivTreninga());	
	}

	@Test
	void testGetAllAdministrator() throws Exception {
		assertFalse(ServerController.getInstance().getAllAdministrator().isEmpty());
	}

	@Test
	void testGetAllKlijent() throws Exception {
		assertFalse(ServerController.getInstance().getAllKlijent().isEmpty());
	}

	@Test
	void testGetAllTrening() throws Exception {
		assertFalse(ServerController.getInstance().getAllTrening().isEmpty());
	}

	@Test
	void testGetAllZakazanTermin() throws Exception {
		assertFalse(ServerController.getInstance().getAllZakazanTermin().isEmpty());
	}	
}
