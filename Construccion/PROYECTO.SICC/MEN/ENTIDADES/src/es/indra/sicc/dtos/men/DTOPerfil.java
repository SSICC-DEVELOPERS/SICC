package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOPerfil extends DTOAuditableSICC {
	private String nombre;
	private Long inicio;
	private Long[] funciones;
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

	public DTOPerfil() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String newNombre) {
		nombre = newNombre;
	}

	public Long getInicio() {
		return inicio;
	}

	public void setInicio(Long newInicio) {
		inicio = newInicio;
	}

	public Long[] getFunciones() {
		return funciones;
	}

	public void setFunciones(Long[] newFunciones) {
		funciones = newFunciones;
	}
}