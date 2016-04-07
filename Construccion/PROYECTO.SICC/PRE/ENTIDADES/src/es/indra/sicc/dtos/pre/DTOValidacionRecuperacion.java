package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

// sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
public class DTOValidacionRecuperacion extends DTOAuditableSICC {
    
    private Long oidMatrizPrincipal;
    private Long oidMatrizRecuperacion;

    public void setOidMatrizPrincipal(Long oidMatrizPrincipal) {
        this.oidMatrizPrincipal = oidMatrizPrincipal;
    }

    public Long getOidMatrizPrincipal() {
        return oidMatrizPrincipal;
    }

    public void setOidMatrizRecuperacion(Long oidMatrizRecuperacion) {
        this.oidMatrizRecuperacion = oidMatrizRecuperacion;
    }

    public Long getOidMatrizRecuperacion() {
        return oidMatrizRecuperacion;
    }
    
}
