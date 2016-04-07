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

public class DTOMovAlmac extends DTOBelcorp  {
    public DTOMovAlmac() {  }
    
    private Long oidLineaOperacion;
    private Long oidAlmacen;
    private Long oidTipoMovimiento;
    private Long oidTipoOferta; // Añadido por la BELC300015895
    private Long oidProducto; // Añadido por la BELC300015895
    private Long oidTipoPosicion;
    private Long oidSubtipoPosicion;
    
    public Long getOidTipoPosicion() {
        return this.oidTipoPosicion;
    }
    
    public void setOidTipoPosicion(Long newOidTipoPosicion) {
        this.oidTipoPosicion = newOidTipoPosicion;
    }
    
    public Long getOidSubtipoPosicion() {
        return this.oidSubtipoPosicion;
    }
    
    public void setOidSubtipoPosicion(Long newOidSubtipoPosicion) {
        this.oidSubtipoPosicion = newOidSubtipoPosicion;
    }

    public Long getOidAlmacen() {
        return oidAlmacen;
    }

    public void setOidAlmacen(Long oidAlmacen) {
        this.oidAlmacen = oidAlmacen;
    }

    public Long getOidLineaOperacion() {
        return oidLineaOperacion;
    }

    public void setOidLineaOperacion(Long oidLineaOperacion) {
        this.oidLineaOperacion = oidLineaOperacion;
    }

    public Long getOidTipoMovimiento() {
        return oidTipoMovimiento;
    }

    public void setOidTipoMovimiento(Long oidTipoMovimiento) {
        this.oidTipoMovimiento = oidTipoMovimiento;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }
}