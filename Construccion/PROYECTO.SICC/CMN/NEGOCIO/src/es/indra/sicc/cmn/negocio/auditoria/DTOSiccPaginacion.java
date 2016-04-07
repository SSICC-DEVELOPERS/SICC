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
 
package es.indra.sicc.cmn.negocio.auditoria;

/**
 * Sistema:           Belcorp
 * Modulo:            CMN
 * Componente:        DTOSiccPaginacion
 * Fecha:             29/10/2003
 * Observaciones:     Componente construido de acuerdo a la especificación del 
 *                    Modelo de Componentes 
 * Descripcion:       DTOAuditableSICC
 * @version           1.0
 * @autor             Fernado Laffaye
 */

public class DTOSiccPaginacion extends DTOAuditableSICC {

    private boolean ultimaPagina;
    private Integer tamanioPagina;
    private Long indicadorSituacion;

    public DTOSiccPaginacion() {
        super();
    }


    public void setUltimaPagina(boolean ultimaPagina)
    {
      this.ultimaPagina = ultimaPagina;
    }

    public boolean getUltimaPagina()
    {
      return this.ultimaPagina;
    }

    public void setTamanioPagina(Integer tamanioPagina)
    {
      this.tamanioPagina = tamanioPagina;
    }

    public Integer getTamanioPagina()
    {
      return this.tamanioPagina;
    }

    public void setIndicadorSituacion(Long indicadorSituacion)
    {
      this.indicadorSituacion = indicadorSituacion;
    }
    
    public Long getIndicadorSituacion()
    {
      return this.indicadorSituacion;
    }

}
