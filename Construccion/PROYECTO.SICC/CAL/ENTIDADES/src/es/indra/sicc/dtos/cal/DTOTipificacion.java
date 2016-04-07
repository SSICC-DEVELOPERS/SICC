package es.indra.sicc.dtos.cal;

import es.indra.sicc.util.DTOBelcorp;
import java.util.HashMap;

public class DTOTipificacion extends DTOBelcorp {

    public final static int TIPIFICACION_TIPO_CLIENTE = 1;
    public final static int TIPIFICACION_SUBTIPO_CLIENTE = 2;
    public final static int TIPIFICACION_TIPO_CLASIFICACION_CLIENTE = 3;
    public final static int TIPIFICACION_CLASIFICACION_CLIENTE = 4;


    private Integer tipoDatosAlmacenados;
    private String descripcionTipificacion;
    private Long oidTipificacion;
    private HashMap dependientesTipificacion;

    public DTOTipificacion(Integer tipoDatosAlmacenados){
        validarTipoDatoAlmacenado(tipoDatosAlmacenados);
        this.tipoDatosAlmacenados = tipoDatosAlmacenados;
    }

    public void setTipoDatosAlmacenados(Integer tipoDatosAlmacenados) {
        validarTipoDatoAlmacenado(tipoDatosAlmacenados);
        this.tipoDatosAlmacenados = tipoDatosAlmacenados;
    }

    private void validarTipoDatoAlmacenado(Integer tipoDatosAlmacenados){
        if(tipoDatosAlmacenados!=null){
            int tmp = tipoDatosAlmacenados.intValue();
            if(tmp!= DTOTipificacion.TIPIFICACION_TIPO_CLIENTE &&
               tmp!= DTOTipificacion.TIPIFICACION_SUBTIPO_CLIENTE &&
               tmp!= DTOTipificacion.TIPIFICACION_TIPO_CLASIFICACION_CLIENTE &&
               tmp!= DTOTipificacion.TIPIFICACION_CLASIFICACION_CLIENTE ) {
                throw new IllegalArgumentException("El valor para el tipo de dato almacenado no es valido");
            }
        }else{
            throw new IllegalArgumentException("El valor para el tipo de dato almacenado no puede ser nulo");
        }        
    }


    public Integer getTipoDatosAlmacenados() {
        return tipoDatosAlmacenados;
    }


    public void setDescripcionTipificacion(String descripcionTipificacion) {
        this.descripcionTipificacion = descripcionTipificacion;
    }


    public String getDescripcionTipificacion() {
        return descripcionTipificacion;
    }


    public void setOidTipificacion(Long oidTipificacion) {
        this.oidTipificacion = oidTipificacion;
    }


    public Long getOidTipificacion() {
        return oidTipificacion;
    }


    public void setDependientesTipificacion(HashMap dependientesTipificacion) {
        this.dependientesTipificacion = dependientesTipificacion;
    }


    public HashMap getDependientesTipificacion() {
        return dependientesTipificacion;
    }

}