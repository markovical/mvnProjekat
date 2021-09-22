/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package so.tipklijenta;

import so.klijent.*;
import db.DBBroker;
import domain.AbstractDomainObject;
import domain.Klijent;
import domain.TipKlijenta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import so.AbstractSO;

/**
 *
 * @author aca99
 */
public class SOGetAllTipKlijenta extends AbstractSO {
    private ArrayList<TipKlijenta> lista;

    @Override
    protected void validate(AbstractDomainObject ado) throws Exception {
        if (!(ado instanceof TipKlijenta)) {
            throw new Exception("Prosledjeni objekat nije instanca klase TipKlijenta!");
        }
    }

    @Override
    protected void execute(AbstractDomainObject ado) throws SQLException {
        String upitZaSve = ado.vratiUpitZaSve();
        
        Statement stat = DBBroker.getInstance().getConnection().createStatement();
        ResultSet rs = stat.executeQuery(upitZaSve);
        
        ArrayList<AbstractDomainObject> listaTipova = ado.vratiListu(rs);
        lista = (ArrayList<TipKlijenta>) (ArrayList<?>) listaTipova;
    }
    
    public ArrayList<TipKlijenta> getLista() {
        return lista;
    }
}
