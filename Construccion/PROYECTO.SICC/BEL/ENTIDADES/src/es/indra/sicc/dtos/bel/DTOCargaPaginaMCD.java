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

package es.indra.sicc.dtos.bel;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOCargaPaginaMCD 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */

public class DTOCargaPaginaMCD extends DTOAuditableSICC {
    private Long oidMonedaAlternativa;
    private String descripcionMonedaAlternativa;
    private BigDecimal tipoCambio;
    private RecordSet mediosDePago;

    public DTOCargaPaginaMCD()
    {
    }

    public Long getOidMonedaAlternativa()
    {
        return oidMonedaAlternativa;
    }

    public void setOidMonedaAlternativa(Long newOidMonedaAlternativa)
    {
        oidMonedaAlternativa = newOidMonedaAlternativa;
    }

    public String getDescripcionMonedaAlternativa()
    {
        return descripcionMonedaAlternativa;
    }

    public void setDescripcionMonedaAlternativa(String newDescripcionMonedaAlternativa)
    {
        descripcionMonedaAlternativa = newDescripcionMonedaAlternativa;
    }

    public BigDecimal getTipoCambio()
    {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal newTipoCambio)
    {
        tipoCambio = newTipoCambio;
    }

    public RecordSet getMediosDePago()
    {
        return mediosDePago;
    }

    public void setMediosDePago(RecordSet newMediosDePago)
    {
        mediosDePago = newMediosDePago;
    }
}