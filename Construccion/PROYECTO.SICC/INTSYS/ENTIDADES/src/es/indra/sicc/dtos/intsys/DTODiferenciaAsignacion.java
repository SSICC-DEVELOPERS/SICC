/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/

package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTODiferenciaAsignacion extends DTOBelcorp {
    public DTODiferenciaAsignacion() 
    {
    }
    
    private String numeroAnaquel;
    private String codProductoSiCC;
    private Long   oidProductoSiCC;
    private String codProductoPTL;


  public void setNumeroAnaquel(String numeroAnaquel) {
    this.numeroAnaquel = numeroAnaquel;
  }


  public String getNumeroAnaquel() {
    return numeroAnaquel;
  }


  public void setCodProductoSiCC(String codProductoSiCC) {
    this.codProductoSiCC = codProductoSiCC;
  }


  public String getCodProductoSiCC() {
    return codProductoSiCC;
  }


  public void setCodProductoPTL(String codProductoPTL) {
    this.codProductoPTL = codProductoPTL;
  }


  public String getCodProductoPTL() {
    return codProductoPTL;
  }


    public void setOidProductoSiCC(Long oidProductoSiCC)
    {
        this.oidProductoSiCC = oidProductoSiCC;
    }


    public Long getOidProductoSiCC()
    {
        return oidProductoSiCC;
    }

}