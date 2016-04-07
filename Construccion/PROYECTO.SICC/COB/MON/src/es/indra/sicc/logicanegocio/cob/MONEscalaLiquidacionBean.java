package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEscalLiquiData;
import es.indra.belcorp.mso.CobMetodLiquiViewData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONEscalaLiquidacionBean implements SessionBean {
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

    public Vector query(CobEscalLiquiData cobEscalLiquiFrom, 
                        CobEscalLiquiData cobEscalLiquiTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONEscalaLiquidacion.query(CobEscalLiquiData cobEscalLiquiFrom, CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOEscalaLiquidacion dao = new DAOEscalaLiquidacion();
        UtilidadesLog.info("MONEscalaLiquidacion.query(CobEscalLiquiData cobEscalLiquiFrom, CobEscalLiquiData cobEscalLiquiTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobEscalLiquiFrom, cobEscalLiquiTo, userProperties, pageCount, pageSize);
   
    }

    public Vector query(CobMetodLiquiViewData cobMetodLiquiViewFrom, 
                        CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONEscalaLiquidacion.query(CobMetodLiquiViewData cobMetodLiquiViewFrom, CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties):Entrada"); 
        DAOEscalaLiquidacion dao = new DAOEscalaLiquidacion();
    
        UtilidadesLog.info("MONEscalaLiquidacion.query(CobMetodLiquiViewData cobMetodLiquiViewFrom, CobMetodLiquiViewData cobMetodLiquiViewTo, HashMap userProperties):Salida"); 
        return dao.query(cobMetodLiquiViewFrom, cobMetodLiquiViewTo, userProperties );
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONEscalaLiquidacion.remove(Vector entities):Entrada");
        DAOEscalaLiquidacion dao = new DAOEscalaLiquidacion();
        dao.remove(entities);
        UtilidadesLog.info("MONEscalaLiquidacion.remove(Vector entities):Salida");
    }

    public void update(CobEscalLiquiData cobEscalLiqui, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONEscalaLiquidacion.update(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels):Entrada");
        DAOEscalaLiquidacion dao = new DAOEscalaLiquidacion();
        dao.update(cobEscalLiqui, localizationLabels);
        UtilidadesLog.info("MONEscalaLiquidacion.update(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels):Salida");
    }

    public Hashtable guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, 
                                      Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobEscalaLiquidacion.guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels, HashMap userProperties):Entrada");
    
        DAOEscalaLiquidacion dao = new DAOEscalaLiquidacion();
        UtilidadesLog.info("MONCobEscalaLiquidacion.guardarEscaLiqui(CobEscalLiquiData cobEscalLiqui, Vector localizationLabels, HashMap userProperties):Entrada");
        
        return dao.guardarEscaLiqui(cobEscalLiqui, localizationLabels, userProperties);
    }
}
