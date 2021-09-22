/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package thread;

import controller.ServerController;
import domain.Administrator;
import domain.VezbaZaTermin;
import domain.Klijent;
import domain.Trening;
import domain.ZakazanTermin;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.Request;
import transfer.Response;
import transfer.util.Operation;
import transfer.util.ResponseStatus;

/**
 *
 * @author PC
 */
public class ThreadClient extends Thread {

    private Socket socket;

    ThreadClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                Request req = (Request) in.readObject();
                Response res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Response handleRequest(Request req) {
        Response res = new Response(null, null, ResponseStatus.Success);
        try {
            switch (req.getOperation()) {
                case Operation.ADD_ADMINISTRATOR:
                    ServerController.getInstance().addAdministrator((Administrator) req.getData());
                    break;
                case Operation.ADD_KLIJENT:
                    ServerController.getInstance().addKlijent((Klijent) req.getData());
                    break;
                case Operation.ADD_TRENING:
                    ServerController.getInstance().addTrening((Trening) req.getData());
                    break;
                case Operation.ADD_ZAKAZAN_TERMIN:
                    ServerController.getInstance().addZakazanTermin((ZakazanTermin) req.getData());
                    break;
                case Operation.ADD_VEZBA_ZA_TERMIN:
                    ServerController.getInstance().addVezbaZaTermin((VezbaZaTermin) req.getData());
                    break;
                case Operation.DELETE_ADMINISTRATOR:
                    ServerController.getInstance().deleteAdministrator((Administrator) req.getData());
                    break;
                case Operation.DELETE_KLIJENT:
                    ServerController.getInstance().deleteKlijent((Klijent) req.getData());
                    break;
                case Operation.DELETE_TRENING:
                    ServerController.getInstance().deleteTrening((Trening) req.getData());
                    break;
                case Operation.DELETE_ZAKAZAN_TERMIN:
                    ServerController.getInstance().deleteZakazanTermin((ZakazanTermin) req.getData());
                    break;
                case Operation.DELETE_VEZBA_ZA_TERMIN:
                    ServerController.getInstance().deleteVezbaZaTermin((VezbaZaTermin) req.getData());
                    break;
                case Operation.EDIT_ADMINISTRATOR:
                    ServerController.getInstance().editAdministrator((Administrator) req.getData());
                    break;
                case Operation.EDIT_KLIJENT:
                    ServerController.getInstance().editKlijent((Klijent) req.getData());
                    break;
                case Operation.EDIT_TRENING:
                    ServerController.getInstance().editTrening((Trening) req.getData());
                    break;
                case Operation.GET_ALL_ADMINISTRATOR:
                    res.setData(ServerController.getInstance().getAllAdministrator());
                    break;
                case Operation.GET_ALL_KLIJENT:
                    res.setData(ServerController.getInstance().getAllKlijent());
                    break;
                case Operation.GET_ALL_TRENING:
                    res.setData(ServerController.getInstance().getAllTrening());
                    break;
                case Operation.GET_ALL_ZAKAZAN_TERMIN:
                    res.setData(ServerController.getInstance().getAllZakazanTermin());
                    break;
                case Operation.GET_ALL_VEZBA_ZA_TERMIN:
                    res.setData(ServerController.getInstance().getAllVezbaZaTermin());
                    break;
                case Operation.GET_ALL_TIP_KLIJENTA:
                    res.setData(ServerController.getInstance().getAllTipKlijenta());
                    break;  
                case Operation.GET_ALL_VRSTA_TRENINGA:
                    res.setData(ServerController.getInstance().getAllVrstaTreninga());
                    break;   
                case Operation.LOGIN:
                    ArrayList<Administrator> listaAdministratora =
                            ServerController.getInstance().getAllAdministrator();
                    
                    Administrator a = (Administrator) req.getData();
                    for (Administrator administrator : listaAdministratora) {
                        if (administrator.getKorisnickoIme().equals(a.getKorisnickoIme()) && 
                                administrator.getLozinka().equals(a.getLozinka())) {
                            res.setData(administrator);
                        }
                    }
                    if (res.getData() == null) {
                        throw new Exception("Ne postoji administrator sa tim kredencijalima.");
                    } else {
                        break;
                    }
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setData(null);
            res.setResponseStatus(ResponseStatus.Error);
        }
        return res;
    }

}
