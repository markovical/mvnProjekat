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
import java.util.Objects;

/**
 * Klasa koja predstavlja tip klijenta
 * 
 * Tip klijenta ima atribute:
 * tipKlijentaID tipa Long
 * nazivTipaKlijenta tipa String
 * opis tipa String
 */
public class TipKlijenta extends AbstractDomainObject implements Serializable {
	/**
	 * Jedinstvena šifra tipa klijenta, tipa Long.
	 */
    private Long tipKlijentaID;
    /**
     * Naziv tipa klijenta tipa String
     */
    private String nazivTipaKlijenta;
    /**
     * Opis tipa klijenta tipa String
     */
    private String opis;
    /**
  	 * Konstruktor koji samo inicijalizuje objekat klase TipKlijenta.
  	 */
    public TipKlijenta() {
    }
    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
	 * tipa klijenta.
	 * 
	 * @param tipKlijentaID
	 *            Šifra  tipa klijenta tipa Long.
	 * @param nazivTipaKlijenta
	 *            Naziv tipa klijenta tipa String.
	 * @param opis
	 *           Opis tipa klijenta tipa String.
	 */
    public TipKlijenta(Long tipKlijentaID, String nazivTipaKlijenta, String opis) {
        this.tipKlijentaID = tipKlijentaID;
        this.nazivTipaKlijenta = nazivTipaKlijenta;
        this.opis = opis;
    }
    /**
  	 * Vraća id(šifru) tipa klijenta.
  	 * 
  	 * @return  Šifra tipa klijenta tipa Long.
  	 */
    public Long getTipKlijentaID() {
        return tipKlijentaID;
    }
    /**
   	 * Postavlja šifru tipa klijenta na novu vrednost.
   	 * 
   	 * @param tipKlijentaID
   	 *            Šifra tipa klijenta tipa Long.
   	 */
    public void setTipKlijentaID(Long tipKlijentaID) {
        this.tipKlijentaID = tipKlijentaID;
    }
    /**
  	 * Vraća naziv tipa klijenta.
  	 * 
  	 * @return    Naziv tipa klijenta tipa String.
  	 */
    public String getNazivTipaKlijenta() {
        return nazivTipaKlijenta;
    }
    /**
   	 * Postavlja naziv tipa klijenta na novu vrednost.
   	 * 
   	 * @param tipKlijentaID
   	 *            Naziv tipa klijenta tipa String.
   	 */
    public void setNazivTipaKlijenta(String nazivTipaKlijenta) {
        this.nazivTipaKlijenta = nazivTipaKlijenta;
    }
    /**
  	 * Vraća opis tipa klijenta.
  	 * 
  	 * @return    Opis tipa klijenta tipa String.
  	 */
    public String getOpis() {
        return opis;
    }
    /**
   	 * Postavlja opis tipa klijenta na novu vrednost.
   	 * 
   	 * @param opis
   	 *            Opis tipa klijenta tipa String.
   	 */
    public void setOpis(String opis) {
        this.opis = opis;
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
        final TipKlijenta other = (TipKlijenta) obj;
        if (!Objects.equals(this.nazivTipaKlijenta, other.nazivTipaKlijenta)) {
            return false;
        }
        if (!Objects.equals(this.opis, other.opis)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return nazivTipaKlijenta;
    }

    @Override
    public String nazivTabele() {
        return " tipklijenta ";
    }

    @Override
    public String alijas() {
        return " tk ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            TipKlijenta tk = new TipKlijenta(rs.getLong("TipKlijentaID"), 
                    rs.getString("NazivTipaKlijenta"), rs.getString("Opis"));
            
            lista.add(tk);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TipKlijentaID = " + tipKlijentaID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "";
    } 

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }
    
}
