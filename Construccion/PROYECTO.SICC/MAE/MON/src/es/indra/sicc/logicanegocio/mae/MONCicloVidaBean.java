package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeCicloVidaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCicloVidaBean implements SessionBean {
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

    public Hashtable guardarCicloVida(MaeCicloVidaData maeCicloVida, 
                                      Vector localizationLabels, HashMap userProperties) throws MareException {
                                      
        UtilidadesLog.info("MONCicloVidaBean.guardarCicloVida(MaeCicloVidaData maeCicloVida, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCicloVida dao = new DAOCicloVida();
        UtilidadesLog.info("MONCicloVidaBean.guardarCicloVida(MaeCicloVidaData maeCicloVida, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarCicloVida(maeCicloVida, localizationLabels, userProperties);
    }

    public Vector query(MaeCicloVidaData maeCicloVidaFrom, 
                        MaeCicloVidaData maeCicloVidaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
                        
        UtilidadesLog.info("MONCicloVidaBean.query(MaeCicloVidaData maeCicloVidaFrom, MaeCicloVidaData maeCicloVidaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCicloVida dao = new DAOCicloVida();
        UtilidadesLog.info("MONCicloVidaBean.query(MaeCicloVidaData maeCicloVidaFrom, MaeCicloVidaData maeCicloVidaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeCicloVidaFrom, maeCicloVidaTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeCicloVidaData maeCicloVida, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCicloVidaBean.update(MaeCicloVidaData maeCicloVida, Vector localizationLabels): Entrada");
        DAOCicloVida dao = new DAOCicloVida();
        dao.update(maeCicloVida, localizationLabels);
        UtilidadesLog.info("MONCicloVidaBean.update(MaeCicloVidaData maeCicloVida, Vector localizationLabels): Salida");               
    }

    public void remove(Vector maeCicloVida) throws MareException {
        UtilidadesLog.info("MONCicloVidaBean.remove(Vector maeCicloVida): Entrada");
        DAOCicloVida dao = new DAOCicloVida();
        dao.remove(maeCicloVida);
        UtilidadesLog.info("MONCicloVidaBean.remove(Vector maeCicloVida): Salida");
    }
}
