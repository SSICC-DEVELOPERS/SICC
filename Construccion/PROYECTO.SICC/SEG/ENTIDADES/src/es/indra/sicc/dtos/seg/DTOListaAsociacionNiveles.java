package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.dtos.seg.AsociacionNivelesDTO;

public class DTOListaAsociacionNiveles extends DTOAuditableSICC {

    private AsociacionNivelesDTO[] asociaciones; 
    
    public DTOListaAsociacionNiveles() {
        super();
    }

    public AsociacionNivelesDTO[] getAsociaciones() {
        return asociaciones;
    }

    public void setAsociaciones(AsociacionNivelesDTO[] newAsociaciones) {
        asociaciones = newAsociaciones;
    }
}