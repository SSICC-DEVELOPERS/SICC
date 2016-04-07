package es.indra.sicc.dtos.car;

import es.indra.sicc.util.DTOBelcorp;

public class DTOTipoOfertaPrioridad extends DTOBelcorp {
    
    private Long oidTipoOferta;
    private Long prioridad;
    
    public DTOTipoOfertaPrioridad() {
    }

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setPrioridad(Long prioridad) {
        this.prioridad = prioridad;
    }

    public Long getPrioridad() {
        return prioridad;
    }
}
