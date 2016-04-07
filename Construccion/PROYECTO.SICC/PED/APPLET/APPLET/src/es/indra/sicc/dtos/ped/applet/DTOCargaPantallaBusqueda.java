package es.indra.sicc.dtos.ped.applet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCargaPantallaBusqueda extends DTOAuditableSICC {
  private DTODatosCombo []catalogos;
  private DTODatosCombo []lineasProducto;

  public DTODatosCombo[] getCatalogos()
  {
    return catalogos;
  }

  public void setCatalogos(DTODatosCombo[] catalogos)
  {
    this.catalogos = catalogos;
  }

  public DTODatosCombo[] getLineasProducto()
  {
    return lineasProducto;
  }

  public void setLineasProducto(DTODatosCombo[] lineasProducto)
  {
    this.lineasProducto = lineasProducto;
  }
}