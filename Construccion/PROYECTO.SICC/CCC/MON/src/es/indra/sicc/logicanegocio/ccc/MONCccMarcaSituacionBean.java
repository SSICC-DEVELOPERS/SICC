package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccMarcaSituaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccMarcaSituacionBean implements SessionBean {
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

    public Hashtable guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCccMarcaSituacionBean.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCccMarcaSituacion dao = new DAOCccMarcaSituacion();
        UtilidadesLog.info("MONCccMarcaSituacionBean.guardarMarcaSituacion(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarMarcaSituacion(cccMarcaSitua, localizationLabels, userProperties);
    }

    public Vector query(CccMarcaSituaData cccMarcaSituaFrom, 
                        CccMarcaSituaData cccMarcaSituaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccMarcaSituacionBean.query(CccMarcaSituaData cccMarcaSituaFrom, CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccMarcaSituacion dao = new DAOCccMarcaSituacion();
        UtilidadesLog.info("MONCccMarcaSituacionBean.query(CccMarcaSituaData cccMarcaSituaFrom, CccMarcaSituaData cccMarcaSituaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(cccMarcaSituaFrom, cccMarcaSituaTo, userProperties, pageCount, pageSize);
    }

    public void update(CccMarcaSituaData cccMarcaSitua, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCccMarcaSituacionBean.update(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels): Entrada");
        DAOCccMarcaSituacion dao = new DAOCccMarcaSituacion();
        dao.update(cccMarcaSitua, localizationLabels);
        UtilidadesLog.info("MONCccMarcaSituacionBean.update(CccMarcaSituaData cccMarcaSitua, Vector localizationLabels): Salida");               
    }

    public void remove(Vector cccMarcaSitua) throws MareException {
        UtilidadesLog.info("MONCccMarcaSituacionBean.remove(Vector cccMarcaSituacion): Entrada");
        DAOCccMarcaSituacion dao = new DAOCccMarcaSituacion();
        dao.remove(cccMarcaSitua);
        UtilidadesLog.info("MONCccMarcaSituacionBean.remove(Vector cccMarcaSituacion): Salida");
    }
}
