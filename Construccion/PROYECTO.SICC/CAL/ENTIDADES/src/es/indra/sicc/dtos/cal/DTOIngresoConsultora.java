package es.indra.sicc.dtos.cal;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOIngresoConsultora extends DTOSiccPaginacion {
    private Long oidMarca;
    private Long oidCanal;
    private Long oidCliente;
    
    public DTOIngresoConsultora() {}
    
    public Long getOidMarca() {
        return this.oidMarca;
    }
    
    public void setOidMarca(Long newOidMarca) {
        this.oidMarca = newOidMarca;
    }
     
    public Long getOidCanal() {
        return this.oidCanal;
    }
    
    public void setOidCanal(Long newOidCanal) {
        this.oidCanal = newOidCanal;
    }
    
    public Long getOidCliente() {
        return this.oidCliente;
    }
    
    public void setOidCliente(Long newOidCliente) {
        this.oidCliente = newOidCliente;
    }

  
}