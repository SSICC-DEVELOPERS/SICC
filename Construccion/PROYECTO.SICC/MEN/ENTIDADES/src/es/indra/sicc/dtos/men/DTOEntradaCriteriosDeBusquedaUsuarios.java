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
import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOEntradaCriteriosDeBusquedaUsuarios extends DTOSiccPaginacion  {

  private String idUsuario;
  private String nombreUsuario1;
  private String nombreUsuario2;
  private String apellidoUsuario1;
  private String apellidoUsuario2;
  private String perfil;
//	private ArrayList perfil;  
	private String telefonoContacto;
	private String departamento;
	private String validezDesde;
	private String validezHasta;
	private String tipoUsuario;
	private String usuarioHabilitado;
	private String formatoFecha;
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

  public DTOEntradaCriteriosDeBusquedaUsuarios() {
    super();
  }

  public String getIdUsuario(){
    return this.idUsuario;
  }

  public void setIdUsuario(String idUsuario){
    this.idUsuario = idUsuario;
  }

  public String getNombreUsuario1(){
    return this.nombreUsuario1;
  }

  public void setNombreUsuario1(String nombreUsuario1){
    this.nombreUsuario1 = nombreUsuario1;
  }

  public String getNombreUsuario2(){
    return this.nombreUsuario2;
  }

  public void setNombreUsuario2(String nombreUsuario2){
    this.nombreUsuario2 = nombreUsuario2;
  }

  public String getApellidoUsuario1(){
    return this.apellidoUsuario1;
  }

  public void setApellidoUsuario1(String apellidoUsuario1){
    this.apellidoUsuario1 = apellidoUsuario1;
  }

  public String getApellidoUsuario2(){
    return this.apellidoUsuario2;
  }

  public void setApellidoUsuario2(String apellidoUsuario2){
    this.apellidoUsuario2 = apellidoUsuario2;
  }

	public String getPerfil()
	{
		return perfil;
	}

	public void setPerfil(String newPerfil)
	{
		perfil = newPerfil;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String newTelefonoContacto) {
		telefonoContacto = newTelefonoContacto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String newDepartamento) {
		departamento = newDepartamento;
	}

	public String getValidezDesde() {
		return validezDesde;
	}

	public void setValidezDesde(String newValidezDesde) {
		validezDesde = newValidezDesde;
	}

	public String getValidezHasta() {
		return validezHasta;
	}

	public void setValidezHasta(String newValidezHasta) {
		validezHasta = newValidezHasta;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String newTipoUsuario) {
		tipoUsuario = newTipoUsuario;
	}

	public String getUsuarioHabilitado() {
		return usuarioHabilitado;
	}

	public void setUsuarioHabilitado(String newUsuarioHabilitado) {
		usuarioHabilitado = newUsuarioHabilitado;
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String newFormatoFecha) {
		formatoFecha = newFormatoFecha;
	}

}