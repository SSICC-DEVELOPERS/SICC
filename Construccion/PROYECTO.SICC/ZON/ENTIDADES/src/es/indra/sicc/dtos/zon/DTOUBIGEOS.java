package es.indra.sicc.dtos.zon;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTOUBIGEOS extends DTOAuditableSICC  {
    public DTOUBIGEOS() {
    }
    private Vector dtoUbigeoVec;

    public Vector getDtoUbigeoVec() {
        return dtoUbigeoVec;
    }

    public void setDtoUbigeoVec(Vector newDtoUbigeoVec) {
        dtoUbigeoVec = newDtoUbigeoVec;
    }
    
}