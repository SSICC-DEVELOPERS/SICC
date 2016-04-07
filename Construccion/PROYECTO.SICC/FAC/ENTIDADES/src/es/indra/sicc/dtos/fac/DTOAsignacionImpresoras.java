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
 
package es.indra.sicc.dtos.fac;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOAsignacionImpresoras extends DTOSiccPaginacion
{
    private Long impresoraVirtual;
    private Long subAcceso;
    private Long formulario;
    private Long canal;
    private Long acceso;

    public Long getImpresoraVirtual()
    {
        return impresoraVirtual;
    }

    public void setImpresoraVirtual(Long impresoraVirtual)
    {
        this.impresoraVirtual = impresoraVirtual;
    }

    public Long getSubAcceso()
    {
        return subAcceso;
    }

    public void setSubAcceso(Long subAcceso)
    {
        this.subAcceso = subAcceso;
    }

    public Long getFormulario()
    {
        return formulario;
    }

    public void setFormulario(Long formulario)
    {
        this.formulario = formulario;
    }

    public Long getCanal()
    {
      return canal;
    }
  
    public void setCanal(Long canaol)
    {
      this.canal = canaol;
    }

    public Long getAcceso()
    {
      return acceso;
    }
  
    public void setAcceso(Long acceso)
    {
      this.acceso = acceso;
    }

}