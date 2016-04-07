/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35guardarParametrosGeneralesConcurso
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Autor: Diego Morello
 *
 */
package es.indra.sicc.logicanegocio.inc;
import es.indra.sicc.util.UtilidadesLog;
import java.io.Serializable;

public class UnidadAdministrativa implements Serializable {
    private Long oidSubgerencia;
    private Long oidRegion;
    private Long oidZona;
    private Long oidSeccion;

    public UnidadAdministrativa() {
    }

    public Long getOidSubgerencia() {
        return oidSubgerencia;
    }

    public void setOidSubgerencia(Long oidSubgerencia) {
        this.oidSubgerencia = oidSubgerencia;
    }

    public Long getOidRegion() {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion) {
        this.oidRegion = oidRegion;
    }

    public Long getOidZona() {
        return oidZona;
    }

    public void setOidZona(Long oidZona) {
        this.oidZona = oidZona;
    }

    public Long getOidSeccion() {
        return oidSeccion;
    }

    public void setOidSeccion(Long oidSeccion) {
        this.oidSeccion = oidSeccion;
    }

    public String toString() {
        StringBuffer strUnidad = new StringBuffer();
        strUnidad.append("[ ");
        strUnidad.append("Sub: " + oidSubgerencia + "; ");
        strUnidad.append("Reg: " + oidRegion + "; ");
        strUnidad.append("Zon: " + oidZona + "; ");
        strUnidad.append("Sec: " + oidSeccion + " ");
        strUnidad.append("]");

        return strUnidad.toString();
    }
    
    public boolean equalsUA(UnidadAdministrativa uniAdm) {
    
        if(uniAdm == null) {
            UtilidadesLog.debug("No Iguales");
            return false;
        }
        
        if (oidSubgerencia != null) {
            if (!oidSubgerencia.equals(uniAdm.getOidSubgerencia())) {
                UtilidadesLog.debug("No Iguales");
                return false;
            }
        }
        
        if (oidRegion != null) {
            if (!oidRegion.equals(uniAdm.getOidRegion())) {
                UtilidadesLog.debug("No Iguales");
                return false;
            }
        }
        
        if (oidZona != null) {
            if (!oidZona.equals(uniAdm.getOidZona())) {
                UtilidadesLog.debug("No Iguales");
                return false;
            }
        }
        
        if (oidSeccion != null) {
            if (!oidSeccion.equals(uniAdm.getOidSeccion())) {
                UtilidadesLog.debug("No Iguales");
                return false;
            }
        }
        
        UtilidadesLog.debug("Iguales");
        return true;
    }
}
