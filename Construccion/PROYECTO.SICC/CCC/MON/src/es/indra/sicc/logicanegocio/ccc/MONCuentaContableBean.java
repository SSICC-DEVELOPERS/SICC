package es.indra.sicc.logicanegocio.ccc;

import es.indra.belcorp.mso.CccCuentContaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONCuentaContableBean implements SessionBean {
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

    public Hashtable guardarCuentaContable(CccCuentContaData cccCuentConta, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("DAOCuentaContableBean.guardarCuentaContable(CccCuentContaData cccCuentConta, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOCuentaConta dao = new DAOCuentaConta();
        UtilidadesLog.info("DAOCuentaContableBean.guardarCuentaContable(CccCuentContaData cccCuentConta, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarCuentaContable(cccCuentConta, localizationLabels, userProperties);
    }

    public Vector query(CccCuentContaData cccCuentContaFrom, 
                        CccCuentContaData cccCuentContaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONCuentaContableBean.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOCuentaConta dao = new DAOCuentaConta();
        UtilidadesLog.info("MONCuentaContableBean.query(CccCuentContaData cccCuentContaFrom, CccCuentContaData cccCuentContaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cccCuentContaFrom, cccCuentContaTo, userProperties, pageCount, pageSize);
    }

    public void update(CccCuentContaData cccCuentConta, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONCuentaContableBeam.update(CccCuentContaData cccCuentConta, Vector localizationLabels): Entrada");
        DAOCuentaConta dao = new DAOCuentaConta();
        dao.update(cccCuentConta, localizationLabels);
        UtilidadesLog.info("MONCuentaContableBeam.update(CccCuentContaData cccCuentConta, Vector localizationLabels): Salida");               
    }

    public void remove(Vector cccCuentConta) throws MareException {
        UtilidadesLog.info("MONCuentaContableBean.remove(Vector cccCuentaContable): Entrada");
           DAOCuentaConta dao = new DAOCuentaConta();
           dao.remove(cccCuentConta);
           UtilidadesLog.info("MONCuentaContableBean.remove(Vector cccCuentaContable): Salida");
    }
}
