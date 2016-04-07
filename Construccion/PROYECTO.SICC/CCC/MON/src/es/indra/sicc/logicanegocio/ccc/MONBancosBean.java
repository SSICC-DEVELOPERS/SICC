package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccBancoData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONBancosBean implements SessionBean {
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

    public Hashtable guardarBancos(CccBancoData cccBanco, 
                                   Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONBancosBena.guardarBancos(CccBancoData cccBanco, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOBancos dao = new DAOBancos();
        UtilidadesLog.info("MONBancosBena.guardarBancos(CccBancoData cccBanco, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarBancos(cccBanco, localizationLabels, userProperties );
    }

    public Vector query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONBancoBean.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOBancos dao = new DAOBancos();
        UtilidadesLog.info("MONBancoBean.query(CccBancoData cccBancoFrom, CccBancoData cccBancoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(cccBancoFrom, cccBancoTo, userProperties, pageCount, pageSize);
    }

    public void update(CccBancoData cccBanco, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONBancoBean.update(CccBancoData cccBanco, Vector localizationLabels): Entrada");
        DAOBancos dao = new DAOBancos();
        dao.update(cccBanco, localizationLabels);
        UtilidadesLog.info("MONBancoBean.update(CccBancoData cccBanco, Vector localizationLabels): Salida");               
    }

    public void remove(Vector cccBanco) throws MareException {
        UtilidadesLog.info("MONBancosBean.remove(Vector cccBancos): Entrada");
        DAOBancos dao = new DAOBancos();
        dao.remove(cccBanco);
        UtilidadesLog.info("MONBancosBean.remove(Vector cccBancos): Salidas");
    }
}
