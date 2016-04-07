    package es.indra.sicc.dtos.dto;

import es.indra.sicc.dtos.dto.DTOEBaseCalculoDetalle;

import java.util.ArrayList;

public class DTOEBaseAplicacionDetalle extends DTOEBaseCalculoDetalle {
    private Long oidEscala;
    private ArrayList escalones;
    private Integer numeroUnidadesObligatorias;

    public DTOEBaseAplicacionDetalle() {
    }

    public Long getOidEscala() {
        return oidEscala;
    }

    public void setOidEscala(Long newOidEscala) {
        oidEscala = newOidEscala;
    }

    public ArrayList getEscalones() {
        return escalones;
    }

    public void setEscalones(ArrayList newEscalones) {
        escalones = newEscalones;
    }

    public Integer getNumeroUnidadesObligatorias() {
        return numeroUnidadesObligatorias;
    }

    public void setNumeroUnidadesObligatorias(Integer newNumeroUnidadesObligatorias) {
        numeroUnidadesObligatorias = newNumeroUnidadesObligatorias;
    }
}