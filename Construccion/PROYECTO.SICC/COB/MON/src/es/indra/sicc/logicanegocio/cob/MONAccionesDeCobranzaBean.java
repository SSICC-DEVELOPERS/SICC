package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobAccioCobraData;
import es.indra.belcorp.mso.CobSubtiAccioData;
import es.indra.mare.common.dto.MareDTO;
import es.indra.mare.common.exception.MareException;

import es.indra.sicc.util.UtilidadesLog;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

import javax.ejb.EJBException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import javax.rmi.PortableRemoteObject;

public class MONAccionesDeCobranzaBean implements SessionBean {
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

    public Vector query(CobSubtiAccioData cobSubtiAccioFrom, 
                        CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties) throws MareException 
    {    UtilidadesLog.info("MONAccionesDeCobranza.query(CobSubtiAccioData cobSubtiAccioFrom, CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties):Entrada");
        
            DAOAccionesDeCobranza dao = new DAOAccionesDeCobranza();
        
        UtilidadesLog.info("MONAccionesDeCobranza.query(CobSubtiAccioData cobSubtiAccioFrom, CobSubtiAccioData cobSubtiAccioTo, HashMap userProperties):Salida");
            return dao.query(cobSubtiAccioFrom, cobSubtiAccioTo, userProperties);
    }
    

    public Vector query(CobAccioCobraData cobAccioCobraFrom, 
                        CobAccioCobraData cobAccioCobraTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONAccionesDeCobranza.query(CobAccioCobraData cobAccioCobraFrom, CobAccioCobraData cobAccioCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOAccionesDeCobranza dao= new DAOAccionesDeCobranza();    
    
    
        UtilidadesLog.info("MONAccionesDeCobranza.query(CobAccioCobraData cobAccioCobraFrom, CobAccioCobraData cobAccioCobraTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        return dao.query(cobAccioCobraFrom, cobAccioCobraTo, userProperties, pageCount, pageSize);
           
 
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONAccionesDeCobranza.remove(Vector entities):Entrada");
        DAOAccionesDeCobranza dao = new DAOAccionesDeCobranza();
        dao.remove(entities);
        UtilidadesLog.info("MONAccionesDeCobranza.remove(Vector entities):Salida");
    }

    public void update(CobAccioCobraData cobAccioCobra, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONAccionesDeCobranza.update(CobAccioCobraData cobAccioCobra, Vector localizationLabels): Entrada");
        ExtensionCOBBean ext = new ExtensionCOBBean();     
        MareDTO dto = new MareDTO();
        // dto.addProperty("id", cobAccioCobra.getId());
        dto.addProperty("paisOidPais", cobAccioCobra.getPaisOidPais().getId());
        dto.addProperty("indAcciMensReco", cobAccioCobra.getIndAcciMensReco());
    
        ext.validacionRecordatorio(dto);
    
        DAOAccionesDeCobranza dao = new DAOAccionesDeCobranza();
        dao.update(cobAccioCobra,localizationLabels );
        UtilidadesLog.info("MONAccionesDeCobranza.update(CobAccioCobraData cobAccioCobra, Vector localizationLabels): Salida");
    
    }

    public Hashtable guardarAccion(CobAccioCobraData cobAccioCobra, 
                                   Vector localizationLabels, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONAccionesDeCobranza.guardarAccion(CobAccioCobraData cobAccioCobra, Vector localizationLabels, HashMap userProperties):Entrada");
        ExtensionCOBBean fun = new ExtensionCOBBean();     
        MareDTO dto = new MareDTO();
        // dto.addProperty("id", cobAccioCobra.getId());
        dto.addProperty("paisOidPais", cobAccioCobra.getPaisOidPais().getId());
        dto.addProperty("indAcciMensReco", cobAccioCobra.getIndAcciMensReco());
    
        fun.validacionRecordatorio(dto);
    
        DAOAccionesDeCobranza dao = new DAOAccionesDeCobranza();
    
        UtilidadesLog.info("MONAccionesDeCobranza.guardarAccion(CobAccioCobraData cobAccioCobra, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardarAccion(cobAccioCobra, localizationLabels, userProperties);
    }


    private ExtensionCOBHome getExtensionCOBHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionCOBHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionCOB" ), ExtensionCOBHome.class );
    }
}
