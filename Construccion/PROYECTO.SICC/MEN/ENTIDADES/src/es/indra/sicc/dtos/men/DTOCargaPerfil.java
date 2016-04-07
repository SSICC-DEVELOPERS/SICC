package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DTOCargaPerfil  extends DTOAuditableSICC {
	public DTOCargaPerfil() {
	}

	private RecordSet funciones;
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



	public RecordSet getFunciones() {
		return funciones;
	}

	public void setFunciones(RecordSet newFunciones) {
		funciones = newFunciones;
	}

	public DTOElementoMenu getArbol() {
		return arbol;
	}

	public void setArbol(DTOElementoMenu newArbol) {
		arbol = newArbol;
	}
	
}