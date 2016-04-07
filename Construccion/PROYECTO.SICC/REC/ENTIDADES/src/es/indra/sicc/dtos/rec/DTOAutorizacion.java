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
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;

public class DTOAutorizacion extends DTOSiccPaginacion 
{
    public DTOAutorizacion()
    {
    }
    
    private Long oid;
    private Long oidUsuario;
    private Long oidOperacion;
    private Long oidTipoOperacion;
    private Long oidPais;
    private BigDecimal importeMaximo;
    private BigDecimal montoMaximoDiferencia;
    private Boolean ingreso;
    private Boolean desbloqueo;


    public void setOid(Long oid)
    {
        this.oid = oid;
    }


    public Long getOid()
    {
        return oid;
    }


    public void setOidUsuario(Long oidUsuario)
    {
        this.oidUsuario = oidUsuario;
    }


    public Long getOidUsuario()
    {
        return oidUsuario;
    }


    public void setOidOperacion(Long oidOperacion)
    {
        this.oidOperacion = oidOperacion;
    }


    public Long getOidOperacion()
    {
        return oidOperacion;
    }


    public void setOidTipoOperacion(Long oidTipoOperacion)
    {
        this.oidTipoOperacion = oidTipoOperacion;
    }


    public Long getOidTipoOperacion()
    {
        return oidTipoOperacion;
    }


    public void setOidPais(Long oidPais)
    {
        this.oidPais = oidPais;
    }


    public Long getOidPais()
    {
        return oidPais;
    }


    public void setImporteMaximo(BigDecimal importeMaximo)
    {
        this.importeMaximo = importeMaximo;
    }


    public BigDecimal getImporteMaximo()
    {
        return importeMaximo;
    }


    public void setMontoMaximoDiferencia(BigDecimal montoMaximoDiferencia)
    {
        this.montoMaximoDiferencia = montoMaximoDiferencia;
    }


    public BigDecimal getMontoMaximoDiferencia()
    {
        return montoMaximoDiferencia;
    }


    public void setIngreso(Boolean ingreso)
    {
        this.ingreso = ingreso;
    }


    public Boolean getIngreso()
    {
        return ingreso;
    }


    public void setDesbloqueo(Boolean desbloqueo)
    {
        this.desbloqueo = desbloqueo;
    }


    public Boolean getDesbloqueo()
    {
        return desbloqueo;
    }
}