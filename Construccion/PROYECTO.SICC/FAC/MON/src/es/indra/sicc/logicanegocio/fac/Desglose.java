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

package es.indra.sicc.logicanegocio.fac;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;
import es.indra.sicc.util.UtilidadesLog;

public class Desglose implements Comparable, Serializable{

	private Integer numeroOrden;     
	private Long oidMedioPago;     
	private BigDecimal importeCuotaFracLocal;    
	private BigDecimal importeCuotaFracDoc;    
	private Date fechaVto;   

        //sapaza -- PER-SiCC-2011-0441 -- 23/06/2011
        private Long oidPerioCCC;        
    
	public Desglose() {
		super();
	}

	//Método de la interfaz java.lang.Comparable 
	public int compareTo(Object obj){ 
		//Ordenamos por fechaVto y por oidMedioPago 
        UtilidadesLog.info("Desglose.compareTo(Object obj): Entrada"); 			
		int result; 

		Desglose el=(Desglose)obj; 
		
		result=this.fechaVto.compareTo(el.fechaVto); 
		if (result != 0) return result; //No son iguales por tanto uno es mayor que el otro 

		//Si son iguales por tanto subordenamos por oidMedioPago 
		result=this.oidMedioPago.compareTo(el.oidMedioPago); 
        UtilidadesLog.info("Desglose.compareTo(Object obj): Salida"); 			
		return result;
	}


	public Date getFechaVto() {
		return fechaVto;
	}

	public void setFechaVto(Date newFechaVto) {
		fechaVto = newFechaVto;
	}

	public BigDecimal getImporteCuotaFracDoc() {
		return importeCuotaFracDoc;
	}

	public void setImporteCuotaFracDoc(BigDecimal newImporteCuotaFracDoc) {
		importeCuotaFracDoc = newImporteCuotaFracDoc;
	}

	public BigDecimal getImporteCuotaFracLocal() {
		return importeCuotaFracLocal;
	}

	public void setImporteCuotaFracLocal(BigDecimal newImporteCuotaFracLocal) {
		importeCuotaFracLocal = newImporteCuotaFracLocal;
	}

	public Integer getNumeroOrden() {
		return numeroOrden;
	}

	public void setNumeroOrden(Integer newNumeroOrden) {
		numeroOrden = newNumeroOrden;
	}

	public Long getOidMedioPago() {
		return oidMedioPago;
	}

	public void setOidMedioPago(Long newOidMedioPago) {
		oidMedioPago = newOidMedioPago;
	}

    public void setOidPerioCCC(Long oidPerioCCC) {
        this.oidPerioCCC = oidPerioCCC;
    }

    public Long getOidPerioCCC() {
        return oidPerioCCC;
    }
}
