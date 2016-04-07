package es.indra.sicc.logicanegocio.com;

import es.indra.belcorp.mso.ComEstadComisData;

import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;



public class MONMantenimientoEstadoComisionBean implements SessionBean {
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

    public Vector query(ComEstadComisData comEstadComisFrom, 
                        ComEstadComisData comEstadComisTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONMantenimientoEstadoComision.query(ComEstadComisData comEstadComisFrom, ComEstadComisData comEstadComisTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOMantenimientoEstadoComision dao = new DAOMantenimientoEstadoComision();
                           
           return dao.query(comEstadComisFrom, comEstadComisTo, userProperties, pageCount, pageSize );
    }

    public void update(ComEstadComisData comEstadComis, 
                       Vector localizationLabels) throws MareException
    {   UtilidadesLog.info("MONMantenimientoEstadoComision.update(ComEstadComisData comEstadComis, Vector localizationLabels):Entrada");
        DAOMantenimientoEstadoComision dao = new DAOMantenimientoEstadoComision();
        dao.update(comEstadComis, localizationLabels);
        UtilidadesLog.info("MONMantenimientoEstadoComision.update(ComEstadComisData comEstadComis, Vector localizationLabels):Salida");
    }
}
