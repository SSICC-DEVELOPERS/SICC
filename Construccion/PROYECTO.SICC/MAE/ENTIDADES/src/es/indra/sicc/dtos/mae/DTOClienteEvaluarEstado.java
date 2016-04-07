package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOClienteEvaluarEstado extends DTOSiccPaginacion {
    
    private Long oidCliente;
    private Long oidEstatusNuevo;               // Oid del nuevo Estatus Calculado
    private Long oidHistoricoEstatus;           // Oid del ultimo Historico de Estatus recuperado (o null si no tenia)
    private Long oidPeriodoInicioHistoEstatus;  // Oid del periodo inicio del ultimo Historico de Estatus recuperado (o null)
    private Long oidHistoricoEstatusNuevo;      // Oid del Historico de Estatus recien insertado (para luego insertar en Historico de Clasificaciones)
  
  
    public DTOClienteEvaluarEstado(Long oidCliente, Long oidEstatusNuevo) {
        this.oidCliente = oidCliente;
        this.oidEstatusNuevo = oidEstatusNuevo;
    }

    /*public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }*/

    public Long getOidCliente() {
        return oidCliente;
    }
    
    public void setOidEstatusNuevo(Long oidEstatusNuevo) {
        this.oidEstatusNuevo = oidEstatusNuevo;
    }

    public Long getOidEstatusNuevo() {
        return oidEstatusNuevo;
    }

    public void setOidHistoricoEstatus(Long oidHistoricoEstatus) {
        this.oidHistoricoEstatus = oidHistoricoEstatus;
    }

    public Long getOidHistoricoEstatus() {
        return oidHistoricoEstatus;
    }

    public void setOidPeriodoInicioHistoEstatus(Long oidPeriodoInicioHistoEstatus) {
        this.oidPeriodoInicioHistoEstatus = oidPeriodoInicioHistoEstatus;
    }

    public Long getOidPeriodoInicioHistoEstatus() {
        return oidPeriodoInicioHistoEstatus;
    }

    public void setOidHistoricoEstatusNuevo(Long oidHistoricoEstatusNuevo) {
        this.oidHistoricoEstatusNuevo = oidHistoricoEstatusNuevo;
    }

    public Long getOidHistoricoEstatusNuevo() {
        return oidHistoricoEstatusNuevo;
    }

}