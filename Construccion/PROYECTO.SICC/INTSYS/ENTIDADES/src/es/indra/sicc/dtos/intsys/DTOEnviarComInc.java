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

public class DTOEnviarComInc extends DTOBelcorp {
	private String numeroLote;
	private String descripcionLote;
	private Date   fechaDesde;
	private Date   fechaHasta;
	private String observaciones;
	private Long[] arrayTiposClientes;


    public void setNumeroLote(String numeroLote){
        this.numeroLote = numeroLote;
    }
    public String getNumeroLote(){
        return numeroLote;
    }
    public void setDescripcionLote(String descripcionLote){
        this.descripcionLote = descripcionLote;
    }
    public String getDescripcionLote(){
        return descripcionLote;
    }
    public void setFechaDesde(Date fechaDesde){
        this.fechaDesde = fechaDesde;
    }
    public Date getFechaDesde(){
        return fechaDesde;
    }
    public void setFechaHasta(Date fechaHasta){
        this.fechaHasta = fechaHasta;
    }
    public Date getFechaHasta(){
        return fechaHasta;
    }
    public void setObservaciones(String observaciones){
        this.observaciones = observaciones;
    }
    public String getObservaciones(){
        return observaciones;
    }
    public void setArrayTiposClientes(Long[] arrayTiposClientes){
        this.arrayTiposClientes = arrayTiposClientes;
    }
    public Long[] getArrayTiposClientes(){
        return arrayTiposClientes;
    }
}