package es.indra.sicc.cmn.negocio.interfaces.notificacion;

public class DTONotificacionRMI extends DTONotificacion  {
	private String servidor;
    private int puerto;
    
    public DTONotificacionRMI() {

    }


    public void setServidor(String servidor) {
        this.servidor = servidor;
    }


    public String getServidor() {
        return servidor;
    }


    public void setPuerto(int puerto) {
        this.puerto = puerto;
    }


    public int getPuerto() {
        return puerto;
    }

}