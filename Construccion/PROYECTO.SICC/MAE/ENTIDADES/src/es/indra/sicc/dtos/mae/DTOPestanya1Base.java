package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPestanya1Base extends DTOAuditableSICC  {

    private String codigoCliente;
    private String digitoControl;
    private RecordSet tiposDocumento;

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public String getDigitoControl() {
        return digitoControl;
    }

    public void setDigitoControl(String newDigitoControl) {
        digitoControl = newDigitoControl;
    }

    public RecordSet getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(RecordSet newTiposDocumento) {
        tiposDocumento = newTiposDocumento;
    }

}