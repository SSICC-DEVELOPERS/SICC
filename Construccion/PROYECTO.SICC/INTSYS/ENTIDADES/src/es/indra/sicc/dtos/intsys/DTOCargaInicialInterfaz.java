package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;


public class DTOCargaInicialInterfaz extends DTOBelcorp {
    private Long numeroLote;
    private String descripcion;

    public DTOCargaInicialInterfaz() {
    }

    public Long getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(Long newNumeroLote) {
        this.numeroLote = newNumeroLote;
    }

     public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
