package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import es.indra.sicc.util.DTOBelcorp;

public class DTODocumento extends DTOBelcorp
{
 
private String documento;
private Integer numSecuencia;
private Long tipoDocumento;
private byte[] documentoByte;
 
 
  public DTODocumento() 
  {
  }

  public String getDocumento()
  {
    return documento;
  }

  public void setDocumento(String newDocumento)
  {
    documento = newDocumento;
  }

  public byte[] getDocumentoByte()
  {
    return documentoByte;
  }

  public void setDocumentoByte(byte[] newDocumentoByte)
  {
    documentoByte = newDocumentoByte;
  }

  public Integer getNumSecuencia()
  {
    return numSecuencia;
  }

  public void setNumSecuencia(Integer newNumSecuencia)
  {
    numSecuencia = newNumSecuencia;
  }

  public Long getTipoDocumento()
  {
    return tipoDocumento;
  }

  public void setTipoDocumento(Long newTipoDocumento)
  {
    tipoDocumento = newTipoDocumento;
  }
}