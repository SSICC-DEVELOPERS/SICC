/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;
import java.math.BigDecimal;

public class Posicion implements Serializable {
    private Long oidProducto;
    private Long oidMarcaProducto;
    private Long oidUnidadNegocio;
    private Long oidNegocio;
    private Long oidGenerico;
    private Long oidSuperGenerico;
    private Long oidTipoOferta;
    private Long oidCicloVida;
    private Long estado;
    private Solicitud solicitud;
    private BigDecimal precioCatalogTotalUniDemandaReal;
    private Long unidadesPorAtender;
    private Long unidadesComprometidas;
    private BigDecimal precioCatalogoUnitarioLocal;
    private boolean controlStock;
    private boolean controlLiquidacion;
    private boolean limiteVenta;
    private Long unidadesDemandaReal;
    private Long oidPosicion;

    //Agregado por Sergio Platas según DMCO - 07/06/2005
    private BigDecimal precioNetoUnitarioLocal;
    private BigDecimal precioFacturaUnitarioLocal;
    private Long unidadesDemandadas;
    private BigDecimal precioContableUnitarioLocal;

    private boolean productoReemplazo;
    
    // sapaza -- COL-SiCC-2013-0030 -- 28/11/2013
    private Long oidDetalleOferta;
    
    public Posicion() {
    }

    public void Posicion(Solicitud sol) {
        this.solicitud = sol;
    }

    /*
     * Obtiene el objeto periodo asociado a la Solicitud que contiene la posicion.
     */
    public Periodo getPeriodo() {
        return solicitud.getPeriodo();
    }

    /*
     * Obtiene el objeto PosicionPuntaje asociado a la posicion.
     */
    public PosicionPuntaje getPosicionPuntaje(Long oidConcurso) {
        UtilidadesLog.info("Posicion.getPosicionPuntaje(Long oidConcurso)");
        return solicitud.getSolicitudConcurso(oidConcurso).getPosicionPuntaje(oidPosicion);
    }

    /*
     * Agrega la informacion sobre un producto exigido al objeto concursoSolicitud.
     */
    public void addProductoExigido(Long oidConcurso) {
        //jrivas 17/8/2006 DBLG50000721 - CAMBIO ANUL_DEVO - gPineda - 30/10/2006
        solicitud.getSolicitudConcurso(oidConcurso).addProductoExigido(this.getPosicionPuntaje(oidConcurso).getOidProductoExigido(),
                                                                       this.getPosicionPuntaje(oidConcurso).getMontoSolicitud(),
                                                                       this.getPosicionPuntaje(oidConcurso).getUnidadesSolicitud(),
                                                                       this.getPosicionPuntaje(oidConcurso).getPuntosSolicitud(), false,
                                                                       this.getSolicitud().getIndDevolucion() );
    }

    public boolean getSolicitudRechazado(Long oidConcurso) {
        return solicitud.getRechazado(oidConcurso);
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }

    public Long getOidMarcaProducto() {
        return oidMarcaProducto;
    }

    public void setOidMarcaProducto(Long oidMarcaProducto) {
        this.oidMarcaProducto = oidMarcaProducto;
    }

    public Long getOidUnidadNegocio() {
        return oidUnidadNegocio;
    }

    public void setOidUnidadNegocio(Long oidUnidadNegocio) {
        this.oidUnidadNegocio = oidUnidadNegocio;
    }

    public Long getOidNegocio() {
        return oidNegocio;
    }

    public void setOidNegocio(Long oidNegocio) {
        this.oidNegocio = oidNegocio;
    }

    public Long getOidGenerico() {
        return oidGenerico;
    }

    public void setOidGenerico(Long oidGenerico) {
        this.oidGenerico = oidGenerico;
    }

    public Long getOidSuperGenerico() {
        return oidSuperGenerico;
    }

    public void setOidSuperGenerico(Long oidSuperGenerico) {
        this.oidSuperGenerico = oidSuperGenerico;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidCicloVida() {
        return oidCicloVida;
    }

    public void setOidCicloVida(Long oidCicloVida) {
        this.oidCicloVida = oidCicloVida;
    }

    public Long getEstado() {
        return estado;
    }

    public void setEstado(Long estado) {
        this.estado = estado;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }

    public BigDecimal getPrecioCatalogTotalUniDemandaReal() {
        return precioCatalogTotalUniDemandaReal;
    }

    public void setPrecioCatalogTotalUniDemandaReal(BigDecimal precioCatalogTotalUniDemandaReal) {
        this.precioCatalogTotalUniDemandaReal = precioCatalogTotalUniDemandaReal;
    }

    public Long getUnidadesPorAtender() {
        return unidadesPorAtender;
    }

    public void setUnidadesPorAtender(Long unidadesPorAtender) {
        this.unidadesPorAtender = unidadesPorAtender;
    }

    public Long getUnidadesComprometidas() {
        return unidadesComprometidas;
    }

    public void setUnidadesComprometidas(Long unidadesComprometidas) {
        this.unidadesComprometidas = unidadesComprometidas;
    }

    public BigDecimal getPrecioCatalogoUnitarioLocal() {
        return precioCatalogoUnitarioLocal;
    }

    public void setPrecioCatalogoUnitarioLocal(BigDecimal precioCatalogoUnitarioLocal) {
        this.precioCatalogoUnitarioLocal = precioCatalogoUnitarioLocal;
    }

    public boolean getControlStock() {
        return controlStock;
    }

    public void setControlStock(boolean controlStock) {
        this.controlStock = controlStock;
    }

    public boolean getControlLiquidacion() {
        return controlLiquidacion;
    }

    public void setControlLiquidacion(boolean controlLiquidacion) {
        this.controlLiquidacion = controlLiquidacion;
    }

    public boolean getLimiteVenta() {
        return limiteVenta;
    }

    public void setLimiteVenta(boolean limiteVenta) {
        this.limiteVenta = limiteVenta;
    }

    public Long getUnidadesDemandaReal() {
        return unidadesDemandaReal;
    }

    public void setUnidadesDemandaReal(Long unidadesDemandaReal) {
        this.unidadesDemandaReal = unidadesDemandaReal;
    }

    public Long getOidPosicion() {
        return oidPosicion;
    }

    public void setOidPosicion(Long oidPosicion) {
        this.oidPosicion = oidPosicion;
    }

    //Agregado por Sergio Platas según DMCO INC8- 07/06/2005
    public BigDecimal getPrecioNetoUnitarioLocal() {
        return precioNetoUnitarioLocal;
    }

    //Agregado por Sergio Platas según DMCO INC8- 07/06/2005
    public void setPrecioNetoUnitarioLocal(BigDecimal precioNetoUnitarioLocal) {
        this.precioNetoUnitarioLocal = precioNetoUnitarioLocal;
    }

    //Agregado por Sergio Platas según DMCO INC8- 07/06/2005
    public BigDecimal getPrecioFacturaUnitarioLocal() {
        return precioFacturaUnitarioLocal;
    }

    //Agregado por Sergio Platas según DMCO INC8- 07/06/2005
    public void setPrecioFacturaUnitarioLocal(BigDecimal precioFacturaUnitarioLocal) {
        this.precioFacturaUnitarioLocal = precioFacturaUnitarioLocal;
    }

    public Long getUnidadesDemandadas() {
        return unidadesDemandadas;
    }

    public void setUnidadesDemandadas(Long unidadesDemandadas) {
        this.unidadesDemandadas = unidadesDemandadas;
    }

    public BigDecimal getPrecioContableUnitarioLocal()
    {
        return precioContableUnitarioLocal;
    }

    public void setPrecioContableUnitarioLocal(BigDecimal precioContableUnitarioLocal)
    {
        this.precioContableUnitarioLocal = precioContableUnitarioLocal;
    }

    public boolean getRechazada(Long oidConcurso)
    {
        return solicitud.getSolicitudConcurso(oidConcurso).getPosicionPuntaje(oidPosicion).isRechazada();
    }

    public void setRechazada(Long oidConcurso)
    {
        solicitud.getSolicitudConcurso(oidConcurso).getPosicionPuntaje(oidPosicion).setRechazada(true);
    }
    
    /**
     * Agregado por dmorello, 19/01/2006
     */
    public String toString() {
        StringBuffer sb = new StringBuffer();

        sb.append("Posicion:");
        
        sb.append("\noidProducto:"
            + this.getOidProducto());
        sb.append("\noidMarcaProducto:"
            + this.getOidMarcaProducto());
        sb.append("\noidUnidadNegocio:"
            + this.getOidUnidadNegocio());
        sb.append("\noidNegocio:"
            + this.getOidNegocio());
        sb.append("\noidGenerico:"
            + this.getOidGenerico());
        sb.append("\noidSuperGenerico:"
            + this.getOidSuperGenerico());
        sb.append("\noidTipoOferta:"
            + this.getOidTipoOferta());
        sb.append("\noidCicloVida:"
            + this.getOidCicloVida());
        sb.append("\nestado:"
            + this.getEstado());
        sb.append("\nsolicitud:"
            + this.getSolicitud());
        sb.append("\nprecioCatalogTotalUniDemandaReal:"
            + this.getPrecioCatalogTotalUniDemandaReal());
        sb.append("\nunidadesPorAtender:"
            + this.getUnidadesPorAtender());
        sb.append("\nunidadesComprometidas:"
            + this.getUnidadesComprometidas());
        sb.append("\nprecioCatalogoUnitarioLocal:"
            + this.getPrecioCatalogoUnitarioLocal());
        sb.append("\ncontrolStock:"
            + this.getControlStock());
        sb.append("\ncontrolLiquidacion:"
            + this.getControlLiquidacion());
        sb.append("\nlimiteVenta:"
            + this.getLimiteVenta());
        sb.append("\nunidadesDemandaReal:"
            + this.getUnidadesDemandaReal());
        sb.append("\noidPosicion:"
            + this.getOidPosicion());
        sb.append("\nprecioNetoUnitarioLocal:"
            + this.getPrecioNetoUnitarioLocal());
        sb.append("\nprecioFacturaUnitarioLocal:"
            + this.getPrecioFacturaUnitarioLocal());
        sb.append("\nunidadesDemandadas:"
            + this.getUnidadesDemandadas());
        sb.append("\nproductoReemplazo:"
            + this.isProductoReemplazo());
        sb.append("\noidDetalleOferta:"
                    + this.getOidDetalleOferta());            
        sb.append("\nprecioContableUnitarioLocal:"
            + this.getPrecioContableUnitarioLocal());

        return sb.toString();
    }

    public void setProductoReemplazo(boolean productoReemplazo) {
        this.productoReemplazo = productoReemplazo;
    }

    public boolean isProductoReemplazo() {
        return productoReemplazo;
    }

    public void setOidDetalleOferta(Long oidDetalleOferta) {
        this.oidDetalleOferta = oidDetalleOferta;
    }

    public Long getOidDetalleOferta() {
        return oidDetalleOferta;
    }
}
