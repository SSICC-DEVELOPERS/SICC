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
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOFichaCliente extends DTOBelcorp
{
    private DTOCliente cliente;
    private DTONombre nombreConsultora;
    private DTONombre nombreGerenteZona;
    private DTONombre nombreGerenteRegional;
    private DTONombre nombreSubgerenteVentas;
    private RecordSet unidadesAdministrativas;
    private RecordSet ultimosPedidos;
    private DTODescTipificacion tipificacion;
    private Long montoSolicitudesNuevas;
    private Long oidContacto;
    private DTOTipoComunicacion dtoTipoComunicacion;
    private RecordSet tipoComunicacion;

    public DTOFichaCliente()
    {
    }

    public DTOCliente getCliente()
    {
        return cliente;
    }

    public void setCliente(DTOCliente cliente)
    {
        this.cliente = cliente;
    }

    public DTONombre getNombreConsultora()
    {
        return nombreConsultora;
    }

    public void setNombreConsultora(DTONombre nombreConsultora)
    {
        this.nombreConsultora = nombreConsultora;
    }

    public DTONombre getNombreGerenteZona()
    {
        return nombreGerenteZona;
    }

    public void setNombreGerenteZona(DTONombre nombreGerenteZona)
    {
        this.nombreGerenteZona = nombreGerenteZona;
    }

    public DTONombre getNombreGerenteRegional()
    {
        return nombreGerenteRegional;
    }

    public void setNombreGerenteRegional(DTONombre nombreGerenteRegional)
    {
        this.nombreGerenteRegional = nombreGerenteRegional;
    }

    public DTONombre getNombreSubgerenteVentas()
    {
        return nombreSubgerenteVentas;
    }

    public void setNombreSubgerenteVentas(DTONombre nombreSubgerenteVentas)
    {
        this.nombreSubgerenteVentas = nombreSubgerenteVentas;
    }

    public RecordSet getUnidadesAdministrativas()
    {
        return unidadesAdministrativas;
    }

    public void setUnidadesAdministrativas(RecordSet unidadesAdministrativas)
    {
        this.unidadesAdministrativas = unidadesAdministrativas;
    }

    public RecordSet getUltimosPedidos()
    {
        return ultimosPedidos;
    }

    public void setUltimosPedidos(RecordSet ultimosPedidos)
    {
        this.ultimosPedidos = ultimosPedidos;
    }

    public DTODescTipificacion getTipificacion()
    {
        return tipificacion;
    }

    public void setTipificacion(DTODescTipificacion tipificacion)
    {
        this.tipificacion = tipificacion;
    }

    public Long getMontoSolicitudesNuevas()
    {
        return montoSolicitudesNuevas;
    }

    public void setMontoSolicitudesNuevas(Long montoSolicitudesNuevas)
    {
        this.montoSolicitudesNuevas = montoSolicitudesNuevas;
    }

    public Long getOidContacto()
    {
        return oidContacto;
    }

    public void setOidContacto(Long oidContacto)
    {
        this.oidContacto = oidContacto;
    }
    public DTOTipoComunicacion getDtoTipoComunicacion()
     {
       return dtoTipoComunicacion;
     }

     public void setDtoTipoComunicacion(DTOTipoComunicacion dtoTipoComunicacion)
     {
       this.dtoTipoComunicacion = dtoTipoComunicacion;
     }

     public RecordSet getTipoComunicacion()
     {
       return tipoComunicacion;
     }

     public void setTipoComunicacion(RecordSet tipoComunicacion)
     {
       this.tipoComunicacion = tipoComunicacion;
     }

}