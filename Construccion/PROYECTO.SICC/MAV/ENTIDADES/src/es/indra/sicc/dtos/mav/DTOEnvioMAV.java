package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class DTOEnvioMAV extends DTOSiccPaginacion  {
	private Long oidEnvioMAV;
	private Long numeroUnidades;
	private Long tipoEstadoEnvio;
	private Timestamp fechaEntrega;
	private BigDecimal precioEstandar;
	private BigDecimal precio;
	private BigDecimal precioContable;
	private Long oidDetalle;
	private Long oidMatrizFact;
	private Long oidCliente;
	private Long oidSolicitudEnvio;
	private Long oidFormaCobro;
	private Long oidBuzonMensaje;
	private Long oidActividadTipoDespacho;
	private Long oidActividad;
	private Long oidFormaPago;
	private String indEnvio;
  private Long oidMensaje;

	public DTOEnvioMAV() {
	}

	public Long getOidEnvioMAV() {
		return oidEnvioMAV;
	}

	public void setOidEnvioMAV(Long newOidEnvioMAV) {
		oidEnvioMAV = newOidEnvioMAV;
	}

	public Long getNumeroUnidades() {
		return numeroUnidades;
	}

	public void setNumeroUnidades(Long newNumeroUnidades) {
		numeroUnidades = newNumeroUnidades;
	}

	public Long getTipoEstadoEnvio() {
		return tipoEstadoEnvio;
	}

	public void setTipoEstadoEnvio(Long newTipoEstadoEnvio) {
		tipoEstadoEnvio = newTipoEstadoEnvio;
	}

	public Timestamp getFechaEntrega() {
		return fechaEntrega;
	}

	public void setFechaEntrega(Timestamp newFechaEntrega) {
		fechaEntrega = newFechaEntrega;
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

	public Long getOidDetalle() {
		return oidDetalle;
	}

	public void setOidDetalle(Long newOidDetalle) {
		oidDetalle = newOidDetalle;
	}

	public Long getOidMatrizFact() {
		return oidMatrizFact;
	}

	public void setOidMatrizFact(Long newOidMatrizFact) {
		oidMatrizFact = newOidMatrizFact;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public Long getOidSolicitudEnvio() {
		return oidSolicitudEnvio;
	}

	public void setOidSolicitudEnvio(Long newOidSolicitudEnvio) {
		oidSolicitudEnvio = newOidSolicitudEnvio;
	}

	public Long getOidFormaCobro() {
		return oidFormaCobro;
	}

	public void setOidFormaCobro(Long newOidFormaCobro) {
		oidFormaCobro = newOidFormaCobro;
	}

	public Long getOidBuzonMensaje() {
		return oidBuzonMensaje;
	}

	public void setOidBuzonMensaje(Long newOidBuzonMensaje) {
		oidBuzonMensaje = newOidBuzonMensaje;
	}

	public Long getOidActividadTipoDespacho() {
		return oidActividadTipoDespacho;
	}

	public void setOidActividadTipoDespacho(Long newOidActividadTipoDespacho) {
		oidActividadTipoDespacho = newOidActividadTipoDespacho;
	}

	public Long getOidActividad() {
		return oidActividad;
	}

	public void setOidActividad(Long newOidActividad) {
		oidActividad = newOidActividad;
	}

	public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
	}

	public String getIndEnvio() {
		return indEnvio;
	}

	public void setIndEnvio(String newIndEnvio) {
		indEnvio = newIndEnvio;
	}

  public Long getOidMensaje() {
    return oidMensaje;
  }

  public void setOidMensaje(Long oidMensaje) {
    this.oidMensaje = oidMensaje;
  }
}