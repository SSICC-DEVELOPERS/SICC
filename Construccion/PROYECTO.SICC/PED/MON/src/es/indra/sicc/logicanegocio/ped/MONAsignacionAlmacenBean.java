package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.BelAlmacData;
import es.indra.belcorp.mso.PedAsignAlmacData;
import es.indra.belcorp.mso.SegAccesData;
import es.indra.belcorp.mso.SegCanalViewData;
import es.indra.belcorp.mso.SegSubacData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONAsignacionAlmacenBean implements SessionBean {
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

    public Vector query(SegCanalViewData segCanalViewFrom, 
                        SegCanalViewData segCanalViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Entrada");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();  
        String usuario = _context.getCallerPrincipal().getName();
        UtilidadesLog.debug("Usuario:" + usuario);
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegCanalViewData segCanalViewFrom, SegCanalViewData segCanalViewTo, HashMap userProperties): Salida");
        return dao.query(segCanalViewFrom, segCanalViewTo, userProperties, usuario);
    }

    public Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
        UtilidadesLog.info("MONAsignacionesAlmacenBean.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada "); 
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties):Salida");
        return dao.query(segAccesFrom, segAccesTo, userProperties, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
    }

    public Vector query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Entrada ");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        UtilidadesLog.info("MONAsignacionAlmacen.query(SegAccesData segAccesFrom, SegAccesData segAccesTo, HashMap userProperties): Salida ");
        return dao.query(segAccesFrom, segAccesTo, userProperties);
    }

    public Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, 
                        HashMap userProperties, Boolean applyStructuralSecurity) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties, Boolean applyStructuralSecurity): Entrada ");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        String usuario = _context.getCallerPrincipal().getName();
        UtilidadesLog.debug("Usuario:" + usuario);
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties, Boolean applyStructuralSecurity): Salida");
        return dao.query(segSubacFrom, segSubacTo, userProperties, (applyStructuralSecurity!= null?applyStructuralSecurity:Boolean.TRUE));
    }

    public Vector query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties): Entrada ");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(SegSubacData segSubacFrom, SegSubacData segSubacTo, HashMap userProperties): Salida");
        return dao.query(segSubacFrom, segSubacTo, userProperties);
    }

    public Vector query(BelAlmacData belAlmacFrom, BelAlmacData belAlmacTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(BelAlmacData belAlmacFrom): Entrada");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        UtilidadesLog.info("MONAsignacionAlmacenBean.query(BelAlmacData belAlmacFrom): Salida");
        return dao.query(belAlmacFrom);
    }

    public Hashtable guardarAsignacionAlmacen(PedAsignAlmacData pedAsignAlmac, 
                                              Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacenBean(PedAsignAlmacData pedAsignAlmac, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        UtilidadesLog.info("MONAsignacionAlmacenBean(PedAsignAlmacData pedAsignAlmac, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarAsignacionAlmacen(pedAsignAlmac,localizationLabels, userProperties);
    }

    public Vector query(PedAsignAlmacData pedAsignAlmacFrom, 
                        PedAsignAlmacData pedAsignAlmacTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException {
        UtilidadesLog.info("DAOAsignacionAlmacenBean.query(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        String usuario = _context.getCallerPrincipal().getName();
        UtilidadesLog.debug("Usuario: " + usuario);
        UtilidadesLog.info("DAOAsignacionAlmacenBean.query(PedAsignAlmacData pedAsignAlmacFrom, PedAsignAlmacData pedAsignAlmacTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(pedAsignAlmacFrom, pedAsignAlmacTo, userProperties, pageCount, pageSize, usuario);
    }

    public void remove(Vector entities) throws MareException {
        UtilidadesLog.info("MONAsignacionAlmacen.remove(Vector pedAsignacionAlmacen): Entrada");
        DAOAsignacionAlmacen dao = new DAOAsignacionAlmacen();
        dao.remove(entities);
        UtilidadesLog.info("MONAsignacionAlmacen.remove(Vector pedAsignacionAlmacen): Salida");
    }
}
