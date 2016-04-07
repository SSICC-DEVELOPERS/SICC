package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class AsociacionNivelesDTO extends DTOAuditableSICC {

private Long oidPais;
private Long oidAsociacionNiveles;
private Long oidNivelSocioeconomicoBelcorp;
private Long oidTipoNivelSocioeconomicoPersonal;


    public AsociacionNivelesDTO() {
        super();
    }

    public Long getOidAsociacionNiveles() {
        return oidAsociacionNiveles;
    }

    public void setOidAsociacionNiveles(Long newOidAsociacionNiveles) {
        oidAsociacionNiveles = newOidAsociacionNiveles;
    }

    public Long getOidNivelSocioeconomicoBelcorp() {
        return oidNivelSocioeconomicoBelcorp;
    }

    public void setOidNivelSocioeconomicoBelcorp(Long newOidNivelSocioeconomicoBelcorp) {
        oidNivelSocioeconomicoBelcorp = newOidNivelSocioeconomicoBelcorp;
    }

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long newOidPais) {
        oidPais = newOidPais;
    }

    public Long getOidTipoNivelSocioeconomicoPersonal() {
        return oidTipoNivelSocioeconomicoPersonal;
    }

    public void setOidTipoNivelSocioeconomicoPersonal(Long newOidTipoNivelSocioeconomicoPersonal) {
        oidTipoNivelSocioeconomicoPersonal = newOidTipoNivelSocioeconomicoPersonal;
    }

    
}