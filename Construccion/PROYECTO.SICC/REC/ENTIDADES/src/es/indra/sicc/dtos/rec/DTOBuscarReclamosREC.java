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

public class DTOBuscarReclamosREC extends DTOSiccPaginacion {

    private Long numAtencion;   
    private String codCliente;   
    private String nombre;  
    private String apellidoPaterno;   
    private String apellidoMaterno;   
    private Long oidMarca;   
    private Long oidCanal;   
    private Long oidSGV;   
    private Long oidRegion;   
    private Long oidZona;   
    private Long oidSeccion;   
    private Long oidTerritorio;   
    private Long oidPerDesdeRef;   
    private Long oidPerHastaRef;   
    private Long oidPerDesdeRecl;   
    private Long oidPerHastaRecl;   
    private Long numDocReferencia;   
    private ArrayList oidsOperaciones;     
    private ArrayList oidsTiposBloqueo;     
    private Boolean mostrarSoloRechazadas;     
    private Date fechaReclamoDesde;     
    private Date fechaReclamoHasta;     
    private Boolean reclamosDigitados;     
    private Boolean reclamosEnLinea;     
    private ArrayList oidsReclamo;
    //añadidos por incidencia 14671
    private String stringOperaciones;
    private String stringTiposBloqueo;
    //añadido por incidencia 15099 --> se añade un oid para el enlace de 
    //las paginas de gestion de reclamos bloqueados.
    private Long oid;
    //añadido por incidencia 21609
    private String opcionMenu;
    private Long numReclamo;


    public DTOBuscarReclamosREC() {
        super();
    }

    public String getApellidoMaterno()
    {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno)
    {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getApellidoPaterno()
    {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno)
    {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getCodCliente()
    {
        return codCliente;
    }

    public void setCodCliente(String codCliente)
    {
        this.codCliente = codCliente;
    }

    public Date getFechaReclamoDesde()
    {
        return fechaReclamoDesde;
    }

    public void setFechaReclamoDesde(Date fechaReclamoDesde)
    {
        this.fechaReclamoDesde = fechaReclamoDesde;
    }

    public Date getFechaReclamoHasta()
    {
        return fechaReclamoHasta;
    }

    public void setFechaReclamoHasta(Date fechaReclamoHasta)
    {
        this.fechaReclamoHasta = fechaReclamoHasta;
    }

    public Boolean getMostrarSoloRechazadas()
    {
        return mostrarSoloRechazadas;
    }

    public void setMostrarSoloRechazadas(Boolean mostrarSoloRechazadas)
    {
        this.mostrarSoloRechazadas = mostrarSoloRechazadas;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public Long getNumAtencion()
    {
        return numAtencion;
    }

    public void setNumAtencion(Long numAtencion)
    {
        this.numAtencion = numAtencion;
    }

    public Long getNumDocReferencia()
    {
        return numDocReferencia;
    }

    public void setNumDocReferencia(Long numDocReferencia)
    {
        this.numDocReferencia = numDocReferencia;
    }

    public Long getOidCanal()
    {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal)
    {
        this.oidCanal = oidCanal;
    }

    public Long getOidMarca()
    {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca)
    {
        this.oidMarca = oidMarca;
    }

    public Long getOidPerDesdeRecl()
    {
        return oidPerDesdeRecl;
    }

    public void setOidPerDesdeRecl(Long oidPerDesdeRecl)
    {
        this.oidPerDesdeRecl = oidPerDesdeRecl;
    }

    public Long getOidPerDesdeRef()
    {
        return oidPerDesdeRef;
    }

    public void setOidPerDesdeRef(Long oidPerDesdeRef)
    {
        this.oidPerDesdeRef = oidPerDesdeRef;
    }

    public Long getOidPerHastaRecl()
    {
        return oidPerHastaRecl;
    }

    public void setOidPerHastaRecl(Long oidPerHastaRecl)
    {
        this.oidPerHastaRecl = oidPerHastaRecl;
    }

    public Long getOidPerHastaRef()
    {
        return oidPerHastaRef;
    }

    public void setOidPerHastaRef(Long oidPerHastaRef)
    {
        this.oidPerHastaRef = oidPerHastaRef;
    }

    public Long getOidRegion()
    {
        return oidRegion;
    }

    public void setOidRegion(Long oidRegion)
    {
        this.oidRegion = oidRegion;
    }

    public Long getOidSGV()
    {
        return oidSGV;
    }

    public void setOidSGV(Long oidSGV)
    {
        this.oidSGV = oidSGV;
    }

    public Long getOidSeccion()
    {
        return oidSeccion;
    }

    public void setOidSeccion(Long oidSeccion)
    {
        this.oidSeccion = oidSeccion;
    }

    public Long getOidTerritorio()
    {
        return oidTerritorio;
    }

    public void setOidTerritorio(Long oidTerritorio)
    {
        this.oidTerritorio = oidTerritorio;
    }

    public Long getOidZona()
    {
        return oidZona;
    }

    public void setOidZona(Long oidZona)
    {
        this.oidZona = oidZona;
    }

    public ArrayList getOidsOperaciones()
    {
        return oidsOperaciones;
    }

    public void setOidsOperaciones(ArrayList oidsOperaciones)
    {
        this.oidsOperaciones = oidsOperaciones;
    }

    public ArrayList getOidsReclamo()
    {
        return oidsReclamo;
    }

    public void setOidsReclamo(ArrayList oidsReclamo)
    {
        this.oidsReclamo = oidsReclamo;
    }

    public ArrayList getOidsTiposBloqueo()
    {
        return oidsTiposBloqueo;
    }

    public void setOidsTiposBloqueo(ArrayList oidsTiposBloqueo)
    {
        this.oidsTiposBloqueo = oidsTiposBloqueo;
    }

    public Boolean getReclamosDigitados()
    {
        return reclamosDigitados;
    }

    public void setReclamosDigitados(Boolean reclamosDigitados)
    {
        this.reclamosDigitados = reclamosDigitados;
    }

    public Boolean getReclamosEnLinea()
    {
        return reclamosEnLinea;
    }

    public void setReclamosEnLinea(Boolean reclamosEnLinea)
    {
        this.reclamosEnLinea = reclamosEnLinea;
    }

    public String getStringOperaciones()
    {
        return stringOperaciones;
    }

    public void setStringOperaciones(String stringOperaciones)
    {
        this.stringOperaciones = stringOperaciones;
    }

    public String getStringTiposBloqueo()
    {
        return stringTiposBloqueo;
    }

    public void setStringTiposBloqueo(String stringTiposBloqueo)
    {
        this.stringTiposBloqueo = stringTiposBloqueo;
    }

    public Long getOid()
    {
        return oid;
    }

    public void setOid(Long oid)
    {
        this.oid = oid;
    }

    public String getOpcionMenu()
    {
        return opcionMenu;
    }

    public void setOpcionMenu(String opcionMenu)
    {
        this.opcionMenu = opcionMenu;
    }

    public Long getNumReclamo() {
        return numReclamo;
    }

    public void setNumReclamo(Long numReclamo) {
        this.numReclamo = numReclamo;
    }
}