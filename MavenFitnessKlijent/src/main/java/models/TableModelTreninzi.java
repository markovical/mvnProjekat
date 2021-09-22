/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import controller.ClientController;
import domain.Klijent;
import domain.Trening;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author PC
 */
public class TableModelTreninzi extends AbstractTableModel implements Runnable {

    private List<Trening> lista;
    private String[] kolone = {"ID", "Naziv treninga", "Vrsta treninga"};
    private String parametar = "";

    public TableModelTreninzi() {
        try {
            lista = ClientController.getInstance().getAllTrening();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
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
        Trening t = lista.get(row);

        switch (column) {
            case 0:
                return t.getTreningID();
            case 1:
                return t.getNazivTreninga();
            case 2:
                return t.getVrstaTreninga();

            default:
                return null;
        }
    }

    public Trening getSelectedTrening(int row) {
        return lista.get(row);
    }

    @Override
    public void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                Thread.sleep(5000);
                osveziTabelu();
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        osveziTabelu();
    }

    private void osveziTabelu() {
        try {
            lista = ClientController.getInstance().getAllTrening();
            if (!parametar.equals("")) {
                List<Trening> novaLista = new ArrayList<>();
                for (Trening t : lista) {
                    if (t.getNazivTreninga().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(t);
                    }
                }
                lista = novaLista;
            } else {

            }
            fireTableDataChanged();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void refreshTable() {
        try {
            lista = ClientController.getInstance().getAllTrening();
        } catch (Exception ex) {
            Logger.getLogger(TableModelTreninzi.class.getName()).log(Level.SEVERE, null, ex);
        }
        fireTableDataChanged();
    }

}
