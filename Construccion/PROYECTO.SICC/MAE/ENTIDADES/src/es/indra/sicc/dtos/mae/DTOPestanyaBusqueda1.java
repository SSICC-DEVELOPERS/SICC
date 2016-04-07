package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPestanyaBusqueda1 extends DTOAuditableSICC  {

        private RecordSet tiposDocumento;
        private Integer tamCodigoCliente;


    public Integer getTamCodigoCliente() {
        return tamCodigoCliente;
    }

    public void setTamCodigoCliente(Integer newTamCodigoCliente) {
        tamCodigoCliente = newTamCodigoCliente;
    }

    public RecordSet getTiposDocumento() {
        return tiposDocumento;
    }

    public void setTiposDocumento(RecordSet newTiposDocumento) {
        tiposDocumento = newTiposDocumento;
    }




}