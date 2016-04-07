package es.indra.sicc.dtos.zon;

import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;

public class DTOBuscarUA extends DTOSiccPaginacion  {
    private Long oidMarca;
    private Long oidCanal;
    private Integer indUA;
    
    //splatas - DBLG400001087 - 27/04/2006
    private String codZona;

    public DTOBuscarUA() {
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Integer getIndUA() {
        return indUA;
    }

    public void setIndUA(Integer indUA) {
        this.indUA = indUA;
    }

    public String getCodZona() {
        return codZona;
    }

    public void setCodZona(String codZona) {
        this.codZona = codZona;
    }
}