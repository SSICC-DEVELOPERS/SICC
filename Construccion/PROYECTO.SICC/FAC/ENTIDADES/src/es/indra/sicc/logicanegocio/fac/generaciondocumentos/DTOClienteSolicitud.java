/**
 * Copyright 2004 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
package es.indra.sicc.logicanegocio.fac.generaciondocumentos;
import es.indra.sicc.util.DTOBelcorp;

//se ha creado por la incidencia 21179 con el nombre DTOClienteOrdenCompra
//y modificado por 21174 a DTOClienteSolicitud
public class DTOClienteSolicitud extends DTOBelcorp 
{
    public DTOClienteSolicitud()
    {
    }
    private String codigoCliente;
    private String nombre;
    private String descripcionVia;
    private String nombreVia;
    private String numero;
    private String descripcionUbigeo;
    private String telefono;
    private String codTerritorio;
    private String codZona;
    private String codRegion;
    private String codSeccion;
    private String observaciones;

    public String getCodigoCliente()
    {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente)
    {
        this.codigoCliente = codigoCliente;
    }

    public String getDescripcionUbigeo()
    {
        return descripcionUbigeo;
    }

    public void setDescripcionUbigeo(String descripcionUbigeo)
    {
        this.descripcionUbigeo = descripcionUbigeo;
    }

    public String getDescripcionVia()
    {
        return descripcionVia;
    }

    public void setDescripcionVia(String descripcionVia)
    {
        this.descripcionVia = descripcionVia;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getTelefono()
    {
        return telefono;
    }

    public void setTelefono(String telefono)
    {
        this.telefono = telefono;
    }

    public String getNombreVia()
    {
        return nombreVia;
    }

    public void setNombreVia(String nombreVia)
    {
        this.nombreVia = nombreVia;
    }

    public String getNumero()
    {
        return numero;
    }

    public void setNumero(String numero)
    {
        this.numero = numero;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }

    public String getCodRegion()
    {
        return codRegion;
    }

    public void setCodRegion(String codRegion)
    {
        this.codRegion = codRegion;
    }

    public String getCodSeccion()
    {
        return codSeccion;
    }

    public void setCodSeccion(String codSeccion)
    {
        this.codSeccion = codSeccion;
    }

    public String getCodTerritorio()
    {
        return codTerritorio;
    }

    public void setCodTerritorio(String codTerritorio)
    {
        this.codTerritorio = codTerritorio;
    }

    public String getCodZona()
    {
        return codZona;
    }

    public void setCodZona(String codZona)
    {
        this.codZona = codZona;
    }
}