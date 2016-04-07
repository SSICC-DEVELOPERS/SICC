package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;

public class DTOPestanya4 extends DTOAuditableSICC  {

        private RecordSet tiposTarjeta;
        private RecordSet clasesTarjeta;
        private RecordSet bancos;
        private RecordSet marcas;
        private RecordSet canales;
        private RecordSet tiposClasificacion;
        private RecordSet clasificaciones;
        private RecordSet tiposProblema;
        private RecordSet tiposSolucion;
        private RecordSet marcasSeleccionadas;
		    private RecordSet tiposPerfiles;
        private RecordSet tipos;
        private RecordSet subtipos;

    public RecordSet getBancos() {
        return bancos;
    }

    public void setBancos(RecordSet newBancos) {
        bancos = newBancos;
    }

    public RecordSet getCanales() {
        return canales;
    }

    public void setCanales(RecordSet newCanales) {
        canales = newCanales;
    }

    public RecordSet getClasesTarjeta() {
        return clasesTarjeta;
    }

    public void setClasesTarjeta(RecordSet newClasesTarjeta) {
        clasesTarjeta = newClasesTarjeta;
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

    public RecordSet getMarcasSeleccionadas() {
        return marcasSeleccionadas;
    }

    public void setMarcasSeleccionadas(RecordSet newMarcasSeleccionadas) {
        marcasSeleccionadas = newMarcasSeleccionadas;
    }

    public RecordSet getTiposClasificacion() {
        return tiposClasificacion;
    }

    public void setTiposClasificacion(RecordSet newTiposClasificacion) {
        tiposClasificacion = newTiposClasificacion;
    }



    public RecordSet getTiposProblema() {
        return tiposProblema;
    }

    public void setTiposProblema(RecordSet newTiposProblema) {
        tiposProblema = newTiposProblema;
    }

    public RecordSet getTiposSolucion() {
        return tiposSolucion;
    }

    public void setTiposSolucion(RecordSet newTiposSolucion) {
        tiposSolucion = newTiposSolucion;
    }

    public RecordSet getTiposTarjeta() {
        return tiposTarjeta;
    }

    public void setTiposTarjeta(RecordSet newTiposTarjeta) {
        tiposTarjeta = newTiposTarjeta;
    }

    public RecordSet getTiposPerfiles() {
      return tiposPerfiles;
    }

    public void setTiposPerfiles(RecordSet newTiposPerfiles) {
      tiposPerfiles = newTiposPerfiles;
    }

    public RecordSet getTipos() {
      return tipos;
    }

    public void setTipos(RecordSet newTipos) {
      tipos = newTipos;
    }

    public RecordSet getSubtipos() {
      return subtipos;
    }

    public void setSubtipos(RecordSet newSubtipos) {
      subtipos = newSubtipos;
    }





}