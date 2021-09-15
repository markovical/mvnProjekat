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

/**
 *
 * @author aca99
 */
public class VezbaZaTermin extends AbstractDomainObject implements Serializable {

    private ZakazanTermin zakazanTermin;
    private int redniBroj;
    private String vezba;
    private int brojPonavljanja;

    public VezbaZaTermin() {
    }

    public VezbaZaTermin(ZakazanTermin zakazanTermin, int redniBroj, String vezba, int brojPonavljanja) {
        this.zakazanTermin = zakazanTermin;
        this.redniBroj = redniBroj;
        this.vezba = vezba;
        this.brojPonavljanja = brojPonavljanja;
    }

    public ZakazanTermin getZakazanTermin() {
        return zakazanTermin;
    }

    public void setZakazanTermin(ZakazanTermin zakazanTermin) {
        this.zakazanTermin = zakazanTermin;
    }

    public int getRedniBroj() {
        return redniBroj;
    }

    public void setRedniBroj(int redniBroj) {
        this.redniBroj = redniBroj;
    }

    public String getVezba() {
        return vezba;
    }

    public void setVezba(String vezba) {
        this.vezba = vezba;
    }

    public int getBrojPonavljanja() {
        return brojPonavljanja;
    }

    public void setBrojPonavljanja(int brojPonavljanja) {
        this.brojPonavljanja = brojPonavljanja;
    }

    @Override
    public String nazivTabele() {
        return " vezbezatermin ";
    }

    @Override
    public String alijas() {
        return " vzt ";
    }

    @Override
    public String join() {
        return " JOIN zakazantermin zt ON (zt.zakazanterminid = vzt.zakazanterminid) "
                + "JOIN administrator a ON (zt.administratorid = a.administratorid) "
                + "JOIN klijent k ON (zt.klijentid = k.klijentid) "
                + "JOIN trening t ON (zt.treningid = t.treningid) "
                + "JOIN vrstatreninga vt ON (t.vrstatreningaid = vt.vrstatreningaid) "
                + "JOIN tipklijenta tk ON (tk.tipklijentaid = k.tipklijentaid) ";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();

        while (rs.next()) {
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"),
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));

            VrstaTreninga vt = new VrstaTreninga(rs.getLong("VrstaTreningaID"),
                    rs.getString("NazivVrsteTreninga"));

            Trening trening = new Trening(rs.getLong("TreningID"),
                    rs.getString("NazivTreninga"), vt);

            TipKlijenta tipKlijenta = new TipKlijenta(rs.getLong("TipKlijentaID"),
                    rs.getString("NazivTipaKlijenta"), rs.getString("Opis"));

            Klijent k = new Klijent(rs.getLong("KlijentID"), rs.getString("Ime"),
                    rs.getString("Prezime"), rs.getString("BrojTelefona"),
                    rs.getString("Email"), tipKlijenta);

            ZakazanTermin zt = new ZakazanTermin(rs.getLong("ZakazanTerminID"),
                    rs.getTimestamp("DatumVreme"),
                    a, k, trening, null);

            VezbaZaTermin vzt = new VezbaZaTermin(zt, rs.getInt("RedniBroj"),
                    rs.getString("Vezba"), rs.getInt("BrojPonavljanja"));

            lista.add(vzt);
        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (ZakazanTerminID, RedniBroj, Vezba, BrojPonavljanja) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ZakazanTerminID = " + zakazanTermin.getZakazanTerminID() + " AND "
                + "RedniBroj = " + redniBroj;
    }

    @Override
    public String vrednostiZaInsert() {
        return " " + zakazanTermin.getZakazanTerminID() + ", " + redniBroj + ", "
                + "'" + vezba + "', " + brojPonavljanja + " ";
        
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

}
