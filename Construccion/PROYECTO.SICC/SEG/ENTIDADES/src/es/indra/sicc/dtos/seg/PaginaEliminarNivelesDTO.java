package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class PaginaEliminarNivelesDTO extends DTOAuditableSICC {

    private RecordSet paises;
    private RecordSet asociaciones;

    public PaginaEliminarNivelesDTO() {
    super();
    }

    public RecordSet getAsociaciones() {
        return asociaciones;
    }

    public void setAsociaciones(RecordSet newAsociaciones) {
        asociaciones = newAsociaciones;
    }

    public RecordSet getPaises() {
        return paises;
    }

    public void setPaises(RecordSet newPaises) {
        paises = newPaises;
    }

    
}