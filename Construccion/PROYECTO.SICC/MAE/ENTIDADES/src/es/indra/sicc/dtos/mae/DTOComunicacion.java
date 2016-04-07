package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOComunicacion extends DTOAuditableSICC  {

        private Long tipoComunicacion;
        private Character diaComunicacion;
        private String textoComunicacion;
        private Boolean principal;
        private Long horaDesde;
        private Long horaHasta;
        private Boolean intervaloComunicacion;
        private Long oid;

    public Character getDiaComunicacion() {
        return diaComunicacion;
    }

    public void setDiaComunicacion(Character newDiaComunicacion) {
        diaComunicacion = newDiaComunicacion;
    }

    public Long getHoraDesde() {
        return horaDesde;
    }

    public void setHoraDesde(Long newHoraDesde) {
        horaDesde = newHoraDesde;
    }

    public Long getHoraHasta() {
        return horaHasta;
    }

    public void setHoraHasta(Long newHoraHasta) {
        horaHasta = newHoraHasta;
    }

    public Boolean getIntervaloComunicacion() {
        return intervaloComunicacion;
    }

    public void setIntervaloComunicacion(Boolean newIntervaloComunicacion) {
        intervaloComunicacion = newIntervaloComunicacion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Boolean getPrincipal() {
        return principal;
    }

    public void setPrincipal(Boolean newPrincipal) {
        principal = newPrincipal;
    }

    public String getTextoComunicacion() {
        return textoComunicacion;
    }

    public void setTextoComunicacion(String newTextoComunicacion) {
        textoComunicacion = newTextoComunicacion;
    }

    public Long getTipoComunicacion() {
        return tipoComunicacion;
    }

    public void setTipoComunicacion(Long newTipoComunicacion) {
        tipoComunicacion = newTipoComunicacion;
    }




}