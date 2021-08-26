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
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaZakazanihTermina = ado.vratiListu(rs);
        lista = (ArrayList<ZakazanTermin>) (ArrayList<?>) listaZakazanihTermina;
    }

    public ArrayList<ZakazanTermin> getLista() {
        return lista;
    }
    
}
