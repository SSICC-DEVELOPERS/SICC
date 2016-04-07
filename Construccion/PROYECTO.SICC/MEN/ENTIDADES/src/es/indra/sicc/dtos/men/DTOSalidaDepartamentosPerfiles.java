package es.indra.sicc.dtos.men;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Vector;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOSalidaDepartamentosPerfiles extends DTOBelcorp 
{
	private RecordSet departamentos;
	private RecordSet perfiles;
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

	public RecordSet getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(RecordSet newDepartamentos) {
		departamentos = newDepartamentos;
	}

	public RecordSet getPerfiles() {
		return perfiles;
	}

	public void setPerfiles(RecordSet newPerfiles) {
		perfiles = newPerfiles;
	}


}