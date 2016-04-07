package es.indra.sicc.logicanegocio.rec;

import es.indra.belcorp.mso.RecResulChequData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONRECTipoResultadosChequeosBean implements SessionBean {
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

    public Hashtable guardarTipoResultadoCliente(RecResulChequData recResulChequ, 
                                                 Vector localizationLabels, HashMap userProperties) throws MareException {
            UtilidadesLog.info("MONRECTipoResultadosChequeosBean.guardarTipoResultadoCliente(RecResulChequData recResulChequ, Vector localizationLabels, HashMap userProperties): Entrada");
            DAORECTipoResultadosChequeos dao = new DAORECTipoResultadosChequeos();
            UtilidadesLog.info("MONRECTipoResultadosChequeosBean.guardarTipoResultadoCliente(RecResulChequData recResulChequ, Vector localizationLabels, HashMap userProperties): Salida");
            return dao.guardarDAORECTipoResultadoChequeo(recResulChequ, localizationLabels, userProperties);
    }

    public Vector query(RecResulChequData recResulChequFrom, 
                        RecResulChequData recResulChequTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
            UtilidadesLog.info("MONRECTipoResultadoChequeosBean.query(RecResulChequData recResulChequFrom, RecResulChequData recResulChequTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
            DAORECTipoResultadosChequeos dao = new DAORECTipoResultadosChequeos();
            UtilidadesLog.info("MONRECTipoResultadoChequeosBean.query(RecResulChequData recResulChequFrom, RecResulChequData recResulChequTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
            return dao.query(recResulChequFrom, recResulChequTo, userProperties, pageCount, pageSize);
    }

    public void update(RecResulChequData recResulChequ, 
                       Vector localizationLabels) throws MareException {
            UtilidadesLog.info("MONRECTipoResultadoChequeoBean.update(RecResulChequData recResulChequ, Vector localizationLabels): Entrada");
            DAORECTipoResultadosChequeos dao = new DAORECTipoResultadosChequeos();
            dao.update(recResulChequ, localizationLabels);
            UtilidadesLog.info("MONRECTipoResultadoChequeoBean.update(RecResulChequData recResulChequ, Vector localizationLabels): Salida");           
    }

    public void remove(Vector entities) throws MareException {
            UtilidadesLog.info("MONRECTipoResultadoChequeoBean.remove(Vector recResulChequeo) : Entrada");
            DAORECTipoResultadosChequeos dao = new DAORECTipoResultadosChequeos();
            dao.remove(entities);
            UtilidadesLog.info("MONRECTipoResultadoChequeoBean.remove(Vector recResulChequeo) : Salida");
       }
    }

