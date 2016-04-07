//Source file: F:\\SICC\\src\\es\\indra\\sicc\\cmn\\negocio\\interfaces\\notificacion\\NotificacionDTO.java

package es.indra.sicc.cmn.negocio.interfaces.notificacion;

import java.io.Serializable;

import java.util.Date;

public class NotificacionDTO implements Serializable
{
  private String codigoInterfaz;
	private String mensaje;
   
   /**
    * @roseuid 40B3B07C0268
    */
   public NotificacionDTO() 
   {
   }

   public NotificacionDTO( String codigoInterfaz, String mensaje ) {
	   this.codigoInterfaz = codigoInterfaz;
	   this.mensaje = mensaje + "\nFecha: " + new Date();
   }

  public String getCodigoInterfaz()
  {
    return codigoInterfaz;
  }

  public void setCodigoInterfaz(String newCodigoInterfaz)
  {
    codigoInterfaz = newCodigoInterfaz;
  }

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String newMensaje) {
		mensaje = newMensaje;
	}
}
