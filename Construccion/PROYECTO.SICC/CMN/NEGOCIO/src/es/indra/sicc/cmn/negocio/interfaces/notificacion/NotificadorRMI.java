//Source file: F:\\SICC\\src\\es\\indra\\sicc\\cmn\\negocio\\interfaces\\notificacion\\NotificadorRMI.java

package es.indra.sicc.cmn.negocio.interfaces.notificacion;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.Notificador;
import es.indra.sicc.cmn.negocio.interfaces.notificacion.NotificacionDTO;
import es.indra.sicc.util.UtilidadesLog;


public class NotificadorRMI extends Notificador 
{
  private String servidor;
  private int puerto;
   
   public NotificadorRMI(DTONotificacion dto)  throws InterfacesException {
        if(!(dto instanceof DTONotificacionRMI)) {
            throw new InterfacesException("DTO Incorrecto, no es de tipo DTONotificacionRMI");
        }
   
        this.setCodigoInt(dto.getCodigoInt());
        
        this.servidor = ((DTONotificacionRMI)dto).getServidor();
        this.puerto = ((DTONotificacionRMI)dto).getPuerto();
   
   
   }

   public void notificar()  throws InterfacesException {
        //TODO: Implementacion  
        try {
            UtilidadesLog.info(this.toString());   
        }
        catch(Exception ex) {
            throw new InterfacesException("Error enviando notificacion RMI",ex);
        }
  }

	public String toString() {
        StringBuffer sb=new StringBuffer("NOTIFICACION RMI -> Codigo Int:" + super.getCodigoInt());
        sb.append("Servidor:" + this.servidor);
        sb.append("Puerto:" + this.puerto);      
        
        return sb.toString();    
	}
}
