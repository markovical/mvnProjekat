/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.zakazantermin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VezbaZaTermin;
import domain.ZakazanTermin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SOAddZakazanTermin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof ZakazanTermin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase ZakazanTermin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ZakazanTermin zt = (ZakazanTermin) ado;
        PreparedStatement ps = 
                zt.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection());
        ps.execute();
        
        ResultSet rs = ps.getGeneratedKeys();
        
        rs.next();
        
        long id = rs.getLong(1);
        
        zt.setZakazanTerminID(id);
        
        for (VezbaZaTermin vezbaZaTermin : zt.getVezbeZaTermin()) {
            vezbaZaTermin.setZakazanTermin(zt);
            vezbaZaTermin.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection()).execute();
        }
        
    }
    
}
