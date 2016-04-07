package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedUmbraFaltaData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONUmbralFaltantesBean implements SessionBean {
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

    public Hashtable guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, 
                                            Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONUmbralFaltantes.guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels, HashMap userProperties): Entrada");
            DAOUmbralFaltantes dao = new DAOUmbralFaltantes(); 
            UtilidadesLog.info("MONUmbralFaltantes.guardarUmbralFaltantes(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarUmbralFaltantes(pedUmbraFalta, localizationLabels, userProperties);
    }

    public Vector query(PedUmbraFaltaData pedUmbraFaltaFrom, 
                        PedUmbraFaltaData pedUmbraFaltaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONUmbralFaltantes.query(PedUmbraFaltaData pedUmbraFaltaFrom, PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAOUmbralFaltantes dao = new DAOUmbralFaltantes();
            UtilidadesLog.info("MONUmbralFaltantes.query(PedUmbraFaltaData pedUmbraFaltaFrom, PedUmbraFaltaData pedUmbraFaltaTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(pedUmbraFaltaFrom, pedUmbraFaltaTo, userProperties, pageCount, pageSize);
    }

    public void update(PedUmbraFaltaData pedUmbraFalta, 
                       Vector localizationLabels) throws MareException {
          UtilidadesLog.info("MONUmbralFaltantes.update(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels): Entrada");
          DAOUmbralFaltantes dao = new DAOUmbralFaltantes();
          dao.update(pedUmbraFalta, localizationLabels);
          UtilidadesLog.info("MONUmbralFaltantes.update(PedUmbraFaltaData pedUmbraFalta, Vector localizationLabels): Salida");            
    }

    public void remove(Vector entities) throws MareException {
          UtilidadesLog.info("MONUmbralFaltantes.remove(Vector pedUmbraFalta): Entrada");
          DAOUmbralFaltantes dao = new DAOUmbralFaltantes();
          dao.remove(entities);
          UtilidadesLog.info("MONUmbralFaltantes.remove(Vector pedUmbraFalta): Salida");  
    }
}
