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

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTORegistroAdam extends DTOBelcorp
{
    public DTORegistroAdam()
    {
    }
    
    
        private Long oidCliente;                 
        private Long oidSubTipoCLiente;          
        private BigDecimal impDeudaCalculado;    
        private BigDecimal impDeudaEnviarAdam;   
        private BigDecimal impDeudaDescontar;    
        private Boolean procesado;               

    public BigDecimal getImpDeudaCalculado()
    {
        return impDeudaCalculado;
    }

    public void setImpDeudaCalculado(BigDecimal impDeudaCalculado)
    {
        this.impDeudaCalculado = impDeudaCalculado;
    }

    public BigDecimal getImpDeudaDescontar()
    {
        return impDeudaDescontar;
    }

    public void setImpDeudaDescontar(BigDecimal impDeudaDescontar)
    {
        this.impDeudaDescontar = impDeudaDescontar;
    }

    public BigDecimal getImpDeudaEnviarAdam()
    {
        return impDeudaEnviarAdam;
    }

    public void setImpDeudaEnviarAdam(BigDecimal impDeudaEnviarAdam)
    {
        this.impDeudaEnviarAdam = impDeudaEnviarAdam;
    }

    public Long getOidCliente()
    {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente)
    {
        this.oidCliente = oidCliente;
    }

    public Long getOidSubTipoCLiente()
    {
        return oidSubTipoCLiente;
    }

    public void setOidSubTipoCLiente(Long oidSubTipoCLiente)
    {
        this.oidSubTipoCLiente = oidSubTipoCLiente;
    }

    public Boolean getProcesado()
    {
        return procesado;
    }

    public void setProcesado(Boolean procesado)
    {
        this.procesado = procesado;
    }

}