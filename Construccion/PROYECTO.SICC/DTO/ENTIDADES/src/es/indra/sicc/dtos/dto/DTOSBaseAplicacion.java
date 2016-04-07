package es.indra.sicc.dtos.dto;

import es.indra.sicc.dtos.dto.DTOSBaseCalculo;

import java.util.ArrayList;


public class DTOSBaseAplicacion  extends DTOSBaseCalculo{
    private Integer numeroUnidadesObligatorias;
    private ArrayList escalones;
    private Long indice;

    public DTOSBaseAplicacion() {
    }
    
    public Long getIndice()  {
        return this.indice;
    }
    
    public void setIndice(Long newIndice) {
        this.indice = newIndice;
    }

    public Integer getNumeroUnidadesObligatorias() {
        return numeroUnidadesObligatorias;
    }

    public void setNumeroUnidadesObligatorias(Integer newNumeroUnidadesObligatorias) {
        numeroUnidadesObligatorias = newNumeroUnidadesObligatorias;
    }

    public ArrayList getEscalones() {
        return escalones;
    }

    public void setEscalones(ArrayList newEscalones) {
        escalones = newEscalones;
    }
}