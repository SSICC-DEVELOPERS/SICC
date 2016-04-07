package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 25/04/2005
 * @author Gustavo Viñales
 */
public class Premio implements Serializable {
    private Long oidPremio;
    private Long numeroPremio;
    private boolean rechazado;
    private boolean actualizarGanadora;
    private Long tipoPremio;
    private BigDecimal unidades;
    private boolean listarGanador;
    private boolean despachado;
    private BigDecimal cantidad;
    private java.math.BigDecimal porcentaje;
    private Periodo periodoDeDespacho;
    private Double puntosObtenerProdExigidos;
    private Double puntajeServicio;
    private String descripcionTipoPremio;
    private String nombre;
    private NivelPremiacion nivel;    
    private Long oidGanadora;
    //jrivas 2/12/2008 20080783
    private boolean indPendiente;
    private Long oidPremioElegido;

    // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
    private boolean indAtenderPremio;
    
    // sapaza -- COL-SiCC-2013-0031 -- 02/04/2014
    private Integer codMotivoInvalido;

    public Premio() {
        rechazado = false;
        actualizarGanadora = false;
        indAtenderPremio = true;
    }
    
    public Long getOidGanadora() {
      return this.oidGanadora;
    }
    
    public void setOidGanadora(Long oidGanadora) {
      this.oidGanadora = oidGanadora;
    }

    public void setOidPremio(Long oidPremio) {
        this.oidPremio = oidPremio;
    }

    public Long getOidPremio() {
        return oidPremio;
    }

    public void setNumeroPremio(Long numeroPremio) {
        this.numeroPremio = numeroPremio;
    }

    public Long getNumeroPremio() {
        return numeroPremio;
    }

    public void setRechazado(boolean rechazado) {
        this.rechazado = rechazado;
    }

    public boolean getRechazado() {
        return rechazado;
    }

    public void setActualizarGanadora(boolean actualizarGanadora) {
        this.actualizarGanadora = actualizarGanadora;
    }

    public boolean getActualizarGanadora() {
        return actualizarGanadora;
    }

    public void setTipoPremio(Long tipoPremio) {
        this.tipoPremio = tipoPremio;
    }

    public Long getTipoPremio() {
        return tipoPremio;
    }

    public void setUnidades(BigDecimal unidades) {
        this.unidades = unidades;
    }

    public BigDecimal getUnidades() {
        return unidades;
    }

    public void setListarGanador(boolean listarGanador) {
        this.listarGanador = listarGanador;
    }

    public boolean getListarGanador() {
        return listarGanador;
    }

    public void setDespachado(boolean despachado) {
        this.despachado = despachado;
    }

    public boolean getDespachado() {
        return despachado;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setPorcentaje(java.math.BigDecimal porcentaje) {
        this.porcentaje = porcentaje;
    }

    public java.math.BigDecimal getPorcentaje() {
        return porcentaje;
    }

    public void setPeriodoDeDespacho(Periodo periodoDeDespacho) {
        this.periodoDeDespacho = periodoDeDespacho;
    }

    public Periodo getPeriodoDeDespacho() {
        return periodoDeDespacho;
    }

    public void setPuntosObtenerProdExigidos(Double puntosObtenerProdExigidos) {
        this.puntosObtenerProdExigidos = puntosObtenerProdExigidos;
    }

    public Double getPuntosObtenerProdExigidos() {
        return puntosObtenerProdExigidos;
    }

    public void setPuntajeServicio(Double puntajeServicio) {
        this.puntajeServicio = puntajeServicio;
    }

    public Double getPuntajeServicio() {
        return puntajeServicio;
    }

    public void setDescripcionTipoPremio(String descripcionTipoPremio) {
        this.descripcionTipoPremio = descripcionTipoPremio;
    }

    public String getDescripcionTipoPremio() {
        return descripcionTipoPremio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNivel(NivelPremiacion nivel) {
        this.nivel = nivel;
    }

    public NivelPremiacion getNivel() {
        return nivel;
    }
    
    /*
     * JVM, 20070359, se adiciona el metodo clone
     */
    /*public Object clone(){
        Object obj=null;
        try{
            obj=super.clone();
        }catch(CloneNotSupportedException ex){
             System.out.println(" no se puede duplicar");
        }
        return obj;
    }*/
    
    public boolean getIndPendiente() {
        return indPendiente;
    }

    public void setIndPendiente(boolean indPendiente) {
        this.indPendiente = indPendiente;
    }

    public Long getOidPremioElegido() {
        return oidPremioElegido;
    }

    public void setOidPremioElegido(Long oidPremioElegido) {
        this.oidPremioElegido = oidPremioElegido;
    }

    public void setIndAtenderPremio(boolean indAtenderPremio) {
        this.indAtenderPremio = indAtenderPremio;
    }

    public boolean isIndAtenderPremio() {
        return indAtenderPremio;
    }

    public void setCodMotivoInvalido(Integer codMotivoInvalido) {
        this.codMotivoInvalido = codMotivoInvalido;
    }

    public Integer getCodMotivoInvalido() {
        return codMotivoInvalido;
    }
}
