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

    private long treningID;
    private String nazivTreninga;
    private VrstaTreninga vrstaTreninga;

    public Trening() {
    }

    public Trening(long treningID, String nazivTreninga, VrstaTreninga vrstaTreninga) {
        this.treningID = treningID;
        this.nazivTreninga = nazivTreninga;
        this.vrstaTreninga = vrstaTreninga;
    }

    @Override
    public String vratiUpitZaSve() {
        return "SELECT * FROM TRENING TK JOIN "
                + "VRSTATRENINGA VT ON (TK.VRSTATRENINGAID = VT.VRSTATRENINGAID)";
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
    public PreparedStatement vratiUpitZaUbacivanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("INSERT INTO TRENING("
                        + "NAZIVTRENINGA,VRSTATRENINGAID) "
                        + "VALUES (?,?)");
        
        ps.setString(1, nazivTreninga);
        ps.setLong(2, vrstaTreninga.getVrstaTreningaID());
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaIzmenu(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("UPDATE TRENING SET nazivTreninga=?, "
                        + "vrstaTreningaID=? "
                        + "WHERE treningid = ?");
        
        ps.setString(1, nazivTreninga);
        ps.setLong(2, vrstaTreninga.getVrstaTreningaID());
        ps.setLong(3, treningID);
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaBrisanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("DELETE FROM TRENING WHERE TRENINGID=?");
        
        ps.setLong(1, treningID);
        
        return ps;
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

    

    public long getTreningID() {
        return treningID;
    }

    public void setTreningID(long treningID) {
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
    
}
