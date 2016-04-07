package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOEntradaCambiarPais extends DTOAuditableSICC {

	private String idUsuario;
	private Integer nuevoPais;
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


	public DTOEntradaCambiarPais()
	{
	}

	public String getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(String newIdUsuario) {
		idUsuario = newIdUsuario;
	}

	public Integer getNuevoPais() {
		return nuevoPais;
	}

	public void setNuevoPais(Integer newNuevoPais) {
		nuevoPais = newNuevoPais;
	}
}