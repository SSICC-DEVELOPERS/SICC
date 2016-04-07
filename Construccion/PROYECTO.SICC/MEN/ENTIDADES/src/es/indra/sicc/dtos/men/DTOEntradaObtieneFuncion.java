package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;


public class DTOEntradaObtieneFuncion extends DTOSiccPaginacion {
    private String idFuncion;
    private String idUsuario;
    private String tipoUsuario;
    private String perfil;
    private Long idIdioma;
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

    public DTOEntradaObtieneFuncion() {
    }

    public String getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(String newIdFuncion) {
        idFuncion = newIdFuncion;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String newIdUsuario) {
        idUsuario = newIdUsuario;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }

    public void setTipoUsuario(String newTipoUsuario) {
        tipoUsuario = newTipoUsuario;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String newPerfil) {
        perfil = newPerfil;
    }

    public Long getIdIdioma() {
        return idIdioma;
    }

    public void setIdIdioma(Long newIdIdioma) {
        idIdioma = newIdIdioma;
    }
}
