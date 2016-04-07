package es.indra.sicc.dtos.men;

public class DTOOIDs extends es.indra.sicc.util.DTOOIDs {

    private String password;
    private String usuario;

    public DTOOIDs() {
        super();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getUsuario() {
        return usuario;
    }
}
