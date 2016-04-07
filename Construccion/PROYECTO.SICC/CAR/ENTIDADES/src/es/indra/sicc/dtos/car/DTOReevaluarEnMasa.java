package es.indra.sicc.dtos.car;

/**
 * 
 * @Autor Joaquin Alem
 * @Fecha 
 * @Descripcion 
 */
public class DTOReevaluarEnMasa extends DTOReevaluar {
  /**
   * 
   * @Autor Joaquin Alem
   * @Fecha 
   * @Descripcion 
   */
   
   
 private Long oidSubgerencia;
 private Long oidRegion;   
 private Long oidZona;
 private Long procedencia;
 private Boolean mensaje;
   
   
  public DTOReevaluarEnMasa() {
  }


  public void setOidSubgerencia(Long oidSubgerencia) {
    this.oidSubgerencia = oidSubgerencia;
  }


  public Long getOidSubgerencia() {
    return oidSubgerencia;
  }


  public void setOidRegion(Long oidRegion) {
    this.oidRegion = oidRegion;
  }


  public Long getOidRegion() {
    return oidRegion;
  }


  public void setOidZona(Long oidZona) {
    this.oidZona = oidZona;
  }


  public Long getOidZona() {
    return oidZona;
  }


  public void setProcedencia(Long procedencia) {
    this.procedencia = procedencia;
  }


  public Long getProcedencia() {
    return procedencia;
  }


  public void setMensaje(Boolean mensaje) {
    this.mensaje = mensaje;
  }


  public Boolean getMensaje() {
    return mensaje;
  }
  
  
}