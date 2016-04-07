package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOConsultaImpuestoUBIGEO  extends DTOAuditableSICC  {
    private String producto;
    private String impuesto;
    private Long oidImpuesto;
    private String canal;
    private String acceso;
    private String subacceso;

    public DTOConsultaImpuestoUBIGEO() {
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String newProducto) {
        producto = newProducto;
    }
   
    public String getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(String newImpuesto) {
        impuesto = newImpuesto;
    }

    public Long getOidImpuesto() {
        return oidImpuesto;
    }

    public void setOidImpuesto(Long newOidImpuesto) {
        oidImpuesto = newOidImpuesto;
    }

    public String getCanal() {
        return canal;
    }

    public void setCanal(String newCanal) {
        canal = newCanal;
    }

    public String getAcceso() {
        return acceso;
    }

    public void setAcceso(String newAcceso) {
        acceso = newAcceso;
    }

    public String getSubacceso() {
        return subacceso;
    }

    public void setSubacceso(String newSubacceso) {
        subacceso = newSubacceso;
    }
}