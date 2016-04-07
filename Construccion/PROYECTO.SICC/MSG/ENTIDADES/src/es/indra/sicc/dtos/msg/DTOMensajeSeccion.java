package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeSeccion extends DTOAuditableSICC {

	private Long oidMensaje;
	private String texto;
	private String codigoMensaje;  
	private Integer ordenImpresion;


	public void setOidMensaje(Long oidMensaje)
	{
	  this.oidMensaje = oidMensaje;	
	}

	public Long getOidMensaje()
	{
	  return this.oidMensaje;	
	}
	
	public void setTexto(String newTexto)
    {
		texto = newTexto;
    }

    public String getTexto()
    {
		return texto;
    }

	public void setOrdenImpresion(Integer ordenImpresion)
	{
	  this.ordenImpresion = ordenImpresion;	
	}

	public Integer getOrdenImpresion()
	{
	  return this.ordenImpresion;	
	}


  public void setCodigoMensaje(String codigoMensaje)
  {
    this.codigoMensaje = codigoMensaje;
  }


  public String getCodigoMensaje()
  {
    return codigoMensaje;
  }
	
}