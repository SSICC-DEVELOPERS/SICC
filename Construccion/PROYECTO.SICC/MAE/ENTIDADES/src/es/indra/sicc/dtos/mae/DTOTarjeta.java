package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOTarjeta extends DTOAuditableSICC  {

        private Long tipo;
        private Long clase;
        private Long banco;
        private Long oid;

    public Long getBanco() {
        return banco;
    }

    public void setBanco(Long newBanco) {
        banco = newBanco;
    }

    public Long getClase() {
        return clase;
    }

    public void setClase(Long newClase) {
        clase = newClase;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public Long getTipo() {
        return tipo;
    }

    public void setTipo(Long newTipo) {
        tipo = newTipo;
    }



}