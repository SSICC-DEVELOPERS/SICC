package es.indra.sicc.logicanegocio.car;

import es.indra.belcorp.mso.CarEstatPedidData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEstatusPedidoBean implements SessionBean {
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

    public Vector query(CarEstatPedidData carEstatPedidFrom, 
                        CarEstatPedidData carEstatPedidTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MonCarEstatPedido.query(CarEstatPedidData carEstatPedidFrom, CarEstatPedidData carEstatPedidTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOEstatusPedido dao = new DAOEstatusPedido();
        
        UtilidadesLog.info("MonCarEstatPedido.query(CarEstatPedidData carEstatPedidFrom, CarEstatPedidData carEstatPedidTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        return dao.query(carEstatPedidFrom, carEstatPedidTo, userProperties, pageCount, pageSize);
    }

    public void update(CarEstatPedidData carEstatPedid, 
                       Vector localizationLabels) throws MareException 
                       
    {    UtilidadesLog.info("MonCarEstatPedido.update(CarEstatPedidData carEstatPedid, Vector localizationLabels): Entrada");
        DAOEstatusPedido dao = new DAOEstatusPedido();
        dao.update(carEstatPedid, localizationLabels);
        
        UtilidadesLog.info("MonCarEstatPedido.update(CarEstatPedidData carEstatPedid, Vector localizationLabels): Salida");
   
    }

    public void remove(Vector entities) throws MareException
    {   UtilidadesLog.info("MonCarEstatPedido.remove(Vector estPed): Entrada");
        DAOEstatusPedido dao = new DAOEstatusPedido();
        dao.remove(entities);
        UtilidadesLog.info("MonCarEstatPedido.remove(Vector estPed): Salida");
    }
    

    public Hashtable guardarEstPed(CarEstatPedidData carEstatPedid, 
                                   Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MonCarEstatPedido.guardarEstPed(CarEstatPedidData carEstatPedid, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOEstatusPedido dao = new DAOEstatusPedido();
    
        UtilidadesLog.info("MonCarEstatPedido.guardarEstPed(CarEstatPedidData carEstatPedid, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarEstPed(carEstatPedid,localizationLabels, userProperties );
    }
}
