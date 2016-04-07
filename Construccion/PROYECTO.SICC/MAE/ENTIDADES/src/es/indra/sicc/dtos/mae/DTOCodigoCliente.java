package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOCodigoCliente extends DTOAuditableSICC  {

    private String codigoCliente;
    
    //  Agregado para incidencia Sicc20070184
    private Long oidTipoCliente;
    private Long oidSubTipoCliente;
    //  Agregado por cambio Sicc20070361
    private Integer edad;
      
    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String newCodigoCliente) {
        codigoCliente = newCodigoCliente;
    }


    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }


    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }


    public void setOidSubTipoCliente(Long oidSubTipoCliente) {
        this.oidSubTipoCliente = oidSubTipoCliente;
    }


    public Long getOidSubTipoCliente() {
        return oidSubTipoCliente;
    }


    public void setEdad(Integer edad) {
        this.edad = edad;
    }


    public Integer getEdad() {
        return edad;
    }

}