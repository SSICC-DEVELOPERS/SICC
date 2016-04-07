package es.indra.sicc.dtos.ape;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarLineasArmado extends DTOSiccPaginacion
{
  public DTOBuscarLineasArmado()
  {
  }
  
  String descripcion;
  String descripcionCD;
  Long codigoLinea;


  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }


  public String getDescripcion()
  {
    return descripcion;
  }


  public void setDescripcionCD(String descripcionCD)
  {
    this.descripcionCD = descripcionCD;
  }


  public String getDescripcionCD()
  {
    return descripcionCD;
  }


  public void setCodigoLinea(Long codigoLinea)
  {
    this.codigoLinea = codigoLinea;
  }


  public Long getCodigoLinea()
  {
    return codigoLinea;
  }
  
}