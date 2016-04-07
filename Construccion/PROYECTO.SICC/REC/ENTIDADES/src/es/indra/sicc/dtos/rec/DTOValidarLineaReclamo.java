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

public class DTOValidarLineaReclamo extends DTOBelcorp implements Cloneable
{
    private Long oidLineaOperacion;
    private Long oidOperacion;
    private String codigoVenta;
    private Long oidMF;
    private Long oidTipoOferta;
    private BigDecimal precioCatalogoUnitarioLocal;
    private BigDecimal importeDescuentoUnitarioLocal;
    private BigDecimal importeCargo;
    private BigDecimal importeAbono;
    private Integer unidadesReclamadas;
    private Integer unidadesDevueltas;   
    private BigDecimal precio;
    private Long oidTipoMovimiento;
    private Long oidProducto;
    private Integer numeroLinea;
    private Long oidMotivoDevolucion;
    private BigDecimal porcentajePerdida;
    private Long oidPrecioPerdida;
    private boolean error; // Añadido por la BELC300014880
    private BigDecimal montoPerdida; // Añadido por la BELC300014939
    private Long oidPosicionReferencia;
    
    
    public Object clone() throws CloneNotSupportedException {
      DTOValidarLineaReclamo dto = (DTOValidarLineaReclamo)super.clone();
      return dto;
   }
    public DTOValidarLineaReclamo()
    {
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta)
    {
        this.codigoVenta = codigoVenta;
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

    public BigDecimal getImporteDescuentoUnitarioLocal()
    {
        return importeDescuentoUnitarioLocal;
    }

    public void setImporteDescuentoUnitarioLocal(BigDecimal importeDescuentoUnitarioLocal)
    {
        this.importeDescuentoUnitarioLocal = importeDescuentoUnitarioLocal;
    }

    public Integer getNumeroLinea()
    {
        return numeroLinea;
    }

    public void setNumeroLinea(Integer numeroLinea)
    {
        this.numeroLinea = numeroLinea;
    }

    public Long getOidLineaOperacion()
    {
        return oidLineaOperacion;
    }

    public void setOidLineaOperacion(Long oidLineaOperacion)
    {
        this.oidLineaOperacion = oidLineaOperacion;
    }

    public Long getOidMF()
    {
        return oidMF;
    }

    public void setOidMF(Long oidMF)
    {
        this.oidMF = oidMF;
    }

    public Long getOidMotivoDevolucion()
    {
        return oidMotivoDevolucion;
    }

    public void setOidMotivoDevolucion(Long oidMotivoDevolucion)
    {
        this.oidMotivoDevolucion = oidMotivoDevolucion;
    }

    public Long getOidOperacion()
    {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion)
    {
        this.oidOperacion = oidOperacion;
    }

    public Long getOidPrecioPerdida()
    {
        return oidPrecioPerdida;
    }

    public void setOidPrecioPerdida(Long oidPrecioPerdida)
    {
        this.oidPrecioPerdida = oidPrecioPerdida;
    }

    public Long getOidProducto()
    {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }

    public Long getOidTipoMovimiento()
    {
        return oidTipoMovimiento;
    }

    public void setOidTipoMovimiento(Long oidTipoMovimiento)
    {
        this.oidTipoMovimiento = oidTipoMovimiento;
    }

    public Long getOidTipoOferta()
    {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta)
    {
        this.oidTipoOferta = oidTipoOferta;
    }

    public BigDecimal getPorcentajePerdida()
    {
        return porcentajePerdida;
    }

    public void setPorcentajePerdida(BigDecimal porcentajePerdida)
    {
        this.porcentajePerdida = porcentajePerdida;
    }

    public BigDecimal getPrecio()
    {
        return precio;
    }

    public void setPrecio(BigDecimal precio)
    {
        this.precio = precio;
    }

    public BigDecimal getPrecioCatalogoUnitarioLocal()
    {
        return precioCatalogoUnitarioLocal;
    }

    public void setPrecioCatalogoUnitarioLocal(BigDecimal precioCatalogoUnitarioLocal)
    {
        this.precioCatalogoUnitarioLocal = precioCatalogoUnitarioLocal;
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

    public boolean getError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public BigDecimal getMontoPerdida() {
        return montoPerdida;
    }

    public void setMontoPerdida(BigDecimal montoPerdida) {
        this.montoPerdida = montoPerdida;
    }

    public Long getOidPosicionReferencia() {
        return oidPosicionReferencia;
    }

    public void setOidPosicionReferencia(Long oidPosicionReferencia) {
        this.oidPosicionReferencia = oidPosicionReferencia;
    }
}