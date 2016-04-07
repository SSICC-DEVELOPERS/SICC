package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionBasicaPosicion extends DTOAuditableSICC {

    private String tipoPosicion;
    private String subtipoPosicion;
    private Integer posicion;


  public void setTipoPosicion(String tipoPosicion)
  {
    this.tipoPosicion = tipoPosicion;
  }


  public String getTipoPosicion()
  {
    return tipoPosicion;
  }


  public void setSubtipoPosicion(String subtipoPosicion)
  {
    this.subtipoPosicion = subtipoPosicion;
  }


  public String getSubtipoPosicion()
  {
    return subtipoPosicion;
  }


  public void setPosicion(Integer posicion)
  {
    this.posicion = posicion;
  }


  public Integer getPosicion()
  {
    return posicion;
  }

}