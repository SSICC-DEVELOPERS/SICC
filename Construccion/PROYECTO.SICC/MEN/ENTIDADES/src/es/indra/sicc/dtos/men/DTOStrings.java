package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOStrings  extends DTOAuditableSICC {
	public DTOStrings() {
	}

	private String[] valor;
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

	public String[] getValor() {
		return valor;
	}

	public void setValor(String[] newValor) {
		valor = newValor;
	}	
}