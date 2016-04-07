package es.indra.sicc.dtos.dto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSPaginaAlcanceTiposClienteDetalle extends DTOAuditableSICC {

	private RecordSet tiposClasificacion	= null;
	private RecordSet clasificacion			= null;

    public RecordSet getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(RecordSet newClasificacion) {
        clasificacion = newClasificacion;
    }

    public RecordSet getTiposClasificacion() {
        return tiposClasificacion;
    }

    public void setTiposClasificacion(RecordSet newTiposClasificacion) {
        tiposClasificacion = newTiposClasificacion;
    }
}