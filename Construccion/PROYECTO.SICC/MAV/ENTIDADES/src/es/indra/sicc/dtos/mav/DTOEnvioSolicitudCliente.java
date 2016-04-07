package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Timestamp;
import java.math.BigDecimal; 

public class DTOEnvioSolicitudCliente extends DTOAuditableSICC {
	private Long oidEnvioMAV;
	private Timestamp fechaEntrega;
	private Long numeroUnidades;
	private BigDecimal precioEstandar;
	private BigDecimal precio;
	private BigDecimal precioContable;
	private Long oidDetalleMAV;
	private Long oidCliente;
	private Long oidActividad;
	private Long oidTipoCliente;
	private Boolean indEnvioMensaje;
	private Long oidTipoClasificacion;
	private Long oidClasificacion;
	private Long oidEstadoMAV;
	private Long oidRegion;
	private Long oidZona;
	private Long oidSubtipoCliente;
	private Long oidTipoSolicitud;
	private Long oidTipoPosicion;
	private Long oidSubtipoPosicion;
	private Long oidAcceso;
	private Long oidMoneda;
	private Long oidDetalleOferta;
	private String textoBreve;
	private BigDecimal tipoCambio;
	private String codMensaje;

	public DTOEnvioSolicitudCliente() {
	}

	public Long getOidEnvioMAV() {
		return oidEnvioMAV;
	}

	public void setOidEnvioMAV(Long newOidEnvioMAV) {
		oidEnvioMAV = newOidEnvioMAV;
	}

	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Timestamp newFechaEntrega) {
		fechaEntrega = newFechaEntrega;
	}

	public Long getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(Long newNumeroUnidades) {
		numeroUnidades = newNumeroUnidades;
	}

	public BigDecimal getPrecioEstandar() {
		return precioEstandar;
	}

	public void setPrecioEstandar(BigDecimal newPrecioEstandar) {
		precioEstandar = newPrecioEstandar;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal newPrecio) {
		precio = newPrecio;
	}

	public BigDecimal getPrecioContable() {
		return precioContable;
	}

	public void setPrecioContable(BigDecimal newPrecioContable) {
		precioContable = newPrecioContable;
	}

	public Long getOidDetalleMAV() {
		return oidDetalleMAV;
	}

	public void setOidDetalleMAV(Long newOidDetalleMAV) {
		oidDetalleMAV = newOidDetalleMAV;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidActividad() {
		return oidActividad;
	}

	public void setOidActividad(Long newOidActividad) {
		oidActividad = newOidActividad;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Boolean isIndEnvioMensaje() {
		return indEnvioMensaje;
	}

	public void setIndEnvioMensaje(Boolean newIndEnvioMensaje) {
		indEnvioMensaje = newIndEnvioMensaje;
	}

	public Long getOidTipoClasificacion() {
		return oidTipoClasificacion;
	}

	public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
		oidTipoClasificacion = newOidTipoClasificacion;
	}

	public Long getOidClasificacion() {
		return oidClasificacion;
	}

	public void setOidClasificacion(Long newOidClasificacion) {
		oidClasificacion = newOidClasificacion;
	}

	public Long getOidEstadoMAV() {
		return oidEstadoMAV;
	}

	public void setOidEstadoMAV(Long newOidEstadoMAV) {
		oidEstadoMAV = newOidEstadoMAV;
	}

	public Long getOidRegion() {
		return oidRegion;
	}

	public void setOidRegion(Long newOidRegion) {
		oidRegion = newOidRegion;
	}

	public Long getOidZona() {
		return oidZona;
	}

	public void setOidZona(Long newOidZona) {
		oidZona = newOidZona;
	}

	public Long getOidSubtipoCliente() {
		return oidSubtipoCliente;
	}

	public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
		oidSubtipoCliente = newOidSubtipoCliente;
	}

	public Long getOidTipoSolicitud() {
		return oidTipoSolicitud;
	}

	public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
		oidTipoSolicitud = newOidTipoSolicitud;
	}

	public Long getOidTipoPosicion() {
		return oidTipoPosicion;
	}

	public void setOidTipoPosicion(Long newOidTipoPosicion) {
		oidTipoPosicion = newOidTipoPosicion;
	}

	public Long getOidSubtipoPosicion() {
		return oidSubtipoPosicion;
	}

	public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
		oidSubtipoPosicion = newOidSubtipoPosicion;
	}

	public Long getOidAcceso() {
		return oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		oidAcceso = newOidAcceso;
	}

	public Long getOidMoneda() {
		return oidMoneda;
	}

	public void setOidMoneda(Long newOidMoneda) {
		oidMoneda = newOidMoneda;
	}

	public Long getOidDetalleOferta() {
		return oidDetalleOferta;
	}

	public void setOidDetalleOferta(Long newOidDetalleOferta) {
		oidDetalleOferta = newOidDetalleOferta;
	}

	public String getTextoBreve() {
		return textoBreve;
	}

	public void setTextoBreve(String newTextoBreve) {
		textoBreve = newTextoBreve;
	}

	public BigDecimal getTipoCambio() {
		return tipoCambio;
	}

	public void setTipoCambio(BigDecimal newTipoCambio) {
		tipoCambio = newTipoCambio;
	}

	public String getCodMensaje() {
		return codMensaje;
	}

	public void setCodMensaje(String newCodMensaje) {
		codMensaje = newCodMensaje;
	}
}