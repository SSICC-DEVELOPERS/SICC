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
 */
 
package es.indra.sicc.dtos.dto;

import es.indra.sicc.dtos.ped.DTOSolicitudValidacion;

import java.math.BigDecimal;

import java.sql.Date;

import java.util.ArrayList;


/**
 * Sistema:       Belcorp
 * Modulo:        DTO
 * Componente:    DTOSolicitudDescuento 
 * Fecha:         28/07/2004
 * Observaciones: Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DCMO-DTO-201-334-N024
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOSolicitudDescuento extends DTOSolicitudValidacion {

    private String codigoCliente;
    private String nombreCliente;
    private Date fechaSolicitud;
    private BigDecimal montoTotalSolicitud;
    private BigDecimal montoDescuento3;
    private ArrayList posiciones;
    private Long region;
    private Long subgerencia;
    private Long periodoDocumentoReferencia;
    private String nombrePeriodoDocumentoReferencia;
    private ArrayList posicionesSolictudReferencia;

    // sapaza -- PER-SiCC-2012-0412 -- 23/05/2012
    private BigDecimal montoBaseCalculo;

    public DTOSolicitudDescuento() {

    }

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente)
    {
        codigoCliente = newCodigoCliente;
    }

    public String getNombreCliente()
    {
        return nombreCliente;
    }

    public void setNombreCliente(String newNombreCliente)
    {
        nombreCliente = newNombreCliente;
    }



    public Date getFechaSolicitud()
    {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date newFechaSolicitud)
    {
        fechaSolicitud = newFechaSolicitud;
    }

    public BigDecimal getMontoTotalSolicitud()
    {
        return montoTotalSolicitud;
    }

    public void setMontoTotalSolicitud(BigDecimal newMontoTotalSolicitud)
    {
        montoTotalSolicitud = newMontoTotalSolicitud;
    }

    public BigDecimal getMontoDescuento3()
    {
        return montoDescuento3;
    }

    public void setMontoDescuento3(BigDecimal newMontoDescuento3)
    {
        montoDescuento3 = newMontoDescuento3;
    }

    public ArrayList getPosiciones()
    {
        return posiciones;
    }

    public void setPosiciones(ArrayList newPosiciones)
    {
        posiciones = newPosiciones;
    }

    public Long getRegion()
    {
        return region;
    }

    public void setRegion(Long region)
    {
        this.region = region;
    }

    public Long getSubgerencia()
    {
        return subgerencia;
    }

    public void setSubgerencia(Long subgerencia)
    {
        this.subgerencia = subgerencia;
    }

    public Long getPeriodoDocumentoReferencia()
    {
      return periodoDocumentoReferencia;
    }
  
    public void setPeriodoDocumentoReferencia(Long periodoDocumentoReferencia)
    {
      this.periodoDocumentoReferencia = periodoDocumentoReferencia;
    }
  
    public String getNombrePeriodoDocumentoReferencia()
    {
      return nombrePeriodoDocumentoReferencia;
    }
  
    public void setNombrePeriodoDocumentoReferencia(String nombrePeriodoDocumentoReferencia)
    {
      this.nombrePeriodoDocumentoReferencia = nombrePeriodoDocumentoReferencia;
    }

    public ArrayList getPosicionesSolictudReferencia()
    {
      return posicionesSolictudReferencia;
    }

    public void setPosicionesSolictudReferencia(ArrayList posicionesSolictudReferencia)
    {
      this.posicionesSolictudReferencia = posicionesSolictudReferencia;
    }


    public void setMontoBaseCalculo(BigDecimal montoBaseCalculo) {
        this.montoBaseCalculo = montoBaseCalculo;
    }

    public BigDecimal getMontoBaseCalculo() {
        return montoBaseCalculo;
    }
}
