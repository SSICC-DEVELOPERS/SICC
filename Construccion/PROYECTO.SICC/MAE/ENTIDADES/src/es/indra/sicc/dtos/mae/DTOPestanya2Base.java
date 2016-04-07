package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DTOPestanya2Base extends DTOAuditableSICC  {

    private RecordSet formasPago;
    private String saldo;
    private Boolean estaCastigado;
    private Boolean existe;
    private Long oidCliente;

    public Boolean getEstaCastigado() {
        return estaCastigado;
    }

    public void setEstaCastigado(Boolean newEstaCastigado) {
        estaCastigado = newEstaCastigado;
    }

    public Boolean getExiste() {
        return existe;
    }

    public void setExiste(Boolean newExiste) {
        existe = newExiste;
    }

    public RecordSet getFormasPago() {
        return formasPago;
    }

    public void setFormasPago(RecordSet newFormasPago) {
        formasPago = newFormasPago;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long newOidCliente) {
        oidCliente = newOidCliente;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String newSaldo) {
        saldo = newSaldo;
    }



}