/**
 * Copyright 2007 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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

package es.indra.sicc.dtos.ape;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTipoCajaSublinea extends DTOBelcorp {
    private Long oid;
    private Long numCaja;
	private DTOTipoCajaProducto tipoCajaProducto;
	private DTOSublineaArmado sublineaArmado;

    public DTOTipoCajaSublinea() {}
    
     public Long getOid(){
        return oid;
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }
    public Long getNumCaja(){
        return numCaja;
    }

    public void setNumCaja(Long numCaja){
        this.numCaja = numCaja;
    }
  
    public DTOTipoCajaProducto getTipoCajaProducto() {
        return tipoCajaProducto;
    }

    public void setTipoCajaProducto(DTOTipoCajaProducto tipoCajaProducto) {
        this.tipoCajaProducto = tipoCajaProducto;
    }

    public DTOSublineaArmado getSublineaArmado() {
        return sublineaArmado;
    }

    public void setSublineaArmado(DTOSublineaArmado sublineaArmado) {
        this.sublineaArmado = sublineaArmado;
    }
    
}