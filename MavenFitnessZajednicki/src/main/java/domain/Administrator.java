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
 * Klasa koja predstavlja jednog administratora
 * 
 * Administrator ima atribute:
 * administratorID tipa Long
 * ime tipa String
 * prezime tipa String
 * korisnickoIme tipa String
 * lozinka tipa String
 * 
 */
public class Administrator extends AbstractDomainObject implements Serializable {
    /**
     * Jedinstvena šifra administratora tipa Long
     */
    private Long administratorID;
    /**
     * Ime administratora tipa String
     */
    private String ime;
    /**
     * Prezime administratora tipa String
     */
    private String prezime;
    /**
     *   Korisničko ime administratora tipa String
     */
    private String korisnickoIme;
    /**
     * Lozinka administratora tipa String
     *
     */
    private String lozinka;
    
    
    /**
	 * Konstruktor koji inicijalizuje objekat administratora
	 */
    public Administrator() {
    }
    /**
	 * Konstruktor koji inicijalizuje objekat i postavlja vrednost svih atributa
	 * Administratora.
	 * 
	 * @param administratorID
	 *            Šifra administratora tipa Long.
	 * @param ime
	 *            Ime administratora tipa String.
	 * @param prezime
	 *            Prezime administratora tipa String
	 * @param korisnickoIme
	 *            Korisničko ime administratora tipa String
	 * @param lozinka
	 * 			  Lozinka administratora tipa String
	 
	 */
    public Administrator(Long administratorID, String ime, String prezime, String korisnickoIme, String lozinka) {
        this.administratorID = administratorID;
        this.ime = ime;
        this.prezime = prezime;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
    }
    /**
	 * Vraća sifru administratora.
	 * 
	 * @return  Šifra administratora tipa Long.
	 */
    public Long getAdministratorID() {
        return administratorID;
    }
    /**
	 * Postavlja šifru administratora na novu vrednost.
	 * 
	 * @param administratorID
	 *            Šifra administratora tipa Long.
	 */
    public void setAdministratorID(Long administratorID) {
        this.administratorID = administratorID;
    }
    /**
  	 * Vraća ime administratora.
  	 * 
  	 * @return  Ime administratora tipa String.
  	 */
    public String getIme() {
        return ime;
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
        final Administrator other = (Administrator) obj;
        if (!Objects.equals(this.ime, other.ime)) {
            return false;
        }
        if (!Objects.equals(this.prezime, other.prezime)) {
            return false;
        }
        if (!Objects.equals(this.korisnickoIme, other.korisnickoIme)) {
            return false;
        }
        if (!Objects.equals(this.lozinka, other.lozinka)) {
            return false;
        }
        return true;
    }
    /**
  	 * Vraća ime administratora.
  	 * 
  	 * @return  Ime administratora tipa String.
  	 */
    public String getPrezime() {
        return prezime;
    }
    /**
  	 * Postavlja prezime administratora na novu vrednost.
  	 * 
  	 * @param prezime
  	 *           Prezime administratora tipa String.
  	 */
    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }
    /**
  	 * Vraća korisničko ime administratora.
  	 * 
  	 * @return  korisnickoIme administratora tipa String.
  	 */
    public String getKorisnickoIme() {
        return korisnickoIme;
    }
    /**
  	 * Postavlja Korisnicko Ime administratora na novu vrednost.
  	 * 
  	 * @param korisnickoIme
  	 *           Korisnicko ime administratora tipa String.
  	 */
    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }
    /**
  	 * Vraća lozinku administratora.
  	 * 
  	 * @return  lozinka administratora tipa String.
  	 */
    public String getLozinka() {
        return lozinka;
    }
    /**
  	 * Postavlja lozinku administratora na novu vrednost.
  	 * 
  	 * @param lozinka
  	 *           Lozinka administratora tipa String.
  	 */
    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }
    /**
  	 * Postavlja ime administratora na novu vrednost.
  	 * 
  	 * @param ime
  	 *           Ime administratora tipa String.
  	 */
    public void setIme(String ime) {
        this.ime = ime;
    }

    @Override
    public String nazivTabele() {
        return " administrator ";
    }

    @Override
    public String alijas() {
        return " a ";
    }

    @Override
    public String join() {
        return "";
    }

    @Override
    public ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException {
        ArrayList<AbstractDomainObject> lista = new ArrayList<>();
        
        while(rs.next()){
            Administrator a = new Administrator(rs.getLong("AdministratorID"),
                    rs.getString("Ime"), rs.getString("Prezime"), 
                    rs.getString("KorisnickoIme"), rs.getString("Lozinka"));
            
            lista.add(a);
        }
        
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return " (Ime, Prezime, KorisnickoIme, Lozinka) ";
    }

    @Override
    public String vrednostZaPrimarniKljuc() {
        return " AdministratorID = " + administratorID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + ime + "', '" + prezime + "', "
                + "'" + korisnickoIme + "', '" + lozinka + "'";
    } 

    @Override
    public String vrednostiZaUpdate() {
        return " Ime = '" + ime + "', Prezime = '" + prezime + "', " 
                + "KorisnickoIme = '" + korisnickoIme + "', Lozinka = '" + lozinka + "' ";
    }
    
}
