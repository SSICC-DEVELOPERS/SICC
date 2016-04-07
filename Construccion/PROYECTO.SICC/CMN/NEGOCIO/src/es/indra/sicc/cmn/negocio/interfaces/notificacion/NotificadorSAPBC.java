package es.indra.sicc.cmn.negocio.interfaces.notificacion;

//import com.wm.app.b2b.client.Context;
//import com.wm.app.b2b.client.ServiceException;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;
import es.indra.sicc.util.UtilidadesLog;

public class NotificadorSAPBC extends Notificador {
   private String servidor;
   private int puerto;
   private String idUsuario;
   private String contrasena;
   private String paquete;
   private String bapi;  
   
   public NotificadorSAPBC(DTONotificacion dto)  throws InterfacesException {
        if(!(dto instanceof DTONotificacionSAPBC)) {
            throw new InterfacesException("DTO Incorrecto, no es de tipo DTONotificacionSAPBC");
        }
   
        this.setCodigoInt(dto.getCodigoInt());
        
        this.servidor = ((DTONotificacionSAPBC)dto).getServidor();
        this.puerto = ((DTONotificacionSAPBC)dto).getPuerto();
        this.idUsuario = ((DTONotificacionSAPBC)dto).getIdUsuario();
        this.contrasena = ((DTONotificacionSAPBC)dto).getContrasena();
        this.paquete = ((DTONotificacionSAPBC)dto).getPaquete();
        this.bapi = ((DTONotificacionSAPBC)dto).getBapi();
   }

  public void notificar()  throws InterfacesException {
        //TODO: Implementacion  
        try {
            UtilidadesLog.info(this.toString());   
        }
        catch(Exception ex) {
            throw new InterfacesException("Error enviando notificacion SAP-BC", ex);
        }
  }

  public String toString() {
        StringBuffer sb=new StringBuffer("NOTIFICACION SAP-BC -> Codigo Int:" + super.getCodigoInt());
        sb.append("Servidor:" + this.servidor);
        sb.append("Puerto:" + this.puerto);
        sb.append("idUsuario:" + this.idUsuario);
        sb.append("contrasena:" + this.contrasena);
        sb.append("paquete:" + this.paquete);
        sb.append("bapi:" + this.bapi);		       
        
        return sb.toString();
  }
}
