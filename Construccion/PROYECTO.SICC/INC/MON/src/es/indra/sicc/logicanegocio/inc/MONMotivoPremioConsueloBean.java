package es.indra.sicc.logicanegocio.inc;

import es.indra.belcorp.mso.IncMotivPremiConsuData;
import es.indra.mare.common.exception.MareException;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMotivoPremioConsueloBean implements SessionBean {
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

    public Hashtable guardar(IncMotivPremiConsuData incMotivPremiConsu, Vector localizationLabels, HashMap userProperties) throws MareException
        {
            DAOMotivoPremioConsuelo daoMotivoPremioConsuelo = new DAOMotivoPremioConsuelo();
        
            return daoMotivoPremioConsuelo.guardar(incMotivPremiConsu, localizationLabels, userProperties) ;
        }

        public void remove(Vector incMotivPremiConsuFrom) throws MareException
        {
            DAOMotivoPremioConsuelo daoMotivoPremioConsuelo = new DAOMotivoPremioConsuelo();
        
            daoMotivoPremioConsuelo.remove(incMotivPremiConsuFrom);
        }

        public Vector query(IncMotivPremiConsuData incMotivPremiConsuFrom, IncMotivPremiConsuData incMotivPremiConsuTo, HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException
        {
            DAOMotivoPremioConsuelo daoMotivoPremioConsuelo = new DAOMotivoPremioConsuelo();
        
            return daoMotivoPremioConsuelo.query(incMotivPremiConsuFrom, incMotivPremiConsuTo, userProperties, pageCount, pageSize);
        }

        public void update(IncMotivPremiConsuData incMotivPremiConsu, Vector localizationLabels) throws MareException
        {
            DAOMotivoPremioConsuelo daoMotivoPremioConsuelo = new DAOMotivoPremioConsuelo();
        
            daoMotivoPremioConsuelo.update(incMotivPremiConsu, localizationLabels);
        }
}
