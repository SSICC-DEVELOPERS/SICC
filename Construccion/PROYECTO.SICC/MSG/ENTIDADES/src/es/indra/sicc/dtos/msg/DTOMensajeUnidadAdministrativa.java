package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOMensajeUnidadAdministrativa extends DTOAuditableSICC{

  private Long oid;
  private Long oidRegion;
  private Long oidZona;
  private Long oidSeccion;
  private Long oidTerritorio;
  private String desRegion;
  private String desZona;
  private String desSeccion;
  private String desTerritorio;
  private DTODestinatario unidadAdministrativa;   //atributo del dto Destinatario

  public Long getOid(){
    return oid;
  }

  public void setOid(Long newOid){
    oid = newOid;
  }

  public Long getOidRegion(){
    return oidRegion;
  }

  public void setOidRegion(Long newOidRegion){
    oidRegion = newOidRegion;
  }

  public Long getOidZona(){
    return oidZona;
  }

  public void setOidZona(Long newOidZona){
    oidZona = newOidZona;
  }

  public Long getOidSeccion(){
    return oidSeccion;
  }

  public void setOidSeccion(Long newOidSeccion){
    oidSeccion = newOidSeccion;
  }

  public Long getOidTerritorio(){
    return oidTerritorio;
  }

  public void setOidTerritorio(Long newOidTerritorio){
    oidTerritorio = newOidTerritorio;
  }

  public String getDesRegion(){
    return desRegion;
  }

  public void setDesRegion(String newDesRegion){
    desRegion = newDesRegion;
  }

  public String getDesZona(){
    return desZona;
  }

  public void setDesZona(String newDesZona){
    desZona = newDesZona;
  }

  public String getDesSeccion(){
    return desSeccion;
  }

  public void setDesSeccion(String newDesSeccion){
    desSeccion = newDesSeccion;
  }

  public String getDesTerritorio(){
    return desTerritorio;
  }

  public void setDesTerritorio(String newDesTerritorio){
    desTerritorio = newDesTerritorio;
  }

  public DTODestinatario getUnidadAdministrativa(){
    return unidadAdministrativa;
  }

  public void setUnidadAdministrativa(DTODestinatario newUnidadAdministrativa) {
    unidadAdministrativa = newUnidadAdministrativa;
  }
  
}