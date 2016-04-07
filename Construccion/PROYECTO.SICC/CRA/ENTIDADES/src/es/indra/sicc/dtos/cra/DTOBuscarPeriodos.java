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
 */
package es.indra.sicc.dtos.cra;

import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

/**
 * Clase creada para Inc. BELC400000652. Sirve de parametro para obtener periodos.
 * @author eiraola
 * @since 05/Sep/2007
 */
public class DTOBuscarPeriodos extends DTOBelcorp {
    private Long oidMarca;
    private Long oidCanal;
    private Date fecha;
    private String nombre;
    private String codigo;
    private Boolean periodoMasNuevoPrimero; // En caso de campanias solapadas cual tiene mayor prioridad

    public DTOBuscarPeriodos() {
    }


    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setPeriodoMasNuevoPrimero(Boolean periodoMasNuevoPrimero) {
        this.periodoMasNuevoPrimero = periodoMasNuevoPrimero;
    }

    public Boolean getPeriodoMasNuevoPrimero() {
        return periodoMasNuevoPrimero;
    }
}