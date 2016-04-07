package es.indra.sicc.dtos.com;
import es.indra.sicc.dtos.com.DTOBuscarMarcarModificar;

public class DTOBuscarModificar extends DTOBuscarMarcarModificar {
  private String estados;

  public DTOBuscarModificar() {  }
  
  public String getEstados() {
    return this.estados;
  }
  
  public void setEstados(String newEstados)  {
    this.estados = newEstados;
  }
}