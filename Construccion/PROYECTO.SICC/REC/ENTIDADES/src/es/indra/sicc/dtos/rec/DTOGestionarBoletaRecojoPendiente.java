/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.Date;

public class DTOGestionarBoletaRecojoPendiente extends DTOSiccPaginacion  {

    private Long oidMarca;
    private Long oidCanal;
    private Long oidPerDde;
    private Long oidPerHta;
    private Date fechaRecojo;
    
    public DTOGestionarBoletaRecojoPendiente()
    {
    }


    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }


    public Long getOidMarca()
    {
        return oidMarca;
    }


    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }


    public Long getOidCanal()
    {
        return oidCanal;
    }


    public void setOidPerDde(Long oidPerDde)
    {
        this.oidPerDde = oidPerDde;
    }


    public Long getOidPerDde()
    {
        return oidPerDde;
    }


    public void setOidPerHta(Long oidPerHta)
    {
        this.oidPerHta = oidPerHta;
    }


    public Long getOidPerHta()
    {
        return oidPerHta;
    }


    public void setFechaRecojo(Date fechaRecojo)
    {
        this.fechaRecojo = fechaRecojo;
    }


    public Date getFechaRecojo()
    {
        return fechaRecojo;
    }
    
}