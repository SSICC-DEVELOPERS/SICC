/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */

package es.indra.sicc.dtos.cal;
import es.indra.sicc.util.DTOBelcorp;
//Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
import java.util.HashMap;

public class DTODescTipificacion  extends DTOBelcorp {
    private String desTipoCliente;
    private String desSubtipoCliente;
    private String desTipoClasificacion;
    private String desClasificacion;
    private HashMap arbolTipificacionCliente;

    public DTODescTipificacion() {
    }

    public String getDesTipoCliente() {
        return desTipoCliente;
    }

    public void setDesTipoCliente(String desTipoCliente) {
        this.desTipoCliente = desTipoCliente;
    }

    public String getDesSubtipoCliente() {
        return desSubtipoCliente;
    }

    public void setDesSubtipoCliente(String desSubtipoCliente) {
        this.desSubtipoCliente = desSubtipoCliente;
    }

    public String getDesTipoClasificacion() {
        return desTipoClasificacion;
    }

    public void setDesTipoClasificacion(String desTipoClasificacion) {
        this.desTipoClasificacion = desTipoClasificacion;
    }

    public String getDesClasificacion() {
        return desClasificacion;
    }

    public void setDesClasificacion(String desClasificacion) {
        this.desClasificacion = desClasificacion;
    }

//Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
    public void setArbolTipificacionCliente(HashMap arbolTipificacionCliente) {
        this.arbolTipificacionCliente = arbolTipificacionCliente;
    }

//Gacevedo(20/06/2007): Se implanta el pedido de cambio CAL-002
    public HashMap getArbolTipificacionCliente() {
        return arbolTipificacionCliente;
    }
}