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
package es.indra.sicc.dtos.car;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;

public class DTOJerarquia extends DTOAuditableSICC  {
    private Long oidJerarquia;
    private String codJerarquia;
    private Long numDias;
    private BigDecimal excesoLineaCredito;
    private BigDecimal excesoMontoMaximo;

    public DTOJerarquia() {
    }

    public Long getOidJerarquia() {
        return oidJerarquia;
    }

    public void setOidJerarquia(Long newOidJerarquia) {
        oidJerarquia = newOidJerarquia;
    }

    public String getCodJerarquia() {
        return codJerarquia;
    }

    public void setCodJerarquia(String newCodJerarquia) {
        codJerarquia = newCodJerarquia;
    }

    public Long getNumDias() {
        return numDias;
    }

    public void setNumDias(Long newNumDias) {
        numDias = newNumDias;
    }

    public BigDecimal getExcesoLineaCredito() {
        return excesoLineaCredito;
    }

    public void setExcesoLineaCredito(BigDecimal newExcesoLineaCredito) {
        excesoLineaCredito = newExcesoLineaCredito;
    }

    public BigDecimal getExcesoMontoMaximo() {
        return excesoMontoMaximo;
    }

    public void setExcesoMontoMaximo(BigDecimal newExcesoMontoMaximo) {
        excesoMontoMaximo = newExcesoMontoMaximo;
    }
}