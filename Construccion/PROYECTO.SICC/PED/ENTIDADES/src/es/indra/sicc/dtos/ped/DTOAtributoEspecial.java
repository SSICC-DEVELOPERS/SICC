package es.indra.sicc.dtos.ped;

import es.indra.sicc.util.DTOBelcorp;

public class DTOAtributoEspecial extends DTOBelcorp {
  private String campo;
  private String descripcion;
  private String formulario;
  private Long oid;
  private String modulo;
  private Long oidModulo;  

  public DTOAtributoEspecial() {
  }

  public String getCampo() {
    return this.campo;
  }

  public void setCampo(String newCampo) {
    this.campo = newCampo;
  }

  public String getDescripcion() {
    return this.descripcion;
  }

  public void setDescripcion(String newDescripcion) {
    this.descripcion = newDescripcion;
  }

  public String getFormulario() {
    return this.formulario;
  }

  public void setFormulario(String newFormulario) {
    this.formulario = newFormulario;
  }

  public Long getOid() {
    return this.oid;
  }

  public void setOid(Long newOid) {
    this.oid = newOid;
  }

  public String getModulo() {
    return this.modulo;
  }

  public void setModulo(String newModulo) {
    this.modulo = newModulo;
  }

  public Long getOidModulo() {
    return this.oidModulo;
  }

  public void setOidModulo(Long newOidModulo) {
    this.oidModulo = newOidModulo;
  }  
}