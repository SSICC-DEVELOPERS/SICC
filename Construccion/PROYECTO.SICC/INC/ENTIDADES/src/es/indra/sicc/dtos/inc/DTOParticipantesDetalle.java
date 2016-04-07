package es.indra.sicc.dtos.inc;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOParticipantesDetalle extends DTOSiccPaginacion {    
    private Long oid;
    private Long oidCabecera;
    private Long tipoCliente;
    private Long subtipoCliente;
    private Long tipoClasificacion;
    private Long clasificacion;
    private String descripcion; // BELC300022456
    
    
    public DTOParticipantesDetalle () { }
    
    public Long getOid() {
        return this.oid;
    }
    
    public void setOid(Long oid) {
        this.oid = oid;
    }
    
    public Long getOidCabecera() {
        return this.oidCabecera;
    }
    
    public void setOidCabecera(Long oidCabecera) {
        this.oidCabecera = oidCabecera;
    }
    
    public Long getTipoCliente() {
        return this.tipoCliente;
    }
    
    public void setTipoCliente(Long tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public Long getSubtipoCliente() {
        return this.subtipoCliente;
    }
    
    public void setSubtipoCliente(Long subtipoCliente) {
        this.subtipoCliente = subtipoCliente;
    }
    
    public Long getTipoClasificacion() {
        return this.tipoClasificacion;
    }
    
    public void setTipoClasificacion(Long tipoClasificacion) {
        this.tipoClasificacion = tipoClasificacion;
    }
    
    public Long getClasificacion() {
        return this.clasificacion;
    }
    
    public void setClasificacion(Long clasificacion) {
        this.clasificacion = clasificacion;
    }  


  public void setDescripcion(String descripcion)
  {
    this.descripcion = descripcion;
  }


  public String getDescripcion()
  {
    return descripcion;
  }
}