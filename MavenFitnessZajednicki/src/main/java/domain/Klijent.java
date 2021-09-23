/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

/**
 * Klasa koja predstavlja jednog administratora
 * 
 * Administrator ima atribute:
 * klijentID tipa Long
 * ime tipa String
 * prezime tipa String
 * brojTelefona tipa String
 * email tipa String
 * tipKlijenta objekat klase TipKlijenta
 */
public class Klijent extends AbstractDomainObject implements Serializable {
	/**
	 * Jedinstvena šifra klijenta, tipa Long.
	 */
    private Long klijentID;
    /**
     * Ime klijenta tipa String
     */
    private String ime;
    /**
     *   Prezime klijenta tipa String
     */
    private String prezime;
    /**
     *   Broj telefona klijenta tipa String
     */
    private String brojTelefona;
    /**
     *  Email klijenta tipa String
     */
    private String email;
    /**
     *   Tip klijenta kao objekat klase TipKlijenta
     */
    private TipKlijenta tipKlijenta;
    /**
	 * Konstruktor koji samo inicijalizuje objekat klase Klijent.
	 */
    public Klijent() {
    }
    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
	 * Klijenta.
	 * 
	 * @param klijentID
	 *            Šifra klijenta tipa Long.
	 * @param ime
	 *            Ime klijenta tipa String.
	 * @param prezime
	 *            Prezime klijenta tipa String
	 * @param brojTelefona
	 *           Broj telefona klijenta tipa String
	 * @param email
	 * 			  Email klijenta tipa String
	 * @param tipKlijenta
	 * 			  Tip klijenta kao objekat klase TipKlijenta
	 
	 */
    
    public Klijent(Long klijentID, String ime, String prezime, String brojTelefona, String email, TipKlijenta tipKlijenta) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.tipKlijenta = tipKlijenta;
    }
    /**
  	 * Vraća sifru klijenta.
  	 * 
  	 * @return  Šifra klijenta tipa Long.
  	 */
    public Long getKlijentID() {
        return klijentID;
    }
    /**
	 * Postavlja šifru klijenta na novu vrednost.
	 * 
	 * @param klijentID
	 *            Šifra klijenta tipa Long.
	 */
    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }
    /**
  	 * Vraća ime klijenta.
  	 * 
  	 * @return  Ime klijenta tipa String.
  	 */
    public String getIme() {
        return ime;
    }
    /**
  	 * Postavlja ime klijenta na novu vrednost.
  	 * 
  	 * @param ime
  	 *           ime klijenta tipa String.
  	 */
    public void setIme(String ime) {
        this.ime = ime;
    }
    /**
  	 * Vraća prezime klijenta.
  	 * 
  	 * @return  Prezime klijenta tipa String.
  	 */
    public String getPrezime() {
        return prezime;
    }
    /**
  	 * Postavlja prezime klijenta na novu vrednost.
  	 * 
  	 * @param prezime
  	 *           Prezime klijenta tipa String.
  	 */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    /**
  	 * Vraća broj telefona klijenta.
  	 * 
  	 * @return  Broj telefona klijenta tipa String.
  	 */
    public String getBrojTelefona() {
        return brojTelefona;
    }
    /**
  	 * Postavlja broj telefona klijenta na novu vrednost.
  	 * 
  	 * @param brojTelefona
  	 *           Broj telefona klijenta tipa String.
  	 */
    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }
    /**
  	 * Vraća email klijenta.
  	 * 
  	 * @return  Email klijenta tipa String.
  	 */
    public String getEmail() {
        return email;
    }
    /**
  	 * Postavlja email klijenta na novu vrednost.
  	 * 
  	 * @param email
  	 *           Email klijenta tipa String.
  	 */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Klijent other = (Klijent) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.brojTelefona, other.brojTelefona)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.tipKlijenta, other.tipKlijenta)) {
            return false;
        }
        return true;
    }
    /**
	 * Vraća tip klijenta.
	 * 
	 * @return Tip klijenta kao objekat klase TipKlijenta
	 *         
	 */
    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }
    /**
	 * Postavlja tip klijenta na novu vrednost.
	 * 
	 * @param tipKlijenta
	 *            Tip klijenta kao objekat klase TipKlijenta
	 */
    public void setTipKlijenta(TipKlijenta tipKlijenta) {
        this.tipKlijenta = tipKlijenta;
    }

    @Override
    public String toString() {
        return ime + " " + prezime;
    }

    @Override
    public String nazivTabele() {
        return " klijent ";
    }

    @Override
    public String alijas() {
        return " k ";
    }

    @Override
    public String join() {
        return " join tipklijenta tk on (k.tipklijentaid = tk.tipklijentaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            
            TipKlijenta tk = new TipKlijenta(rs.getLong("TipKlijentaID"),
                    rs.getString("NazivTipaKlijenta"), rs.getString("Opis"));
            
            Klijent k = new Klijent(rs.getLong("KlijentID"), rs.getString("Ime"), 
                    rs.getString("Prezime"), rs.getString("BrojTelefona"),
                    rs.getString("Email"), tk);
            
            lista.add(k);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, BrojTelefona, Email, TipKlijentaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " KlijentID = " + klijentID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + brojTelefona + "', '" + email + "', " + tipKlijenta.getTipKlijentaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        return " BrojTelefona = '" + brojTelefona + "', Email = '" + email + "', "
                + "TipKlijentaID = " + tipKlijenta.getTipKlijentaID();
    }

}
