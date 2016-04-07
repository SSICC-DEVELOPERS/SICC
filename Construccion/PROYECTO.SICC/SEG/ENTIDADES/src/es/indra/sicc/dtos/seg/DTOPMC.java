package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPMC extends DTOAuditableSICC  {
    private RecordSet paises;
    private RecordSet marcas;
    private RecordSet canales;

    public DTOPMC() {
        super();
    }


    public RecordSet getCanales() {
        return canales;
    }

    public void setCanales(RecordSet newCanales) {
        canales = newCanales;
    }

    public RecordSet getMarcas() {
        return marcas;
    }

    public void setMarcas(RecordSet newMarcas) {
        marcas = newMarcas;
    }

    public RecordSet getPaises() {
        return paises;
    }

    public void setPaises(RecordSet newPaises) {
        paises = newPaises;
    }
   
}