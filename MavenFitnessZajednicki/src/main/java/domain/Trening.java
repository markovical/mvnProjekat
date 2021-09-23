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
import java.util.Date;
import java.util.Objects;

/**
 * Klasa koja predstavlja trening
 * 
 * Trening ima atribute:
 * treningID tipa Long
 * nazivTreninga tipa String
 * vrstaTreninga objekat klase VrstaTreninga
 */
public class Trening extends AbstractDomainObject implements Serializable {
	/**
	 * Jedinstvena šifra treninga, tipa Long.
	 */
    private Long treningID;
    /**
     * Naziv treninga tipa String
     */
    private String nazivTreninga;
    /**
     *  Vrsta treninga kao objekat klase VrstaTreninga
     */
    private VrstaTreninga vrstaTreninga;
    /**
   	 * Konstruktor koji samo inicijalizuje objekat klase Trening.
   	 */
    public Trening() {
    }
    /**
   	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
   	 * treninga.
   	 * 
   	 * @param treningID
   	 *            Šifra treninga tipa Long.
   	 * @param nazivTreninga
   	 *            Naziv treninga tipa String.
   	 * @param vrstaTreninga
   	 *            Vrsta treninga kao objekat klase VrstaTreninga.
   	 */
    public Trening(Long treningID, String nazivTreninga, VrstaTreninga vrstaTreninga) {
        this.treningID = treningID;
        this.nazivTreninga = nazivTreninga;
        this.vrstaTreninga = vrstaTreninga;
    }
    /**
  	 * Vraća id(šifru) treninga.
  	 * 
  	 * @return  Šifra treninga tipa Long.
  	 */
    public VrstaTreninga getVrstaTreninga() {
        return vrstaTreninga;
    }
    /**
   	 * Postavlja vrstu treninga na novu vrednost.
   	 * 
   	 * @param vrstaTreninga
   	 *            Vrsta treninga kao objekat klase VrstaTreninga.
   	 */
    public void setVrstaTreninga(VrstaTreninga vrstaTreninga) {
        this.vrstaTreninga = vrstaTreninga;
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
        final Trening other = (Trening) obj;
        if (!Objects.equals(this.nazivTreninga, other.nazivTreninga)) {
            return false;
        }
        if (!Objects.equals(this.vrstaTreninga, other.vrstaTreninga)) {
            return false;
        }
        return true;
    }
    /**
  	 * Vraća sifru treninga.
  	 * 
  	 * @return  Šifra treninga tipa Long.
  	 */
    public Long getTreningID() {
        return treningID;
    }
    /**
   	 * Postavlja šifru treninga na novu vrednost.
   	 * 
   	 * @param treningID
   	 *            Šifra treninga tipa Long.
   	 */
    public void setTreningID(Long treningID) {
        this.treningID = treningID;
    }
    /**
  	 * Vraća naziv treninga.
  	 * 
  	 * @return  Naziv treninga tipa String.
  	 */
    public String getNazivTreninga() {
        return nazivTreninga;
    }
    /**
   	 * Postavlja naziv treninga na novu vrednost.
   	 * 
   	 * @param nazivTreninga
   	 *            Naziv treninga tipa String.
   	 */
    public void setNazivTreninga(String nazivTreninga) {
        this.nazivTreninga = nazivTreninga;
    }
    
    @Override
    public String toString() {
        return nazivTreninga;
    }
    
    @Override
    public String nazivTabele() {
        return " trening ";
    }

    @Override
    public String alijas() {
        return " t ";
    }

    @Override
    public String join() {
        return " join vrstatreninga vt on (vt.vrstatreningaid = t.vrstatreningaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            
            VrstaTreninga vt = new VrstaTreninga(rs.getLong("VrstaTreningaID"),
                    rs.getString("NazivVrsteTreninga"));
            
            Trening tk = new Trening(rs.getLong("TreningID"),
                    rs.getString("NazivTreninga"), vt);
            
            lista.add(tk);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (NazivTreninga, VrstaTreningaID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " TreningID = " + treningID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivTreninga + "', " + vrstaTreninga.getVrstaTreningaID();
    } 

    @Override
    public String vrednostiZaUpdate() {
        return " NazivTreninga = '" + nazivTreninga + "', VrstaTreningaID = " + vrstaTreninga.getVrstaTreningaID() + " ";
    }
    
    
}
