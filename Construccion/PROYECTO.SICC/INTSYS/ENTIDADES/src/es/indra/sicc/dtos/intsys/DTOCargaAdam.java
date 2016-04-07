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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOCargaAdam extends DTOBelcorp{
    private RecordSet canales;
    private RecordSet marcas;
    private RecordSet tipoCliente;
    private Boolean estadoP;
    private Date fechaDesde;


    public void setCanales(RecordSet canales){
        this.canales = canales;
    }


    public RecordSet getCanales(){
        return canales;
    }


    public void setMarcas(RecordSet marcas){
        this.marcas = marcas;
    }


    public RecordSet getMarcas(){
        return marcas;
    }


    public void setTipoCliente(RecordSet tipoCliente){
        this.tipoCliente = tipoCliente;
    }


    public RecordSet getTipoCliente(){
        return tipoCliente;
    }


    public void setEstadoP(Boolean estadoP){
        this.estadoP = estadoP;
    }


    public Boolean getEstadoP(){
        return estadoP;
    }


    public void setFechaDesde(Date fechaDesde){
        this.fechaDesde = fechaDesde;
    }


    public Date getFechaDesde(){
        return fechaDesde;
    }
}