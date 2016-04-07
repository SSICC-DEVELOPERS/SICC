package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTDatosImpresionGuias extends DTOBelcorp
{
	private Long oidCabecera;
	private String codigoEmpresa;
	private String numeroPedido;
	private String tipoFormulario;
	private String numeroFormulario;
	private String claseSolicitud;
	private String tipoSolicitud;

	public DTOINTDatosImpresionGuias()
	{
	}

	public Long getOidCabecera()
	{
		return oidCabecera;
	}

	public void setOidCabecera(Long oidCabecera)
	{
		this.oidCabecera = oidCabecera;
	}

	public String getCodigoEmpresa()
	{
		return codigoEmpresa;
	}

	public void setCodigoEmpresa(String codigoEmpresa)
	{
		this.codigoEmpresa = codigoEmpresa;
	}

	public String getNumeroPedido()
	{
		return numeroPedido;
	}

	public void setNumeroPedido(String numeroPedido)
	{
		this.numeroPedido = numeroPedido;
	}

	public String getTipoFormulario()
	{
		return tipoFormulario;
	}

	public void setTipoFormulario(String tipoFormulario)
	{
		this.tipoFormulario = tipoFormulario;
	}

	public String getNumeroFormulario()
	{
		return numeroFormulario;
	}

	public void setNumeroFormulario(String numeroFormulario)
	{
		this.numeroFormulario = numeroFormulario;
	}

	public String getClaseSolicitud()
	{
		return claseSolicitud;
	}

	public void setClaseSolicitud(String claseSolicitud)
	{
		this.claseSolicitud = claseSolicitud;
	}

	public String getTipoSolicitud()
	{
		return tipoSolicitud;
	}

	public void setTipoSolicitud(String tipoSolicitud)
	{
		this.tipoSolicitud = tipoSolicitud;
	}
}