package es.indra.sicc.dtos.mae;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPestanya3 extends DTOAuditableSICC  {

        private DTOPestanya3Base base;
        private RecordSet tiposComunicacion;
        private RecordSet tiposCliente;
        private Long[] oidClientesVinculo;
        private Long oidClienteContacto;
    // Agregado por SiCC20070433 - Rafael Romero - 24/09/2007
    // Se agregan metodos de acceso
    private Integer nivelValidacionTipoHijaDupla;
    private Long cteOidSubTipoHijaDupla;
    private Integer nivelValidacionEdadHijaDupla;

    public DTOPestanya3Base getBase() {
        return base;
    }

    public void setBase(DTOPestanya3Base newBase) {
        base = newBase;
    }

    public Long getOidClienteContacto() {
        return oidClienteContacto;
    }

    public void setOidClienteContacto(Long newOidClienteContacto) {
        oidClienteContacto = newOidClienteContacto;
    }

    public RecordSet getTiposCliente() {
        return tiposCliente;
    }

    public void setTiposCliente(RecordSet newTiposCliente) {
        tiposCliente = newTiposCliente;
    }

    public RecordSet getTiposComunicacion() {
        return tiposComunicacion;
    }

    public void setTiposComunicacion(RecordSet newTiposComunicacion) {
        tiposComunicacion = newTiposComunicacion;
    }

    public Long[] getOidClientesVinculo() {
        return oidClientesVinculo;
    }

    public void setOidClientesVinculo(Long[] newOidClientesVinculo) {
        oidClientesVinculo = newOidClientesVinculo;
    }

    public Integer getNivelValidacionTipoHijaDupla() {
        return nivelValidacionTipoHijaDupla;
    }

    public void setNivelValidacionTipoHijaDupla(Integer nivelValidacionTipoHijaDupla) {
        this.nivelValidacionTipoHijaDupla = nivelValidacionTipoHijaDupla;
    }

    public Long getCteOidSubTipoHijaDupla() {
        return cteOidSubTipoHijaDupla;
    }

    public void setCteOidSubTipoHijaDupla(Long cteOidSubTipoHijaDupla) {
        this.cteOidSubTipoHijaDupla = cteOidSubTipoHijaDupla;
    }

    public Integer getNivelValidacionEdadHijaDupla() {
        return nivelValidacionEdadHijaDupla;
    }

    public void setNivelValidacionEdadHijaDupla(Integer nivelValidacionEdadHijaDupla) {
        this.nivelValidacionEdadHijaDupla = nivelValidacionEdadHijaDupla;
    }


}