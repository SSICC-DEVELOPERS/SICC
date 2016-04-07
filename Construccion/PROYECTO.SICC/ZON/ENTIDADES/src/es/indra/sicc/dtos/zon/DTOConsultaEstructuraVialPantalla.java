package es.indra.sicc.dtos.zon;
import es.indra.sicc.dtos.zon.DTOEstructuraGeopoliticaPais;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOConsultaEstructuraVialPantalla extends DTOAuditableSICC  {


    private RecordSet tiposVia;    
    private DTOEstructuraGeopoliticaPais nivelesGeopoliticos;    
    private RecordSet unidadesGeo;

    public DTOEstructuraGeopoliticaPais getNivelesGeopoliticos() {
        return nivelesGeopoliticos;
    }

    public void setNivelesGeopoliticos(DTOEstructuraGeopoliticaPais newNivelesGeopoliticos) {
        nivelesGeopoliticos = newNivelesGeopoliticos;
    }

    public RecordSet getTiposVia() {
        return tiposVia;
    }

    public void setTiposVia(RecordSet newTiposVia) {
        tiposVia = newTiposVia;
    }

    public RecordSet getUnidadesGeo() {
        return unidadesGeo;
    }

    public void setUnidadesGeo(RecordSet newUnidadesGeo) {
        unidadesGeo = newUnidadesGeo;
    }


}