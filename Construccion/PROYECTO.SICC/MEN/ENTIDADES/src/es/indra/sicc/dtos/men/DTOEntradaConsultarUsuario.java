/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEntradaConsultarUsuario extends DTOAuditableSICC  {

  private String idUsuario;
  private String perfil;
	private String primerApellido;
	private String primerNombre;
	private String tipoUsuario;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

  public DTOEntradaConsultarUsuario() {
    super();
  }

  public String getIdUsuario(){
    return this.idUsuario;
  }

  public void setIdUsuario(String idUsuario){
    this.idUsuario = idUsuario;
  }

  public String getPerfil()	{
	return perfil;
  }

  public void setPerfil(String newPerfil) {
	perfil = newPerfil;
  }

	public String getPrimerApellido() {
		return primerApellido;
	}

	public void setPrimerApellido(String newPrimerApellido) {
		primerApellido = newPrimerApellido;
	}

	public String getPrimerNombre() {
		return primerNombre;
	}

	public void setPrimerNombre(String newPrimerNombre) {
		primerNombre = newPrimerNombre;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String newTipoUsuario) {
		tipoUsuario = newTipoUsuario;
	}
}