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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DTOSalidaMantenimientoUsuarios extends DTOAuditableSICC {
	private RecordSet marcas;
	private RecordSet accesos;
	private RecordSet canales;
    private RecordSet departamentos;
    private RecordSet paises;
    private RecordSet empresas;
    private RecordSet subaccesos;
	private RecordSet perfiles;
	private RecordSet funcionesMenu;
	private RecordSet usuariosSustitucion;
	private RecordSet idiomas;
	private RecordSet zonas;
	private RecordSet regiones;
	private RecordSet secciones;
	private RecordSet territorios;
	private RecordSet subgerencias;
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

	public DTOSalidaMantenimientoUsuarios()	{
		super();
	}

	public DTOSalidaMantenimientoUsuarios(RecordSet marcas,
										  RecordSet accesos,
										  RecordSet canales,
										  RecordSet departamentos,
										  RecordSet paises, 
										  RecordSet empresas, 
										  RecordSet subaccesos,
										  RecordSet perfiles,
										  RecordSet funcionesMenu,
										  RecordSet usuariosSustitucion,
										  RecordSet idiomas,
										  RecordSet zonas,
										  RecordSet regiones,
										  RecordSet secciones,
										  RecordSet territorios,
										  RecordSet comunidades) {
		super();
		this.marcas = marcas;
		this.accesos = accesos;
		this.canales = canales;
		this.departamentos = departamentos;
		this.paises = paises;
		this.empresas = empresas;
		this.subaccesos = subaccesos;
		this.perfiles = perfiles;
		this.funcionesMenu = funcionesMenu;
		this.usuariosSustitucion = usuariosSustitucion;
		this.idiomas = idiomas;
		this.zonas = zonas;
		this.regiones =  regiones;
		this.secciones = secciones;
		this.territorios = territorios;
		this.subgerencias = subgerencias;
	}
	
	public RecordSet getMarcas() {
		return marcas;
	}

	public void setMarcas(RecordSet newMarcas) {
		marcas = newMarcas;
	}

	public RecordSet getAccesos() {
		return accesos;
	}

	public void setAccesos(RecordSet newAccesos) {
		accesos = newAccesos;
	}

	public RecordSet getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(RecordSet newDepartamentos) {
		departamentos = newDepartamentos;
	}

	public RecordSet getEmpresas() {
		return empresas;
	}

	public void setEmpresas(RecordSet newEmpresas) {
		empresas = newEmpresas;
	}

	public RecordSet getCanales() {
		return canales;
	}

	public void setCanales(RecordSet newCanales) {
		canales = newCanales;
	}

	public RecordSet getPaises() {
		return paises;
	}

	public void setPaises(RecordSet newPaises) {
		paises = newPaises;
	}

	public RecordSet getSubaccesos() {
		return subaccesos;
	}

	public void setSubaccesos(RecordSet newSubaccesos) {
		subaccesos = newSubaccesos;
	}

	public RecordSet getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(RecordSet newPerfiles) {
		perfiles = newPerfiles;
	}

	public RecordSet getFuncionesMenu() {
		return funcionesMenu;
	}

	public void setFuncionesMenu(RecordSet newFuncionesMenu) {
		funcionesMenu = newFuncionesMenu;
	}

	public RecordSet getUsuariosSustitucion() {
		return usuariosSustitucion;
	}

	public void setUsuariosSustitucion(RecordSet newUsuariosSustitucion) {
		usuariosSustitucion = newUsuariosSustitucion;
	}

	public RecordSet getZonas() {
		return zonas;
	}

	public void setZonas(RecordSet newZonas) {
		zonas = newZonas;
	}

	public RecordSet getTerritorios() {
		return territorios;
	}

	public void setTerritorios(RecordSet newTerritorios) {
		territorios = newTerritorios;
	}

	public RecordSet getSecciones() {
		return secciones;
	}

	public void setSecciones(RecordSet newSecciones) {
		secciones = newSecciones;
	}

	public RecordSet getRegiones() {
		return regiones;
	}

	public void setRegiones(RecordSet newRegiones) {
		regiones = newRegiones;
	}

	public RecordSet getIdiomas() {
		return idiomas;
	}

	public void setIdiomas(RecordSet newIdiomas) {
		idiomas = newIdiomas;
	}

	public RecordSet getSubgerencias() {
		return subgerencias;
	}

	public void setSubgerencias(RecordSet newComunidades) {
		subgerencias = newComunidades;
	}
}