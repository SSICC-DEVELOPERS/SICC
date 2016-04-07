package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccTipoCargoAbonoData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccTipoCargoAbonoBean implements SessionBean {
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

    public Hashtable guardarTipoCargoAbono(CccTipoCargoAbonoData cccTipoCargoAbono, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCccTipoCargoAbono.guardarTipoCargoAbono(CccTipoCargoAbonoData cccTipoCargoAbono, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCccTipoCargoAbono dao = new DAOCccTipoCargoAbono();
        UtilidadesLog.info("MONCccTipoCargoAbono.guardarTipoCargoAbono(CccTipoCargoAbonoData cccTipoCargoAbono, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarTipoCargoAbono(cccTipoCargoAbono, localizationLabels, userProperties);
    }

    public Vector query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, 
                        CccTipoCargoAbonoData cccTipoCargoAbonoTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccTipoCargoAbonoBean.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccTipoCargoAbono dao = new DAOCccTipoCargoAbono();
        UtilidadesLog.info("MONCccTipoCargoAbonoBean.query(CccTipoCargoAbonoData cccTipoCargoAbonoFrom, CccTipoCargoAbonoData cccTipoCargoAbonoTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccTipoCargoAbonoFrom, cccTipoCargoAbonoTo, userProperties, pageCount, pageSize);
    }

    public void update(CccTipoCargoAbonoData cccTipoCargoAbono, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCccTipoCargoAbono.update(CccTipoCargoAbonoData cccTipoCargoAbono, Vector localizationLabels): Entrada");
        DAOCccTipoCargoAbono dao = new DAOCccTipoCargoAbono();
        dao.update(cccTipoCargoAbono, localizationLabels);
        UtilidadesLog.info("MONCccTipoCargoAbono.update(CccTipoCargoAbonoData cccTipoCargoAbono, Vector localizationLabels): Entrada");               
    }

    public void remove(Vector cccTipoCargoAbono) throws MareException {
        UtilidadesLog.info("MONCccTipoCargoAbono.remove(Vector cccTipoCargoAbono): Entrada");
        DAOCccTipoCargoAbono dao = new DAOCccTipoCargoAbono();
        dao.remove(cccTipoCargoAbono);
        UtilidadesLog.info("MONCccTipoCargoAbono.remove(Vector cccTipoCargoAbono): Entrada");
    }
}
