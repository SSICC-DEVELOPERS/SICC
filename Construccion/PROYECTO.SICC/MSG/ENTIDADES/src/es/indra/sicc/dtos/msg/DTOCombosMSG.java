package es.indra.sicc.dtos.msg;

import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;


public class DTOCombosMSG extends DTOAuditableSICC {
    private RecordSet mediosEnvio;
    private RecordSet tiposPeriodo;
    private RecordSet patrones;
    private RecordSet modulos;

    public DTOCombosMSG() {
    }

    public RecordSet getMediosEnvio() {
        return mediosEnvio;
    }

    public void setMediosEnvio(RecordSet newMediosEnvio) {
        mediosEnvio = newMediosEnvio;
    }

    public RecordSet getModulos() {
        return modulos;
    }

    public void setModulos(RecordSet newModulos) {
        modulos = newModulos;
    }

    public RecordSet getPatrones() {
        return patrones;
    }

    public void setPatrones(RecordSet newPatrones) {
        patrones = newPatrones;
    }

    public RecordSet getTiposPeriodo() {
        return tiposPeriodo;
    }

    public void setTiposPeriodo(RecordSet newTiposPeriodo) {
        tiposPeriodo = newTiposPeriodo;
    }
}
