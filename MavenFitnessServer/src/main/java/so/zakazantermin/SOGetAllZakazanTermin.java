/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zakazantermin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.ZakazanTermin;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SOGetAllZakazanTermin extends AbstractSO {
    
    private ArrayList<ZakazanTermin> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ZakazanTermin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ZakazanTermin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ArrayList<AbstractDomainObject> listaTermina = 
                      (ArrayList<AbstractDomainObject>) DBBroker.getInstance().select(ado);
        lista = (ArrayList<ZakazanTermin>) (ArrayList<?>) listaTermina;
    }

    public ArrayList<ZakazanTermin> getLista() {
        return lista;
    }
    
}
