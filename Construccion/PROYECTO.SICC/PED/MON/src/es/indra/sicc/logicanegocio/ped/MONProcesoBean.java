package es.indra.sicc.logicanegocio.ped;

import es.indra.belcorp.mso.PedGrupoProceData;
import es.indra.belcorp.mso.PedProceData;
import es.indra.belcorp.mso.PedProceViewData;
import es.indra.belcorp.mso.PedProgrData;
import es.indra.belcorp.mso.PedSubtiPosicViewData;
import es.indra.belcorp.mso.PedTipoPosicData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONProcesoBean implements SessionBean {
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

    public Vector query(PedGrupoProceData pedGrupoProceFrom, 
                        PedGrupoProceData pedGrupoProceTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONProcesoBean.query(PedGrupoProceData pedGrupoProceFrom, PedGrupoProceData pedGrupoProceTo, HashMap userProperties ): Entrada");
        DAOProceso dao = new DAOProceso();     
        UtilidadesLog.info("MONProcesoBean.query(PedGrupoProceData pedGrupoProceFrom, PedGrupoProceData pedGrupoProceTo, HashMap userProperties ): Salida"); 
        return  dao.obtenerGrupoProceso(pedGrupoProceFrom, pedGrupoProceTo, userProperties);
    }

    public Vector query(PedProgrData pedProgrFrom, PedProgrData pedProgrTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONProcesoBean.query(PedProgrData pedProgrFrom, PedProgrData pedProgrTo, HashMap userProperties ): Entrada");  
        DAOProceso dao  = new DAOProceso();      
        UtilidadesLog.info("MONProcesoBean.query(PedProgrData pedProgrFrom, PedProgrData pedProgrTo, HashMap userProperties ): Salida"); 
        return dao.obtenerPrograma(pedProgrFrom, pedProgrTo, userProperties);
    }

    public Vector query(PedTipoPosicData pedTipoPosicFrom, 
                        PedTipoPosicData pedTipoPosicTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONProcesoBean.query(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedProgrTo, HashMap userProperties ): Entrada");
        DAOProceso dao = new DAOProceso();        
        UtilidadesLog.info("MONProcesoBean.query(PedTipoPosicData pedTipoPosicFrom, PedTipoPosicData pedProgrTo, HashMap userProperties ): Salida");
        return dao.obtenerTipoPosicion(pedTipoPosicFrom, pedTipoPosicTo, userProperties);
    }

    public Vector query(PedSubtiPosicViewData pedSubtiPosicViewFrom, 
                        PedSubtiPosicViewData pedSubtiPosicViewTo, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONProcesoBean.query( PedSubtiPosicViewData pedSubtiPosicViewFrom, PedSubtiPosicViewData pedSubtiPosicViewTo, HashMap userProperties): Entrada");
        DAOProceso dao = new DAOProceso();     
        UtilidadesLog.info("MONProcesoBean.query( PedSubtiPosicViewData pedSubtiPosicViewFrom, PedSubtiPosicViewData pedSubtiPosicViewTo, HashMap userProperties): Salida");
        return dao.obtenerSubtipoPosicion(pedSubtiPosicViewFrom, pedSubtiPosicViewTo, userProperties); 
    }

    public Vector query(PedProceViewData pedProceViewFrom, 
                        PedProceViewData pedProceViewTo, HashMap userProperties) throws MareException {
        DAOProceso dao = new DAOProceso();
        return dao.obtenerCodigoProcesoRevision(pedProceViewFrom, pedProceViewTo, userProperties);
    }

    public Hashtable guardarProceso(PedProceData pedProce, 
                                    Vector localizationLabels, HashMap userProperties) throws MareException {
        UtilidadesLog.info("MONProcesoBean.guardarProceso(PedProceData pedProce, Vector localizationLabels, HashMap userProperties): Entrada");
        DAOProceso dao = new DAOProceso();
        UtilidadesLog.info("MONProcesoBean.guardarProceso(PedProceData pedProce, Vector localizationLabels, HashMap userProperties): Salida");
        return dao.guardarProceso(pedProce, localizationLabels, userProperties);
    }

    public Vector query(PedProceData pedProceFrom, PedProceData pedProceTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException{
        DAOProceso dao = new DAOProceso();
        return dao.query( pedProceFrom, pedProceTo, userProperties, pageCount, pageSize);
    }

    public void update(PedProceData pedProce, 
                       Vector localizationLabels) throws MareException {
        DAOProceso dao = new DAOProceso();
        dao.update(pedProce, localizationLabels);               
    }

    public void remove(Vector entities) throws MareException {
        DAOProceso dao = new DAOProceso();
        dao.remove(entities);
    }
}
