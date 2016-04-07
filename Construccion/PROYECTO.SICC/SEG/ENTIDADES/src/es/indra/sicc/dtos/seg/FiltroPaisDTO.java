package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class FiltroPaisDTO extends DTOAuditableSICC {

private Long oidPais;

    public FiltroPaisDTO() {
        super();
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long newOidPais) {
        oidPais = newOidPais;
    }

    
}