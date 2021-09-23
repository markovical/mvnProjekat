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
import java.util.List;

/**
 * Interfejs koji definiše osnovne operacije koje se vrše nad svim domenskim
 * objektima u projektu Fitness.
 * 
 * Nasleđuje interfejs Serializable.
 * 
 */
public abstract class AbstractDomainObject implements Serializable {
	/**
	 * Metoda koja vraća naziv tabele u bazi.
	 * 
	 * @return Naziv tabele u bazi kao String.
	 */
    public abstract String nazivTabele();
    /**
	 * Metoda koja vraća alijas tabele u bazi.
	 * 
	 * @return Alijas tabele u bazi kao String.
	 */
    public abstract String alijas();
    /**
	 * Metoda koja vraća kriterijum po kome se vrši join u SQL upitima.
	 * 
	 * @return Vraća kriterijum po kome se vrši join u SQL upitima, kao String.
	 *         Vraća null ako se nad tom tabelom ne vrši nikakvo spajanje sa drugom
	 *         tabelom.
	 */
    public abstract String join();
    /**
     * Metoda koja vraća listu objekata tipa AbstractDomainObject 
     * 
     * @param rs
     * 			Odnosno tabela koja je tipa ResultSet
     * @return Vraća listu objekata tipa AbstractDomainObject 
     * @throws SQLException
     * 			Kada mysql javi grešku pri izvlačenju kolona iz baze
     */
    public abstract ArrayList<AbstractDomainObject> vratiListu(ResultSet rs) throws SQLException;
    /**
     * Metoda koja vraća nazive kolona nad kojima vršimo insert upit
     * 
     * @return Vraća kolone za insert nase tabele nad kojom vršimo insert, kao String.
     * 
     */
    public abstract String koloneZaInsert();
    /**
     * Metoda koja vraća vrednosti primarnog ključa odabrane tabele
     * 
     * @return Vrednost primarnog ključa tipa Long
     */
    public abstract String vrednostZaPrimarniKljuc();
    /**
   	 * Metoda koja vraća sve vrednosti atributa objekta koje mogu da se menjaju operacijom
   	 * ubacivanja.
   	 * 
   	 * @return Vraća sve vrednosti atributa objekta koje mogu da se menjaju
   	 *         operacijom ubacivanja, kao String.
   	 */
    public abstract String vrednostiZaInsert();
    /**
	 * Metoda koja vraća sve vrednosti atributa objekta koje mogu da se menjaju operacijom
	 * ažuriranja.
	 * 
	 * @return Vraća sve vrednosti atributa objekta koje mogu da se menjaju
	 *         operacijom ažuriranja, kao String.
	 */
    public abstract String vrednostiZaUpdate();
    
    
    public Object vratiUpitZaUbacivanje(Connection connection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param connection
     * @return
     */
   
}
