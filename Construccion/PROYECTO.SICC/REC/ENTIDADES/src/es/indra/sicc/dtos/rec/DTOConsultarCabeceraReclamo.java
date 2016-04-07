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
import es.indra.sicc.util.DTOBelcorp;

public class DTOConsultarCabeceraReclamo extends DTOBelcorp {
    public DTOConsultarCabeceraReclamo() {
    }
    
    private Long oidCliente;
    private String codCliente;
    private String nombre;
    private String zona;
    private String estadoCliente;
    //Se agrega para los reclamos digitados Gacevedo.
    private String codigoEstado;
    private String numeroReclamo;
    private Long numeroDocReferencia;
    

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(String estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getZona() {
        return zona;
    }

    public void setZona(String zona) {
        this.zona = zona;
    }


    public void setCodigoEstado(String codigoEstado)
    {
        this.codigoEstado = codigoEstado;
    }


    public String getCodigoEstado()
    {
        return codigoEstado;
    }


    public void setNumeroReclamo(String numeroReclamo)
    {
        this.numeroReclamo = numeroReclamo;
    }


    public String getNumeroReclamo()
    {
        return numeroReclamo;
    }


    public void setNumeroDocReferencia(Long numeroDocReferencia)
    {
        this.numeroDocReferencia = numeroDocReferencia;
    }


    public Long getNumeroDocReferencia()
    {
        return numeroDocReferencia;
    }
    
    
}