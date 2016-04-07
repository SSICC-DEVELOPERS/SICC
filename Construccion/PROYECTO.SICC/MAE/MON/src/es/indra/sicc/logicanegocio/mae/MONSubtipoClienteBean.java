package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeSubtiClienData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONSubtipoClienteBean implements SessionBean {
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

    public Hashtable guardarSubtipoCliente(MaeSubtiClienData maeSubtiClien, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONSubtipoCliente.guardarSubtipoCliente(MaeSubtiClienData maeSubtiClien, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOSubtipoCliente dao = new DAOSubtipoCliente();
        UtilidadesLog.info("MONSubtipoCliente.guardarSubtipoCliente(MaeSubtiClienData maeSubtiClien, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarSubtipoCliente(maeSubtiClien, localizationLabels, userProperties);
    }

    public Vector query(MaeSubtiClienData maeSubtiClienFrom, 
                        MaeSubtiClienData maeSubtiClienTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONSubtipoClienteBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada"); 
        DAOSubtipoCliente dao = new DAOSubtipoCliente();
        UtilidadesLog.info("MONSubtipoClienteBean.query(MaeSubtiClienData maeSubtiClienFrom, MaeSubtiClienData maeSubtiClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeSubtiClienFrom, maeSubtiClienTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeSubtiClienData maeSubtiClien, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONSubtipoCliente.update(MaeSubtiClienData maeSubtiClien, Vector localizationLabels): Entrada");
        DAOSubtipoCliente dao = new DAOSubtipoCliente();
        dao.update(maeSubtiClien, localizationLabels);
        UtilidadesLog.info("MONSubtipoCliente.update(MaeSubtiClienData maeSubtiClien, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeSubtiClien) throws MareException {
        UtilidadesLog.info("MONSubtipoCliente.remove(Vector maeSubtipoCliente): Entrada");
        DAOSubtipoCliente dao = new DAOSubtipoCliente();
        dao.remove(maeSubtiClien);
        UtilidadesLog.info("MONSubtipoCliente.remove(Vector maeSubtipoCliente): Salida");
    }
}
