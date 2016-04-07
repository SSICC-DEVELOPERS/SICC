package es.indra.sicc.logicanegocio.dto;
import java.util.Hashtable;
   
public class ServiciosDTO {

    private static ServiciosDTO instanciaUnica = null;
    private Hashtable descuentos;

    public ServiciosDTO()  {
        descuentos = new Hashtable();
    }

    public Hashtable getDescuentos() {
        if (descuentos == null) {
            descuentos = new Hashtable();
        }
        return descuentos;
    }

    public void setDescuentos(Hashtable hash) {
        descuentos = hash;
    }

    public void eliminarDescuentos() {
        descuentos = null;
    }

    
    public static ServiciosDTO getInstannce() {
        if (instanciaUnica == null) {
            instanciaUnica = new ServiciosDTO();
        } 
        return instanciaUnica;
    }
}