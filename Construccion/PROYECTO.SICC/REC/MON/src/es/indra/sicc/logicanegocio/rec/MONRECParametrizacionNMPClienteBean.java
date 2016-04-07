package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecParamNmperData;
import es.indra.belcorp.mso.RecPreciPerdiData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRECParametrizacionNMPClienteBean implements SessionBean {
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

    public Vector query(RecPreciPerdiData recPreciPerdiFrom, 
                        RecPreciPerdiData recPreciPerdiTo, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.query(RecPreciPerdiData recPreciPerdiFrom, RecPreciPerdiData recPreciPerdiTo, HashMap userProperties): Entrada ");
            DAORECParametrizacionCliente dao = new DAORECParametrizacionCliente();
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.query(RecPreciPerdiData recPreciPerdiFrom, RecPreciPerdiData recPreciPerdiTo, HashMap userProperties): Salida ");
            return dao.query(recPreciPerdiFrom, recPreciPerdiTo, userProperties);
    }

    public Vector query(RecParamNmperData recParamNmperFrom, 
                        RecParamNmperData recParamNmperTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.query(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORECParametrizacionCliente dao = new DAORECParametrizacionCliente();
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.query(RecParamNmperData recParamNmperFrom, RecParamNmperData recParamNmperTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recParamNmperFrom, recParamNmperTo, userProperties, pageCount, pageSize);
    }

    public Hashtable guardarParametrizacionCliente(RecParamNmperData recParamNmper, 
                                                   Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.guardarParametrizacionCliente(RecParamNmperData recParamNmper, Vector localizationLabels, HashMap userProperties): Entrada");
            DAORECParametrizacionCliente dao = new DAORECParametrizacionCliente();
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.guardarParametrizacionCliente(RecParamNmperData recParamNmper, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarParametrizacionCliente(recParamNmper, localizationLabels, userProperties);
    }

    public void update(RecParamNmperData recParamNmper, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.update(RecParamNmperData recParamNmper, Vector localizationLabels): Entrada");
            DAORECParametrizacionCliente dao = new DAORECParametrizacionCliente();
            dao.update(recParamNmper, localizationLabels);
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.update(RecParamNmperData recParamNmper, Vector localizationLabels): Salida");            
    }

    public void remove(Vector entities) throws MareException {
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.remove(Vector recParametrizacionCliente): Entrada");
            DAORECParametrizacionCliente dao = new DAORECParametrizacionCliente();
            dao.remove(entities);
            UtilidadesLog.info("MONRECParametrizacionNMPClienteBean.remove(Vector recParametrizacionCliente): Salida");
    }
}
