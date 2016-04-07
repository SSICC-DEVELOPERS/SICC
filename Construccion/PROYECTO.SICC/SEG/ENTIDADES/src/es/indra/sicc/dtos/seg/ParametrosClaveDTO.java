package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class ParametrosClaveDTO extends DTOAuditableSICC 
{
  private Integer diasCambio;
  private Integer numeroRepeticiones;
  private Integer longitudMinina;
  private Integer numeroMaximoIntentos;
  
  public ParametrosClaveDTO()
  {
    super();
  }

  public ParametrosClaveDTO(Integer diasCambio, Integer numeroRepeticiones, Integer longitudMinima, Integer numeroMaximoIntentos)
  {
    super();
    this.diasCambio = diasCambio;
    this.numeroRepeticiones = numeroRepeticiones;
    this.longitudMinina = longitudMinima;
    this.numeroMaximoIntentos = numeroMaximoIntentos;
  }
  // **************************
  //  Setter/Getter diasCambio
  // **************************
  public void setDiasCambio(Integer diasCambio)
  {
    this.diasCambio = diasCambio;
  }

  public Integer getDiasCambio()
  {
    return this.diasCambio;
  }

  // **********************************
  //  Setter/Getter numeroRepeticiones
  // **********************************
  public void setNumeroRepeticiones(Integer numeroRepeticiones)
  {
    this.numeroRepeticiones = numeroRepeticiones;  
  }

  public Integer getNumeroRepeticiones()
  {
    return this.numeroRepeticiones;
  }

  // **********************************
  //  Setter/Getter longitudMinima
  // **********************************
  public void setLongitudMinima(Integer longitudMinima)
  {
    this.longitudMinina = longitudMinima;
  }

  public Integer getLongitudMinina()
  {
    return this.longitudMinina;
  }

  // ************************************
  //  Setter/Getter numeroMaximoIntentos
  // ************************************
  public void setNumeroMaximoIntentos(Integer numeroMaximoIntentos)
  {
    this.numeroMaximoIntentos = numeroMaximoIntentos;
  }

  public Integer getNumeroMaximoIntentos()
  {
    return this.numeroMaximoIntentos;
  }  
  
}