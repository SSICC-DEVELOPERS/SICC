package es.indra.sicc.logicanegocio.cal;

import es.indra.belcorp.mso.CalGuiasData;
import es.indra.belcorp.mso.SegDeptoEmpreData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCalGuiasBean implements SessionBean {
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

    public Vector query(SegDeptoEmpreData segDeptoEmpreFrom, 
                        SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONCalGuiasBean.query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties): Entrada"); 
        DAOCalGuias dao = new DAOCalGuias();
        UtilidadesLog.info("MONCalGuiasBean.query(SegDeptoEmpreData segDeptoEmpreFrom, SegDeptoEmpreData segDeptoEmpreTo, HashMap userProperties): Salida");
        return dao.query(segDeptoEmpreFrom, segDeptoEmpreTo, userProperties);
    }

    public Hashtable guardarGuias(CalGuiasData calGuias, 
                                  Vector localizationLabels, HashMap userProperties) throws MareException {
       UtilidadesLog.info("MONCalGuiasBean.guardarGuias(CalGuiasData calGuias,Vector localizationLabels, HashMap userProperties): Entrada");                         
       DAOCalGuias dao = new DAOCalGuias();
       UtilidadesLog.info("MONCalGuiasBean.guardarGuias(CalGuiasData calGuias,Vector localizationLabels, HashMap userProperties): Salida");
       return dao.guardarGuias(calGuias, localizationLabels, userProperties);
    }

    public Vector query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
    UtilidadesLog.info("MONCalGuiasBean.query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");                    
    DAOCalGuias dao = new DAOCalGuias();
    UtilidadesLog.info("MONCalGuiasBean.query(CalGuiasData calGuiasFrom, CalGuiasData calGuiasTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
    return dao.query(calGuiasFrom, calGuiasTo, userProperties, pageCount, pageSize);
    }

    public void update(CalGuiasData calGuias, 
                       Vector localizationLabels) throws MareException {
      UtilidadesLog.info("MONCalGuiasBean.update(CalGuiasData calGuias,Vector localizationLabels): Entrada");                         
      DAOCalGuias dao = new DAOCalGuias();
      dao.update(calGuias, localizationLabels);
      UtilidadesLog.info("MONCalGuiasBean.update(CalGuiasData calGuias,Vector localizationLabels): Salida");
    }

    public void remove(Vector calGuias) throws MareException {
    UtilidadesLog.info("MONCalGuiasBean.remove(Vector calGuias): Entrada");
    DAOCalGuias dao = new DAOCalGuias();
    dao.remove(calGuias);
    UtilidadesLog.info("MONCalGuiasBean.remove(Vector calGuias): Salida");
    }
}
