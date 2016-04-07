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
import java.util.ArrayList;
public class DTODescPers extends DTOBelcorp{

    private Date fechaVencimientoDesde;
    private Date fechaVencimientoHasta;
    private ArrayList ListaTS;


    public void setFechaVencimientoDesde(Date fechaVencimientoDesde){
        this.fechaVencimientoDesde = fechaVencimientoDesde;
    }


    public Date getFechaVencimientoDesde(){
        return fechaVencimientoDesde;
    }


    public void setFechaVencimientoHasta(Date fechaVencimientoHasta){
        this.fechaVencimientoHasta = fechaVencimientoHasta;
    }


    public Date getFechaVencimientoHasta(){
        return fechaVencimientoHasta;
    }


    public void setListaTS(ArrayList ListaTS){
        this.ListaTS = ListaTS;
    }


    public ArrayList getListaTS(){
        return ListaTS;
    }
}