package es.indra.sicc.dtos.com;
import es.indra.sicc.dtos.com.DTOBuscarInsertarComisiones;

public class DTOBuscarMarcarModificar extends DTOBuscarInsertarComisiones{
  private String codigo;
  private Integer version;
  private Long oidTipoComision;
  
  public DTOBuscarMarcarModificar() {  }
  
  public String getCodigo() {
    return this.codigo;
  }
  
  public void setCodigo(String newCodigo) {
    this.codigo = newCodigo;
  }
  
  public Integer getVersion() {
    return this.version;
  }
  
  public void setVersion(Integer newVersion) {
    this.version = newVersion;
  }
  
  public Long getOidTipoComision() {
    return this.oidTipoComision;
  }
  
  public void setOidTipoComision(Long newOidTipoComision) {
    this.oidTipoComision = newOidTipoComision;
  }
  
}