package es.indra.sicc.dtos.dto;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.util.ArrayList;

public class DTOSBaseCalculo extends DTOAuditableSICC {
    private Long oidDescuento;
    private Long oidBase;
    private ArrayList detalle;
    private ArrayList productos;

    public DTOSBaseCalculo() { }
    
    public ArrayList getProductos() {
        return this.productos;
    }
    
    public void setProductos(ArrayList newProductos) {
        this.productos = newProductos;
    }

    public Long getOidDescuento() {
        return oidDescuento;
    }

    public void setOidDescuento(Long newOidDescuento) {
        oidDescuento = newOidDescuento;
    }

    public Long getOidBase() {
        return oidBase;
    }

    public void setOidBase(Long newOidBase) {
        oidBase = newOidBase;
    }

    public ArrayList getDetalle() {
        return detalle;
    }

    public void setDetalle(ArrayList newDetalle) {
        detalle = newDetalle;
    }
}