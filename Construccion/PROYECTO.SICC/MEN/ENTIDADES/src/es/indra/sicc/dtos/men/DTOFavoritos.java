package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOFavoritos  extends DTOAuditableSICC {
	private Long[] favoritos;
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

	public DTOFavoritos() {
	}

	public Long[] getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(Long[] newFavoritos) {
		favoritos = newFavoritos;
	}

	
}