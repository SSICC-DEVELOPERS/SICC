package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;

public class DTODetalleCampaniaEstimadosBP extends DTOAuditableSICC {
	private Long oidDetalleMAV;
	private String codigoSAP;
	private String codigoVenta;
	private String descripcionProducto;
	private ArrayList subtiposCliente;
	private Long tipoClasificacion;
	private Long clasificacion;
	private Long numeroClientesEstimados;
	private Long unidadesPromedio;
	private Long unidadesTotales;
	private Long unidadesDisponibles;
	private String condicion;
	private String valorCondicion;

	public DTODetalleCampaniaEstimadosBP() {
	}

	public Long getOidDetalleMAV() {
		return oidDetalleMAV;
	}

	public void setOidDetalleMAV(Long newOidDetalleMAV) {
		oidDetalleMAV = newOidDetalleMAV;
	}

	public String getCodigoSAP() {
		return codigoSAP;
	}

	public void setCodigoSAP(String newCodigoSAP) {
		codigoSAP = newCodigoSAP;
	}

	public String getCodigoVenta() {
		return codigoVenta;
	}

	public void setCodigoVenta(String newCodigoVenta) {
		codigoVenta = newCodigoVenta;
	}

	public String getDescripcionProducto() {
		return descripcionProducto;
	}

	public void setDescripcionProducto(String newDescripcionProducto) {
		descripcionProducto = newDescripcionProducto;
	}

	public ArrayList getSubtiposCliente() {
		return subtiposCliente;
	}

	public void setSubtiposCliente(ArrayList newSubtiposCliente) {
		subtiposCliente = newSubtiposCliente;
	}

	public Long getTipoClasificacion() {
		return tipoClasificacion;
	}

	public void setTipoClasificacion(Long newTipoClasificacion) {
		tipoClasificacion = newTipoClasificacion;
	}

	public Long getClasificacion() {
		return clasificacion;
	}

	public void setClasificacion(Long newClasificacion) {
		clasificacion = newClasificacion;
	}

	public Long getNumeroClientesEstimados() {
		return numeroClientesEstimados;
	}

	public void setNumeroClientesEstimados(Long newNumeroClientesEstimados) {
		numeroClientesEstimados = newNumeroClientesEstimados;
	}

	public Long getUnidadesPromedio() {
		return unidadesPromedio;
	}

	public void setUnidadesPromedio(Long newUnidadesPromedio) {
		unidadesPromedio = newUnidadesPromedio;
	}

	public Long getUnidadesTotales() {
		return unidadesTotales;
	}

	public void setUnidadesTotales(Long newUnidadesTotales) {
		unidadesTotales = newUnidadesTotales;
	}

	public Long getUnidadesDisponibles() {
		return unidadesDisponibles;
	}

	public void setUnidadesDisponibles(Long newUnidadesDisponibles) {
		unidadesDisponibles = newUnidadesDisponibles;
	}

	public String getCondicion() {
		return condicion;
	}

	public void setCondicion(String newCondicion) {
		condicion = newCondicion;
	}

	public String getValorCondicion() {
		return valorCondicion;
	}

	public void setValorCondicion(String newValorCondicion) {
		valorCondicion = newValorCondicion;
	}
}