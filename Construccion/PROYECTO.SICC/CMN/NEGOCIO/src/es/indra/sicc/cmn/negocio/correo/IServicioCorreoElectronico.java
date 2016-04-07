package es.indra.sicc.cmn.negocio.correo;
import es.indra.mare.common.exception.MareException;
public interface IServicioCorreoElectronico  {

	public void enviarCorreo (DTOCorreoElectronico dto) throws MareException;

}