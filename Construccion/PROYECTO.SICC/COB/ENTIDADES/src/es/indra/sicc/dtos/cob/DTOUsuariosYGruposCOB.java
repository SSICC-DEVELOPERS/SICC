package es.indra.sicc.dtos.cob;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.sicc.util.DTOSalida;

public class DTOUsuariosYGruposCOB extends DTOAuditableSICC  {
    
    private RecordSet grupos;
    private RecordSet usuarios;
    
    public DTOUsuariosYGruposCOB() {
    }


    public void setUsuarios(RecordSet usuarios) {
        this.usuarios = usuarios;
    }


    public RecordSet getUsuarios() {
        return usuarios;
    }


    public void setGrupos(RecordSet grupos) {
        this.grupos = grupos;
    }


    public RecordSet getGrupos() {
        return grupos;
    }
    
    
}