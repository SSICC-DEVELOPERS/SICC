/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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


package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOFACImpuestosUbigeo extends DTOBelcorp {

    public DTOFACImpuestosUbigeo() {
    }

	//incidencia BELC300008737: se eliminan pais, canal, acceso y codigoProducto.
		//Se añade: oid, producto, tasaImpuesto.  
		//Cambios reflejados en: SICC-DMCO-FAC-201-364-N005-2
		

    //private Long pais;     
    //private Long canal;     
    //private Long acceso;     
    private Long subacceso;     
	private Long oid;
	private Long producto;
	private Long tasaImpuesto;
    //private String codigoProducto;

	/*
    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long newAcceso) {
        acceso = newAcceso;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long newCanal) {
        canal = newCanal;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(String newCodigoProducto) {
        codigoProducto = newCodigoProducto;
    }

    public Long getPais() {
        return pais;
    }

    public void setPais(Long newPais) {
        pais = newPais;
    }
	*/
	
    public Long getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(Long newSubacceso) {
        subacceso = newSubacceso;
    }

	public Long getOid() {
		return oid;
	}

	public void setOid(Long newOid) {
		oid = newOid;
	}

	public Long getProducto() {
		return producto;
	}

	public void setProducto(Long newProducto) {
		producto = newProducto;
	}

	public Long getTasaImpuesto() {
		return tasaImpuesto;
	}

	public void setTasaImpuesto(Long newTasaImpuesto) {
		tasaImpuesto = newTasaImpuesto;
	}
    
}