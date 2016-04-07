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
import es.indra.sicc.util.DTOBelcorp;

public class DTOLineaOperacionAuxiliarREC extends DTOBelcorp {

    private Long numLinea;
    private String tipoMovimiento;   
    private Long oidTipoMovimiento;   
    private String codVenta;   
    private String codProducto;   
    private String descProducto;  
    private Long UReclamadas;
    private String motivoDevolucion;   
    private Long oidMotivoDevolucion;  
    private Double precioProducto;   
    private Double importeCargo;   
    private Double importeAbono;   
    private Long UDevueltas;
    private Long oidCodigoVenta;
    private Long oidCodigoProducto;
    private Double montoPerdida;
    private Double descuentoUnitario;
    private Long oidPosicionSolicitud;
    private Long oidTipoOferta;
    private Long oidNivel;
    private Long oidConcurso;
    private Long oidPremio;
    private Double precioContable;
    
    public DTOLineaOperacionAuxiliarREC() {
        super();
    }

    public Long getUDevueltas()
    {
        return UDevueltas;
    }

    public void setUDevueltas(Long UDevueltas)
    {
        this.UDevueltas = UDevueltas;
    }

    public Long getUReclamadas()
    {
        return UReclamadas;
    }

    public void setUReclamadas(Long UReclamadas)
    {
        this.UReclamadas = UReclamadas;
    }

    public String getDescProducto()
    {
        return descProducto;
    }

    public void setDescProducto(String descProducto)
    {
        this.descProducto = descProducto;
    }

    public String getMotivoDevolucion()
    {
        return motivoDevolucion;
    }

    public void setMotivoDevolucion(String motivoDevolucion)
    {
        this.motivoDevolucion = motivoDevolucion;
    }

    public Long getNumLinea()
    {
        return numLinea;
    }

    public void setNumLinea(Long numLinea)
    {
        this.numLinea = numLinea;
    }

    public Long getOidMotivoDevolucion()
    {
        return oidMotivoDevolucion;
    }

    public void setOidMotivoDevolucion(Long oidMotivoDevolucion)
    {
        this.oidMotivoDevolucion = oidMotivoDevolucion;
    }

    public Long getOidTipoMovimiento()
    {
        return oidTipoMovimiento;
    }

    public void setOidTipoMovimiento(Long oidTipoMovimiento)
    {
        this.oidTipoMovimiento = oidTipoMovimiento;
    }

    public String getTipoMovimiento()
    {
        return tipoMovimiento;
    }

    public void setTipoMovimiento(String tipoMovimiento)
    {
        this.tipoMovimiento = tipoMovimiento;
    }


    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getCodVenta() {
        return codVenta;
    }


    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }


    public String getCodProducto() {
        return codProducto;
    }


    public void setImporteCargo(Double importeCargo) {
        this.importeCargo = importeCargo;
    }


    public Double getImporteCargo() {
        return importeCargo;
    }


    public void setImporteAbono(Double importeAbono) {
        this.importeAbono = importeAbono;
    }


    public Double getImporteAbono() {
        return importeAbono;
    }


    public void setPrecioProducto(Double precioProducto) {
        this.precioProducto = precioProducto;
    }

    public Double getPrecioProducto() {
        return precioProducto;
    }


    public void setOidCodigoVenta(Long oidCodigoVenta) {
        this.oidCodigoVenta = oidCodigoVenta;
    }


    public Long getOidCodigoVenta() {
        return oidCodigoVenta;
    }


    public void setOidCodigoProducto(Long oidCodigoProducto) {
        this.oidCodigoProducto = oidCodigoProducto;
    }


    public Long getOidCodigoProducto() {
        return oidCodigoProducto;
    }

  public Double getMontoPerdida() {
    return montoPerdida;
  }

  public void setMontoPerdida(Double montoPerdida) {
    this.montoPerdida = montoPerdida;
  }



  public Double getDescuentoUnitario() {
    return descuentoUnitario;
  }

  public void setDescuentoUnitario(Double descuentoUnitario) {
    this.descuentoUnitario = descuentoUnitario;
  }

    public Long getOidPosicionSolicitud() {
        return oidPosicionSolicitud;
    }

    public void setOidPosicionSolicitud(Long oidPosicionSolicitud) {
        this.oidPosicionSolicitud = oidPosicionSolicitud;
    }
    
    public Long getOidTipoOferta(){
        return oidTipoOferta;
    }
    
    public void setOidTipoOferta(Long oidTipoOferta){
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidNivel() {
        return oidNivel;
    }

    public void setOidNivel(Long oidNivel) {
        this.oidNivel = oidNivel;
    }
    
    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidPremio() {
        return oidPremio;
    }

    public void setOidPremio(Long oidPremio) {
        this.oidPremio = oidPremio;
    }

    public Double getPrecioContable() {
        return precioContable;
    }

    public void setPrecioContable(Double precioContable) {
        this.precioContable = precioContable;
    }

}