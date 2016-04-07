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
 
package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.lang.Long;

/**
 * 
 * @date 06/09/2005
 * @author pperanzola
 *      [1] modificaciones segun DT codigo de venta
 */
public class DTOEFicheroGP extends DTOSiccPaginacion
{
 private Long oidCabeceraMF = null;
 private Long oidCatalogo = null; //[1]
 
  public DTOEFicheroGP() 
  {
  }

  public void setOidCabeceraMF(Long oidCabeceraMF)
  {
    this.oidCabeceraMF = oidCabeceraMF;
  }

  public Long getOidCabeceraMF ()
  {
    return this.oidCabeceraMF;
  }
  // /* [1]
  public void setOidCatalogo(Long oidCatalogo) {
      this.oidCatalogo = oidCatalogo;
  }
  public Long getOidCatalogo (){
      return this.oidCatalogo;
  }
  // */ [1]
}