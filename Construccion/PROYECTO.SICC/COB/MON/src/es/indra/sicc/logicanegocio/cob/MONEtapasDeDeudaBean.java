package es.indra.sicc.logicanegocio.cob;

import es.indra.belcorp.mso.CobEtapaDeudaData;
import es.indra.belcorp.mso.CobGuionArgumCabecViewData;
import es.indra.belcorp.mso.CobOrdenEtapaDeudaData;
import es.indra.belcorp.mso.CobTipoBalanData;
import es.indra.belcorp.mso.MsgMensaData;
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

public class MONEtapasDeDeudaBean implements SessionBean {
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

    public Vector query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, 
                        CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        UtilidadesLog.info("MONEtapasDeuda.query(CobGuionArgumCabecViewData cobGuionArgumCabecViewFrom, CobGuionArgumCabecViewData cobGuionArgumCabecViewTo, HashMap userProperties):Salida");
        return dao.query(cobGuionArgumCabecViewFrom, cobGuionArgumCabecViewTo, userProperties);
    
    
    }

    public Vector query(CobTipoBalanData cobTipoBalanFrom, 
                        CobTipoBalanData cobTipoBalanTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.query(CobTipoBalanData cobTipoBalanFrom, CobTipoBalanData cobTipoBalanTo, HashMap userProperties):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        UtilidadesLog.info("MONEtapasDeuda.query(CobTipoBalanData cobTipoBalanFrom, CobTipoBalanData cobTipoBalanTo, HashMap userProperties):Salida");
        return dao.query(cobTipoBalanFrom, cobTipoBalanTo,userProperties);
   
    }

    public Vector query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        UtilidadesLog.info("MONEtapasDeuda.query(MsgMensaData msgMensaFrom, MsgMensaData msgMensaTo, HashMap userProperties):Entrada");
        return dao.query(msgMensaFrom, msgMensaTo,userProperties);   
    }

    public Vector query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, 
                        CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        UtilidadesLog.info("MONEtapasDeuda.query(CobOrdenEtapaDeudaData cobOrdenEtapaDeudaFrom, CobOrdenEtapaDeudaData cobOrdenEtapaDeudaTo, HashMap userProperties):Entrada");
        return dao.query(cobOrdenEtapaDeudaFrom, cobOrdenEtapaDeudaTo, userProperties);
  
    }

    public Vector query(CobEtapaDeudaData cobEtapaDeudaFrom, 
                        CobEtapaDeudaData cobEtapaDeudaTo, 
                        HashMap userProperties, Integer pageCount, Integer pageSize) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        UtilidadesLog.info("MONEtapasDeuda.query(CobEtapaDeudaData cobEtapaDeudaFrom, CobEtapaDeudaData cobEtapaDeudaTo, HashMap userProperties, Integer pageCount, Integer pageSize):Salida");
        return dao.query(cobEtapaDeudaFrom, cobEtapaDeudaTo, userProperties, pageCount, pageSize);
    
    }

    public Hashtable guardar(CobEtapaDeudaData cobEtapaDeuda, 
                             Vector localizationLabels, HashMap userProperties) throws MareException
    {   UtilidadesLog.info("MONCobEtapasDeuda.guardar(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels, HashMap userProperties):Entrada");
         ExtensionCOBBean ext = new ExtensionCOBBean();     
        MareDTO dto = new MareDTO();
        
        dto.addProperty("id", cobEtapaDeuda.getId());
        dto.addProperty("valEdadInic", cobEtapaDeuda.getValEdadInic());
        dto.addProperty("valEdadFina", cobEtapaDeuda.getValEdadFina());
        dto.addProperty("paisOidPais", cobEtapaDeuda.getPaisOidPais().getId());
        ext.validacionEntreExclusivas(dto);
    
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
    
        UtilidadesLog.info("MONCobEtapasDeuda.guardar(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels, HashMap userProperties):Salida");
        return dao.guardar(cobEtapaDeuda, localizationLabels, userProperties);
    
    }

    public void remove(Vector entities) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.remove(Vector entities):Entrada");
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        dao.remove(entities);
        UtilidadesLog.info("MONEtapasDeuda.remove(Vector entities):Salida");
    }

    public void update(CobEtapaDeudaData cobEtapaDeuda, 
                       Vector localizationLabels) throws MareException 
    {   UtilidadesLog.info("MONEtapasDeuda.update(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels):Entrada");
        ExtensionCOBBean ext = new ExtensionCOBBean();     
        MareDTO dto = new MareDTO();
        
        dto.addProperty("id", cobEtapaDeuda.getId());
        dto.addProperty("valEdadInic", cobEtapaDeuda.getValEdadInic());
        dto.addProperty("valEdadFina", cobEtapaDeuda.getValEdadFina());
        dto.addProperty("paisOidPais", cobEtapaDeuda.getPaisOidPais().getId());
        ext.validacionEntreExclusivas(dto);
        
        
        DAOEtapasDeDeuda dao = new DAOEtapasDeDeuda();
        dao.update(cobEtapaDeuda, localizationLabels);
        
        UtilidadesLog.info("MONEtapasDeuda.update(CobEtapaDeudaData cobEtapaDeuda, Vector localizationLabels):Salida");
    
    }

    private ExtensionCOBHome getExtensionCOBHome() throws NamingException {
        final InitialContext context = new InitialContext();
        return (ExtensionCOBHome) PortableRemoteObject.narrow( context.lookup( "java:comp/env/ExtensionCOB" ), ExtensionCOBHome.class );
    }
}
