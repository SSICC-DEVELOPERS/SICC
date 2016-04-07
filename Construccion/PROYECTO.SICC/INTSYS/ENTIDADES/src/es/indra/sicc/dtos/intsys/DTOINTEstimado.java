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

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOINTEstimado extends DTOBelcorp{

    private Long numeroLoteTransaccion;
    private String pais;                       
    private String sociedad;
    private String canal;                                        
    private String acceso;                                       
    private String subacceso;                                    
    private String tipoPeriodo;                                  
    private String periodo;                                      
    private String codigoProductoSAP;                            
    private String tipoOferta;                                   
    private String cicloVida;                                    
    private Long unidadesEstimadas;                              
    private BigDecimal ventaNetaEstimada;                        
    private BigDecimal precioCatalogo;                           
    private BigDecimal precioPosicionamiento;                    
    private String monedaTransaccion;                            
    private Integer catalogo;
    private Integer numeroPaginaCatalogo;                        
    private Integer posicionDentroPagina;                        
    private Integer argumento;
    private String estrategia;                                   
    private String condicionPromocion;
    private Integer codigoFormaVenta;                            
    private BigDecimal costeEstandar;                            
    private String codigoFormaPago;                              
    private String centro;                                       
    private String marca;                                        
    private Integer ejercicio;                                   
    private String descripcionCriterio;                          
    private String tipoCliente;                                  
    private Long baseDestinatarios;                              
    private BigDecimal factorCorreccion;                         
    private BigDecimal promedioUnidadesDestinatarios;            
    private Long unidades;       
    private String atributoConsulta;       
    private BigDecimal precioEstandar;       


    public DTOINTEstimado() {
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String acceso) {
        this.acceso = acceso;
    }

    public Integer getArgumento() {
        return argumento;
    }

    public void setArgumento(Integer argumento) {
        this.argumento = argumento;
    }

    public String getAtributoConsulta() {
        return atributoConsulta;
    }

    public void setAtributoConsulta(String atributoConsulta) {
        this.atributoConsulta = atributoConsulta;
    }

    public Long getBaseDestinatarios() {
        return baseDestinatarios;
    }

    public void setBaseDestinatarios(Long baseDestinatarios) {
        this.baseDestinatarios = baseDestinatarios;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String canal) {
        this.canal = canal;
    }

    public Integer getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Integer catalogo) {
        this.catalogo = catalogo;
    }

    public String getCentro() {
        return centro;
    }

    public void setCentro(String centro) {
        this.centro = centro;
    }

    public String getCicloVida() {
        return cicloVida;
    }

    public void setCicloVida(String cicloVida) {
        this.cicloVida = cicloVida;
    }

    public String getCodigoFormaPago() {
        return codigoFormaPago;
    }

    public void setCodigoFormaPago(String codigoFormaPago) {
        this.codigoFormaPago = codigoFormaPago;
    }

    public Integer getCodigoFormaVenta() {
        return codigoFormaVenta;
    }

    public void setCodigoFormaVenta(Integer codigoFormaVenta) {
        this.codigoFormaVenta = codigoFormaVenta;
    }

    public String getCodigoProductoSAP() {
        return codigoProductoSAP;
    }

    public void setCodigoProductoSAP(String codigoProductoSAP) {
        this.codigoProductoSAP = codigoProductoSAP;
    }

    public String getCondicionPromocion() {
        return condicionPromocion;
    }

    public void setCondicionPromocion(String condicionPromocion) {
        this.condicionPromocion = condicionPromocion;
    }

    public BigDecimal getCosteEstandar() {
        return costeEstandar;
    }

    public void setCosteEstandar(BigDecimal costeEstandar) {
        this.costeEstandar = costeEstandar;
    }

    public String getDescripcionCriterio() {
        return descripcionCriterio;
    }

    public void setDescripcionCriterio(String descripcionCriterio) {
        this.descripcionCriterio = descripcionCriterio;
    }

    public Integer getEjercicio() {
        return ejercicio;
    }

    public void setEjercicio(Integer ejercicio) {
        this.ejercicio = ejercicio;
    }

    public String getEstrategia() {
        return estrategia;
    }

    public void setEstrategia(String estrategia) {
        this.estrategia = estrategia;
    }

    public BigDecimal getFactorCorreccion() {
        return factorCorreccion;
    }

    public void setFactorCorreccion(BigDecimal factorCorreccion) {
        this.factorCorreccion = factorCorreccion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMonedaTransaccion() {
        return monedaTransaccion;
    }

    public void setMonedaTransaccion(String monedaTransaccion) {
        this.monedaTransaccion = monedaTransaccion;
    }

    public Long getNumeroLoteTransaccion() {
        return numeroLoteTransaccion;
    }

    public void setNumeroLoteTransaccion(Long numeroLoteTransaccion) {
        this.numeroLoteTransaccion = numeroLoteTransaccion;
    }

    public Integer getNumeroPaginaCatalogo() {
        return numeroPaginaCatalogo;
    }

    public void setNumeroPaginaCatalogo(Integer numeroPaginaCatalogo) {
        this.numeroPaginaCatalogo = numeroPaginaCatalogo;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public Integer getPosicionDentroPagina() {
        return posicionDentroPagina;
    }

    public void setPosicionDentroPagina(Integer posicionDentroPagina) {
        this.posicionDentroPagina = posicionDentroPagina;
    }

    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }

    public void setPrecioCatalogo(BigDecimal precioCatalogo) {
        this.precioCatalogo = precioCatalogo;
    }

    public BigDecimal getPrecioEstandar() {
        return precioEstandar;
    }

    public void setPrecioEstandar(BigDecimal precioEstandar) {
        this.precioEstandar = precioEstandar;
    }

    public BigDecimal getPrecioPosicionamiento() {
        return precioPosicionamiento;
    }

    public void setPrecioPosicionamiento(BigDecimal precioPosicionamiento) {
        this.precioPosicionamiento = precioPosicionamiento;
    }

    public BigDecimal getPromedioUnidadesDestinatarios() {
        return promedioUnidadesDestinatarios;
    }

    public void setPromedioUnidadesDestinatarios(BigDecimal promedioUnidadesDestinatarios) {
        this.promedioUnidadesDestinatarios = promedioUnidadesDestinatarios;
    }

    public String getSociedad() {
        return sociedad;
    }

    public void setSociedad(String sociedad) {
        this.sociedad = sociedad;
    }

    public String getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(String subacceso) {
        this.subacceso = subacceso;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoOferta() {
        return tipoOferta;
    }

    public void setTipoOferta(String tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    public String getTipoPeriodo() {
        return tipoPeriodo;
    }

    public void setTipoPeriodo(String tipoPeriodo) {
        this.tipoPeriodo = tipoPeriodo;
    }

    public Long getUnidades() {
        return unidades;
    }

    public void setUnidades(Long unidades) {
        this.unidades = unidades;
    }

    public Long getUnidadesEstimadas() {
        return unidadesEstimadas;
    }

    public void setUnidadesEstimadas(Long unidadesEstimadas) {
        this.unidadesEstimadas = unidadesEstimadas;
    }

    public BigDecimal getVentaNetaEstimada() {
        return ventaNetaEstimada;
    }

    public void setVentaNetaEstimada(BigDecimal ventaNetaEstimada) {
        this.ventaNetaEstimada = ventaNetaEstimada;
    }
}