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
import java.util.Date;

public class DTOCambiosTerritorio extends DTOBelcorp{
    public DTOCambiosTerritorio()
    {
    }

    private String codigoUA1;
    private String codigoUA2;
    private String codigoUA3;
    private String tipoModificacion;
    private Date fechaCreacion;
    // vbongiov -- 11/10/2006
    private String codPeriodo;

    public String getCodigoUA1()
    {
        return codigoUA1;
    }

    public void setCodigoUA1(String codigoUA1)
    {
        this.codigoUA1 = codigoUA1;
    }

    public String getCodigoUA2()
    {
        return codigoUA2;
    }

    public void setCodigoUA2(String codigoUA2)
    {
        this.codigoUA2 = codigoUA2;
    }

    public String getCodigoUA3()
    {
        return codigoUA3;
    }

    public void setCodigoUA3(String codigoUA3)
    {
        this.codigoUA3 = codigoUA3;
    }

    public Date getFechaCreacion()
    {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion)
    {
        this.fechaCreacion = fechaCreacion;
    }

    public String getTipoModificacion()
    {
        return tipoModificacion;
    }

    public void setTipoModificacion(String tipoModificacion)
    {
        this.tipoModificacion = tipoModificacion;
    }

  public String getCodPeriodo()
  {
    return codPeriodo;
  }

  public void setCodPeriodo(String codPeriodo)
  {
    this.codPeriodo = codPeriodo;
  }

}