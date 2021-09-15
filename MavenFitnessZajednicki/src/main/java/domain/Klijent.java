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
 *
 * @author 38160
 */
public class Klijent extends AbstractDomainObject implements Serializable {

    private Long klijentID;
    private String ime;
    private String prezime;
    private String brojTelefona;
    private String email;
    private TipKlijenta tipKlijenta;

    public Klijent() {
    }

    public Klijent(Long klijentID, String ime, String prezime, String brojTelefona, String email, TipKlijenta tipKlijenta) {
        this.klijentID = klijentID;
        this.ime = ime;
        this.prezime = prezime;
        this.brojTelefona = brojTelefona;
        this.email = email;
        this.tipKlijenta = tipKlijenta;
    }

    public Long getKlijentID() {
        return klijentID;
    }

    public void setKlijentID(Long klijentID) {
        this.klijentID = klijentID;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

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

    public TipKlijenta getTipKlijenta() {
        return tipKlijenta;
    }

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
