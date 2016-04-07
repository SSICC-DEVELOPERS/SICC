package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTOPsicografia extends DTOAuditableSICC  {

        private Long marca;
        private Long tipoPerfil;
        private String codigoTest;
        private Date fecha;
        private Long oid;

    public String getCodigoTest() {
        return codigoTest;
    }

    public void setCodigoTest(String newCodigoTest) {
        codigoTest = newCodigoTest;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date newFecha) {
        fecha = newFecha;
    }

    public Long getMarca() {
        return marca;
    }

    public void setMarca(Long newMarca) {
        marca = newMarca;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getTipoPerfil() {
        return tipoPerfil;
    }

    public void setTipoPerfil(Long newTipoPerfil) {
        tipoPerfil = newTipoPerfil;
    }



}