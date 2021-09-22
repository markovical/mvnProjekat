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
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author aca99
 */
public class ZakazanTermin extends AbstractDomainObject implements Serializable {

    private Long zakazanTerminID;
    private Date datumVreme;
    private Administrator administrator;
    private Klijent klijent;
    private Trening trening;
    private ArrayList<VezbaZaTermin> vezbeZaTermin;

    public ZakazanTermin() {
    }

    public ZakazanTermin(Long zakazanTerminID, Date datumVreme, Administrator administrator, Klijent klijent, Trening trening, ArrayList<VezbaZaTermin> vezbeZaTermin) {
        this.zakazanTerminID = zakazanTerminID;
        this.datumVreme = datumVreme;
        this.administrator = administrator;
        this.klijent = klijent;
        this.trening = trening;
        this.vezbeZaTermin = vezbeZaTermin;
    }

    public Long getZakazanTerminID() {
        return zakazanTerminID;
    }

    public void setZakazanTerminID(Long zakazanTerminID) {
        this.zakazanTerminID = zakazanTerminID;
    }

    public Date getDatumVreme() {
        return datumVreme;
    }

    public void setDatumVreme(Date datumVreme) {
        this.datumVreme = datumVreme;
    }

    public Administrator getAdministrator() {
        return administrator;
    }

    public void setAdministrator(Administrator administrator) {
        this.administrator = administrator;
    }

    public Klijent getKlijent() {
        return klijent;
    }

    public void setKlijent(Klijent klijent) {
        this.klijent = klijent;
    }

    public Trening getTrening() {
        return trening;
    }

    public void setTrening(Trening trening) {
        this.trening = trening;
    }

    public ArrayList<VezbaZaTermin> getVezbeZaTermin() {
        return vezbeZaTermin;
    }

    public void setVezbeZaTermin(ArrayList<VezbaZaTermin> vezbeZaTermin) {
        this.vezbeZaTermin = vezbeZaTermin;
    }

    @Override
    public String nazivTabele() {
        return " zakazantermin ";
    }

    @Override
    public String alijas() {
        return " zt ";
    }

    @Override
    public String join() {
        return "JOIN administrator a ON (a.administratorid = zt.administratorid) "
                + "JOIN klijent k ON (k.klijentid = zt.klijentid) "
                + "JOIN trening tk ON (tk.treningid = zt.treningid) "
                + "JOIN vrstatreninga vt ON (vt.vrstatreningaid = tk.vrstatreningaid) "
                + "JOIN tipklijenta tipkl ON (tipkl.tipklijentaid = k.tipklijentaid) "
                + "JOIN vezbezatermin vzt ON (vzt.zakazanterminid = zt.zakazanterminid) "
                + "GROUP BY zt.zakazanterminid";
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

            ArrayList<VezbaZaTermin> vezbeZaTermin = new ArrayList<>();
            vezbeZaTermin.add(vzt);
            zt.setVezbeZaTermin(vezbeZaTermin);

            if (lista.contains(zt)) {
                int index = lista.indexOf(zt);
                ZakazanTermin zakTer = (ZakazanTermin) lista.get(index);
                vzt.setZakazanTermin(zakTer);
                zakTer.getVezbeZaTermin().add(vzt);
            } else {
                lista.add(zt);
            }

        }

        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (DatumVreme, AdministratorID, KlijentID, TreningID) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " ZakazanTerminID = " + zakazanTerminID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVreme.getTime()) + "', " + administrator.getAdministratorID() + ", "
                + "" + klijent.getKlijentID() + ", " + trening.getTreningID() + " ";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "";
    }

}
