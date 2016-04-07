package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;


public class DTOPestanya3Base extends DTOAuditableSICC  {

        private RecordSet tiposDirecciones;
        private RecordSet tipoVia;
        private RecordSet marcas;
        private Boolean usaGeoreferenciador;
        private RecordSet tiposClasificacion;
        private RecordSet clasificaciones;
        private RecordSet canales;

    public RecordSet getCanales() {
        return canales;
    }

    public void setCanales(RecordSet newCanales) {
        canales = newCanales;
    }

    public RecordSet getClasificaciones() {
        return clasificaciones;
    }

    public void setClasificaciones(RecordSet newClasificaciones) {
        clasificaciones = newClasificaciones;
    }

    public RecordSet getMarcas() {
        return marcas;
    }

    public void setMarcas(RecordSet newMarcas) {
        marcas = newMarcas;
    }

    public RecordSet getTipoVia() {
        return tipoVia;
    }

    public void setTipoVia(RecordSet newTipoVia) {
        tipoVia = newTipoVia;
    }

    public RecordSet getTiposClasificacion() {
        return tiposClasificacion;
    }

    public void setTiposClasificacion(RecordSet newTiposClasificacion) {
        tiposClasificacion = newTiposClasificacion;
    }

    public RecordSet getTiposDirecciones() {
        return tiposDirecciones;
    }

    public void setTiposDirecciones(RecordSet newTiposDirecciones) {
        tiposDirecciones = newTiposDirecciones;
    }

    public Boolean getUsaGeoreferenciador() {
        return usaGeoreferenciador;
    }

    public void setUsaGeoreferenciador(Boolean newUsaGeoreferenciador) {
        usaGeoreferenciador = newUsaGeoreferenciador;
    }



}