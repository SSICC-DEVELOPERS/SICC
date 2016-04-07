package es.indra.sicc.logicanegocio.mae;

import es.indra.belcorp.mso.MaeEstatClienData;
import es.indra.belcorp.mso.MaeEstatClienViewData;
import es.indra.belcorp.mso.MaeTipoEstatClienViewData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMAEEstatusClienteBean implements SessionBean {
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

    public Vector query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, 
                        MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        UtilidadesLog.info("MONEstatusCliente.query(MaeTipoEstatClienViewData maeTipoEstatClienViewFrom, MaeTipoEstatClienViewData maeTipoEstatClienViewTo, HashMap userProperties): Salida");
        return dao.query(maeTipoEstatClienViewFrom, maeTipoEstatClienViewTo, userProperties);
    }

    public Vector query(MaeEstatClienViewData maeEstatClienViewFrom, 
                        MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.query(MaeEstatClienViewData maeEstatClienViewFrom, MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        UtilidadesLog.info("MONEstatusCliente.query(MaeEstatClienViewData maeEstatClienViewFrom, MaeEstatClienViewData maeEstatClienViewTo, HashMap userProperties): Entrada");
        return dao.query(maeEstatClienViewFrom, maeEstatClienViewTo, userProperties);
    }

    public Hashtable guardarEstatusCliente(MaeEstatClienData maeEstatClien, 
                                           Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONEstatusClienteBean.guardarEstatusCliente(MaeEstatClienData maeEstatClien, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        UtilidadesLog.info("MONEstatusClienteBean.guardarEstatusCliente(MaeEstatClienData maeEstatClien, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarEstatusCliente(maeEstatClien, localizationLabels, userProperties);
    }

    public Vector query(MaeEstatClienData maeEstatClienFrom, 
                        MaeEstatClienData maeEstatClienTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("MONEstatusClienteBean.query(MaeEstatClienData maeEstatClienFrom, MaeEstatClienData maeEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        UtilidadesLog.info("MONEstatusClienteBean.query(MaeEstatClienData maeEstatClienFrom, MaeEstatClienData maeEstatClienTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(maeEstatClienFrom, maeEstatClienTo, userProperties, pageCount, pageSize);
    }

    public void update(MaeEstatClienData maeEstatClien, 
                       Vector localizationLabels) throws MareException {
        UtilidadesLog.info("MONEstatusCliente.update(MaeEstatClienData maeEstatClien, Vector localizationLabels): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        dao.update(maeEstatClien, localizationLabels);
        UtilidadesLog.info("MONEstatusCliente.update(MaeEstatClienData maeEstatClien, Vector localizationLabels): Salida");                
    }

    public void remove(Vector maeEstatClien) throws MareException {
        UtilidadesLog.info("MONEstatusCliente(Vector maeEstatusCliente): Entrada");
        DAOEstatusClien dao = new DAOEstatusClien();
        dao.remove(maeEstatClien);
        UtilidadesLog.info("MONEstatusCliente(Vector maeEstatusCliente): Salida");
    }
}
