package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPeriodosPorTipoPeriodo extends DTOAuditableSICC  {

    private Long oidIdioma;
    private Long oidTipoPeriodo;

    public DTOPeriodosPorTipoPeriodo() {
        super();
    }

    public Long getOidIdioma() {
        return oidIdioma;
    }

    public void setOidIdioma(Long newOidIdioma) {
        oidIdioma = newOidIdioma;
    }

    public Long getOidTipoPeriodo() {
        return oidTipoPeriodo;
    }

    public void setOidTipoPeriodo(Long newOidTipoPeriodo) {
        oidTipoPeriodo = newOidTipoPeriodo;
    }
}