package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTODatosMensaje extends DTOAuditableSICC  {
	private Long oidMarca;
	private Long oidCanal;
	private Long oidAcceso;
	private Long oidSubacceso;
	private Long oidActividad;
	private Long oidPeriodoInicio;
	private Long oidPeriodoFin;
	private String codigoCliente;
	private String codigoMensaje;
	private Long oidProducto;
	private String codigoVenta;
	private String descripcionProducto;
	private BigDecimal precioPosicionamiento;
	private BigDecimal precioCatalogo;
	private BigDecimal precioVenta;
	private Long unidadesDemandadas;
	private Long oidRegion;
	private Long oidZona;
	private Long oidTerritorio;
	private Long oidTipoCliente;
	private Long oidSubtipoCliente;
	private Long oidTipoClasificacion;
	private Long oidClasificacion;
	private Long oidEstatusMAV;
  private Long oidMensaje;

	public DTODatosMensaje() {
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidAcceso() {
		return oidAcceso;
	}

	public void setOidAcceso(Long newOidAcceso) {
		oidAcceso = newOidAcceso;
	}

	public Long getOidSubacceso() {
		return oidSubacceso;
	}

	public void setOidSubacceso(Long newOidSubacceso) {
		oidSubacceso = newOidSubacceso;
	}

	public Long getOidActividad() {
		return oidActividad;
	}

	public void setOidActividad(Long newOidActividad) {
		oidActividad = newOidActividad;
	}

	public Long getOidPeriodoInicio() {
		return oidPeriodoInicio;
	}

	public void setOidPeriodoInicio(Long newOidPeriodoInicio) {
		oidPeriodoInicio = newOidPeriodoInicio;
	}

	public Long getOidPeriodoFin() {
		return oidPeriodoFin;
	}

	public void setOidPeriodoFin(Long newOidPeriodoFin) {
		oidPeriodoFin = newOidPeriodoFin;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	public void setCodigoMensaje(String newCodigoMensaje) {
		codigoMensaje = newCodigoMensaje;
	}

	public Long getOidProducto() {
		return oidProducto;
	}

	public void setOidProducto(Long newOidProducto) {
		oidProducto = newOidProducto;
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

	public BigDecimal getPrecioPosicionamiento() {
		return precioPosicionamiento;
	}

	public void setPrecioPosicionamiento(BigDecimal newPrecioPosicionamiento) {
		precioPosicionamiento = newPrecioPosicionamiento;
	}

	public BigDecimal getPrecioCatalogo() {
		return precioCatalogo;
	}

	public void setPrecioCatalogo(BigDecimal newPrecioCatalogo) {
		precioCatalogo = newPrecioCatalogo;
	}

	public BigDecimal getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(BigDecimal newPrecioVenta) {
		precioVenta = newPrecioVenta;
	}

	public Long getUnidadesDemandadas() {
		return unidadesDemandadas;
	}

	public void setUnidadesDemandadas(Long newUnidadesDemandadas) {
		unidadesDemandadas = newUnidadesDemandadas;
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

	public Long getOidTerritorio() {
		return oidTerritorio;
	}

	public void setOidTerritorio(Long newOidTerritorio) {
		oidTerritorio = newOidTerritorio;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Long getOidSubtipoCliente() {
		return oidSubtipoCliente;
	}

	public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
		oidSubtipoCliente = newOidSubtipoCliente;
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

	public Long getOidEstatusMAV() {
		return oidEstatusMAV;
	}

	public void setOidEstatusMAV(Long newOidEstatusMAV) {
		oidEstatusMAV = newOidEstatusMAV;
	}

  public Long getOidMensaje() {
    return oidMensaje;
  }

  public void setOidMensaje(Long oidMensaje) {
    this.oidMensaje = oidMensaje;
  }
}