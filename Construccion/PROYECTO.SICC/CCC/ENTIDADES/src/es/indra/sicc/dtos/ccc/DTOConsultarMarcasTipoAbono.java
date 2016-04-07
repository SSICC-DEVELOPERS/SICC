package es.indra.sicc.dtos.ccc;

import es.indra.sicc.dtos.ccc.DTOMarcasPorTipoAbono;

public class DTOConsultarMarcasTipoAbono extends DTOMarcasPorTipoAbono  {

  private String subprocesoDesc;
  private String procesoDesc;
  private String tipoAbonoDesc;
  private String marcaSituacionSalidaDesc;
  private String[] marcasSituacionEntradaDesc; 

  public DTOConsultarMarcasTipoAbono() {}

  public String getSubprocesoDesc() {
    return subprocesoDesc;
  }

  public void setSubprocesoDesc(String newSubprocesoDesc) { 
    subprocesoDesc = newSubprocesoDesc; 
  }

  public String getProcesoDesc () {
    return procesoDesc;
  }

  public void setProcesoDesc(String newProcesoDesc) {
    procesoDesc = newProcesoDesc;
  }

  public String getTipoAbonoDesc () {
    return tipoAbonoDesc;
  }

  public void setTipoAbonoDesc(String newTipoAbonoDesc) {
    tipoAbonoDesc = newTipoAbonoDesc;
  }

  public String getMarcaSituacionSalidaDesc() {
    return marcaSituacionSalidaDesc;
  }

  public void setMarcaSituacionSalidaDesc(String newMarcaSituacionSalidaDesc) {
    marcaSituacionSalidaDesc = newMarcaSituacionSalidaDesc;
  }

  public String[] getMarcasSituacionEntradaDesc() { 
    return marcasSituacionEntradaDesc;
  }

  public void setMarcasSituacionEntradaDesc(String[] newMarcasSituacionEntradaDesc) {
    marcasSituacionEntradaDesc = newMarcasSituacionEntradaDesc;
  }  
}