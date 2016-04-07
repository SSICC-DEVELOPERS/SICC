package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODetalleFlete extends DTOSiccPaginacion  {
    Long oidSubtipoCliente;
    Long oidTipoClasificacion;
    Long oidClasificacion;
    Long oid;
    String subtipoCliente;
    String tipoClasificacion;
    String clasificacion;

    public DTODetalleFlete() {
    }

    public Long getOidSubtipoCliente() {
        return oidSubtipoCliente;
    }

    public void setOidSubtipoCliente(Long newOidSubtipoCliente) {
        oidSubtipoCliente = newOidSubtipoCliente;
    }

    public Long getOidTipoClasificacion() {
        return oidTipoClasificacion;
    }

    public void setOidTipoClasificacion(Long newOidTipoClasificacion) {
        oidTipoClasificacion = newOidTipoClasificacion;
    }

    public Long getOidClasificacion() {
        return oidClasificacion;
    }

    public void setOidClasificacion(Long newOidClasificacion) {
        oidClasificacion = newOidClasificacion;
    }

    public Long getOid() {
        return oid;
    }

    public void setOid(Long newOid) {
        oid = newOid;
    }

    public String getSubtipoCliente() {
        return subtipoCliente;
    }

    public void setSubtipoCliente(String newSubtipoCliente) {
        subtipoCliente = newSubtipoCliente;
    }

    public String getTipoClasificacion() {
        return tipoClasificacion;
    }

    public void setTipoClasificacion(String newTipoClasificacion) {
        tipoClasificacion = newTipoClasificacion;
    }

    public String getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(String newClasificacion) {
        clasificacion = newClasificacion;
    }
}