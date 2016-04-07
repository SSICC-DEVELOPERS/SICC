package es.indra.sicc.dtos.com;

/**
 * Sistema:           Belcorp
 * Modulo:            COMISIONES
 * Componente:        DTOGerenteZona
 * Fecha:             06/04/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-COM-202-334-N034
 * Descripcion:       DTOGerenteZona
 * @version           1.0
 * @autor             pcabrera
 */




public class DTOGerenteZona 
{
  private Long oidGerente;
  private Long[] oidZona;
  private Long[] oidSubgerenciaVentas;
  private Long[] oidRegion;
  private Long[] oidSeccion;

  public DTOGerenteZona()
  {
  }

  public Long getOidGerente()
  {
    return oidGerente;
  }

  public void setOidGerente(Long oidGerente)
  {
    this.oidGerente = oidGerente;
  }

  public Long[] getOidZona()
  {
    return oidZona;
  }

  public void setOidZona(Long[] oidZona)
  {
    this.oidZona = oidZona;
  }

  public Long[] getOidSubgerenciaVentas()
  {
    return oidSubgerenciaVentas;
  }

  public void setOidSubgerenciaVentas(Long[] oidSubgerenciaVentas)
  {
    this.oidSubgerenciaVentas = oidSubgerenciaVentas;
  }

  public Long[] getOidRegion()
  {
    return oidRegion;
  }

  public void setOidRegion(Long[] oidRegion)
  {
    this.oidRegion = oidRegion;
  }

  public Long[] getOidSeccion()
  {
    return oidSeccion;
  }

  public void setOidSeccion(Long[] oidSeccion)
  {
    this.oidSeccion = oidSeccion;
  }
}