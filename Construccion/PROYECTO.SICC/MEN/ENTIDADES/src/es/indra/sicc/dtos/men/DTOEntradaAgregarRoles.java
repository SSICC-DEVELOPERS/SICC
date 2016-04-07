package es.indra.sicc.dtos.men;

import es.indra.mare.common.mgu.manager.MarePrincipal;
import es.indra.sicc.util.DTOBelcorp;

public class DTOEntradaAgregarRoles extends DTOBelcorp {
    public DTOEntradaAgregarRoles() {
    }
    
    private MarePrincipal principal;
    private String usuario;
    private String password;


    public void setPrincipal(MarePrincipal principal) {
        this.principal = principal;
    }

    public MarePrincipal getPrincipal() {
        return principal;
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
}
