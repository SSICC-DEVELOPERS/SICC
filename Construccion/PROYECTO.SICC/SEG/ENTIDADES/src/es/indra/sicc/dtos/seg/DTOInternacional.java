package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOInternacional extends DTOAuditableSICC {

    private Long oidPais;
    private Long oidIdioma;
    
    public DTOInternacional() {
        super();
    }

    public Long getOidIdioma() {
        return oidIdioma;
    }

    public void setOidIdioma(Long newOidIdioma) {
        oidIdioma = newOidIdioma;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long newOidPais) {
        oidPais = newOidPais;
    }

   
   
}