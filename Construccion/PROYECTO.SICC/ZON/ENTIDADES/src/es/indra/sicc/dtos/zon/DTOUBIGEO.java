package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOUBIGEO extends DTOAuditableSICC  {
    public String UBIGEO;
    public String descCompleta;
    public Boolean IndicadorActiva;
    public Long oidTerritorio;
    public String nombreVia;
    public Integer numInicio;
    public Integer numFin;

    public DTOUBIGEO() {
    }

    public String getUBIGEO() {
        return UBIGEO;
    }

    public void setUBIGEO(String newUBIGEO) {
        UBIGEO = newUBIGEO;
    }

    public String getDescCompleta() {
        return descCompleta;
    }

    public void setDescCompleta(String newDescCompleta) {
        descCompleta = newDescCompleta;
    }

    public Boolean getIndicadorActiva() {
        return IndicadorActiva;
    }

    public void setIndicadorActiva(Boolean newIndicadorActiva) {
        IndicadorActiva = newIndicadorActiva;
    }

    public Long getOidTerritorio() {
        return oidTerritorio;
    }

    public void setOidTerritorio(Long newOidTerritorio) {
        oidTerritorio = newOidTerritorio;
    }

    public String getNombreVia() {
        return nombreVia;
    }

    public void setNombreVia(String newNombreVia) {
        nombreVia = newNombreVia;
    }

    public Integer getNumInicio() {
        return numInicio;
    }

    public void setNumInicio(Integer newNumInicio) {
        numInicio = newNumInicio;
    }

    public Integer getNumFin() {
        return numFin;
    }

    public void setNumFin(Integer newNumFin) {
        numFin = newNumFin;
    }
    
}