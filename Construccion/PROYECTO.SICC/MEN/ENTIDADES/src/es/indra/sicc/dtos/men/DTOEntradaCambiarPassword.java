package es.indra.sicc.dtos.men;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.io.Serializable;

public class DTOEntradaCambiarPassword extends DTOAuditableSICC implements Serializable {
    public DTOEntradaCambiarPassword() {
    }
    
    private String userName;
    private Object newPass;
    private Object newPassConfirm;

    //para la seguridad de mgu
    //************************
    private String usuario;
    private String password;
    //************************


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setNewPass(Object newPass) {
        this.newPass = newPass;
    }

    public Object getNewPass() {
        return newPass;
    }

    public void setNewPassConfirm(Object newPassConfirm) {
        this.newPassConfirm = newPassConfirm;
    }

    public Object getNewPassConfirm() {
        return newPassConfirm;
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
