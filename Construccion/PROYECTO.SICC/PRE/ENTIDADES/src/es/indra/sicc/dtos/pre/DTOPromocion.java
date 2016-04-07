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
 *
 */
package es.indra.sicc.dtos.pre;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.Vector;

/**
 * 
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 */
public class DTOPromocion extends DTOAuditableSICC 
{
  private Long oidPromocion;
  private Integer numeroCondicion;
  private Long oidIndicadorCuadre;
  private String descripcionIndicadorCuadre;
  private Float factorCuadre;//inc. 24193 pasa a float
  private Vector lineaPromocion;
  private String tipoOperacion;//[1]


  public DTOPromocion()  {
  }

  public Long getOidPromocion()  {
    return oidPromocion;
  }

  public void setOidPromocion(Long newOidPromocion)  {
    oidPromocion = newOidPromocion;
  }

  public Integer getNumeroCondicion()  {
    return numeroCondicion;
  }

  public void setNumeroCondicion(Integer newNumeroCondicion)  {
    numeroCondicion = newNumeroCondicion;
  }

  public Long getOidIndicadorCuadre()  {
    return oidIndicadorCuadre;
  }

  public void setOidIndicadorCuadre(Long newOidIndicadorCuadre)  {
    oidIndicadorCuadre = newOidIndicadorCuadre;
  }

  public String getDescripcionIndicadorCuadre()  {
    return descripcionIndicadorCuadre;
  }

  public void setDescripcionIndicadorCuadre(String newDescripcionIndicadorCuadre)  {
    descripcionIndicadorCuadre = newDescripcionIndicadorCuadre;
  }

  public Float getFactorCuadre()  {
    return factorCuadre;
  }

  public void setFactorCuadre(Float newFactorCuadre)  {
    factorCuadre = newFactorCuadre;
  }

  public Vector getLineaPromocion()  {
    return lineaPromocion;
  }

  public void setLineaPromocion(Vector newLineaPromocion)  {
    lineaPromocion = newLineaPromocion;
  }
  ///*[1]
  public String getTipoOperacion(){
        return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion){
        this.tipoOperacion = tipoOperacion;
  }
  //*/[1]
}