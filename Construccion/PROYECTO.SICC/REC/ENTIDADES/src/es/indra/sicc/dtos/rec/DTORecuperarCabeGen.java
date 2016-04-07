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

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

public class DTORecuperarCabeGen extends DTOBelcorp  {
    public DTORecuperarCabeGen() {
    }
    
    private String descripcionOrigen;
    private String descripcionDestino;
    private BigDecimal precioCatalogoOrigen;
    private BigDecimal precioCatalogoDestino;
    private RecordSet lstNoGenerar;

    public String getDescripcionDestino() {
        return descripcionDestino;
    }

    public void setDescripcionDestino(String descripcionDestino) {
        this.descripcionDestino = descripcionDestino;
    }

    public String getDescripcionOrigen() {
        return descripcionOrigen;
    }

    public void setDescripcionOrigen(String descripcionOrigen) {
        this.descripcionOrigen = descripcionOrigen;
    }

    public RecordSet getLstNoGenerar() {
        return lstNoGenerar;
    }

    public void setLstNoGenerar(RecordSet lstNoGenerar) {
        this.lstNoGenerar = lstNoGenerar;
    }

    public BigDecimal getPrecioCatalogoDestino() {
        return precioCatalogoDestino;
    }

    public void setPrecioCatalogoDestino(BigDecimal precioCatalogoDestino) {
        this.precioCatalogoDestino = precioCatalogoDestino;
    }

    public BigDecimal getPrecioCatalogoOrigen() {
        return precioCatalogoOrigen;
    }

    public void setPrecioCatalogoOrigen(BigDecimal precioCatalogoOrigen) {
        this.precioCatalogoOrigen = precioCatalogoOrigen;
    }
}