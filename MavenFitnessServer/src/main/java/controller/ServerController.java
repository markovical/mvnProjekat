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

    public void addAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOAddAdministrator();
        aso.templateExecute(administrator);
    }

    public void addKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SOAddKlijent();
        aso.templateExecute(klijent);
    }

    public void addTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOAddTrening();
        aso.templateExecute(trening);
    }

    public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SOAddZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SOAddVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    public void deleteAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SODeleteAdministrator();
        aso.templateExecute(administrator);
    }

    public void deleteKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SODeleteKlijent();
        aso.templateExecute(klijent);
    }

    public void deleteTrening(Trening trening) throws Exception{
        AbstractSO aso=new SODeleteTrening();
        aso.templateExecute(trening);
    }

    public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
        AbstractSO aso=new SODeleteZakazanTermin();
        aso.templateExecute(zakazanTermin);
    }
    
    public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
        AbstractSO aso=new SODeleteVezbaZaTermin();
        aso.templateExecute(vezbaZaTermin);
    }

    public void editAdministrator(Administrator administrator) throws Exception{
        AbstractSO aso=new SOEditAdministrator();
        aso.templateExecute(administrator);
    }

    public void editKlijent(Klijent klijent) throws Exception{
        AbstractSO aso=new SOEditKlijent();
        aso.templateExecute(klijent);
    }

    public void editTrening(Trening trening) throws Exception{
        AbstractSO aso=new SOEditTrening();
        aso.templateExecute(trening);
    }
    
    public ArrayList<Administrator> getAllAdministrator() throws Exception{
        SOGetAllAdministrator so=new SOGetAllAdministrator();
        so.templateExecute(new Administrator());
        return so.getLista();
    }

    public ArrayList<Klijent> getAllKlijent() throws Exception{
        SOGetAllKlijent so=new SOGetAllKlijent();
        so.templateExecute(new Klijent());
        return so.getLista();
    }

    public ArrayList<Trening> getAllTrening() throws Exception{
        SOGetAllTrening so=new SOGetAllTrening();
        so.templateExecute(new Trening());
        return so.getLista();
    }

    public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
        SOGetAllZakazanTermin so=new SOGetAllZakazanTermin();
        so.templateExecute(new ZakazanTermin());
        return so.getLista();
    }
    
    public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
        SOGetAllVezbaZaTermin so=new SOGetAllVezbaZaTermin();
        so.templateExecute(new VezbaZaTermin());
        return so.getLista();
    }
    
    public ArrayList<TipKlijenta> getAllTipKlijenta() throws Exception{
        SOGetAllTipKlijenta so=new SOGetAllTipKlijenta();
        so.templateExecute(new TipKlijenta());
        return so.getLista();
    }
    
    public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
        SOGetAllVrstaTreninga so=new SOGetAllVrstaTreninga();
        so.templateExecute(new VrstaTreninga());
        return so.getLista();
    }
    
}
