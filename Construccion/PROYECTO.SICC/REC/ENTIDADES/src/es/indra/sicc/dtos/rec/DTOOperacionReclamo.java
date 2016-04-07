/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;
import java.util.ArrayList;

public class DTOOperacionReclamo extends DTOBelcorp {

    private Long numAtencion;   
    private Long tipoOperacion;   
    private Integer numSecuencial;   
    private Long oidDocumentoReferencia;   
    private Long motivoBloqueo;   
    private String tipoBloqueo; 
    private Boolean atendido;   
    private Long periodo;
    private Long indEntregaMercaderia;   
    private Long responsablePerdida;   
    private Long tipoSolicitudPerdida;   
    private Long tipoPosicionPerdida;   
    private Long asumePerdida;  
    private Long codigoArticulo;   
    private BigDecimal montoPerdida;   
    private Long precioPerdida;   
    private Double porcentajePerdida;   
    private Long estadoOperacion;   
    private Long periodoReclamo;   
    private Long clienteSeguro;   
    private ArrayList lineas;   
    private Long oidOperacion; 
    //campos añadidos para el paquete N041
    private String codigoArticuloDigitacion;        
    private String codigoClienteSeguro;
    private String codigoOperacion;                       
    private String codigoResponsablePerdida;
    
    
  private String usuario;
    private String codigoTipoOperacion;
    private String descripcionCorta;
    private Long oidOperacionReclamo;
    private Boolean indAnulacion;
    private volatile String numDocReferencia;
    private volatile String autorizacion;
    private String descripcionAsumePerdida;
    private String descripcionPrecioPerdida;
    private String nombreClienteSeguro;
    private String codigoArticuloSeguro;
    private String descripcionArticuloSeguro;
    private String codigoTipoSolicitudPerdida;
    private String descripcionTipoSolicitudPerdida;
    private ArrayList operacionesAEliminar;

    public DTOOperacionReclamo() {
       super(); 
    }

    public Long getAsumePerdida()
    {
        return asumePerdida;
    }

    public void setAsumePerdida(Long asumePerdida)
    {
        this.asumePerdida = asumePerdida;
    }

    public Boolean getAtendido()
    {
        return atendido;
    }

    public void setAtendido(Boolean atendido)
    {
        this.atendido = atendido;
    }

    public Long getClienteSeguro()
    {
        return clienteSeguro;
    }

    public void setClienteSeguro(Long clienteSeguro)
    {
        this.clienteSeguro = clienteSeguro;
    }

    public Long getCodigoArticulo()
    {
        return codigoArticulo;
    }

    public void setCodigoArticulo(Long codigoArticulo)
    {
        this.codigoArticulo = codigoArticulo;
    }

    public Long getEstadoOperacion()
    {
        return estadoOperacion;
    }

    public void setEstadoOperacion(Long estadoOperacion)
    {
        this.estadoOperacion = estadoOperacion;
    }

    public Long getIndEntregaMercaderia()
    {
        return indEntregaMercaderia;
    }

    public void setIndEntregaMercaderia(Long indEntregaMercaderia)
    {
        this.indEntregaMercaderia = indEntregaMercaderia;
    }

    public ArrayList getLineas()
    {
        return lineas;
    }

    public void setLineas(ArrayList lineas)
    {
        this.lineas = lineas;
    }

    public BigDecimal getMontoPerdida()
    {
        return montoPerdida;
    }

    public void setMontoPerdida(BigDecimal montoPerdida)
    {
        this.montoPerdida = montoPerdida;
    }

    public Long getMotivoBloqueo()
    {
        return motivoBloqueo;
    }

    public void setMotivoBloqueo(Long motivoBloqueo)
    {
        this.motivoBloqueo = motivoBloqueo;
    }

    public Long getNumAtencion()
    {
        return numAtencion;
    }

    public void setNumAtencion(Long numAtencion)
    {
        this.numAtencion = numAtencion;
    }

    public Integer getNumSecuencial()
    {
        return numSecuencial;
    }

    public void setNumSecuencial(Integer numSecuencial)
    {
        this.numSecuencial = numSecuencial;
    }

    public Long getOidDocumentoReferencia()
    {
        return oidDocumentoReferencia;
    }

    public void setOidDocumentoReferencia(Long oidDocumentoReferencia)
    {
        this.oidDocumentoReferencia = oidDocumentoReferencia;
    }

    public Long getOidOperacion()
    {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion)
    {
        this.oidOperacion = oidOperacion;
    }

    public Long getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Long periodo)
    {
        this.periodo = periodo;
    }

    public Long getPeriodoReclamo()
    {
        return periodoReclamo;
    }

    public void setPeriodoReclamo(Long periodoReclamo)
    {
        this.periodoReclamo = periodoReclamo;
    }

    public Double getPorcentajePerdida()
    {
        return porcentajePerdida;
    }

    public void setPorcentajePerdida(Double porcentajePerdida)
    {
        this.porcentajePerdida = porcentajePerdida;
    }

    public Long getPrecioPerdida()
    {
        return precioPerdida;
    }

    public void setPrecioPerdida(Long precioPerdida)
    {
        this.precioPerdida = precioPerdida;
    }

    public Long getResponsablePerdida()
    {
        return responsablePerdida;
    }

    public void setResponsablePerdida(Long responsablePerdida)
    {
        this.responsablePerdida = responsablePerdida;
    }

    public String getTipoBloqueo()
    {
        return tipoBloqueo;
    }

    public void setTipoBloqueo(String tipoBloqueo)
    {
        this.tipoBloqueo = tipoBloqueo;
    }

    public Long getTipoOperacion()
    {
        return tipoOperacion;
    }

    public void setTipoOperacion(Long tipoOperacion)
    {
        this.tipoOperacion = tipoOperacion;
    }

    public Long getTipoPosicionPerdida()
    {
        return tipoPosicionPerdida;
    }

    public void setTipoPosicionPerdida(Long tipoPosicionPerdida)
    {
        this.tipoPosicionPerdida = tipoPosicionPerdida;
    }

    public Long getTipoSolicitudPerdida()
    {
        return tipoSolicitudPerdida;
    }

    public void setTipoSolicitudPerdida(Long tipoSolicitudPerdida)
    {
        this.tipoSolicitudPerdida = tipoSolicitudPerdida;
    }

    public String getCodigoArticuloDigitacion()
    {
        return codigoArticuloDigitacion;
    }

    public void setCodigoArticuloDigitacion(String codigoArticuloDigitacion)
    {
        this.codigoArticuloDigitacion = codigoArticuloDigitacion;
    }

    public String getCodigoClienteSeguro()
    {
        return codigoClienteSeguro;
    }

    public void setCodigoClienteSeguro(String codigoClienteSeguro)
    {
        this.codigoClienteSeguro = codigoClienteSeguro;
    }

    public String getCodigoOperacion()
    {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion)
    {
        this.codigoOperacion = codigoOperacion;
    }

    public String getCodigoResponsablePerdida()
    {
        return codigoResponsablePerdida;
    }

    public void setCodigoResponsablePerdida(String codigoResponsablePerdida)
    {
        this.codigoResponsablePerdida = codigoResponsablePerdida;
    }

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

    public String getCodigoTipoOperacion() {
        return codigoTipoOperacion;
    }

    public void setCodigoTipoOperacion(String codigoTipoOperacion) {
        this.codigoTipoOperacion = codigoTipoOperacion;
    }

    public String getDescripcionCorta() {
        return descripcionCorta;
    }

    public void setDescripcionCorta(String descripcionCorta) {
        this.descripcionCorta = descripcionCorta;
    }

    public Long getOidOperacionReclamo() {
        return oidOperacionReclamo;
    }

    public void setOidOperacionReclamo(Long oidOperacionReclamo) {
        this.oidOperacionReclamo = oidOperacionReclamo;
    }

    public Boolean getIndAnulacion() {
        return indAnulacion;
    }

    public void setIndAnulacion(Boolean indAnulacion) {
        this.indAnulacion = indAnulacion;
    }

    public String getNumDocReferencia() {
        return numDocReferencia;
    }

    public void setNumDocReferencia(String numDocReferencia) {
        this.numDocReferencia = numDocReferencia;
    }

    public String getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(String autorizacion) {
        this.autorizacion = autorizacion;
    }

    public String getDescripcionAsumePerdida() {
        return descripcionAsumePerdida;
    }

    public void setDescripcionAsumePerdida(String descripcionAsumePerdida) {
        this.descripcionAsumePerdida = descripcionAsumePerdida;
    }

    public String getDescripcionPrecioPerdida() {
        return descripcionPrecioPerdida;
    }

    public void setDescripcionPrecioPerdida(String descripcionPrecioPerdida) {
        this.descripcionPrecioPerdida = descripcionPrecioPerdida;
    }

    public String getNombreClienteSeguro() {
        return nombreClienteSeguro;
    }

    public void setNombreClienteSeguro(String nombreClienteSeguro) {
        this.nombreClienteSeguro = nombreClienteSeguro;
    }

    public String getCodigoArticuloSeguro() {
        return codigoArticuloSeguro;
    }

    public void setCodigoArticuloSeguro(String codigoArticuloSeguro) {
        this.codigoArticuloSeguro = codigoArticuloSeguro;
    }

    public String getDescripcionArticuloSeguro() {
        return descripcionArticuloSeguro;
    }

    public void setDescripcionArticuloSeguro(String descripcionArticuloSeguro) {
        this.descripcionArticuloSeguro = descripcionArticuloSeguro;
    }

    public String getCodigoTipoSolicitudPerdida() {
        return codigoTipoSolicitudPerdida;
    }

    public void setCodigoTipoSolicitudPerdida(String codigoTipoSolicitudPerdida) {
        this.codigoTipoSolicitudPerdida = codigoTipoSolicitudPerdida;
    }

    public String getDescripcionTipoSolicitudPerdida() {
        return descripcionTipoSolicitudPerdida;
    }

    public void setDescripcionTipoSolicitudPerdida(String descripcionTipoSolicitudPerdida) {
        this.descripcionTipoSolicitudPerdida = descripcionTipoSolicitudPerdida;
    }

    public ArrayList getOperacionesAEliminar() {
        return operacionesAEliminar;
    }

    public void setOperacionesAEliminar(ArrayList operacionesAEliminar) {
        this.operacionesAEliminar = operacionesAEliminar;
    }
}