package es.indra.sicc.cmn.negocio.interfaces.notificacion;

import es.indra.mare.common.exception.MareException;
import es.indra.mare.common.mii.MareMii;
import es.indra.mare.common.mii.MareMiiServiceNotFoundException;
import es.indra.mare.common.mii.MareTopic;
import es.indra.mare.common.mii.services.mailservice.MailService;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfacesException;

import es.indra.sicc.util.UtilidadesLog;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NotificadorEmail extends Notificador 
{
	private static MailService mailService = null;
	private String dirCorreo;
    private String mensaje;

   public NotificadorEmail(DTONotificacion dto) throws InterfacesException, MareException {
    if(! (dto instanceof DTONotificacionEmail)) {
        throw new InterfacesException("DTO Incorrecto, no es de tipo DTONotificacionEmail");
    }
    
    this.setCodigoInt(dto.getCodigoInt());
    
    this.dirCorreo = ((DTONotificacionEmail)dto).getDirCorreo();
    this.mensaje = ((DTONotificacionEmail)dto).getMensaje();
    
    if(!validarEmail(this.dirCorreo))
        throw new InterfacesException("Dirección de correo incorrecta");
    	try {
            mailService = ((MailService) MareMii.getService(new MareTopic("MailService")));
        }
        catch (MareMiiServiceNotFoundException ex) {
            throw new MareException( "Error al buscar servicio de correo de MARE" );
        }
   }

  public void notificar() throws InterfacesException
  {    
        try {
            UtilidadesLog.info(this.toString());
            
            mailService.sendMessage(this.dirCorreo,
									this.getCodigoInt(),
									this.mensaje);            
        }
        catch(Exception ex) {
            throw new InterfacesException("Error enviando notificacion Email", ex);
        }        
  }

  public String toString() {
        StringBuffer sb=new StringBuffer("NOTIFICACION EMAIL -> Codigo Int:" + this.getCodigoInt());
        sb.append("dirCorreo:" + this.dirCorreo);
        sb.append("mensaje:" + this.mensaje);
        
        return sb.toString();
  }
 
  private static boolean validarEmail( String direccion ) 
  {
    // Comprueba si la dirección comienza con caracteres no permitidos( ., @, etc)
    Pattern p = Pattern.compile( "^\\.|^\\@" );
    Matcher m = p.matcher( direccion );
    if( m.find() )
      return false;
      
    //Comprueba si la dirección de email comienza con "www"
    p = Pattern.compile( "^www\\." );
    m = p.matcher( direccion );
    if( m.find() )
      return false;

    p = Pattern.compile("[^A-Za-z0-9\\.\\@_\\-~#]+");
    m = p.matcher(direccion);
    StringBuffer sb = new StringBuffer();
    boolean result = m.find();
    boolean deletedIllegalChars = false;

    while(result) {
      deletedIllegalChars = true;
      m.appendReplacement(sb, "");
      result = m.find();
    }

    // Add the last segment of input to the new String
    m.appendTail(sb);

    direccion = sb.toString();

    if( deletedIllegalChars )
      return false;
      
    return true;
   }
}
