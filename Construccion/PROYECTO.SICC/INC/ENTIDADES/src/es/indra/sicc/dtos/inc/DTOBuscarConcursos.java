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
 * 
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;


//import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


/**
 * Modificado por ssantana, 1/6/2005
 *  - Se hace que extienda de DTOSiccPaginacion para usarlo con Búsqueda Paginada 
 *    en parte cliente.
 */

public class DTOBuscarConcursos extends DTOSiccPaginacion
{
  private Long oidConcurso;
  private Long oidPlantilla;
  private String nombreConcurso;
  private String nombrePlantilla;
  private Integer version;
  private Long oidMarca;
  private Long oidCanal;
  private Boolean indActivo;
  private String nroConcurso;
    private Long oidVigenciaConcurso;
    private Long oidPeriodo;

  public DTOBuscarConcursos()
  {
  }

  public Long getOidConcurso()
  {
    return oidConcurso;
  }

  public void setOidConcurso(Long oidConcurso)
  {
    this.oidConcurso = oidConcurso;
  }

  public Long getOidPlantilla()
  {
    return oidPlantilla;
  }

  public void setOidPlantilla(Long oidPlantilla)
  {
    this.oidPlantilla = oidPlantilla;
  }

  public String getNombreConcurso()
  {
    return nombreConcurso;
  }

  public void setNombreConcurso(String nombreConcurso)
  {
    this.nombreConcurso = nombreConcurso;
  }

  public String getNombrePlantilla()
  {
    return nombrePlantilla;
  }

  public void setNombrePlantilla(String nombrePlantilla)
  {
    this.nombrePlantilla = nombrePlantilla;
  }

  public Integer getVersion()
  {
    return version;
  }

  public void setVersion(Integer version)
  {
    this.version = version;
  }

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }

  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;
  }

  public Boolean getIndActivo()
  {
    return indActivo;
  }

  public void setIndActivo(Boolean indActivo)
  {
    this.indActivo = indActivo;
  }

  public String getNroConcurso() {
    return nroConcurso;
  }

  public void setNroConcurso(String nroConcurso) {
    this.nroConcurso = nroConcurso;
  }

    public Long getOidVigenciaConcurso() {
        return oidVigenciaConcurso;
    }

    public void setOidVigenciaConcurso(Long oidVigenciaConcurso) {
        this.oidVigenciaConcurso = oidVigenciaConcurso;
    }

    public Long getOidPeriodo()
    {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo)
    {
        this.oidPeriodo = oidPeriodo;
    }
}