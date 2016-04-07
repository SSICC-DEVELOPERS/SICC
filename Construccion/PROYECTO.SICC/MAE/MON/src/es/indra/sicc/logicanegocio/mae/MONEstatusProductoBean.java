package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstatProduData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEstatusProductoBean implements SessionBean {
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

    public Hashtable guardarEstatusProducto(MaeEstatProduData maeEstatProdu, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONEstatusProductoBean.guardarEstatusProducto(MaeEstatProduData maeEstatProdu, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOEstatusProducto dao = new DAOEstatusProducto();
        UtilidadesLog.info("MONEstatusProductoBean.guardarEstatusProducto(MaeEstatProduData maeEstatProdu, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarEstatusProducto(maeEstatProdu, localizationLabels, userProperties);
    }

    public Vector query(MaeEstatProduData maeEstatProduFrom, 
                        MaeEstatProduData maeEstatProduTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONEstatusProductoBean.query(MaeEstatProduData maeEstatProduFrom, MaeEstatProduData maeEstatProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOEstatusProducto dao = new DAOEstatusProducto();
        UtilidadesLog.info("MONEstatusProductoBean.query(MaeEstatProduData maeEstatProduFrom, MaeEstatProduData maeEstatProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeEstatProduFrom, maeEstatProduTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeEstatProduData maeEstatProdu, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONEstatusProductoBean(MaeEstatProduData maeEstatProdu, Vector localizationLabels): Entrada");
        DAOEstatusProducto dao = new DAOEstatusProducto();
        dao.update(maeEstatProdu, localizationLabels);
        UtilidadesLog.info("MONEstatusProductoBean(MaeEstatProduData maeEstatProdu, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeEstatProdu) throws MareException {
        UtilidadesLog.info("MONEstatusProductosBean.remove(Vector maeEstatusProducto): Entrada");
           DAOEstatusProducto dao = new DAOEstatusProducto();
           dao.remove(maeEstatProdu);
           UtilidadesLog.info("MONEstatusProductosBean.remove(Vector maeEstatusProducto): Salida");
    }
}
