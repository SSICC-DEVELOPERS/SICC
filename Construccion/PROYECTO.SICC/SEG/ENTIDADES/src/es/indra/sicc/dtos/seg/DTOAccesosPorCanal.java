package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOAccesosPorCanal extends DTOAuditableSICC  {
    private Long oidIdioma;
    private Long oidCanal;

    public DTOAccesosPorCanal() {
        super();
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