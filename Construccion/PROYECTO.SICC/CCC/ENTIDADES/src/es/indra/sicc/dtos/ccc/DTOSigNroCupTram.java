/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.dtos.ccc;

import java.util.Date;
import es.indra.mare.common.dto.BaseDruidaDTO;

public class DTOSigNroCupTram extends BaseDruidaDTO 
{

	private java.lang.Long oidPais;
    private Date fechDigit;
    
    public DTOSigNroCupTram()
    {
    }


    public void setOidPais(Long oidPais)
    {
        this.oidPais = oidPais;
    }


    public Long getOidPais()
    {
        return oidPais;
    }


    public void setFechDigit(Date fechDigit)
    {
        this.fechDigit = fechDigit;
    }


    public Date getFechDigit()
    {
        return fechDigit;
    }
    
}