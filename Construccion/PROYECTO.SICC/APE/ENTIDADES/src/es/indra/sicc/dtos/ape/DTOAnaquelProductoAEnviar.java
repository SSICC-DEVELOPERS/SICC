package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;

public class DTOAnaquelProductoAEnviar extends DTOBelcorp  {
    private String numeroAnaquel;
    private String codProdu;
    private Long unidadesProducto1;
    private Long unidadesProducto2;


  public void setNumeroAnaquel(String numeroAnaquel) {
    this.numeroAnaquel = numeroAnaquel;
  }


  public String getNumeroAnaquel() {
    return numeroAnaquel;
  }


  public void setCodProdu(String codProdu) {
    this.codProdu = codProdu;
  }


  public String getCodProdu() {
    return codProdu;
  }


  public void setUnidadesProducto1(Long unidadesProducto1) {
    this.unidadesProducto1 = unidadesProducto1;
  }


  public Long getUnidadesProducto1() {
    return unidadesProducto1;
  }


  public void setUnidadesProducto2(Long unidadesProducto2) {
    this.unidadesProducto2 = unidadesProducto2;
  }


  public Long getUnidadesProducto2() {
    return unidadesProducto2;
  }
    
}