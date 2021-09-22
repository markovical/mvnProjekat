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

    private long vrstaTreningaID;
    private String nazivVrsteTreninga;

    public VrstaTreninga() {
    }

    public VrstaTreninga(long vrstaTreningaID, String nazivVrsteTreninga) {
        this.vrstaTreningaID = vrstaTreningaID;
        this.nazivVrsteTreninga = nazivVrsteTreninga;
    }
    
    
    @Override
    public String vratiUpitZaSve() {
        return "SELECT * FROM VRSTATRENINGA";
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
    public PreparedStatement vratiUpitZaUbacivanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("INSERT INTO VrstaTreninga("
                        + "NazivVrsteTreninga) "
                        + "VALUES (?)");
        
        ps.setString(1, nazivVrsteTreninga);
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaIzmenu(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("UPDATE VrstaTreninga SET nazivVrsteTreninga=? "
                        + "WHERE tipKlijentaID = ?");
        
        ps.setString(1, nazivVrsteTreninga);
        ps.setLong(2, vrstaTreningaID);
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaBrisanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("DELETE FROM VrstaTreninga WHERE vrstaTreningaID=?");
        
        ps.setLong(1, vrstaTreningaID);
        
        return ps;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
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

    public long getVrstaTreningaID() {
        return vrstaTreningaID;
    }

    public void setVrstaTreningaID(long vrstaTreningaID) {
        this.vrstaTreningaID = vrstaTreningaID;
    }

    public String getNazivVrsteTreninga() {
        return nazivVrsteTreninga;
    }

    public void setNazivVrsteTreninga(String nazivVrsteTreninga) {
        this.nazivVrsteTreninga = nazivVrsteTreninga;
    }

    @Override
    public String toString() {
        return nazivVrsteTreninga;
    }
    
    
    
}
