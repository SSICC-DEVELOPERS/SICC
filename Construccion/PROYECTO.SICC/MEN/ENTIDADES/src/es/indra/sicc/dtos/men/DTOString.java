package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOString extends DTOSiccPaginacion {
	private String valor;
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

	public DTOString() {
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String newValor) {
		valor = newValor;
	}
}