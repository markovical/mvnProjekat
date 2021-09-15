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
 *
 * @author aca99
 */
public class Trening extends AbstractDomainObject implements Serializable {

    private Long treningID;
    private String nazivTreninga;
    private VrstaTreninga vrstaTreninga;

    public Trening() {
    }

    public Trening(Long treningID, String nazivTreninga, VrstaTreninga vrstaTreninga) {
        this.treningID = treningID;
        this.nazivTreninga = nazivTreninga;
        this.vrstaTreninga = vrstaTreninga;
    }

    public VrstaTreninga getVrstaTreninga() {
        return vrstaTreninga;
    }

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

    public Long getTreningID() {
        return treningID;
    }

    public void setTreningID(Long treningID) {
        this.treningID = treningID;
    }

    public String getNazivTreninga() {
        return nazivTreninga;
    }

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
