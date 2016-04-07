package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeTipoTarjeData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MAETipoTarjeBean implements SessionBean {
    private SessionContext _context;

    public void ejbCreate() {
    }

    public void setSessionContext(SessionContext context) throws EJBException {
        _context = context;
    }

    public void ejbRemove() throws EJBException {
    }

    public void ejbActivate() throws EJBException {
    }

    public void ejbPassivate() throws EJBException {
    }

    public Hashtable guardar(MaeTipoTarjeData maeTipoTarje, 
                             Vector localizationLabels, HashMap userProperties) throws MareException {
          DAOTipoTarje daoTipoTarje = new DAOTipoTarje();
          return daoTipoTarje.guardar(maeTipoTarje, localizationLabels, userProperties);
    }

    public Vector query(MaeTipoTarjeData maeTipoTarjeFrom, 
                        MaeTipoTarjeData maeTipoTarjeTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
          DAOTipoTarje daoTipoTarje = new DAOTipoTarje();
          return daoTipoTarje.query(maeTipoTarjeFrom, maeTipoTarjeTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeTipoTarjeData maeTipoTarje, 
                       Vector localizationLabels) throws MareException {
                       
        DAOTipoTarje daoTipoTarje = new DAOTipoTarje();
        daoTipoTarje.update(maeTipoTarje, localizationLabels);              
    }

    public void remove(Vector entities) throws MareException {
         DAOTipoTarje daoTipoTarje = new DAOTipoTarje();
         daoTipoTarje.remove(entities);
    }
}
