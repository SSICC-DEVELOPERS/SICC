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
import java.util.ArrayList;
public class DTOEntradaInsertarUsuarios extends DTOAuditableSICC  {

 
	private String accesoPorDefecto;
	private String apellidoCasada;
	private String canalPorDefecto;
	private String departamento;
	private String email;
	private String fechaFinalRastreo;
	private String fechaInicioRastreo;
	private String fechaSustitucionDesde;
	private String fechaSustitucionHasta;
	private String formatoFecha;
	private String formatoNumerico;
	private String formatoNumericoSeparadorDecimales;
	private String formatoNumericoSeparadorMiles;
	private String identificadorPc;
	private String idioma;
	private String indicacionClaveInicial;
	private String marcaPorDefecto;
	private String observacionesSustitucion;
	private String paisDefecto;
	private String pantallaInicioAsociada;
	private String periodoValidezFechaDesde;
	private String periodoValidezFechaHasta;
	private String primerApellido;
	private String primerNombre;
	private String rastreoAcceso;
	private String regionPorDefecto;
	private String seccionDefecto;
	private String segundoApellido;
	private String segundoNombre;
	private String sociedad;
	private String sociedadPorDefecto;
	private String subaccesoPorDefecto;
	private String subgerenciaVentasDefecto;
	private String telefonoContacto;
	private String territorioPorDefecto;
	private String tipoUsuario;
	private String usuarioHabilitado;
	private String usuarioSustitucion;
	private String zonaPorDefecto;
	private String acceso;
	private String canal;
	private String marca;
	private String pais;
	private String region;
	private String seccion;
	private String subgerenciaVentas;
	private String subnivelAcceso;
	private String territorio;
	private String zona;
//	private String perfil;
	private ArrayList perfil;
	private String idUsuario;
	private String claveAcceso;
  private String indNDG;
  private String indAdmNDG;
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


  public DTOEntradaInsertarUsuarios() {
    super();
  }


	public String getAccesoPorDefecto() {
		return accesoPorDefecto;
	}

	public void setAccesoPorDefecto(String newAccesoPorDefecto) {
		accesoPorDefecto = newAccesoPorDefecto;
	}

	public String getApellidoCasada() {
		return apellidoCasada;
	}

	public void setApellidoCasada(String newApellidoCasada) {
		apellidoCasada = newApellidoCasada;
	}

	public String getCanalPorDefecto() {
		return canalPorDefecto;
	}

	public void setCanalPorDefecto(String newCanalPorDefecto) {
		canalPorDefecto = newCanalPorDefecto;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String newDepartamento) {
		departamento = newDepartamento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String newEmail) {
		email = newEmail;
	}

	public String getFechaFinalRastreo() {
		return fechaFinalRastreo;
	}

	public void setFechaFinalRastreo(String newFechaFinalRastreo) {
		fechaFinalRastreo = newFechaFinalRastreo;
	}

	public String getFechaInicioRastreo() {
		return fechaInicioRastreo;
	}

	public void setFechaInicioRastreo(String newFechaInicioRastreo) {
		fechaInicioRastreo = newFechaInicioRastreo;
	}

	public String getFechaSustitucionDesde() {
		return fechaSustitucionDesde;
	}

	public void setFechaSustitucionDesde(String newFechaSustitucionDesde) {
		fechaSustitucionDesde = newFechaSustitucionDesde;
	}

	public String getFechaSustitucionHasta() {
		return fechaSustitucionHasta;
	}

	public void setFechaSustitucionHasta(String newFechaSustitucionHasta) {
		fechaSustitucionHasta = newFechaSustitucionHasta;
	}

	public String getFormatoFecha() {
		return formatoFecha;
	}

	public void setFormatoFecha(String newFormatoFecha) {
		formatoFecha = newFormatoFecha;
	}

	public String getFormatoNumerico() {
		return formatoNumerico;
	}

	public void setFormatoNumerico(String newFormatoNumerico) {
		formatoNumerico = newFormatoNumerico;
	}

	public String getFormatoNumericoSeparadorDecimales() {
		return formatoNumericoSeparadorDecimales;
	}

	public void setFormatoNumericoSeparadorDecimales(String newFormatoNumericoSeparadorDecimales) {
		formatoNumericoSeparadorDecimales = newFormatoNumericoSeparadorDecimales;
	}

	public String getFormatoNumericoSeparadorMiles() {
		return formatoNumericoSeparadorMiles;
	}

	public void setFormatoNumericoSeparadorMiles(String newFormatoNumericoSeparadorMiles) {
		formatoNumericoSeparadorMiles = newFormatoNumericoSeparadorMiles;
	}

	public String getIdentificadorPc() {
		return identificadorPc;
	}

	public void setIdentificadorPc(String newIdentificadorPc) {
		identificadorPc = newIdentificadorPc;
	}

	public String getIdioma() {
		return idioma;
	}

	public void setIdioma(String newIdioma) {
		idioma = newIdioma;
	}

	public String getIndicacionClaveInicial() {
		return indicacionClaveInicial;
	}

	public void setIndicacionClaveInicial(String newIndicacionClaveInicial) {
		indicacionClaveInicial = newIndicacionClaveInicial;
	}

	public String getMarcaPorDefecto() {
		return marcaPorDefecto;
	}

	public void setMarcaPorDefecto(String newMarcaPorDefecto) {
		marcaPorDefecto = newMarcaPorDefecto;
	}

	public String getObservacionesSustitucion() {
		return observacionesSustitucion;
	}

	public void setObservacionesSustitucion(String newObservacionesSustitucion) {
		observacionesSustitucion = newObservacionesSustitucion;
	}

	public String getPaisDefecto() {
		return paisDefecto;
	}

	public void setPaisDefecto(String newPaisDefecto) {
		paisDefecto = newPaisDefecto;
	}

	public String getPantallaInicioAsociada() {
		return pantallaInicioAsociada;
	}

	public void setPantallaInicioAsociada(String newPantallaInicioAsociada) {
		pantallaInicioAsociada = newPantallaInicioAsociada;
	}

	public String getPeriodoValidezFechaDesde() {
		return periodoValidezFechaDesde;
	}

	public void setPeriodoValidezFechaDesde(String newPeriodoValidezFechaDesde) {
		periodoValidezFechaDesde = newPeriodoValidezFechaDesde;
	}

	public String getPeriodoValidezFechaHasta() {
		return periodoValidezFechaHasta;
	}

	public void setPeriodoValidezFechaHasta(String newPeriodoValidezFechaHasta) {
		periodoValidezFechaHasta = newPeriodoValidezFechaHasta;
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

	public String getRastreoAcceso() {
		return rastreoAcceso;
	}

	public void setRastreoAcceso(String newRastreoAcceso) {
		rastreoAcceso = newRastreoAcceso;
	}

	public String getRegionPorDefecto() {
		return regionPorDefecto;
	}

	public void setRegionPorDefecto(String newRegionPorDefecto) {
		regionPorDefecto = newRegionPorDefecto;
	}

	public String getSeccionDefecto() {
		return seccionDefecto;
	}

	public void setSeccionDefecto(String newSeccionDefecto) {
		seccionDefecto = newSeccionDefecto;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public void setSegundoApellido(String newSegundoApellido) {
		segundoApellido = newSegundoApellido;
	}

	public String getSegundoNombre() {
		return segundoNombre;
	}

	public void setSegundoNombre(String newSegundoNombre) {
		segundoNombre = newSegundoNombre;
	}

	public String getSociedad() {
		return sociedad;
	}

	public void setSociedad(String newSociedad) {
		sociedad = newSociedad;
	}

	public String getSociedadPorDefecto() {
		return sociedadPorDefecto;
	}

	public void setSociedadPorDefecto(String newSociedadPorDefecto) {
		sociedadPorDefecto = newSociedadPorDefecto;
	}

	public String getSubaccesoPorDefecto() {
		return subaccesoPorDefecto;
	}

	public void setSubaccesoPorDefecto(String newSubaccesoPorDefecto) {
		subaccesoPorDefecto = newSubaccesoPorDefecto;
	}

	public String getSubgerenciaVentasDefecto() {
		return subgerenciaVentasDefecto;
	}

	public void setSubgerenciaVentasDefecto(String newSubgerenciaVentasDefecto) {
		subgerenciaVentasDefecto = newSubgerenciaVentasDefecto;
	}

	public String getTelefonoContacto() {
		return telefonoContacto;
	}

	public void setTelefonoContacto(String newTelefonoContacto) {
		telefonoContacto = newTelefonoContacto;
	}

	public String getTerritorioPorDefecto() {
		return territorioPorDefecto;
	}

	public void setTerritorioPorDefecto(String newTerritorioPorDefecto) {
		territorioPorDefecto = newTerritorioPorDefecto;
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

	public String getUsuarioSustitucion() {
		return usuarioSustitucion;
	}

	public void setUsuarioSustitucion(String newUsuarioSustitucion) {
		usuarioSustitucion = newUsuarioSustitucion;
	}

	public String getZonaPorDefecto() {
		return zonaPorDefecto;
	}

	public void setZonaPorDefecto(String newZonaPorDefecto) {
		zonaPorDefecto = newZonaPorDefecto;
	}

	public String getAcceso() {
		return acceso;
	}

	public void setAcceso(String newAcceso) {
		acceso = newAcceso;
	}

	public String getCanal() {
		return canal;
	}

	public void setCanal(String newCanal) {
		canal = newCanal;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String newMarca) {
		marca = newMarca;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String newPais) {
		pais = newPais;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String newRegion) {
		region = newRegion;
	}

	public String getSeccion() {
		return seccion;
	}

	public void setSeccion(String newSeccion) {
		seccion = newSeccion;
	}

	public String getSubgerenciaVentas() {
		return subgerenciaVentas;
	}

	public void setSubgerenciaVentas(String newSubgerenciaVentas) {
		subgerenciaVentas = newSubgerenciaVentas;
	}

	public String getSubnivelAcceso() {
		return subnivelAcceso;
	}

	public void setSubnivelAcceso(String newSubnivelAcceso) {
		subnivelAcceso = newSubnivelAcceso;
	}

	public String getTerritorio() {
		return territorio;
	}

	public void setTerritorio(String newTerritorio) {
		territorio = newTerritorio;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String newZona) {
		zona = newZona;
	}

	public ArrayList getPerfil() {
		return perfil;
	}

	public void setPerfil(ArrayList newPerfil) {
		perfil = newPerfil;
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String newIdUsuario) {
		idUsuario = newIdUsuario;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String newClaveAcceso) {
		claveAcceso = newClaveAcceso;
	}

  public String getIndNDG()
  {
    return indNDG;
  }

  public void setIndNDG(String newIndNDG)
  {
    indNDG = newIndNDG;
  }

  public String getIndAdmNDG()
  {
    return indAdmNDG;
  }

  public void setIndAdmNDG(String newIndAdmNDG)
  {
    indAdmNDG = newIndAdmNDG;
  }

}
