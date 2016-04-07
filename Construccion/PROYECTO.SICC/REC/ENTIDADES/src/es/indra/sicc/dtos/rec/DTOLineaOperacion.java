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

public class DTOLineaOperacion extends DTOBelcorp {

    private Integer numLinea;   
    private Long oidTpoOferta;   
    private Long oidCodVenta;   
    private Long oidCodProducto;   
    private Integer unidadesReclamadas;     
    private BigDecimal precio;     
    private BigDecimal importeAbono;     
    private BigDecimal importeCargo; 
    private Integer unidadesDevueltas;     
    private BigDecimal montoPerdida;     
    private Long precioPerdida;  
    private Long oidTipoMovimiento;  
    private Long oidMotivoDevolucion;   
    private Long oidTipoPosicion;   
    private Long oidTipoSolicitud;  
    private Character indicadorEstado;     
    private Boolean atendido;     
    private Long operacion;
    private String codigoVenta;     
    private String tipoMovimiento;
    private String codProducto;
    private String descProducto;
    private Long posicionReferencia;
    //pzerbino 10/11/2006 inci DBLG700000104
    private BigDecimal descuento;
    private Long oidConcurso;
    private Long oidNivel;
    private Long oidPremio;
    private BigDecimal precioContable;
    
    // dmorello, 22/09/2009
    private Character indicadorRecogible;
    private Long motivoDesbloqueo;
    private Long motivoDevolucion;
    private Long oid;



    public DTOLineaOperacion() {
        super();
    }

    public Boolean getAtendido()
    {
        return atendido;
    }

    public void setAtendido(Boolean atendido)
    {
        this.atendido = atendido;
    }

    public BigDecimal getImporteAbono()
    {
        return importeAbono;
    }

    public void setImporteAbono(BigDecimal importeAbono)
    {
        this.importeAbono = importeAbono;
    }

    public BigDecimal getImporteCargo()
    {
        return importeCargo;
    }

    public void setImporteCargo(BigDecimal importeCargo)
    {
        this.importeCargo = importeCargo;
    }

    public Character getIndicadorEstado()
    {
        return indicadorEstado;
    }

    public void setIndicadorEstado(Character indicadorEstado)
    {
        this.indicadorEstado = indicadorEstado;
    }

    public BigDecimal getMontoPerdida()
    {
        return montoPerdida;
    }

    public void setMontoPerdida(BigDecimal montoPerdida)
    {
        this.montoPerdida = montoPerdida;
    }

    public Integer getNumLinea()
    {
        return numLinea;
    }

    public void setNumLinea(Integer numLinea)
    {
        this.numLinea = numLinea;
    }

    public Long getOidCodProducto()
    {
        return oidCodProducto;
    }

    public void setOidCodProducto(Long oidCodProducto)
    {
        this.oidCodProducto = oidCodProducto;
    }

    public Long getOidCodVenta()
    {
        return oidCodVenta;
    }

    public void setOidCodVenta(Long oidCodVenta)
    {
        this.oidCodVenta = oidCodVenta;
    }

    public Long getOidMotivoDevolucion()
    {
        return oidMotivoDevolucion;
    }

    public void setOidMotivoDevolucion(Long oidMotivoDevolucion)
    {
        this.oidMotivoDevolucion = oidMotivoDevolucion;
    }

    public Long getOidTipoMovimiento()
    {
        return oidTipoMovimiento;
    }

    public void setOidTipoMovimiento(Long oidTipoMovimiento)
    {
        this.oidTipoMovimiento = oidTipoMovimiento;
    }

    public Long getOidTipoPosicion()
    {
        return oidTipoPosicion;
    }

    public void setOidTipoPosicion(Long oidTipoPosicion)
    {
        this.oidTipoPosicion = oidTipoPosicion;
    }

    public Long getOidTipoSolicitud()
    {
        return oidTipoSolicitud;
    }

    public void setOidTipoSolicitud(Long oidTipoSolicitud)
    {
        this.oidTipoSolicitud = oidTipoSolicitud;
    }

    public Long getOidTpoOferta()
    {
        return oidTpoOferta;
    }

    public void setOidTpoOferta(Long oidTpoOferta)
    {
        this.oidTpoOferta = oidTpoOferta;
    }

    public Long getOperacion()
    {
        return operacion;
    }

    public void setOperacion(Long operacion)
    {
        this.operacion = operacion;
    }

    public BigDecimal getPrecio()
    {
        return precio;
    }

    public void setPrecio(BigDecimal precio)
    {
        this.precio = precio;
    }

    public Long getPrecioPerdida()
    {
        return precioPerdida;
    }

    public void setPrecioPerdida(Long precioPerdida)
    {
        this.precioPerdida = precioPerdida;
    }

    public Integer getUnidadesDevueltas()
    {
        return unidadesDevueltas;
    }

    public void setUnidadesDevueltas(Integer unidadesDevueltas)
    {
        this.unidadesDevueltas = unidadesDevueltas;
    }

    public Integer getUnidadesReclamadas()
    {
        return unidadesReclamadas;
    }

    public void setUnidadesReclamadas(Integer unidadesReclamadas)
    {
        this.unidadesReclamadas = unidadesReclamadas;
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta)
    {
        this.codigoVenta = codigoVenta;
    }

    public String getTipoMovimiento() {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento) {
        this.tipoMovimiento = tipoMovimiento;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescProducto() {
        return descProducto;
    }

    public void setDescProducto(String descProducto) {
        this.descProducto = descProducto;
    }

    public Long getPosicionReferencia() {
        return posicionReferencia;
    }

    public void setPosicionReferencia(Long posicionReferencia) {
        this.posicionReferencia = posicionReferencia;
    }

  public BigDecimal getDescuento()
  {
    return descuento;
  }

  public void setDescuento(BigDecimal descuento)
  {
    this.descuento = descuento;
  }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidNivel() {
        return oidNivel;
    }

    public void setOidNivel(Long oidNivel) {
        this.oidNivel = oidNivel;
    }

    public Long getOidPremio() {
        return oidPremio;
    }

    public void setOidPremio(Long oidPremio) {
        this.oidPremio = oidPremio;
    }

    public BigDecimal getPrecioContable() {
        return precioContable;
    }

    public void setPrecioContable(BigDecimal precioContable) {
        this.precioContable = precioContable;
    }

    public void setIndicadorRecogible(Character indicadorRecogible) {
        this.indicadorRecogible = indicadorRecogible;
    }

    public Character getIndicadorRecogible() {
        return indicadorRecogible;
    }

    public void setMotivoDesbloqueo(Long motivoDesbloqueo) {
        this.motivoDesbloqueo = motivoDesbloqueo;
    }

    public Long getMotivoDesbloqueo() {
        return motivoDesbloqueo;
    }

    public void setMotivoDevolucion(Long motivoDevolucion) {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Long getMotivoDevolucion() {
        return motivoDevolucion;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }

    public Long getOid() {
        return oid;
    }
}
