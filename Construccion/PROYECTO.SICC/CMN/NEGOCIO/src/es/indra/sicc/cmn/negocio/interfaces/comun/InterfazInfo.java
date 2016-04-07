package es.indra.sicc.cmn.negocio.interfaces.comun;

import java.io.Serializable;

public class InterfazInfo implements Serializable
{
  private String codigoInterfaz;
  private String numeroLote;
  private Long pais;
  private String descripcionLote;
  private String observaciones;
  private String criteriosConsulta;
  private Long periodo;

  public InterfazInfo( String _codigoInterfaz, String _numeroLote, Long _pais )
  {
    codigoInterfaz = _codigoInterfaz;
    numeroLote = _numeroLote;
    pais = _pais;
  }

  public String getCodigoInterfaz()
  {
    return codigoInterfaz;
  }

  public void setCodigoInterfaz(String newCodigoInterfaz)
  {
    codigoInterfaz = newCodigoInterfaz;
  }


 public String getCriteriosConsulta()
  {
    return criteriosConsulta;
  }

  public void setCriteriosConsulta(String newCriteriosConsulta)
  {
    criteriosConsulta = newCriteriosConsulta;
  }



  public String getNumeroLote()
  {
    return numeroLote;
  }

  public void setNumeroLote(String newNumeroLote)
  {
    numeroLote = newNumeroLote;
  }

  public Long getPais()
  {
    return pais;
  }

  public void setPais(Long newPais)
  {
    pais = newPais;
  }
  
  public String toString() 
  {
    return "Código: " + codigoInterfaz + " - N.lote: " + numeroLote;
  }

  public String getDescripcionLote()
  {
    return descripcionLote;
  }

  public void setDescripcionLote(String descripcionLote)
  {
    this.descripcionLote = descripcionLote;
  }

  public String getObservaciones()
  {
    return observaciones;
  }

  public void setObservaciones(String observaciones)
  {
    this.observaciones = observaciones;
  }
  
  public Long getPeriodo()
  {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo)
  {
    this.periodo = newPeriodo;
  }
}