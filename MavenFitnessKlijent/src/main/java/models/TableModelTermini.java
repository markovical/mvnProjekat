/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
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
public class TableModelTermini extends AbstractTableModel implements Runnable{

    private List<ZakazanTermin> lista;
    private String[] kolone = {"ID", "Datum i vreme", "Trening"};
    private String parametar = "";
    
    public TableModelTermini() {
        try {
            lista = ClientController.getInstance().getAllZakazanTermin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
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
        ZakazanTermin zt = lista.get(row);
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy hh:mm");
        switch(column){
            case 0: return zt.getZakazanTerminID();
            case 1: return sdf.format(zt.getDatumVreme());
            case 2: return zt.getTrening();
            
            default: return null;
        }
    }
    
    public ZakazanTermin getSelectedZakazanTermin(int row){
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while(!Thread.currentThread().isInterrupted()){
                    Thread.sleep(5000);
                    osveziTabelu();
            }
        } catch (InterruptedException ex) {
                Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try{
            lista = ClientController.getInstance().getAllZakazanTermin();
            if(!parametar.equals("")){
                List<ZakazanTermin> novaLista=new ArrayList<>();
                for(ZakazanTermin zt: lista)
                    if(zt.getAdministrator().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getAdministrator().getPrezime().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getKlijent().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getKlijent().getIme().toLowerCase().contains(parametar.toLowerCase())
                            || zt.getTrening().getNazivTreninga().toLowerCase().contains(parametar.toLowerCase()))
                        novaLista.add(zt);
                lista=novaLista;
            }else{
                
            }
            fireTableDataChanged();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllZakazanTermin();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTermini.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }
    
}

