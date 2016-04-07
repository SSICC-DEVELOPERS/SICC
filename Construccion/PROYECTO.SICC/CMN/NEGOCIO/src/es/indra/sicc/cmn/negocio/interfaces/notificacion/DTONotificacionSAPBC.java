package es.indra.sicc.cmn.negocio.interfaces.notificacion;

public class DTONotificacionSAPBC extends DTONotificacion  {
   private String servidor;
   private int puerto;
   private String idUsuario;
   private String contrasena;
   private String paquete;
   private String bapi;  
    
    public DTONotificacionSAPBC() {
        
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


    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    public String getIdUsuario() {
        return idUsuario;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public String getContrasena() {
        return contrasena;
    }


    public void setPaquete(String paquete) {
        this.paquete = paquete;
    }


    public String getPaquete() {
        return paquete;
    }


    public void setBapi(String bapi) {
        this.bapi = bapi;
    }


    public String getBapi() {
        return bapi;
    }
    
    
}