package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOELocalizacionDirecciones extends DTOSiccPaginacion  {
    public Long oidPais;
    public Long oidTipoVia;
    public String nombreVia;
    public String numeroPortal;
    public Long oidUGnivel;

    public Long getOidPais() {
        return oidPais;
    }

    public void setOidPais(Long newOidpais) {
        oidPais = newOidpais;
    }

    public Long getOidTipoVia() {
        return oidTipoVia;
    }

    public void setOidTipoVia(Long newOidtipoVia) {
        oidTipoVia = newOidtipoVia;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String newNombreVia) {
        nombreVia = newNombreVia;
    }

    public String getNumeroPortal() {
        return numeroPortal;
    }

    public void setNumeroPortal(String newNumeroPortal) {
        numeroPortal = newNumeroPortal;
    }

    public Long getOidUGnivel() {
        return oidUGnivel;
    }

    public void setOidUGnivel(Long newOidUGnivel) {
        oidUGnivel = newOidUGnivel;
    }
    
}