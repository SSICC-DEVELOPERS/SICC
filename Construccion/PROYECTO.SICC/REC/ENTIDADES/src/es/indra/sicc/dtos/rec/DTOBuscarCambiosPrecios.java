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
package es.indra.sicc.dtos.rec;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.util.ArrayList;
import java.util.Date;

public class DTOBuscarCambiosPrecios extends DTOSiccPaginacion  {
    public DTOBuscarCambiosPrecios() {
        super();
    }
    
    private Long numSolicitud;
    private String codCliente;
    private Long oidEstadoGeneracion;
    private String stringTipoSolicitud;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidAcceso;
    private Long oidSubAcceso;
    private String numGeneracion;
    private Long oidPeriodo;
    private String codVenta;
    private String codVentaGenerar;
    private Long oidOperacion;
    private Long oidTipoOperacion;
    private Date fechaGeneracion;
    private ArrayList arrayTipoSolicitud;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodVenta() {
        return codVenta;
    }

    public void setCodVenta(String codVenta) {
        this.codVenta = codVenta;
    }

    public String getCodVentaGenerar() {
        return codVentaGenerar;
    }

    public void setCodVentaGenerar(String codVentaGenerar) {
        this.codVentaGenerar = codVentaGenerar;
    }

    public Date getFechaGeneracion() {
        return fechaGeneracion;
    }

    public void setFechaGeneracion(Date fechaGeneracion) {
        this.fechaGeneracion = fechaGeneracion;
    }

    public String getNumGeneracion() {
        return numGeneracion;
    }

    public void setNumGeneracion(String numGeneracion) {
        this.numGeneracion = numGeneracion;
    }

    public Long getNumSolicitud() {
        return numSolicitud;
    }

    public void setNumSolicitud(Long numSolicitud) {
        this.numSolicitud = numSolicitud;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidEstadoGeneracion() {
        return oidEstadoGeneracion;
    }

    public void setOidEstadoGeneracion(Long oidEstadoGeneracion) {
        this.oidEstadoGeneracion = oidEstadoGeneracion;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidOperacion() {
        return oidOperacion;
    }

    public void setOidOperacion(Long oidOperacion) {
        this.oidOperacion = oidOperacion;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidSubAcceso() {
        return oidSubAcceso;
    }

    public void setOidSubAcceso(Long oidSubAcceso) {
        this.oidSubAcceso = oidSubAcceso;
    }

    public Long getOidTipoOperacion() {
        return oidTipoOperacion;
    }

    public void setOidTipoOperacion(Long oidTipoOperacion) {
        this.oidTipoOperacion = oidTipoOperacion;
    }

    public String getStringTipoSolicitud() {
        return stringTipoSolicitud;
    }

    public void setStringTipoSolicitud(String stringTipoSolicitud) {
        this.stringTipoSolicitud = stringTipoSolicitud;
    }

    public ArrayList getArrayTipoSolicitud()
    {
        return arrayTipoSolicitud;
    }

    public void setArrayTipoSolicitud(ArrayList arrayTipoSolicitud)
    {
        this.arrayTipoSolicitud = arrayTipoSolicitud;
    }
}