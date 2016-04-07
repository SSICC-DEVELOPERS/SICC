package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSubaccesosPorAccesoYCanal extends DTOAuditableSICC  {
    private Long oidIdioma;
    private Long oidAcceso;
    private Long oidCanal;

    public DTOSubaccesosPorAccesoYCanal() {
        super();
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long newOidAcceso) {
        oidAcceso = newOidAcceso;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long newOidCanal) {
        oidCanal = newOidCanal;
    }

    public Long getOidIdioma() {
        return oidIdioma;
    }

    public void setOidIdioma(Long newOidIdioma) {
        oidIdioma = newOidIdioma;
    }


}