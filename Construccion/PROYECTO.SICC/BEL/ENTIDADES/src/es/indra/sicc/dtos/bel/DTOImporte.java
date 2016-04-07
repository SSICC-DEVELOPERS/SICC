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

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOImporte 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOImporte extends DTOAuditableSICC {
    private Long oidMedioPagoBelcenter;
    private Long oidMonedaAlternativa;
    private BigDecimal importe;
    private BigDecimal importeDivisa;

    public DTOImporte()
    {
    }

    public Long getOidMedioPagoBelcenter()
    {
        return oidMedioPagoBelcenter;
    }

    public void setOidMedioPagoBelcenter(Long newOidMedioPagoBelcenter)
    {
        oidMedioPagoBelcenter = newOidMedioPagoBelcenter;
    }

    public Long getOidMonedaAlternativa()
    {
        return oidMonedaAlternativa;
    }

    public void setOidMonedaAlternativa(Long newOidMonedaAlternativa)
    {
        oidMonedaAlternativa = newOidMonedaAlternativa;
    }

    public BigDecimal getImporte()
    {
        return importe;
    }

    public void setImporte(BigDecimal newImporte)
    {
        importe = newImporte;
    }

    public BigDecimal getImporteDivisa()
    {
        return importeDivisa;
    }

    public void setImporteDivisa(BigDecimal newImporteDivisa)
    {
        importeDivisa = newImporteDivisa;
    }
}