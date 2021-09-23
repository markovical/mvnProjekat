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
 *
 * @author aca99
 */
public class VrstaTreninga extends AbstractDomainObject implements Serializable {
	 /**
   	 *   Jedinstvena šifra vrste treninga, tipa Long.
   	 */
    private Long vrstaTreningaID;
    /**
     * Naziv vrste treninga, tipa String
     */
    private String nazivVrsteTreninga;
    /**
   	 * Konstruktor koji samo inicijalizuje objekat klase VrstaTreninga.
   	 */
    public VrstaTreninga() {
    }
    /**
   	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
   	 * treninga.
   	 * 
   	 * @param vrstaTreningaID
   	 *            Šifra  vrste treninga tipa Long.
   	 * @param nazivVrsteTreninga
   	 *            Naziv vrste treninga tipa String.
   	 */
    public VrstaTreninga(long vrstaTreningaID, String nazivVrsteTreninga) {
        this.vrstaTreningaID = vrstaTreningaID;
        this.nazivVrsteTreninga = nazivVrsteTreninga;
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
        final VrstaTreninga other = (VrstaTreninga) obj;
        if (!Objects.equals(this.nazivVrsteTreninga, other.nazivVrsteTreninga)) {
            return false;
        }
        return true;
    }
    /**
  	 * Vraæa id(šifru) vrste treninga.
  	 * 
  	 * @return  Šifra vrste treninga tipa Long.
  	 */
    public Long getVrstaTreningaID() {
        return vrstaTreningaID;
    }
    /**
   	 * Postavlja jedinstvenu šifru vrste treninge na novu vrednost.
   	 * 
   	 * @param vrstaTreningaID
   	 *           Jedinstvena šifra vrste treninga kao Long.
   	 */
    public void setVrstaTreningaID(Long vrstaTreningaID) {
        this.vrstaTreningaID = vrstaTreningaID;
    }
    /**
  	 * Vraæa naziv vrste treninga.
  	 * 
  	 * @return  Naziv vrste treninga tipa String.
  	 */
    public String getNazivVrsteTreninga() {
        return nazivVrsteTreninga;
    }
    /**
   	 * Postavlja naziv vrste treninga na novu vrednost.
   	 * 
   	 * @param nazivVrsteTreninga
   	 *            Naziv vrste treninga tipa String.
   	 */
    public void setNazivVrsteTreninga(String nazivVrsteTreninga) {
        this.nazivVrsteTreninga = nazivVrsteTreninga;
    }

    @Override
    public String toString() {
        return nazivVrsteTreninga;
    }
    
    @Override
    public String nazivTabele() {
        return " vrstatreninga ";
    }

    @Override
    public String alijas() {
        return " vt ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            VrstaTreninga vt = new VrstaTreninga(rs.getLong("VrstaTreningaID"), 
                    rs.getString("NazivVrsteTreninga"));
            
            lista.add(vt);
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
        return " VrstaTreningaID = " + vrstaTreningaID;
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
