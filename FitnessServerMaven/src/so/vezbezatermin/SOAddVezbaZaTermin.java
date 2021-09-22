/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.vezbezatermin;

import db.DBBroker;
import domain.AbstractDomainObject;
import domain.VezbaZaTermin;
import java.sql.SQLException;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SOAddVezbaZaTermin extends AbstractSO {

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof VezbaZaTermin)) {
            throw new Exception("Prosledjeni objekat nije instanca klase VezbaZaTermin!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        ado.vratiUpitZaUbacivanje(DBBroker.getInstance().getConnection()).execute();
    }
    
}
