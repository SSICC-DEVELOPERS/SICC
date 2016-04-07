package es.indra.sicc.cmn.negocio.interfaces.notificacion;

//import com.sap.mw.jco.IFunctionTemplate;
//import com.sap.mw.jco.JCO;

import es.indra.mare.common.exception.MareException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

public class NotificadorJCO extends Notificador 
{
  public NotificadorJCO()
  {
  }
  
  public void notificar( ) throws InterfacesException
  {
    
  }
  
  public void notificar( NotificacionDTO dto ) throws InterfacesException
  {
    
  }
  
    public Notificador obtenerNotificador(DTONotificacion dto) throws InterfacesException {
        try {
            return new NotificadorJCO();
        }
        catch(Exception ex) {
            ex.printStackTrace();
            throw new InterfacesException( "Error obteniendo NotificadorJCO", ex );
        }        
    }
}