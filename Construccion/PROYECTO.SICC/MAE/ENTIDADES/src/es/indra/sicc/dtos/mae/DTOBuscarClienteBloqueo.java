package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarClienteBloqueo extends DTOSiccPaginacion  {

	private String codigo;
	private String nombre1;
	private String nombre2;
	private String apellido1;
	private String apellido2;
	private String documentoIdentificacion;
  
  // Brecha COL-BLO-001 - dmorello, 14/03/2008
  private Long oidTipoDocumento;

	public DTOBuscarClienteBloqueo() {
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String newCodigo) {
		codigo = newCodigo;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String newNombre1) {
		nombre1 = newNombre1;
	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String newNombre2) {
		nombre2 = newNombre2;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String newApellido1) {
		apellido1 = newApellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String newApellido2) {
		apellido2 = newApellido2;
	}

	public String getDocumentoIdentificacion() {
		return documentoIdentificacion;
	}

	public void setDocumentoIdentificacion(String newDocumentoIdentificacion) {
		documentoIdentificacion = newDocumentoIdentificacion;
	}

  public Long getOidTipoDocumento()
  {
    return oidTipoDocumento;
  }

  public void setOidTipoDocumento(Long oidTipoDocumento)
  {
    this.oidTipoDocumento = oidTipoDocumento;
  }
}