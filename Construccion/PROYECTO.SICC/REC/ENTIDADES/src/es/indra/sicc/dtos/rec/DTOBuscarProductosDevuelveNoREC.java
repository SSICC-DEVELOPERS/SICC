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

public class DTOBuscarProductosDevuelveNoREC extends DTOSiccPaginacion  {

    private String descripcion;     
    private String codigoVenta;  //BELC300015147   
    private String codigoProducto;  //BELC300015147   
    private Long paginaCatalogo;     
    private Long numDocumento;     
    private Long operacion;   
    private Boolean devuelveFisicoFactura;


    public DTOBuscarProductosDevuelveNoREC() {
        super();
    }

    public String getCodigoProducto()
    {
        return codigoProducto;
    }

    public void setCodigoProducto(String codigoProducto)
    {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoVenta()
    {
        return codigoVenta;
    }

    public void setCodigoVenta(String codigoVenta)
    {
        this.codigoVenta = codigoVenta;
    }

    public String getDescripcion()
    {
        return descripcion;
    }

    public void setDescripcion(String descripcion)
    {
        this.descripcion = descripcion;
    }

    public Long getNumDocumento()
    {
        return numDocumento;
    }

    public void setNumDocumento(Long numDocumento)
    {
        this.numDocumento = numDocumento;
    }

    public Long getOperacion()
    {
        return operacion;
    }

    public void setOperacion(Long operacion)
    {
        this.operacion = operacion;
    }

    public Long getPaginaCatalogo()
    {
        return paginaCatalogo;
    }

    public void setPaginaCatalogo(Long paginaCatalogo)
    {
        this.paginaCatalogo = paginaCatalogo;
    }
    
    public Boolean getDevuelveFisicoFactura(){
        return devuelveFisicoFactura;
    }
    
    public void setDevuelveFisicoFactura(Boolean devuelveFisicoFactura){
        this.devuelveFisicoFactura = devuelveFisicoFactura;
    }
}