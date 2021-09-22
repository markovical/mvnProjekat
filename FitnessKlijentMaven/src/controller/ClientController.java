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
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import session.Session;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class ClientController {
    private static ClientController instance;

    public ClientController() {
    }

    public static ClientController getInstance() {
        if(instance == null)
            instance = new ClientController();
        return instance;
    }
    
    public Administrator login(Administrator administrator) throws Exception{
        return (Administrator)sendRequest(Operation.LOGIN, administrator);
    }
    
    public void addKlijent(Klijent klijent) throws Exception{
         sendRequest(Operation.ADD_KLIJENT, klijent);
     }

     public void addTrening(Trening trening) throws Exception{
         sendRequest(Operation.ADD_TRENING, trening);
     }

     public void addZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
         sendRequest(Operation.ADD_ZAKAZAN_TERMIN, zakazanTermin);
     }
     
     public void addVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
         sendRequest(Operation.ADD_VEZBA_ZA_TERMIN, vezbaZaTermin);
     }

     public void addAdministrator(Administrator administrator) throws Exception{
         sendRequest(Operation.ADD_ADMINISTRATOR, administrator);
     }

     public void deleteKlijent(Klijent klijent) throws Exception{
         sendRequest(Operation.DELETE_KLIJENT, klijent);
     }

     public void deleteTrening(Trening trening) throws Exception{
         sendRequest(Operation.DELETE_TRENING, trening);
     }

     public void deleteZakazanTermin(ZakazanTermin zakazanTermin) throws Exception{
         sendRequest(Operation.DELETE_ZAKAZAN_TERMIN, zakazanTermin);
     }
     
     public void deleteVezbaZaTermin(VezbaZaTermin vezbaZaTermin) throws Exception{
         sendRequest(Operation.DELETE_VEZBA_ZA_TERMIN, vezbaZaTermin);
     }

     public void deleteAdministrator(Administrator administrator) throws Exception{
         sendRequest(Operation.DELETE_ADMINISTRATOR, administrator);
     }

     public void editKlijent(Klijent klijent) throws Exception{
         sendRequest(Operation.EDIT_KLIJENT, klijent);
     }

     public void editTrening(Trening trening) throws Exception{
         sendRequest(Operation.EDIT_TRENING, trening);
     }

     public void editAdministrator(Administrator administrator) throws Exception{
         sendRequest(Operation.EDIT_ADMINISTRATOR, administrator);
     }

     public ArrayList<Klijent> getAllKlijent() throws Exception{
         return (ArrayList<Klijent>)sendRequest(Operation.GET_ALL_KLIJENT, null);
     }

     public ArrayList<Trening> getAllTrening() throws Exception{
         return (ArrayList<Trening>)sendRequest(Operation.GET_ALL_TRENING, null);
     }

     public ArrayList<ZakazanTermin> getAllZakazanTermin() throws Exception{
         return (ArrayList<ZakazanTermin>)sendRequest(Operation.GET_ALL_ZAKAZAN_TERMIN, null);
     }
     
     public ArrayList<VezbaZaTermin> getAllVezbaZaTermin() throws Exception{
         return (ArrayList<VezbaZaTermin>)sendRequest(Operation.GET_ALL_VEZBA_ZA_TERMIN, null);
     }

     public ArrayList<Administrator> getAllAdministrator() throws Exception{
         return (ArrayList<Administrator>)sendRequest(Operation.GET_ALL_ADMINISTRATOR, null);
     }
     
     public ArrayList<TipKlijenta> getAllTipKlijenta() throws Exception{
         return (ArrayList<TipKlijenta>)sendRequest(Operation.GET_ALL_TIP_KLIJENTA, null);
     }
     
     public ArrayList<VrstaTreninga> getAllVrstaTreninga() throws Exception{
         return (ArrayList<VrstaTreninga>)sendRequest(Operation.GET_ALL_VRSTA_TRENINGA, null);
     }
    
    private Object sendRequest(int operation,Object data) throws Exception{
        Request req = new Request(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Session.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        ObjectInputStream in = new ObjectInputStream(Session.getInstance().getSocket().getInputStream());
        Response res = (Response)in.readObject();
        if(res.getResponseStatus().equals(ResponseStatus.Error))
            throw res.getError();
        else 
            return res.getData();
    }
}
