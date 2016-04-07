package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOEstructuraGeopoliticaPais extends DTOAuditableSICC 
{
  private Vector codDivPol;
  private Vector nivelEG;
  private Long pais;
  private Vector oidEG;
  private Vector descripcionDivPol;

  public DTOEstructuraGeopoliticaPais()
  {
  }

  public Vector getCodDivPol()
  {
    return codDivPol;
  }

  public void setCodDivPol(Vector newCodDivPol)
  {
    codDivPol = newCodDivPol;
  }

  public Vector getNivelEG()
  {
    return nivelEG;
  }

  public void setNivelEG(Vector newNivelEG)
  {
    nivelEG = newNivelEG;
  }

  public Long getPais()
  {
    return pais;
  }

  public void setPais(Long newPais)
  {
    pais = newPais;
  }

  public Vector getOidEG()
  {
    return oidEG;
  }

  public void setOidEG(Vector newOidEG)
  {
    oidEG = newOidEG;
  }

  public Vector getDescripcionDivPol()
  {
    return descripcionDivPol;
  }

  public void setDescripcionDivPol(Vector newDescripcionDivPol)
  {
    descripcionDivPol = newDescripcionDivPol;
  }
}