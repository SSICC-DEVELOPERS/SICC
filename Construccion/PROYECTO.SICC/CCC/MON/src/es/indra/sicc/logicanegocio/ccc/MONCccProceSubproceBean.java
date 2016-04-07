package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccProceData;
import es.indra.belcorp.mso.CccSubprData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCccProceSubproceBean implements SessionBean {
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

    public Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccProceSubprocBean.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccProceSubproce dao = new DAOCccProceSubproce();
        UtilidadesLog.info("MONCccProceSubprocBean.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(cccProceFrom, cccProceTo, userProperties, pageCount, pageSize);
    }

    public Vector query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCccProceSubproceBean.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties): Entrada");
        DAOCccProceSubproce dao = new DAOCccProceSubproce();
        UtilidadesLog.info("MONCccProceSubproceBean.query(CccProceData cccProceFrom, CccProceData cccProceTo, HashMap userProperties): Salida");
        return dao.query(cccProceFrom, cccProceTo, userProperties);
    }

    public Vector query(CccSubprData cccSubprFrom, CccSubprData cccSubprTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCccProceSubproceBean.query(CccSubprData cccSubprFrom, CccSubprData cccSubprTom, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCccProceSubproce dao = new DAOCccProceSubproce();
        UtilidadesLog.info("MONCccProceSubproceBean.query(CccSubprData cccSubprFrom, CccSubprData cccSubprTom, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccSubprFrom,  cccSubprTo, userProperties, pageCount, pageSize);
    }

    public void update(CccSubprData cccSubpr, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCccProceSubproceBean.update(CccSubprData cccSubpr, Vector localizationLabels): Entrada");
        DAOCccProceSubproce dao = new DAOCccProceSubproce();
        dao.update(cccSubpr, localizationLabels);
        UtilidadesLog.info("MONCccProceSubproceBean.update(CccSubprData cccSubpr, Vector localizationLabels): Salida");               
    }
}
