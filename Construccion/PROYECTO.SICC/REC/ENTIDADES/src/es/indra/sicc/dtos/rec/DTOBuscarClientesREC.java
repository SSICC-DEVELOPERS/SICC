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
package es.indra.sicc.dtos.rec;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarClientesREC extends DTOSiccPaginacion  {
    public DTOBuscarClientesREC() {
    }
    
    private Long oidCliente;
    private String codigoCliente;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private Long oidTipoCliente;
    private Long numDocumento;
    private String indicadorMatriz;
  private String codigoVenta;
  private Long oidPeriodo;

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getNumDocumento() {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento) {
        this.numDocumento = numDocumento;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }

    public String getIndicadorMatriz() {
        return indicadorMatriz;
    }

    public void setIndicadorMatriz(String indicadorMatriz) {
        this.indicadorMatriz = indicadorMatriz;
    }

  public String getCodigoVenta()
  {
    return codigoVenta;
  }

  public void setCodigoVenta(String codigoVenta)
  {
    this.codigoVenta = codigoVenta;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }
}