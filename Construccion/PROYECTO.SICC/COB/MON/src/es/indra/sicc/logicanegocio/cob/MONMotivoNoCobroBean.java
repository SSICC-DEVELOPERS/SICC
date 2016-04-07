package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobMotivIncobData;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

public class MONMotivoNoCobroBean implements SessionBean {
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

    public Vector query(CobMotivIncobData cobMotivIncobFrom, 
                        CobMotivIncobData cobMotivIncobTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONCobMotivoNoCobro.query(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOMotivoNoCobro dao = new DAOMotivoNoCobro();
        
        UtilidadesLog.info("MONCobMotivoNoCobro.query(CobMotivIncobData cobMotivIncobFrom, CobMotivIncobData cobMotivIncobTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobMotivIncobFrom, cobMotivIncobTo, userProperties, pageCount, pageSize);
    
    
    }

    public void update(CobMotivIncobData cobMotivIncob, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONCobMotivoNoCobro.update(CobMotivoIncobData cobMotivIncob, Vector localizationLabels):Entrada"); 
        DAOMotivoNoCobro dao = new DAOMotivoNoCobro();
        dao.update(cobMotivIncob, localizationLabels );
        UtilidadesLog.info("MONCobMotivoNoCobro.update(CobMotivoIncobData cobMotivIncob, Vector localizationLabels):Salida");
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONCobMotivoNoCobro.remove(Vector entities):Entrada");
        DAOMotivoNoCobro dao = new DAOMotivoNoCobro();
        dao.remove(entities);
        UtilidadesLog.info("MONCobMotivoNoCobro.remove(Vector entities):Salida");
    }

    public Hashtable guardarMotivIncob(CobMotivIncobData cobMotivIncob, 
                                       Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONCobMotivoNoCobro.guardarMotivIncob(CobMotivIncobData cobMotivIncob, Vector localizationLabels, HashMap userProperties):Entrada");
        DAOMotivoNoCobro dao = new DAOMotivoNoCobro();
    
        UtilidadesLog.info("MONCobMotivoNoCobro.guardarMotivIncob(CobMotivIncobData cobMotivIncob, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardarMotivIncob(cobMotivIncob, localizationLabels, userProperties);
    
    
    }
}
