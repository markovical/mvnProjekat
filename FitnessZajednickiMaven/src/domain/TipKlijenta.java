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
public class TipKlijenta extends AbstractDomainObject implements Serializable {
    
    private long tipKlijentaID;
    private String nazivTipaKlijenta;
    private String opis;

    public TipKlijenta() {
    }

    public TipKlijenta(long tipKlijentaID, String nazivTipaKlijenta, String opis) {
        this.tipKlijentaID = tipKlijentaID;
        this.nazivTipaKlijenta = nazivTipaKlijenta;
        this.opis = opis;
    }
    

    @Override
    public String vratiUpitZaSve() {
        return "SELECT * FROM TIPKLIJENTA";
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
    public PreparedStatement vratiUpitZaUbacivanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("INSERT INTO TIPKLIJENTA("
                        + "NazivTipaKlijenta, Opis) "
                        + "VALUES (?,?)");
        
        ps.setString(1, nazivTipaKlijenta);
        ps.setString(2, opis);
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaIzmenu(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("UPDATE TIPKLIJENTA SET nazivTipaKlijenta=?, opis=? "
                        + "WHERE tipKlijentaID = ?");
        
        ps.setString(1, nazivTipaKlijenta);
        ps.setString(2, opis);
        ps.setLong(3, tipKlijentaID);
        
        return ps;
    }

    @Override
    public PreparedStatement vratiUpitZaBrisanje(Connection con) throws SQLException {
        PreparedStatement ps = 
                con.prepareStatement("DELETE FROM TIPKLIJENTA WHERE tipKlijentaID=?");
        
        ps.setLong(1, tipKlijentaID);
        
        return ps;
    }

    public long getTipKlijentaID() {
        return tipKlijentaID;
    }

    public void setTipKlijentaID(long tipKlijentaID) {
        this.tipKlijentaID = tipKlijentaID;
    }

    public String getNazivTipaKlijenta() {
        return nazivTipaKlijenta;
    }

    public void setNazivTipaKlijenta(String nazivTipaKlijenta) {
        this.nazivTipaKlijenta = nazivTipaKlijenta;
    }

    public String getOpis() {
        return opis;
    }

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
    
    
    
}
