/**
 * Sistema:     Belcorp
 * Modulo:      MAV
 * Fecha:       05/08/2004
 * @version     2.0
 * @autor       Maximiliano Dello Russo
 * Descripcion: 
 */
package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOOIDs;
import java.util.Vector;

public class DTOActividadMAV extends DTOAuditableSICC {
	
	/*------------------------------------------------------------------------*/
	private Long oidActividad;
	private String descripcion;
	private String descripcionDetallada;
	private Long oidCanal ;
	private Vector tipoOferta;
	private Vector cicloVida;
	private Vector tipoDespacho;
	private Vector tipoSolicitudOrigen;
	private Long oidTipoSolicitudDestino;
	private Long oidEnvioConSolicitud;
	private Vector subtipoCliente;
	private Vector estado;
	private Long oidTipoCondicionPago;
	private Long oidFormaPago;
	private Vector criterioAsignacion;
	private Integer campagnaEvaluacion;
	private Boolean facturaIntercompanias;
	private Integer costo;
	private Long oidTipoSolicitudParaPago;
	private Long oidTipoPosicionParaPago;
	private Long oidMarca;
	private Long oidTipoCliente;
	private Long oidSubtipoPosicionParaPago;
	private Long oidSubtipoPosicionEnvio;
	// De aqui para abajo son atributos contenidos en la versión nueva
	private Vector attTraducible;
	private String descripcionMarca;
	private String descripcionCanal;
	private String descripcionTipoCliente;
	private String descripcionEnvioConSolicitud;
	private String descripcionTipoSolicitudDestino;
	private Long oidTipoPosicionEnvio;
	private String descripcionTipoPosicionEnvio;
	private String descripcionSubtipoPosicionEnvio;
	private String descripcionTipoCondicionPago;
	private String descripcionFormaPago;
	private Long oidEmpresa;
	private String descripcionEmpresa;
	private Long oidCliente;
	private String codigoCliente;
	private String descripcionTipoPosicionParaPago;
	private String descripcionSubtipoPosicionParaPago;
	private String descripcionTipoSolicitudParaPago;
	private String descripcionPais;
	/*------------------------------------------------------------------------*/
	
	public DTOActividadMAV() {
	}

	public Integer getCampagnaEvaluacion() {
		return campagnaEvaluacion;
	}

	public void setCampagnaEvaluacion(Integer newCampagnaEvaluacion) {
		campagnaEvaluacion = newCampagnaEvaluacion;
	}

	public Vector getCicloVida() {
		return cicloVida;
	}

	public void setCicloVida(Vector newCicloVida) {
		cicloVida = newCicloVida;
	}

	public Integer getCosto() {
		return costo;
	}

	public void setCosto(Integer newCosto) {
		costo = newCosto;
	}

	public Vector getCriterioAsignacion() {
		return criterioAsignacion;
	}

	public void setCriterioAsignacion(Vector newCriterioAsignacion) {
		criterioAsignacion = newCriterioAsignacion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String newDescripcion) {
		descripcion = newDescripcion;
	}

	public String getDescripcionDetallada() {
		return descripcionDetallada;
	}

	public void setDescripcionDetallada(String newDescripcionDetallada) {
		descripcionDetallada = newDescripcionDetallada;
	}

	public Vector getEstado() {
		return estado;
	}

	public void setEstado(Vector newEstado) {
		estado = newEstado;
	}

	public Boolean getFacturaIntercompanias() {
		return facturaIntercompanias;
	}

	public void setFacturaIntercompanias(Boolean newFacturaIntercompanias) {
		facturaIntercompanias = newFacturaIntercompanias;
	}

	public Long getOidActividad() {
		return oidActividad;
	}

	public void setOidActividad(Long newOidActividad) {
		oidActividad = newOidActividad;
	}

	public Long getOidCanal() {
		return oidCanal;
	}

	public void setOidCanal(Long newOidCanal) {
		oidCanal = newOidCanal;
	}

	public Long getOidEnvioConSolicitud() {
		return oidEnvioConSolicitud;
	}

	public void setOidEnvioConSolicitud(Long newOidEnvioConSolicitud) {
		oidEnvioConSolicitud = newOidEnvioConSolicitud;
	}

	public Long getOidFormaPago() {
		return oidFormaPago;
	}

	public void setOidFormaPago(Long newOidFormaPago) {
		oidFormaPago = newOidFormaPago;
	}

	public Long getOidTipoCondicionPago() {
		return oidTipoCondicionPago;
	}

	public void setOidTipoCondicionPago(Long newOidTipoCondicionPago) {
		oidTipoCondicionPago = newOidTipoCondicionPago;
	}



	public Long getOidTipoPosicionParaPago() {
		return oidTipoPosicionParaPago;
	}

	public void setOidTipoPosicionParaPago(Long newOidTipoPosicionParaPago) {
		oidTipoPosicionParaPago = newOidTipoPosicionParaPago;
	}

	public Long getOidTipoSolicitudDestino() {
		return oidTipoSolicitudDestino;
	}

	public void setOidTipoSolicitudDestino(Long newOidTipoSolicitudDestino) {
		oidTipoSolicitudDestino = newOidTipoSolicitudDestino;
	}

	public Long getOidTipoSolicitudParaPago() {
		return oidTipoSolicitudParaPago;
	}

	public void setOidTipoSolicitudParaPago(Long newOidTipoSolicitudParaPago) {
		oidTipoSolicitudParaPago = newOidTipoSolicitudParaPago;
	}





	public Vector getSubtipoCliente() {
		return subtipoCliente;
	}

	public void setSubtipoCliente(Vector newSubtipoCliente) {
		subtipoCliente = newSubtipoCliente;
	}



	public Vector getTipoDespacho() {
		return tipoDespacho;
	}

	public void setTipoDespacho(Vector newTipoDespacho) {
		tipoDespacho = newTipoDespacho;
	}

	public Vector getTipoOferta() {
		return tipoOferta;
	}

	public void setTipoOferta(Vector newTipoOferta) {
		tipoOferta = newTipoOferta;
	}

	public Vector getTipoSolicitudOrigen() {
		return tipoSolicitudOrigen;
	}

	public void setTipoSolicitudOrigen(Vector newTipoSolicitudOrigen) {
		tipoSolicitudOrigen = newTipoSolicitudOrigen;
	}

	public Long getOidMarca() {
		return oidMarca;
	}

	public void setOidMarca(Long newOidMarca) {
		oidMarca = newOidMarca;
	}

	public Long getOidTipoCliente() {
		return oidTipoCliente;
	}

	public void setOidTipoCliente(Long newOidTipoCliente) {
		oidTipoCliente = newOidTipoCliente;
	}

	public Long getOidSubtipoPosicionParaPago() {
		return oidSubtipoPosicionParaPago;
	}

	public void setOidSubtipoPosicionParaPago(Long newOidSubtipoPosicionParaPago) {
		oidSubtipoPosicionParaPago = newOidSubtipoPosicionParaPago;
	}

	public Long getOidSubtipoPosicionEnvio() {
		return oidSubtipoPosicionEnvio;
	}

	public void setOidSubtipoPosicionEnvio(Long newOidSubtipoPosicionEnvio) {
		oidSubtipoPosicionEnvio = newOidSubtipoPosicionEnvio;
	}

	public Vector getAttTraducible() {
		return attTraducible;
	}

	public void setAttTraducible(Vector newAttTraducible) {
		attTraducible = newAttTraducible;
	}

	public String getDescripcionMarca() {
		return descripcionMarca;
	}

	public void setDescripcionMarca(String newDescripcionMarca) {
		descripcionMarca = newDescripcionMarca;
	}

	public String getDescripcionCanal() {
		return descripcionCanal;
	}

	public void setDescripcionCanal(String newDescripcionCanal) {
		descripcionCanal = newDescripcionCanal;
	}

	public String getDescripcionTipoCliente() {
		return descripcionTipoCliente;
	}

	public void setDescripcionTipoCliente(String newDescripcionTipoCliente) {
		descripcionTipoCliente = newDescripcionTipoCliente;
	}

	public String getDescripcionEnvioConSolicitud() {
		return descripcionEnvioConSolicitud;
	}

	public void setDescripcionEnvioConSolicitud(String newDescripcionEnvioConSolicitud) {
		descripcionEnvioConSolicitud = newDescripcionEnvioConSolicitud;
	}

	public String getDescripcionTipoSolicitudDestino() {
		return descripcionTipoSolicitudDestino;
	}

	public void setDescripcionTipoSolicitudDestino(String newDescripcionTipoSolicitudDestino) {
		descripcionTipoSolicitudDestino = newDescripcionTipoSolicitudDestino;
	}

	public Long getOidTipoPosicionEnvio() {
		return oidTipoPosicionEnvio;
	}

	public void setOidTipoPosicionEnvio(Long newOidTipoPosicionEnvio) {
		oidTipoPosicionEnvio = newOidTipoPosicionEnvio;
	}

	public String getDescripcionTipoPosicionEnvio() {
		return descripcionTipoPosicionEnvio;
	}

	public void setDescripcionTipoPosicionEnvio(String newDescripcionTipoPosicionEnvio) {
		descripcionTipoPosicionEnvio = newDescripcionTipoPosicionEnvio;
	}

	public String getDescripcionSubtipoPosicionEnvio() {
		return descripcionSubtipoPosicionEnvio;
	}

	public void setDescripcionSubtipoPosicionEnvio(String newDescripcionSubtipoPosicionEnvio) {
		descripcionSubtipoPosicionEnvio = newDescripcionSubtipoPosicionEnvio;
	}

	public String getDescripcionTipoCondicionPago() {
		return descripcionTipoCondicionPago;
	}

	public void setDescripcionTipoCondicionPago(String newDescripcionTipoCondicionPago) {
		descripcionTipoCondicionPago = newDescripcionTipoCondicionPago;
	}

	public String getDescripcionFormaPago() {
		return descripcionFormaPago;
	}

	public void setDescripcionFormaPago(String newDescripcionFormaPago) {
		descripcionFormaPago = newDescripcionFormaPago;
	}

	public Long getOidEmpresa() {
		return oidEmpresa;
	}

	public void setOidEmpresa(Long newOidEmpresa) {
		oidEmpresa = newOidEmpresa;
	}

	public String getDescripcionEmpresa() {
		return descripcionEmpresa;
	}

	public void setDescripcionEmpresa(String newDescripcionEmpresa) {
		descripcionEmpresa = newDescripcionEmpresa;
	}

	public Long getOidCliente() {
		return oidCliente;
	}

	public void setOidCliente(Long newOidCliente) {
		oidCliente = newOidCliente;
	}

	public String getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(String newCodigoCliente) {
		codigoCliente = newCodigoCliente;
	}

	public String getDescripcionTipoPosicionParaPago() {
		return descripcionTipoPosicionParaPago;
	}

	public void setDescripcionTipoPosicionParaPago(String newDescripcionTipoPosicionParaPago) {
		descripcionTipoPosicionParaPago = newDescripcionTipoPosicionParaPago;
	}

	public String getDescripcionSubtipoPosicionParaPago() {
		return descripcionSubtipoPosicionParaPago;
	}

	public void setDescripcionSubtipoPosicionParaPago(String newDescripcionSubtipoPosicionParaPago) {
		descripcionSubtipoPosicionParaPago = newDescripcionSubtipoPosicionParaPago;
	}

	public String getDescripcionTipoSolicitudParaPago() {
		return descripcionTipoSolicitudParaPago;
	}

	public void setDescripcionTipoSolicitudParaPago(String newDescripcionTipoSolicitudParaPago) {
		descripcionTipoSolicitudParaPago = newDescripcionTipoSolicitudParaPago;
	}

	public String getDescripcionPais() {
		return descripcionPais;
	}

	public void setDescripcionPais(String newDescripcionPais) {
		descripcionPais = newDescripcionPais;
	}








}