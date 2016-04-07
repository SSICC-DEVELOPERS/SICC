package es.indra.sicc.dtos.rec;

import es.indra.sicc.util.DTOBelcorp;

public class DTOGenerarBoletasRecojoCierreZona extends DTOBelcorp {

    private Long oidZona;
    private Long oidPeriodo;

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }
}
