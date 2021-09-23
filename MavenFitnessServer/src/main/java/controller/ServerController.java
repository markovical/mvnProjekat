/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import domain.Administrator;
import domain.VezbaZaTermin;
import domain.Klijent;
import domain.TipKlijenta;
import domain.Trening;
import domain.VrstaTreninga;
import domain.ZakazanTermin;
import java.util.ArrayList;
import so.AbstractSO;
import so.administrator.SOAddAdministrator;
import so.administrator.SODeleteAdministrator;
import so.administrator.SOEditAdministrator;
import so.administrator.SOGetAllAdministrator;
import so.vezbezatermin.SOAddVezbaZaTermin;
import so.vezbezatermin.SODeleteVezbaZaTermin;
import so.vezbezatermin.SOGetAllVezbaZaTermin;
import so.klijent.SOAddKlijent;
import so.klijent.SODeleteKlijent;
import so.klijent.SOEditKlijent;
import so.klijent.SOGetAllKlijent;
import so.tipklijenta.SOGetAllTipKlijenta;
import so.trening.SOAddTrening;
import so.trening.SODeleteTrening;
import so.trening.SOEditTrening;
import so.trening.SOGetAllTrening;
import so.vrstatreninga.SOGetAllVrstaTreninga;
import so.zakazantermin.SOAddZakazanTermin;
import so.zakazantermin.SODeleteZakazanTermin;
import so.zakazantermin.SOGetAllZakazanTermin;


/**
 *
 * @author PC
 */
public class ServerController {
    private static ServerController instance;

    public ServerController() {
    }

    public static ServerController getInstance() {
        if(instance==null)
            instance=new ServerController();
        return instance;
    }
    /**
     * Poziva sistemsku operaciju addAdministrator kojom dodaje administratora.
     * 
     * @return Dodat je administrator
     * @throws Exception Ako prosledjeni objekat nije instanca klase Administrator
     */
    public void addAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOAddAdministrator();
        aso.templateExecute(administrator);
    }
    /**
     * Poziva sistemsku operaciju addKlijent kojom dodaje klijenta.
     * 
     * @return Dodat je klijent
     * @throws Exception Ako prosledjeni objekat nije instanca klase Klijent
     */
    public void addKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SOAddKlijent();
        aso.templateExecute(klijent);
    }
    /**
     * Poziva sistemsku operaciju addTrening kojom dodaje trening.
     * 
     * @return Dodat je trening
     * @throws Exception Ako prosledjeni objekat nije instanca klase Trening
     */
    public void addTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOAddTrening();
        aso.templateExecute(trening);
    }
    /**
     * Poziva sistemsku operaciju addZakazanTermin kojom dodaje zakazan termin.
     * 
     * @return Dodat je zakazan termin
     * @throws Exception Ako prosledjeni objekat nije instanca klase ZakazanTermin
     */
    public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SOAddZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    /**
     * Poziva sistemsku operaciju addVezbaZaTermin kojom dodaje vezbu za termin.
     * 
     * @return Dodata je vezba za termin
     * @throws Exception Ako prosledjeni objekat nije instanca klase VezbaZaTermin
     */
    public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SOAddVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }
    /**
     * Poziva sistemsku operaciju deleteAdministrator kojom brise administratora.
     * 
     * @return Obrisan je administrator
     * @throws Exception Ako prosledjeni objekat nije instanca klase Administrator
     */
    public void deleteAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SODeleteAdministrator();
        aso.templateExecute(administrator);
    }
    /**
     * Poziva sistemsku operaciju deleteKlijent kojom brise klijenta.
     * 
     * @return Obrisan je klijent
     * @throws Exception Ako prosledjeni objekat nije instanca klase Klijent
     */
    public void deleteKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SODeleteKlijent();
        aso.templateExecute(klijent);
    }
    /**
     * Poziva sistemsku operaciju deleteTrening kojom brise trening.
     * 
     * @return Obrisan je trening
     * @throws Exception Ako prosledjeni objekat nije instanca klase Trening
     */
    public void deleteTrening(Trening trening) throws Exception{
        AbstractSO aso=new SODeleteTrening();
        aso.templateExecute(trening);
    }
    /**
     * Poziva sistemsku operaciju deleteZakazanTermin kojom brise zakazan termin.
     * 
     * @return Obrisan je zakazan termin
     * @throws Exception Ako prosledjeni objekat nije instanca klase ZakazanTermin
     */
    public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SODeleteZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    /**
     * Poziva sistemsku operaciju deleteVezbaZaTermin kojom brise vežbu za termin.
     * 
     * @return Obrisana je vežba za termin
     * @throws Exception Ako prosledjeni objekat nije instanca klase VezbaZaTermin
     */
    public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SODeleteVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }
    /**
     * Poziva sistemsku operaciju editAdministrator kojom izmenjuje administratora.
     * 
     * @return Vraća izmenjenog administratora
     * @throws Exception Ako prosledjeni objekat nije instanca klase Administrator
     */
    public void editAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOEditAdministrator();
        aso.templateExecute(administrator);
    }
    /**
     * Poziva sistemsku operaciju editKlijent kojom izmenjuje klijenta.
     * 
     * @return Vraća izmenjenog klijenta
     * @throws Exception Ako prosledjeni objekat nije instanca klase Klijent
     */
    public void editKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SOEditKlijent();
        aso.templateExecute(klijent);
    }
    /**
     * Poziva sistemsku operaciju editTrening kojom izmenjuje trening.
     * 
     * @return Vraća izmenjen trening
     * @throws Exception Ako prosledjeni objekat nije instanca klase Trening
     */
    public void editTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOEditTrening();
        aso.templateExecute(trening);
    }
    /**
     * Poziva sistemsku operaciju getAllAdministrator kojom vraća listu administratora.
     * 
     * @return Vraća sve administratore kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase Administrator
     */
    public ArrayList<Administrator> getAllAdministrator() throws Exception{
        SOGetAllAdministrator so=new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllKlijent kojom vraća listu klijenata.
     * 
     * @return Vraća sve klijente kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase Klijent
     */
    public ArrayList<Klijent> getAllKlijent() throws Exception{
        SOGetAllKlijent so=new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllTrening kojom vraća listu svih treninga.
     * 
     * @return Vraća sve treninge kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase Trening
     */
    public ArrayList<Trening> getAllTrening() throws Exception{
        SOGetAllTrening so=new SOGetAllTrening();
        so.templateExecute(new Trening());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllZakazanTermin kojom vraća sve zakazane termine.
     * 
     * @return Vraća sve zakazane termine kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase ZakazanTermin
     */
    public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
        SOGetAllZakazanTermin so=new SOGetAllZakazanTermin();
        so.templateExecute(new ZakazanTermin());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllVezbaZaTermin kojom vraća sve vežbe za termin.
     * 
     * @return Vraća sve vežbe za izabrani termin kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase VezbaZaTermin
     */
    public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
        SOGetAllVezbaZaTermin so=new SOGetAllVezbaZaTermin();
        so.templateExecute(new VezbaZaTermin());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllTipKlijenta kojom vraća sve tipove klijenata.
     * 
     * @return Vraća sve tipove klijenata kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase TipKlijenta
     */
    public ArrayList<TipKlijenta> getAllTipKlijenta() throws Exception{
        SOGetAllTipKlijenta so=new SOGetAllTipKlijenta();
        so.templateExecute(new TipKlijenta());
        return so.getLista();
    }
    /**
     * Poziva sistemsku operaciju getAllVrstaTreninga kojom vraća sve vrste treninga.
     * 
     * @return Vraća sve vrste treninga kao listu
     * @throws Exception Ako prosledjeni objekat nije instanca klase VrstaTreninga
     */
    public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
        SOGetAllVrstaTreninga so=new SOGetAllVrstaTreninga();
        so.templateExecute(new VrstaTreninga());
        return so.getLista();
    }
    
}
