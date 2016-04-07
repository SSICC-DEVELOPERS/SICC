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
import java.util.ArrayList;

public class DTOChequeo extends DTOBelcorp  {
    public DTOChequeo() {
    }
    
    private ArrayList listaChequeos;
    // vbongiov -- Cambio 20080756 -- 29/04/2009
    private Boolean indConsReincidentes;
    private Integer cantidadMinima;
    private Integer cantidadPeriHaciaAtras;
    private Boolean indConsNuevas;
    private Long oidTipoRevision;

    public ArrayList getListaChequeos() {
        return listaChequeos;
    }

    public void setListaChequeos(ArrayList listaChequeos) {
        this.listaChequeos = listaChequeos;
    }
    
    public void setIndConsReincidentes(Boolean indConsReincidentes) {
        this.indConsReincidentes = indConsReincidentes;
    }

    public Boolean getIndConsReincidentes() {
        return indConsReincidentes;
    }
    
    public void setCantidadMinima(Integer cantidadMinima) {
        this.cantidadMinima = cantidadMinima;
    }

    public Integer getCantidadMinima() {
        return cantidadMinima;
    }
    
    public void setCantidadPeriHaciaAtras(Integer cantidadPeriHaciaAtras) {
        this.cantidadPeriHaciaAtras = cantidadPeriHaciaAtras;
    }

    public Integer getCantidadPeriHaciaAtras() {
        return cantidadPeriHaciaAtras;
    }
    
    public void setIndConsNuevas(Boolean indConsNuevas) {
        this.indConsNuevas = indConsNuevas;
    }

    public Boolean getIndConsNuevas() {
        return indConsNuevas;
    }
    
    public Long getOidTipoRevision() {
        return oidTipoRevision;
    }

    public void setOidTipoRevision(Long oidTipoRevision) {
        this.oidTipoRevision = oidTipoRevision;
    }
}