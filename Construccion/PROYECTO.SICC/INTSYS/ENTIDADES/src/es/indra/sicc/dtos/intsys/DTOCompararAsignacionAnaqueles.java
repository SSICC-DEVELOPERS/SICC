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

public class DTOCompararAsignacionAnaqueles  extends DTOBelcorp {
    public DTOCompararAsignacionAnaqueles() 
    {
    }
    
    private Long oidAsignacionAnaquel;
    private String codigoProducto;
    private Long oidProducto;


    public void setOidAsignacionAnaquel(Long oidAsignacionAnaquel) {
      this.oidAsignacionAnaquel = oidAsignacionAnaquel;
    }
  
    public Long getOidAsignacionAnaquel() {
      return oidAsignacionAnaquel;
    }
  
    public void setCodigoProducto(String codigoProducto) {
      this.codigoProducto = codigoProducto;
    }
  
    public String getCodigoProducto() {
      return codigoProducto;
    }


    public void setOidProducto(Long oidProducto)
    {
        this.oidProducto = oidProducto;
    }


    public Long getOidProducto()
    {
        return oidProducto;
    }
    
}