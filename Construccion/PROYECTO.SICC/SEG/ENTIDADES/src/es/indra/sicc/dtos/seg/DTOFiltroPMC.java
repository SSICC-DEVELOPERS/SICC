package es.indra.sicc.dtos.seg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOFiltroPMC extends DTOAuditableSICC  {
    private Boolean paises;
    private Boolean marcas;
    private Boolean canales;
    private Long oidIdioma;

    public DTOFiltroPMC() {
        super();
    }

    public Boolean getCanales() {
        return canales;
    }

    public void setCanales(Boolean newCanales) {
        canales = newCanales;
    }

    public Boolean getMarcas() {
        return marcas;
    }

    public void setMarcas(Boolean newMarcas) {
        marcas = newMarcas;
    }

    public Boolean getPaises() {
        return paises;
    }

    public void setPaises(Boolean newPaises) {
        paises = newPaises;
    }

    public Long getOidIdioma() {
        return oidIdioma;
    }

    public void setOidIdioma(Long newOidIdioma) {
        oidIdioma = newOidIdioma;
    }
    
}