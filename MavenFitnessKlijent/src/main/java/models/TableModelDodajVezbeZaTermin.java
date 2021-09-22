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
public class TableModelDodajVezbeZaTermin extends AbstractTableModel{

    private List<VezbaZaTermin> lista;
    private String[] kolone = {"Redni broj", "Vezba", "Broj ponavljanja"};
    
    public TableModelDodajVezbeZaTermin() {
        try {
            lista = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(TableModelDodajVezbeZaTermin.class.getName()).log(Level.SEVERE, null, ex);
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

    public List<VezbaZaTermin> getLista() {
        return lista;
    }

    public void dodajVezbu(VezbaZaTermin vzt) {
        int rb = 1;
        
        for (VezbaZaTermin vezbaZaTermin : lista) {
            rb++;
        }
        
        vzt.setRedniBroj(rb);
        
        lista.add(vzt);
        fireTableDataChanged();
    }

    public void obrisiVezbu(int selectedRow) {
        lista.remove(selectedRow);
        int rb = 0;
        
        for (VezbaZaTermin vezbaZaTermin : lista) {
            vezbaZaTermin.setRedniBroj(++rb);
        }
        
        fireTableDataChanged();
        
    }

    
}

