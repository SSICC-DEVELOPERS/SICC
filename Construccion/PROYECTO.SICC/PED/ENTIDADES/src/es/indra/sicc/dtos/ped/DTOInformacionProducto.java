package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInformacionProducto extends DTOAuditableSICC {

    private String codigoVenta;
    private String descripcionCorta;
    private String codigoProducto;
    private String descripcionLarga;


  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }


  public String getCodigoVenta()
  {
    return codigoVenta;
  }


  public void setDescripcionCorta(String descripcionCorta)
  {
    this.descripcionCorta = descripcionCorta;
  }


  public String getDescripcionCorta()
  {
    return descripcionCorta;
  }


  public void setCodigoProducto(String codigoProducto)
  {
    this.codigoProducto = codigoProducto;
  }


  public String getCodigoProducto()
  {
    return codigoProducto;
  }


  public void setDescripcionLarga(String descripcionLarga)
  {
    this.descripcionLarga = descripcionLarga;
  }


  public String getDescripcionLarga()
  {
    return descripcionLarga;
  }

}