/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor : Dante Castiglione
 */
package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;

public class TipificacionCliente implements Serializable {
    private Long oidTipoCliente;
    private Long oidSubTipoCliente;
    private Long oidTipoClasificacionCliente;
    private Long oidClasificacionCliente;
    
    //Agregado jrivas DBLG500000255 23/05/2006
    private Long oidParticipante;
    
    // sapaza -- PER-SiCC-2013-0825 -- 30/07/2013
    private boolean indExclusion;


    public TipificacionCliente() {
    }

    /**
     * Define si el objeto pasado por parámetro es igual a la tipificacion de la instancia.
     */
    public boolean equals(Object obj) {
        UtilidadesLog.info("TipificacionCliente.equals(Object obj):Entrada");
        if (obj == null) {
            UtilidadesLog.debug(" rechazo por null");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        if (!this.getClass().isInstance(obj)) {
            UtilidadesLog.debug(" rechazo por otra clase");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        TipificacionCliente castObj = (TipificacionCliente) obj;

        if ((this.getOidTipoCliente() != null) && !this.getOidTipoCliente().equals(castObj.getOidTipoCliente())) {
            UtilidadesLog.debug(" rechazo por tipoCleinte");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        if ((this.getOidSubTipoCliente() != null) && !this.getOidSubTipoCliente().equals(castObj.getOidSubTipoCliente())) {
            UtilidadesLog.debug(" rechazo por subtipoCleinte");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        if ((this.getOidTipoClasificacionCliente() != null) &&
                !this.getOidTipoClasificacionCliente().equals(castObj.getOidTipoClasificacionCliente())) {
            UtilidadesLog.debug(" rechazo por tipoclasi");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        if ((this.getOidClasificacionCliente() != null) && !this.getOidClasificacionCliente().equals(castObj.getOidClasificacionCliente())) {
            UtilidadesLog.debug(" rechazo por clase");
            UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
            return false;
        }

        UtilidadesLog.debug(" valido");
        UtilidadesLog.info("TipificacionCliente.equals(Object obj):Salida");
        return true;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }

    public Long getOidSubTipoCliente() {
        return oidSubTipoCliente;
    }

    public void setOidSubTipoCliente(Long oidSubTipoCliente) {
        this.oidSubTipoCliente = oidSubTipoCliente;
    }

    public Long getOidTipoClasificacionCliente() {
        return oidTipoClasificacionCliente;
    }

    public void setOidTipoClasificacionCliente(Long oidTipoClasificacionCliente) {
        this.oidTipoClasificacionCliente = oidTipoClasificacionCliente;
    }

    public Long getOidClasificacionCliente() {
        return oidClasificacionCliente;
    }

    public void setOidClasificacionCliente(Long oidClasificacionCliente) {
        this.oidClasificacionCliente = oidClasificacionCliente;
    }

    public Long getOidParticipante() {
        return oidParticipante;
    }

    public void setOidParticipante(Long oidParticipante) {
        this.oidParticipante = oidParticipante;
    }

    public void setIndExclusion(boolean indExclusion) {
        this.indExclusion = indExclusion;
    }

    public boolean isIndExclusion() {
        return indExclusion;
    }
}
