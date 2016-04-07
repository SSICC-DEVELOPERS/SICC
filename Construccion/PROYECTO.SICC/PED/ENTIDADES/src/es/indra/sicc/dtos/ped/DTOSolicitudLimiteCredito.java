package es.indra.sicc.dtos.ped;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.math.BigDecimal;
import java.sql.Date;

public class DTOSolicitudLimiteCredito extends DTOAuditableSICC  {
    private Long oidSolicitud;
    private BigDecimal montoSolicitud;
    private Date fechaSolicitud;

    public DTOSolicitudLimiteCredito() {
    }

    public Long getOidSolicitud() {
        return oidSolicitud;
    }

    public void setOidSolicitud(Long newOidSolicitud) {
        oidSolicitud = newOidSolicitud;
    }

    public BigDecimal getMontoSolicitud() {
        return montoSolicitud;
    }

    public void setMontoSolicitud(BigDecimal newMontoSolicitud) {
        montoSolicitud = newMontoSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date newFechaSolicitud) {
        fechaSolicitud = newFechaSolicitud;
    }
}