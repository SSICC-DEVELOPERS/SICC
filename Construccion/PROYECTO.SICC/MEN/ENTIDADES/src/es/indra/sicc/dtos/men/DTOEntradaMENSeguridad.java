package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOEntradaMENSeguridad extends DTOAuditableSICC {
    
    private String usuario;
    private String password;
    private Long idioma;

    public DTOEntradaMENSeguridad() {
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setIdioma(Long idioma) {
        this.idioma = idioma;
    }

    public Long getIdioma() {
        return idioma;
    }
}
