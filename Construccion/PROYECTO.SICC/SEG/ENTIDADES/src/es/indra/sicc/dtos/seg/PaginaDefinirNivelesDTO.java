package es.indra.sicc.dtos.seg;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class PaginaDefinirNivelesDTO  extends DTOAuditableSICC {

    private RecordSet nivelesSocioeconomicosBelcorp;
    private RecordSet tiposNivelesSocioeconomicosPersonal;
    private RecordSet paises;
    
    public PaginaDefinirNivelesDTO() {
        super();
    }

    public RecordSet getNivelesSocioeconomicosBelcorp() {
        return nivelesSocioeconomicosBelcorp;
    }

    public void setNivelesSocioeconomicosBelcorp(RecordSet newNivelesSocioeconomicosBelcorp) {
        nivelesSocioeconomicosBelcorp = newNivelesSocioeconomicosBelcorp;
    }

    public RecordSet getPaises() {
        return paises;
    }

    public void setPaises(RecordSet newPaises) {
        paises = newPaises;
    }

    public RecordSet getTiposNivelesSocioeconomicosPersonal() {
        return tiposNivelesSocioeconomicosPersonal;
    }

    public void setTiposNivelesSocioeconomicosPersonal(RecordSet newTiposNivelesSocioeconomicosPersonal) {
        tiposNivelesSocioeconomicosPersonal = newTiposNivelesSocioeconomicosPersonal;
    }

    
}