package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.ArrayList;


public class DTOEnvio extends DTOAuditableSICC 
{
  private Long oidCliente;
  private String codCliente;
  private String codMarca;
  private String codCanal;
  private String codPais;
  private String codSGV;
  private String codRegion;
  private String codZona;
  private String codSeccion;
  private String codTerritorio; 
  private ArrayList atributos;


  public DTOEnvio()
  {
  }
  
  public void setOidCliente(Long newOidCliente) {
    this.oidCliente = newOidCliente;
  }


  public Long getOidCliente() {
    return oidCliente;
  }
  
  
  public void setCodCliente(String newCodCliente){
      codCliente = newCodCliente;
  }

  public String getCodCliente() {
     return codCliente;
  }
  
  public void setCodMarca(String newCodMarca){
      codMarca = newCodMarca;
  }

  public String getCodMarca() {
     return codMarca;
  }
  
  public void setCodCanal(String newCodCanal){
      codCanal = newCodCanal;
  }

  public String getCodCanal() {
     return codCanal;
  }
  
  public void setCodPais(String newCodPais){
      codPais = newCodPais;
  }

  public String getCodPais() {
     return codPais;
  }
  
  public void setCodSGV(String newCodSGV){
      codSGV = newCodSGV;
  }

  public String getCodSGV() {
     return codSGV;
  }
  
   public void setCodRegion(String newCodRegion){
      codRegion = newCodRegion;
  }

  public String getCodRegion() {
     return codRegion;
  }
   public void setCodZona(String newCodZona){
      codZona = newCodZona;
  }

  public String getCodZona() {
     return codZona;
  }
   public void setCodSeccion(String newCodSeccion){
      codSeccion = newCodSeccion;
  }

  public String getCodSeccion() {
     return codSeccion;
  }
   public void setCodTerritorio(String newCodTerritorio){
      codTerritorio = newCodTerritorio;
  }
  
  public String getCodTerritorio()
  {
    return this.codTerritorio;
  }

   public void setAtributos(ArrayList newAtributos){
      atributos = newAtributos;
  }

  public ArrayList getAtributos() {
     return atributos;
  }
  
  
}