package es.indra.sicc.dtos.ape;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTODatosTextoVariable extends DTOSiccPaginacion {
    private Long oidTipoCliente;
    private Long oidSubtipoCliente;
    private Long oidTipoClasificacion;
    private Long oidClasificacion;
    private Long oidConfiguracionTextoVariable;
    private String textoVariable;

    public DTODatosTextoVariable()  {  }
    
    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }
    
    public Long getOidTipoCliente() {
        return this.oidTipoCliente;
    }
    
    public void setOidSubtipoCliente(Long oidSubtipoCliente) {
        this.oidSubtipoCliente = oidSubtipoCliente;
    }
    
    public Long getOidSubtipoCliente() {
        return this.oidSubtipoCliente;
    }
    
    public void setOidTipoClasificacion(Long oidTipoClasificacion) {
        this.oidTipoClasificacion = oidTipoClasificacion;
    }
    
    public Long getOidTipoClasificacion() {
        return this.oidTipoClasificacion;
    }
    
    public void setOidClasificacion(Long oidClasificacion) {
        this.oidClasificacion = oidClasificacion;
    }
    
    public Long getOidClasificacion() {
        return this.oidClasificacion;
    }
    
    public void setOidConfiguracionTextoVariable(Long oidConfiguracionTextoVariable) {
        this.oidConfiguracionTextoVariable = oidConfiguracionTextoVariable;
    }
    
    public Long getOidConfiguracionTextoVariable()  {
        return this.oidConfiguracionTextoVariable;
    }
    
    public void setTextoVariable(String textoVariable) {
        this.textoVariable = textoVariable;
    }    
    
    public String getTextoVariable() {
        return this.textoVariable;
    }
}