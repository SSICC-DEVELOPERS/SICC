package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOConsultaPantallaUG extends DTOAuditableSICC  {
    public RecordSet EstructuraGeopolitica;
    public RecordSet UnidadesGeograficasN1;

    public DTOConsultaPantallaUG() {
    }

    public RecordSet getEstructuraGeopolitica() {
        return EstructuraGeopolitica;
    }

    public void setEstructuraGeopolitica(RecordSet newEstructuraGeopolitica) {
        EstructuraGeopolitica = newEstructuraGeopolitica;
    }

    public RecordSet getUnidadesGeograficasN1() {
        return UnidadesGeograficasN1;
    }

    public void setUnidadesGeograficasN1(RecordSet newUnidadesGeograficasN1) {
        UnidadesGeograficasN1 = newUnidadesGeograficasN1;
    }
    
}