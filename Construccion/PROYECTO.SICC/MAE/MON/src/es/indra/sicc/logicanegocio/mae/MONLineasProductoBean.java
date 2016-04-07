package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeLineaProduData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONLineasProductoBean implements SessionBean {
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

    public Hashtable guardarLineasProducto(MaeLineaProduData maeLineaProdu, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONLineasProducto.guardarLineasProducto(MaeLineaProduData maeLineaProdu, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOLineasProducto dao = new DAOLineasProducto();
        UtilidadesLog.info("MONLineasProducto.guardarLineasProducto(MaeLineaProduData maeLineaProdu, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.gardarLineasProducto(maeLineaProdu, localizationLabels, userProperties);
    }

    public Vector query(MaeLineaProduData maeLineaProduFrom, 
                        MaeLineaProduData maeLineaProduTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONLineasProducto.query(MaeLineaProduData maeLineaProduFrom, MaeLineaProduData maeLineaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOLineasProducto dao = new DAOLineasProducto();
        UtilidadesLog.info("MONLineasProducto.query(MaeLineaProduData maeLineaProduFrom, MaeLineaProduData maeLineaProduTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeLineaProduFrom, maeLineaProduTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeLineaProduData maeLineaProdu, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONLineasProducto.update(MaeLineaProduData maeLineaProdu, Vector localizationLabels): Entrada");
        DAOLineasProducto dao = new DAOLineasProducto();
        dao.update(maeLineaProdu, localizationLabels);
        UtilidadesLog.info("MONLineasProducto.update(MaeLineaProduData maeLineaProdu, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeLineaProdu) throws MareException {
        UtilidadesLog.info("MONLineasProducto.remove(Vector maeLineaProducto): Entrada");
        DAOLineasProducto dao = new DAOLineasProducto();
        dao.remove(maeLineaProdu);
        UtilidadesLog.info("MONLineasProducto.remove(Vector maeLineaProducto): Salida");
    }
}
