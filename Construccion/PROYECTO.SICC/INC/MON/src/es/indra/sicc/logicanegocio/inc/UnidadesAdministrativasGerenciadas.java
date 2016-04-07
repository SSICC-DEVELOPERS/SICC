package es.indra.sicc.logicanegocio.inc;

import es.indra.sicc.util.UtilidadesLog;

import java.io.Serializable;
import java.util.ArrayList;

public class UnidadesAdministrativasGerenciadas
        implements Cloneable, Serializable {
    private ArrayList regiones;
    private ArrayList secciones;
    private ArrayList subGerencias;
    private ArrayList zonas;

    public UnidadesAdministrativasGerenciadas() {
    }

    public void setRegiones(ArrayList regiones) {
        this.regiones = regiones;
    }

    public ArrayList getRegiones() {
        return regiones;
    }

    public void setSecciones(ArrayList secciones) {
        this.secciones = secciones;
    }

    public ArrayList getSecciones() {
        return secciones;
    }

    public void setSubGerencias(ArrayList subGerencias) {
        this.subGerencias = subGerencias;
    }

    public ArrayList getSubGerencias() {
        return subGerencias;
    }

    public void setZonas(ArrayList zonas) {
        this.zonas = zonas;
    }

    public ArrayList getZonas() {
        return zonas;
    }

    /**
    * @return
    * @version 1.00 09/06/2005
    * @author: Carlos Leal
    * Descripcion: retorna el ArrayList que sea distinto de null de acuerdo al nivel de gerenciamiento.
    */
    public ArrayList getUnidadesGerenciadas() {
        UtilidadesLog.info("UnidadesAdministrativasGerenciadas.getUnidadesGerenciadas():Entrada");

        if ((regiones != null) && (secciones == null) && (subGerencias == null) && (zonas == null)) {
            UtilidadesLog.info("UnidadesAdministrativasGerenciadas.getUnidadesGerenciadas():Salida");
            return regiones;
        } else if ((regiones == null) && (secciones != null) && (subGerencias == null) && (zonas == null)) {
            UtilidadesLog.info("UnidadesAdministrativasGerenciadas.getUnidadesGerenciadas():Salida");
            return secciones;
        } else if ((regiones == null) && (secciones == null) && (subGerencias != null) && (zonas == null)) {
            UtilidadesLog.info("UnidadesAdministrativasGerenciadas.getUnidadesGerenciadas():Salida");
            return subGerencias;
        }

        UtilidadesLog.info("UnidadesAdministrativasGerenciadas.getUnidadesGerenciadas():Salida");

        return zonas;
    }

    /**
    * @return
    * @version 1.00 10/06/2005
    * @author: Carlos Leal
    * Descripcion: elimina todos los elementos del atributo distinto de null y agrega la unidad recibida por parametro.
    */
    public void setUnidadGerenciada(Long oidUnidadGerenciada) {
        UtilidadesLog.info("UnidadesAdministrativasGerenciadas.setUnidadGerenciada(Long oidUnidadGerenciada):Entrada");

        if (regiones != null) {
            regiones = new ArrayList();
            regiones.add(oidUnidadGerenciada);
        } else if (secciones != null) {
            secciones = new ArrayList();
            secciones.add(oidUnidadGerenciada);
        } else if (subGerencias != null) {
            subGerencias = new ArrayList();
            subGerencias.add(oidUnidadGerenciada);
        } else {
            zonas = new ArrayList();
            zonas.add(oidUnidadGerenciada);
        }

        UtilidadesLog.info("UnidadesAdministrativasGerenciadas.setUnidadGerenciada(Long oidUnidadGerenciada):Salida");
    }
}
