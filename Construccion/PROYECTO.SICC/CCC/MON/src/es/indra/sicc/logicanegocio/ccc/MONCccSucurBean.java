package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccSucurData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccSucurBean implements SessionBean {
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

    public Hashtable guardarSucursales(CccSucurData cccSucur, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("DAOCccSucur.guardarSucursales(CccSucurData cccSucur, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCccSucur dao = new DAOCccSucur();
        UtilidadesLog.info("DAOCccSucur.guardarSucursales(CccSucurData cccSucur, Vector localizationLabels, HashMap userProperties): Entrada");
        return dao.guardarSucursales(cccSucur, localizationLabels, userProperties);
    }

    public Vector query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("DAOCccSucur.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccSucur dao = new DAOCccSucur();
        UtilidadesLog.info("DAOCccSucur.query(CccSucurData cccSucurFrom, CccSucurData cccSucurTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccSucurFrom, cccSucurTo, userProperties, pageCount, pageSize);
    }

    public void update(CccSucurData cccSucur, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("DAOCccSucur.update(CccSucurData cccSucur, Vector localizationLabels): Entrada");
        DAOCccSucur dao = new DAOCccSucur();
        dao.update(cccSucur, localizationLabels);
        UtilidadesLog.info("DAOCccSucur.update(CccSucurData cccSucur, Vector localizationLabels): Salida");               
    }

    public void remove(Vector cccSucur) throws MareException {
        UtilidadesLog.info("DAOCccSucur.remove(Vector cccSucursales): Entrada");
        DAOCccSucur dao = new DAOCccSucur();
        dao.remove(cccSucur);   
        UtilidadesLog.info("DAOCccSucur.remove(Vector cccSucursales): Salida");
    }
}
