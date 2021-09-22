/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.VezbaZaTermin;
import domain.Klijent;
import domain.ZakazanTermin;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelVezbeZaTermin extends AbstractTableModel implements Runnable{

    private List<VezbaZaTermin> lista;
    private String[] kolone = {"Redni broj", "Vezba", "Broj ponavljanja"};
    private String parametar = "";
    
    public TableModelVezbeZaTermin(long id) {
        try {
            ArrayList<VezbaZaTermin> listaSvih = ClientController.getInstance().getAllVezbaZaTermin();
            ArrayList<VezbaZaTermin> listaZaTermin = new ArrayList<>();
            
            for (VezbaZaTermin vezbaZaTermin : listaSvih) {
                if(vezbaZaTermin.getZakazanTermin().getZakazanTerminID() == id)
                    listaZaTermin.add(vezbaZaTermin);
            }
            
            lista = listaZaTermin;
            
        } catch (Exception ex) {
            Logger.getLogger(TableModelVezbeZaTermin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        VezbaZaTermin vzt = lista.get(row);

        switch(column){
            case 0: return vzt.getRedniBroj();
            case 1: return vzt.getVezba();
            case 2: return vzt.getBrojPonavljanja();
            
            default: return null;
        }
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelVezbeZaTermin.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllVezbaZaTermin();
            if(!parametar.equals("")){
                List<VezbaZaTermin> novaLista=new ArrayList<>();
                for(VezbaZaTermin vzt: lista)
                    if(vzt.getVezba().toLowerCase().equals(parametar.toLowerCase()))
                        novaLista.add(vzt);
                lista=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public List<VezbaZaTermin> getLista() {
        return lista;
    }
    
}

