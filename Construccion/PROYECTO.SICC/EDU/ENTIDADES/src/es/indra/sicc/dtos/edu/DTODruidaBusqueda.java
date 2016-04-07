/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 
package es.indra.sicc.dtos.edu;

public class DTODruidaBusqueda extends es.indra.sicc.util.DTOBelcorp {

    private Long oidMarca;
    private Long oidCanal;
    private Long oidTipoCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoClasificacion;
    private Long oidSubgerencia;
    private Long oidZona;
    private Long oidRegion;
    private Long oidSeccion;
    private Long oidTipoCurso;

    public DTODruidaBusqueda() {
        super();
    }

    public Long getOidMarca() {
        return this.oidMarca;
    }

    public void setOidMarca(Long newOidMarca) {
        this.oidMarca = newOidMarca;
    }

    public Long getOidCanal() {
        return this.oidCanal;
    }

    public void setOidCanal(Long newOidCanal) {
        this.oidCanal = newOidCanal;
    }

    public Long getOidTipoCliente() {
        return this.oidTipoCliente;
    }

    public void setOidTipoCliente(Long newOidTipoCliente) {
        this.oidTipoCliente = newOidTipoCliente;
    }

    public Long getOidSubtipoCliente() {
        return this.oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        this.oidSubtipoCliente = newOidSubtipoCliente;
    }

    public Long getOidTipoClasificacion() {
        return this.oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        this.oidTipoClasificacion = newOidTipoClasificacion;
    }

    public Long getOidSubgerencia() {
        return this.oidSubgerencia;
    }

    public void setOidSubgerencia(Long newOidSubgerencia) {
        this.oidSubgerencia = newOidSubgerencia;
    }

    public Long getOidZona() {
        return this.oidZona;
    }

    public void setOidZona(Long newOidZona) {
        this.oidZona = newOidZona;
    }

    public Long getOidRegion() {
        return this.oidRegion;
    }

    public void setOidRegion(Long newOidRegion) {
        this.oidRegion = newOidRegion;
    }

    public Long getOidSeccion() {
        return this.oidSeccion;
    }

    public void setOidSeccion(Long newOidSeccion) {
        this.oidSeccion = newOidSeccion;
    }

	public Long getOidTipoCurso() {
		return oidTipoCurso;
	}

	public void setOidTipoCurso(Long newOidTipoCurso) {
		oidTipoCurso = newOidTipoCurso;
	}

}