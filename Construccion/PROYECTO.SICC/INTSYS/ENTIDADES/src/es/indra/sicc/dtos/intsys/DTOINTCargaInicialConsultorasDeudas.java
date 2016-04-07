package es.indra.sicc.dtos.intsys;

import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.dtos.mae.DTOClasificaciones;
import es.indra.sicc.dtos.mae.DTOTipoSubtipo;

public class DTOINTCargaInicialConsultorasDeudas extends DTOBelcorp
{
    private DTOSalida listaEmpresas;
    private DTOSalida listaRegiones;
    private DTOSalida listaZonas;
    private DTOTipoSubtipo listaTiposSubtiposClientes;
    private DTOClasificaciones listaTiposClasificacion;
    private String numeroLote;
    private String descripcionLote;
    private String observaciones;
    
    public DTOINTCargaInicialConsultorasDeudas()
    {
    }

    public String getDescripcionLote()
    {
        return descripcionLote;
    }

    public void setDescripcionLote(String descripcionLote)
    {
        this.descripcionLote = descripcionLote;
    }

    public DTOSalida getListaEmpresas()
    {
        return listaEmpresas;
    }

    public void setListaEmpresas(DTOSalida listaEmpresas)
    {
        this.listaEmpresas = listaEmpresas;
    }

    public DTOSalida getListaRegiones()
    {
        return listaRegiones;
    }

    public void setListaRegiones(DTOSalida listaRegiones)
    {
        this.listaRegiones = listaRegiones;
    }

    public DTOClasificaciones getListaTiposClasificacion()
    {
        return listaTiposClasificacion;
    }

    public void setListaTiposClasificacion(DTOClasificaciones listaTiposClasificacion)
    {
        this.listaTiposClasificacion = listaTiposClasificacion;
    }

    public DTOTipoSubtipo getListaTiposSubtiposClientes()
    {
        return listaTiposSubtiposClientes;
    }

    public void setListaTiposSubtiposClientes(DTOTipoSubtipo listaTiposSubtiposClientes)
    {
        this.listaTiposSubtiposClientes = listaTiposSubtiposClientes;
    }

    public DTOSalida getListaZonas()
    {
        return listaZonas;
    }

    public void setListaZonas(DTOSalida listaZonas)
    {
        this.listaZonas = listaZonas;
    }

    public String getNumeroLote()
    {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote)
    {
        this.numeroLote = numeroLote;
    }

    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }
}