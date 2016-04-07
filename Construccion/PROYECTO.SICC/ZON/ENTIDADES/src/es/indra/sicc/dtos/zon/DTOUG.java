package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUG extends DTOAuditableSICC  {
    public Long oidPais;
    public Long oidUG;
    public Boolean filtroActiva;

    public DTOUG() {
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long newOidPais) {
        oidPais = newOidPais;
    }

    public Long getOidUG() {
        return oidUG;
    }

    public void setOidUG(Long newOidUG) {
        oidUG = newOidUG;
    }

    public Boolean getFiltroActiva() {
        return filtroActiva;
    }

    public void setFiltroActiva(Boolean newFiltroActiva) {
        filtroActiva = newFiltroActiva;
    }

    
}