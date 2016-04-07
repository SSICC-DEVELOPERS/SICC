package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOClienteSubtipos extends DTOAuditableSICC  {

    private Long oidCliente;
    private RecordSet subtipos;
    
    public DTOClienteSubtipos() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public RecordSet getSubtipos() {
        return subtipos;
    }

    public void setSubtipos(RecordSet newSubtipos) {
        subtipos = newSubtipos;
    }
}