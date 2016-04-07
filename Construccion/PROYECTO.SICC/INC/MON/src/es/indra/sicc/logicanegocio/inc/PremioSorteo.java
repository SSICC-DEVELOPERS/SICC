package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

public class PremioSorteo extends Premio implements Serializable {

    private Integer cantidadNumerosAOtorgar;
    private String codProducto;
    private Long oidProducto;

    public PremioSorteo() {
        super();
    }

    public Integer getCantidadNumerosAOtorgar(){
      return this.cantidadNumerosAOtorgar;
    }
      
    public void setCantidadNumerosAOtorgar(Integer cantidadNumerosAOtorgar){
      this.cantidadNumerosAOtorgar = cantidadNumerosAOtorgar;
    }
      
    public String getCodProducto(){
      return this.codProducto;
    }
      
    public void setCodProducto(String codProducto){
      this.codProducto = codProducto;
    }
    
    public Long getOidProducto(){
      return this.oidProducto;
    }
      
    public void setOidProducto(Long oidProducto) {
      this.oidProducto = oidProducto;
    }
}
