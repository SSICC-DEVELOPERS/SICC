package es.indra.sicc.dtos.ped;

import java.util.ArrayList;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEjecucionProcesos extends DTOAuditableSICC {

	private ArrayList listaSolicitudes;
	private Long oidGrupoProcesos;
	private Long oidTipoSolicitud;
        
        // sapaza -- Ajuste Segmentacion SICC -- 26/09/2014
        private String codigoBatch;
    
	public DTOEjecucionProcesos() {
	}

	public ArrayList getListaSolicitudes() {
		return listaSolicitudes;
	}

	public void setListaSolicitudes(ArrayList newListaSolicitudes) {
		listaSolicitudes = newListaSolicitudes;
	}

	public Long getOidGrupoProcesos() {
		return oidGrupoProcesos;
	}

	public void setOidGrupoProcesos(Long newOidGrupoProcesos) {
		oidGrupoProcesos = newOidGrupoProcesos;
	}

	public Long getOidTipoSolicitud() {
		return oidTipoSolicitud;
	}

	public void setOidTipoSolicitud(Long newOidTipoSolicitud) {
		oidTipoSolicitud = newOidTipoSolicitud;
	}

    public void setCodigoBatch(String codigoBatch) {
        this.codigoBatch = codigoBatch;
    }

    public String getCodigoBatch() {
        return codigoBatch;
    }
}
