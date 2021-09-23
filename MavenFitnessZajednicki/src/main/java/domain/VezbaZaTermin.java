/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Klasa koja predstavlja vezbe za termin
 * 
 * Trening ima atribute:
 * zakazanTermin tipa ZakazTermin, odnosno objekat klase ZakazanTermin
 * vezba tipa String
 * broj ponavljanja kao int
 */
public class VezbaZaTermin extends AbstractDomainObject implements Serializable {
	/**
     * Zakazan Termin tipa ZakazanTermin
     */
    private ZakazanTermin zakazanTermin;
    /**
     * Redni broj vezbe tipa int
     */
    private int redniBroj;
    /**
     * Vezba tipa String
     */
    private String vezba;
    /**
     * Broj ponavljanja vezbe tipa int
     */
    private int brojPonavljanja;
    /**
   	 * Konstruktor koji samo inicijalizuje objekat klase VezbaZaTermin	.
   	 */
    public VezbaZaTermin() {
    }
    /**
   	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
   	 * vezba za termin.
   	 * 
   	 * @param zakazanTermin
   	 *           Zakazan Termin kao ZakazanTermin.
   	 * @param redniBroj
   	 *           Redni broj vezbe kao int.
   	 * @param vezba
   	 *            Vezba kao String.
   	 * @param brojPonavljanja
   	 *           Broj ponavljanja vezbe kao int.
   	 */
    public VezbaZaTermin(ZakazanTermin zakazanTermin, int redniBroj, String vezba, int brojPonavljanja) {
        this.zakazanTermin = zakazanTermin;
        this.redniBroj = redniBroj;
        this.vezba = vezba;
        this.brojPonavljanja = brojPonavljanja;
    }
    /**
   	 * Vraæa objekat klase ZakazanTermin.
   	 * 
   	 * @return  Šifra treninga tipa Long.
   	 */
    public ZakazanTermin getZakazanTermin() {
        return zakazanTermin;
    }
    /**
   	 * Postavlja zakazan termin na novu vrednost.
   	 * 
   	 * @param zakazanTermin
   	 *           Zakazan Termin kao objekat klase ZakazanTermin.
   	 */
    public void setZakazanTermin(ZakazanTermin zakazanTermin) {
        this.zakazanTermin = zakazanTermin;
    }
    /**
   	 * Vraæa redni broj vezbe.
   	 * 
   	 * @return    Redni broj vezbe tipa int.
   	 */
    public int getRedniBroj() {
        return redniBroj;
    }
    /**
   	 * Postavlja redni broj na novu vrednost.
   	 * 
   	 * @param redniBroj
   	 *           Redni broj vezbe kao int.
   	 */
    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }
    /**
   	 * Vraæa vezbu.
   	 * 
   	 * @return   Vezba kao String.
   	 */
    
    public String getVezba() {
        return vezba;
    }

    public void setVezba(String vezba) {
        this.vezba = vezba;
    }
    /**
   	 * Vraæa broj ponavljanja vezbe.
   	 * 
   	 * @return   Broj ponavljannja kao int.
   	 */
    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }
    /**
   	 * Postavlja broj ponavljanja na novu vrednost.
   	 * 
   	 * @param brojPonavljanja
   	 *           Broj ponavljanja vezbe kao int.
   	 */
    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    @Override
    public String nazivTabele() {
        return " vezbezatermin ";
    }

    @Override
    public String alijas() {
        return " vzt ";
    }

    @Override
    public String join() {
        return " JOIN zakazantermin zt ON (zt.zakazanterminid = vzt.zakazanterminid) "
                + "JOIN administrator a ON (zt.administratorid = a.administratorid) "
                + "JOIN klijent k ON (zt.klijentid = k.klijentid) "
                + "JOIN trening t ON (zt.treningid = t.treningid) "
                + "JOIN vrstatreninga vt ON (t.vrstatreningaid = vt.vrstatreningaid) "
                + "JOIN tipklijenta tk ON (tk.tipklijentaid = k.tipklijentaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

            VrstaTreninga vt = new VrstaTreninga(rs.getLong("VrstaTreningaID"),
                    rs.getString("NazivVrsteTreninga"));

            Trening trening = new Trening(rs.getLong("TreningID"),
                    rs.getString("NazivTreninga"), vt);

            TipKlijenta tipKlijenta = new TipKlijenta(rs.getLong("TipKlijentaID"),
                    rs.getString("NazivTipaKlijenta"), rs.getString("Opis"));

            Klijent k = new Klijent(rs.getLong("KlijentID"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getString("BrojTelefona"),
                    rs.getString("Email"), tipKlijenta);

            ZakazanTermin zt = new ZakazanTermin(rs.getLong("ZakazanTerminID"),
                    rs.getTimestamp("DatumVreme"),
                    a, k, trening, null);

            VezbaZaTermin vzt = new VezbaZaTermin(zt, rs.getInt("RedniBroj"),
                    rs.getString("Vezba"), rs.getInt("BrojPonavljanja"));

            lista.add(vzt);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ZakazanTerminID, RedniBroj, Vezba, BrojPonavljanja) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ZakazanTerminID = " + zakazanTermin.getZakazanTerminID() + " AND "
                + "RedniBroj = " + redniBroj;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + zakazanTermin.getZakazanTerminID() + ", " + redniBroj + ", "
                + "'" + vezba + "', " + brojPonavljanja + " ";
        
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

}
