package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOCargaFavoritos  extends DTOAuditableSICC {
	private RecordSet favoritos;
	private DTOElementoMenu arbol;
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


	public DTOCargaFavoritos() {
	}

	public RecordSet getFavoritos() {
		return favoritos;
	}

	public void setFavoritos(RecordSet newFavoritos) {
		favoritos = newFavoritos;
	}

	public DTOElementoMenu getArbol() {
		return arbol;
	}

	public void setArbol(DTOElementoMenu newArbol) {
		arbol = newArbol;
	}


}
