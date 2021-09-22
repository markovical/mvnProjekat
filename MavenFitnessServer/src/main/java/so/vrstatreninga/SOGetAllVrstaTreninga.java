/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vrstatreninga;

import so.klijent.*;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import domain.VrstaTreninga;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SOGetAllVrstaTreninga extends AbstractSO {
    private ArrayList<VrstaTreninga> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VrstaTreninga)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VrstaTreninga!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaVrstaTreninga = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<VrstaTreninga>) (ArrayList<?>) listaVrstaTreninga;
    }
    
    public ArrayList<VrstaTreninga> getLista() {
        return lista;
    }
}
