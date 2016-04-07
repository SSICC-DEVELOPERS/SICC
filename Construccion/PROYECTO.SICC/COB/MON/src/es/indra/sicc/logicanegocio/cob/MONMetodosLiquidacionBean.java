package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobBaseEscalData;
import es.indra.belcorp.mso.CobMetodLiquiData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMetodosLiquidacionBean implements SessionBean {
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

    public Vector query(CobBaseEscalData cobBaseEscalFrom, 
                        CobBaseEscalData cobBaseEscalTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONMetodosLiquidacion.query(CobBaseEscalData cobBaseEscalFrom, CobBaseEscalData cobBaseEscalTo, HashMap userProperties):Entrada");
        DAOMetodosLiquidacion dao = new DAOMetodosLiquidacion();
    
        UtilidadesLog.info("MONMetodosLiquidacion.query(CobBaseEscalData cobBaseEscalFrom, CobBaseEscalData cobBaseEscalTo, HashMap userProperties):Salida");
        return dao.query(cobBaseEscalFrom, cobBaseEscalTo, userProperties);
    
    }

    public Vector query(CobMetodLiquiData cobMetodLiquiFrom, 
                        CobMetodLiquiData cobMetodLiquiTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONMetodosLiquidacion.query(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Entrada");
        DAOMetodosLiquidacion dao = new DAOMetodosLiquidacion();
                
        UtilidadesLog.info("MONMetodosLiquidacion.query(CobMetodLiquiData cobMetodLiquiFrom, CobMetodLiquiData cobMetodLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize): Salida");
        return dao.query(cobMetodLiquiFrom, cobMetodLiquiTo, userProperties, pageCount, pageSize );
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONMetodosLiquidacion.remove(Vector entities):Entrada");
        DAOMetodosLiquidacion dao = new DAOMetodosLiquidacion();
        dao.remove(entities);
        UtilidadesLog.info("MONMetodosLiquidacion.remove(Vector entities):Salida");
    }

    public Hashtable guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, 
                                      Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobMetodosLiquidacion.guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOMetodosLiquidacion dao = new DAOMetodosLiquidacion();
        UtilidadesLog.info("MONCobMetodosLiquidacion.guardarMetodoLiq(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardarMetodoLiq(cobMetodLiqui,localizationLabels, userProperties);
    }

    public void update(CobMetodLiquiData cobMetodLiqui, 
                       Vector localizationLabels) throws MareException 
    {    UtilidadesLog.info("MONMetodosLiquidacion.update(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels):Entrada");
        DAOMetodosLiquidacion dao = new DAOMetodosLiquidacion();
        dao.update(cobMetodLiqui,localizationLabels );
        UtilidadesLog.info("MONMetodosLiquidacion.update(CobMetodLiquiData cobMetodLiqui, Vector localizationLabels):Salida");
    }
}
