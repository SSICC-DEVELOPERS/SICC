/**
 * Sistema:     Belcorp
 * Modulo:      PED
 * Fecha:       12/07/2004
 * @version     1.0
 * @autor       Maximiliano Dello Russo
 */

package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.HashMap;
import es.indra.sicc.cmn.negocio.i18n.DTOI18nSICC;
import java.util.Vector;

public class DTOTipoSolicitud extends DTOSiccPaginacion {

	private Long oid;
	private Boolean indConsolidado;
	private Long claseSolicitud;
	private String descripcion;
	private Boolean indSolNegativa;
	private Long marca;
	private Long canal;
	private Long acceso;
	private Long tipoCliente;
	private String codigo;
	private Boolean indDevoluciones;
	private Boolean indAnulacion;
	private Long subacceso;
	private Vector attriTraducible;

	public DTOTipoSolicitud() {
	}

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Boolean getIndConsolidado() {
		return indConsolidado;
	}

	public void setIndConsolidado(Boolean newIndConsolidado) {
		indConsolidado = newIndConsolidado;
	}

	public Long getClaseSolicitud() {
		return claseSolicitud;
	}

	public void setClaseSolicitud(Long newClaseSolicitud) {
		claseSolicitud = newClaseSolicitud;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public Boolean getIndSolNegativa() {
		return indSolNegativa;
	}

	public void setIndSolNegativa(Boolean newIndSolNegativa) {
		indSolNegativa = newIndSolNegativa;
	}

	public Long getMarca() {
		return marca;
	}

	public void setMarca(Long newMarca) {
		marca = newMarca;
	}

	public Long getCanal() {
		return canal;
	}

	public void setCanal(Long newCanal) {
		canal = newCanal;
	}

	public Long getAcceso() {
		return acceso;
	}

	public void setAcceso(Long newAcceso) {
		acceso = newAcceso;
	}

	public Long getTipoCliente() {
		return tipoCliente;
	}

	public void setTipoCliente(Long newTipoCliente) {
		tipoCliente = newTipoCliente;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String newCodigo) {
		codigo = newCodigo;
	}

	public Boolean getIndDevoluciones() {
		return indDevoluciones;
	}

	public void setIndDevoluciones(Boolean newIndDevoluciones) {
		indDevoluciones = newIndDevoluciones;
	}

	public Boolean getIndAnulacion() {
		return indAnulacion;
	}

	public void setIndAnulacion(Boolean newIndAnulacion) {
		indAnulacion = newIndAnulacion;
	}

	public Long getSubacceso() {
		return subacceso;
	}

	public void setSubacceso(Long newSubacceso) {
		subacceso = newSubacceso;
	}

	public Vector getAttriTraducible() {
		return attriTraducible;
	}

	public void setAttriTraducible(Vector newAttriTraducible) {
		attriTraducible = newAttriTraducible;
	}



}

