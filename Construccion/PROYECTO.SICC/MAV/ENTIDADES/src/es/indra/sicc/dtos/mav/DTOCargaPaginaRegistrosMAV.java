package es.indra.sicc.dtos.mav;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DTOCargaPaginaRegistrosMAV extends DTOAuditableSICC
{
  public RecordSet regiones;
  public RecordSet zonas;

  public DTOCargaPaginaRegistrosMAV()
  {
  }

  public RecordSet getRegiones()
  {
    return regiones;
  }


  public void setRegiones(RecordSet newRegiones)
  {
    regiones = newRegiones;
  }

  public RecordSet getZonas()
  {
    return zonas;
  }

  public void setZonas(RecordSet newZonas)
  {
    zonas = newZonas;
  }


}