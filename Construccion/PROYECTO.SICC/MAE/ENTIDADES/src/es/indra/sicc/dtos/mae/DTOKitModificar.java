package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOKitModificar extends DTOAuditableSICC  {

    private DTOKit datos;
    private RecordSet periodos;

    public DTOKit getDatos() {
        return datos;
    }

    public void setDatos(DTOKit newDatos) {
        datos = newDatos;
    }

    public RecordSet getPeriodos() {
        return periodos;
    }

    public void setPeriodos(RecordSet newPeriodos) {
        periodos = newPeriodos;
    }
    
}