package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.beans.PropertyChangeSupport;
import java.beans.PropertyChangeListener;

public class DTOBusquedaRapidaCliente extends DTOSiccPaginacion  {
    public DTOBusquedaRapidaCliente() {
    }
    public String codigoCliente;
    public String nombre1;
    public String nombre2;
    public String apellido1;
    public String apellido2;
    public String documentoIdentidad;
    public String criterioBusqueda1;
    public String criterioBusqueda2;

    public String getApellido1() {
        return apellido1;
    }



    public void setApellido1(String newApellido1) {
        apellido1 = newApellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String newApellido2) {
        apellido2 = newApellido2;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }

    public String getCriterioBusqueda1() {
        return criterioBusqueda1;
    }

    public void setCriterioBusqueda1(String newCriterioBusqueda1) {
        criterioBusqueda1 = newCriterioBusqueda1;
    }

    public String getCriterioBusqueda2() {
        return criterioBusqueda2;
    }

    public void setCriterioBusqueda2(String newCriterioBusqueda2) {
        criterioBusqueda2 = newCriterioBusqueda2;
    }

    public String getDocumentoIdentidad() {
        return documentoIdentidad;
    }

    public void setDocumentoIdentidad(String newDocumentoIdentidad) {
        documentoIdentidad = newDocumentoIdentidad;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String newNombre1) {
        nombre1 = newNombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String newNombre2) {
        nombre2 = newNombre2;
    }
    
    
}