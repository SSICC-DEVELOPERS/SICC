package es.indra.sicc.dtos.dto;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOSCargarPaginaCrearMatrizDTO extends DTOAuditableSICC  {

    private RecordSet marca;
    private RecordSet canal;
    private RecordSet acceso;
    private RecordSet subacceso;
    private RecordSet tipoCliente;
    private RecordSet subtipoCliente;    
    private RecordSet tipoClasificacion;
    private RecordSet subtipoClasificacion;
    private RecordSet parametros;
    
    public DTOSCargarPaginaCrearMatrizDTO() {
    }

    public RecordSet getAcceso() {
        return acceso;
    }

    public void setAcceso(RecordSet newAcceso) {
        acceso = newAcceso;
    }

    public RecordSet getCanal() {
        return canal;
    }

    public void setCanal(RecordSet newCanal) {
        canal = newCanal;
    }

    public RecordSet getMarca() {
        return marca;
    }

    public void setMarca(RecordSet newMarca) {
        marca = newMarca;
    }

    public RecordSet getParametros() {
        return parametros;
    }

    public void setParametros(RecordSet newParametros) {
        parametros = newParametros;
    }

    public RecordSet getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(RecordSet newSubacceso) {
        subacceso = newSubacceso;
    }

    public RecordSet getSubtipoClasificacion() {
        return subtipoClasificacion;
    }

    public void setSubtipoClasificacion(RecordSet newSubtipoClasificacion) {
        subtipoClasificacion = newSubtipoClasificacion;
    }

    public RecordSet getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(RecordSet newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

    public RecordSet getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(RecordSet newTipoClasificacion) {
        tipoClasificacion = newTipoClasificacion;
    }

    public RecordSet getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(RecordSet newTipoCliente) {
        tipoCliente = newTipoCliente;
    }
}