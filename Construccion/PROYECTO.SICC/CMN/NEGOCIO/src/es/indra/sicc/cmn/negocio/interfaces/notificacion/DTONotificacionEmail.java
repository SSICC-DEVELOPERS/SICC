package es.indra.sicc.cmn.negocio.interfaces.notificacion;

public class DTONotificacionEmail extends DTONotificacion  {
	private String dirCorreo;
    private String mensaje;
    
    public DTONotificacionEmail() {
    }
    
    public String getDirCorreo() {
        return this.dirCorreo;
    }
    
    public void setDirCorreo(String dirCorreo) {
        this.dirCorreo=dirCorreo;
    }
            
    public String getMensaje() {
            return mensaje;
    }
    
    public void setMensaje(String newMensaje) {
            mensaje = newMensaje;
    }
}