package es.indra.sicc.util;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public abstract class DTOBusquedaGenerica extends DTOSiccPaginacion{
  
  private Long codigo=null;
  private String descripcion=null;
  private String strCodigo=null;
  private Boolean esPaginado = new Boolean(false);


  public DTOBusquedaGenerica() {
  }

  public void setCodigo(Long codigo) {
    this.codigo = codigo;
  }


  public Long getCodigo() {
    return codigo;
  }


  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }


  public String getDescripcion() {
    return descripcion;
  }


  public void setStrCodigo(String strCodigo) {
    this.strCodigo = strCodigo;
  }


  public String getStrCodigo(){
    return strCodigo;
  }
  
 public Boolean getEsPaginado() {
   return this.esPaginado;
 }
  
 public void setEsPaginado(Boolean esPaginado) {
   this.esPaginado = esPaginado;
 }
  
  /*
   * Este metodo se utilizará para encapsular la obtencion del sql
   * necesario para la ejecucion de la consulta.
   * Las diferentes consultas crearan dtos que heredaran de este y sobreescribiran
   * el metodo obtenerSQL
   * */ 
  public abstract String obtenerSQL();
  
  
}