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
import java.util.ArrayList;

/**
 * Sistema:       Belcorp
 * Modulo:        BEL - BelCenter
 * Componente:    DTOImportesFisicos 
 * Fecha:         05/11/2004
 * Observaciones: 
 * 
 * @version       1.0
 * @author        Gustavo De Marzi
 */
 
public class DTOImportesFisicos extends DTOAuditableSICC {
    private Long oidCaja;
    private Long oidSubacceso;
    private String usuario;
    private ArrayList detalle;
    private Integer nroOportunidad;

    public DTOImportesFisicos()
    {
    }

    public Long getOidCaja()
    {
        return oidCaja;
    }

    public void setOidCaja(Long newOidCaja)
    {
        oidCaja = newOidCaja;
    }

    public Long getOidSubacceso()
    {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long newOidSubacceso)
    {
        oidSubacceso = newOidSubacceso;
    }

    public String getUsuario()
    {
        return usuario;
    }

    public void setUsuario(String newUsuario)
    {
        usuario = newUsuario;
    }

    public ArrayList getDetalle()
    {
        return detalle;
    }

    public void setDetalle(ArrayList newDetalle)
    {
        detalle = newDetalle;
    }
    
    public Integer getNroOportunidad()
    {
        return nroOportunidad;
    }

    public void setNroOportunidad(Integer newOportunidad)
    {
        nroOportunidad = newOportunidad;
    }
    
    
}