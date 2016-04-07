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
import java.math.BigDecimal;
/**
 * 
 * pperanzola - 20/10/2005 - [1] se modifica según el SICC-DMCO-PRE_MAE_INT-GCC-001
 */
public class DTOGrupo extends DTOAuditableSICC 
{
  private Integer numeroGrupo;
  private BigDecimal factorCuadre;
  private Boolean indicadorGrupo;
  private Boolean condicionante;
  private Boolean condicionado;
  private Long oidIndicadorCuadre;
  private String descripcionIndicadorCuadre;
  private Long oidGrupo;
  private String tipoOperacion;//[1]
  

  public DTOGrupo()
  {
  }

  public Integer getNumeroGrupo()
  {
    return numeroGrupo;
  }

  public void setNumeroGrupo(Integer newNumeroGrupo)
  {
    numeroGrupo = newNumeroGrupo;
  }

  public BigDecimal getFactorCuadre()
  {
    return factorCuadre;
  }

  public void setFactorCuadre(BigDecimal newFactorCuadre)
  {
    factorCuadre = newFactorCuadre;
  }

  public Boolean getIndicadorGrupo()
  {
    return indicadorGrupo;
  }

  public void setIndicadorGrupo(Boolean newIndicadorGrupo)
  {
    indicadorGrupo = newIndicadorGrupo;
  }

  public Boolean getCondicionante()
  {
    return condicionante;
  }

  public void setCondicionante(Boolean newCondicionante)
  {
    condicionante = newCondicionante;
  }

  public Boolean getCondicionado()
  {
    return condicionado;
  }

  public void setCondicionado(Boolean newCondicionado)
  {
    condicionado = newCondicionado;
  }

  public Long getOidIndicadorCuadre()
  {
    return oidIndicadorCuadre;
  }

  public void setOidIndicadorCuadre(Long newOidIndicadorCuadre)
  {
    oidIndicadorCuadre = newOidIndicadorCuadre;
  }

  public String getDescripcionIndicadorCuadre()
  {
    return descripcionIndicadorCuadre;
  }

  public void setDescripcionIndicadorCuadre(String newDescripcionIndicadorCuadre)
  {
    descripcionIndicadorCuadre = newDescripcionIndicadorCuadre;
  }

  public Long getOidGrupo()
  {
    return oidGrupo;
  }

  public void setOidGrupo(Long newOidGrupo)
  {
    oidGrupo = newOidGrupo;
  }
  ///*[1]
  public String getTipoOperacion() {
        return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion){
        this.tipoOperacion = tipoOperacion;
  }
  //*/[1]
}