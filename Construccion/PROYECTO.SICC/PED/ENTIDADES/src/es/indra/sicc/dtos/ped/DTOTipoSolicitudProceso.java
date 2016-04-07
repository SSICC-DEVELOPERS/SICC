/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas .
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * Componente : DTOTipoSolicitudProceso.java
 * Autor: Hugo Mansi      
 * Creado: 12 de julio de 2004
 * Modificado:
 

**/ 


package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOTipoSolicitudProceso  extends DTOSiccPaginacion {

    private Long subtipoPosicion;   
    private Long tipoPosicion;
    private Long operacion;
	private String producto;
    private Long tipoSolicitud;
    private String descripcion;
	private Boolean indProducto;
    private Long oid;
    //En el modelo se hace referencia a DTOI18nSICC[] como tipo de dato.
	private Vector attriTraducible;
  private Long oidProducto;

	public DTOTipoSolicitudProceso() {
	}

	public Vector getAttriTraducible() {
		return attriTraducible;
	}

	public void setAttriTraducible(Vector newAttriTraducible) {
		attriTraducible = newAttriTraducible;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public Long getTipoSolicitud() {
		return tipoSolicitud;
	}

	public void setTipoSolicitud(Long newTipoSolicitud) {
		tipoSolicitud = newTipoSolicitud;
	}

	public Long getTipoPosicion() {
		return tipoPosicion;
	}

	public void setTipoPosicion(Long newTipoPosicion) {
		tipoPosicion = newTipoPosicion;
	}

	public Boolean getIndProducto() {
		return indProducto;
	}

	public void setIndProducto(Boolean newIndProducto) {
		indProducto = newIndProducto;
	}

	public Long getOperacion() {
		return operacion;
	}

	public void setOperacion(Long newOperacion) {
		operacion = newOperacion;
	}

	public String getProducto() {
		return producto;
	}

	public void setProducto(String newProducto) {
		producto = newProducto;
	}

	public Long getSubtipoPosicion() {
		return subtipoPosicion;
	}

	public void setSubtipoPosicion(Long newSubtipoPosicion) {
		subtipoPosicion = newSubtipoPosicion;
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

  public Long getOidProducto() {
    return oidProducto;
  }

  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }

    







	
}