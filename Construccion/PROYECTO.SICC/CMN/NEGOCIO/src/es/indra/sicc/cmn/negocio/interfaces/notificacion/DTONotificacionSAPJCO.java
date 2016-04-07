package es.indra.sicc.cmn.negocio.interfaces.notificacion;
import java.util.HashMap;

public class DTONotificacionSAPJCO extends DTONotificacion  {
	private String servidor;
    private String usuario;
    private String contrasena;
    private String mandante;
    private String centro;
    private String repositorio;
    
    private String funcion;
    private HashMap funcion_parametros;
    
    public DTONotificacionSAPJCO() {
        super();
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }


    public String getServidor() {
        return servidor;
    }


    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }


    public String getUsuario() {
        return usuario;
    }


    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }


    public String getContrasena() {
        return contrasena;
    }


    public void setMandante(String mandante) {
        this.mandante = mandante;
    }


    public String getMandante() {
        return mandante;
    }


    public void setCentro(String centro) {
        this.centro = centro;
    }


    public String getCentro() {
        return centro;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }


    public String getFuncion() {
        return funcion;
    }


    public void setFuncion_parametros(HashMap funcion_parametros) {
        this.funcion_parametros = funcion_parametros;
    }


    public HashMap getFuncion_parametros() {
        return funcion_parametros;
    }        


    public void setRepositorio(String repositorio) {
        this.repositorio = repositorio;
    }


    public String getRepositorio() {
        return repositorio;
    }
}