/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vezbezatermin;

import so.zakazantermin.*;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VezbaZaTermin;
import domain.ZakazanTermin;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SODeleteVezbaZaTermin extends AbstractSO {
    
    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VezbaZaTermin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VezbaZaTermin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ado.vratiUpitZaBrisanje(DBBroker.getInstance().getConnection()).execute();
    }
    
}
