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

package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;


/**
 * Sistema:         Belcorp
 * Modulo:           MAE
 * Submódulo:     Mantenimiento de Materiales
 * Componente:   DTO's
 * Fecha:             02/12/2003
 * Observaciones:     
 *                    
 * @version          1.0
 * @autor             Luis Ramos
 */

public class DTOBusquedaMateriales extends DTOSiccPaginacion 
{
    private String codSAP;
    private String codAntiguo;
    private String descSAP;
    private String descCorta;
    private Boolean indLote;
    private Boolean indProductoServicio;
    private Long marca;
    private Long unidadNegocio;
    private Long negocio;
    private Long generico;
    private Long supergenerico;

    public DTOBusquedaMateriales()
    {
    }

    public String getCodSAP()
    {
        return codSAP;
    }

    public void setCodSAP(String newCodSAP)
    {
        codSAP = newCodSAP;
    }

    public String getCodAntiguo()
    {
        return codAntiguo;
    }

    public void setCodAntiguo(String newCodAntiguo)
    {
        codAntiguo = newCodAntiguo;
    }

    public String getDescSAP()
    {
        return descSAP;
    }

    public void setDescSAP(String newDescSAP)
    {
        descSAP = newDescSAP;
    }

    public String getDescCorta()
    {
        return descCorta;
    }

    public void setDescCorta(String newDescCorta)
    {
        descCorta = newDescCorta;
    }

    public Boolean getIndLote()
    {
        return indLote;
    }

    public void setIndLote(Boolean newIndLote)
    {
        indLote = newIndLote;
    }

    public Boolean getIndProductoServicio()
    {
        return indProductoServicio;
    }

    public void setIndProductoServicio(Boolean newProductoServicio)
    {
        indProductoServicio = newProductoServicio;
    }

    public Long getMarca()
    {
        return marca;
    }

    public void setMarca(Long newMarca)
    {
        marca = newMarca;
    }

    public Long getUnidadNegocio()
    {
        return unidadNegocio;
    }

    public void setUnidadNegocio(Long newUnidadNegocio)
    {
        unidadNegocio = newUnidadNegocio;
    }

    public Long getNegocio()
    {
        return negocio;
    }

    public void setNegocio(Long newNegocio)
    {
        negocio = newNegocio;
    }

    public Long getGenerico()
    {
        return generico;
    }

    public void setGenerico(Long newGenerico)
    {
        generico = newGenerico;
    }

    public Long getSupergenerico()
    {
        return supergenerico;
    }

    public void setSupergenerico(Long newSupergenerico)
    {
        supergenerico = newSupergenerico;
    }


}