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

public class PosicionPuntaje implements Serializable {
    private Double puntosSolicitud;
    private Long unidadesSolicitud;
    private BigDecimal montoSolicitud;
    private Long unidadesValidas;
    private BigDecimal montoValido;
    private Double puntosValidos;
    private double puntosBonificados;
    private Long oidProductoExigido;
    private Long oidPosicion;
    private Double puntajeFaltanteNoAnunciado;

    //Agregado por Jrivas 30/5/2005
    private BigDecimal montoCalificacion;
    private Long unidadesCalificacion;
    private BigDecimal factorMultiplicadorImporteBonificado;

    //Agregado por Jrivas 16/8/2005 INC 20358
    private Long oidProductoBonificado;
    private boolean rechazada;
    
    //BELC300024301 - gPineda - 04/10/06 - Se agrega
    private Double puntosPorUnidad;

    public PosicionPuntaje() {
        UtilidadesLog.info("PosicionPuntaje(): Entrada");
        
        //BELC300024301 - gPineda - 04/10/06
        //this.factorMultiplicadorImporteBonificado = new BigDecimal(1);
        this.factorMultiplicadorImporteBonificado = new BigDecimal(0);
        this.puntosPorUnidad = new Double(0);
        
        this.puntosSolicitud = new Double(0);
        this.unidadesSolicitud = new Long(0);
        this.montoSolicitud = new BigDecimal(0);
        this.unidadesValidas = new Long(0);
        this.montoValido = new BigDecimal(0);
        this.puntosValidos = new Double(0);
        this.puntosBonificados = 0;
        this.puntajeFaltanteNoAnunciado = new Double(0);
        this.montoCalificacion = new BigDecimal(0);
        this.unidadesCalificacion = new Long(0);
        
        UtilidadesLog.info("PosicionPuntaje(): Salida");
    }

    public PosicionPuntaje(Long oidPosicion) {
        UtilidadesLog.info("PosicionPuntaje(Long oidPosicion): Entrada");
        
        this.oidPosicion = oidPosicion;
        
        //BELC300024301 - gPineda - 04/10/06
        //this.factorMultiplicadorImporteBonificado = new BigDecimal(1);
        this.factorMultiplicadorImporteBonificado = new BigDecimal(0);        
        this.puntosPorUnidad = new Double(0);
        
        this.puntosSolicitud = new Double(0);
        this.unidadesSolicitud = new Long(0);
        this.montoSolicitud = new BigDecimal(0);
        this.unidadesValidas = new Long(0);
        this.montoValido = new BigDecimal(0);
        this.puntosValidos = new Double(0);
        this.puntosBonificados = 0;
        this.puntajeFaltanteNoAnunciado = new Double(0);
        this.montoCalificacion = new BigDecimal(0);
        this.unidadesCalificacion = new Long(0);
        
        UtilidadesLog.info("PosicionPuntaje(Long oidPosicion): Salida");
    }

    public Double getPuntosSolicitud() {
        return puntosSolicitud;
    }

    public void setPuntosSolicitud(Double puntosSolicitud) {
        this.puntosSolicitud = puntosSolicitud;
    }

    public Long getUnidadesSolicitud() {
        return unidadesSolicitud;
    }

    public void setUnidadesSolicitud(Long unidadesSolicitud) {
        this.unidadesSolicitud = unidadesSolicitud;
    }

    public BigDecimal getMontoSolicitud() {
        return montoSolicitud;
    }

    public void setMontoSolicitud(BigDecimal montoSolicitud) {
        this.montoSolicitud = montoSolicitud;
    }

    public Long getUnidadesValidas() {
        return unidadesValidas;
    }

    public void setUnidadesValidas(Long unidadesValidas) {
        this.unidadesValidas = unidadesValidas;
    }

    public BigDecimal getMontoValido() {
        return montoValido;
    }

    public void setMontoValido(BigDecimal montoValido) {
        this.montoValido = montoValido;
    }

    public Double getPuntosValidos() {
        return puntosValidos;
    }

    public void setPuntosValidos(Double puntosValidos) {
        this.puntosValidos = puntosValidos;
    }

    public double getPuntosBonificados() {
        return puntosBonificados;
    }

    public void setPuntosBonificados(double puntosBonificados) {
        this.puntosBonificados = puntosBonificados;
    }

    public Long getOidProductoExigido() {
        return oidProductoExigido;
    }

    public void setOidProductoExigido(Long oidProductoExigido) {
        this.oidProductoExigido = oidProductoExigido;
    }

    public Long getOidPosicion() {
        return oidPosicion;
    }

    public void setOidPosicion(Long oidPosicion) {
        this.oidPosicion = oidPosicion;
    }

    public Double getPuntajeFaltanteNoAnunciado() {
        return puntajeFaltanteNoAnunciado;
    }

    public void setPuntajeFaltanteNoAnunciado(Double puntajeFaltanteNoAnunciado) {
        this.puntajeFaltanteNoAnunciado = puntajeFaltanteNoAnunciado;
    }

    public BigDecimal getMontoCalificacion() {
        return montoCalificacion;
    }

    public void setMontoCalificacion(BigDecimal montoCalificacion) {
        this.montoCalificacion = montoCalificacion;
    }

    public Long getUnidadesCalificacion() {
        return unidadesCalificacion;
    }

    public void setUnidadesCalificacion(Long unidadesCalificacion) {
        this.unidadesCalificacion = unidadesCalificacion;
    }

    public BigDecimal getFactorMultiplicadorImporteBonificado() {
        return factorMultiplicadorImporteBonificado;
    }

    public void setFactorMultiplicadorImporteBonificado(BigDecimal factorMultiplicadorImporteBonificado) {
        this.factorMultiplicadorImporteBonificado = factorMultiplicadorImporteBonificado;
    }

    public Long getOidProductoBonificado() {
        return oidProductoBonificado;
    }

    public void setOidProductoBonificado(Long oidProductoBonificado) {
        this.oidProductoBonificado = oidProductoBonificado;
    }

    public boolean isRechazada()
    {
        return rechazada;
    }

    public void setRechazada(boolean rechazada)
    {
        this.rechazada = rechazada;
    }


  public void setPuntosPorUnidad(Double puntosPorUnidad)
  {
    this.puntosPorUnidad = puntosPorUnidad;
  }


  public Double getPuntosPorUnidad()
  {
    return puntosPorUnidad;
  }
}
