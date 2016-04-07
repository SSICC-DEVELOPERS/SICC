package es.indra.sicc.dtos.men;
import java.util.Vector;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOSalidaSeleccionarFuncionesFavoritas extends DTOAuditableSICC 
{
	private Vector IdFunciones;
    private String usuario;
    private String password;
    
    public String getUsuario() {
        return usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

	public Vector getIdFunciones() {
		return IdFunciones;
	}

	public void setIdFunciones(Vector newIdFunciones) {
		IdFunciones = newIdFunciones;
	}
}