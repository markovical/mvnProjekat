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
    
    private Long tipKlijentaID;
    private String nazivTipaKlijenta;
    private String opis;

    public TipKlijenta() {
    }

    public TipKlijenta(Long tipKlijentaID, String nazivTipaKlijenta, String opis) {
        this.tipKlijentaID = tipKlijentaID;
        this.nazivTipaKlijenta = nazivTipaKlijenta;
        this.opis = opis;
    }

    public Long getTipKlijentaID() {
        return tipKlijentaID;
    }

    public void setTipKlijentaID(Long tipKlijentaID) {
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
