package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

public class DTOComisionProducto extends DTOAuditableSICC  {
    private String incluidoExcluido;
    private Long oidMarca;
    private Long oidUnidadNegocio;
    private Long oidNegocio;
    private Long oidGenerico;
    private Long oidSuperGenerico;
    private Long oidProducto;
    private Long oidCanal;
    private Long oidTipoOferta;
    private Long oidCicloVida;

    public DTOComisionProducto() {
    }


    public void setIncluidoExcluido(String incluidoExcluido) {
        this.incluidoExcluido = incluidoExcluido;
    }


    public String getIncluidoExcluido() {
        return incluidoExcluido;
    }


    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }


    public Long getOidMarca() {
        return oidMarca;
    }


    public void setOidUnidadNegocio(Long oidUnidadNegocio) {
        this.oidUnidadNegocio = oidUnidadNegocio;
    }


    public Long getOidUnidadNegocio() {
        return oidUnidadNegocio;
    }


    public void setOidNegocio(Long oidNegocio) {
        this.oidNegocio = oidNegocio;
    }


    public Long getOidNegocio() {
        return oidNegocio;
    }


    public void setOidGenerico(Long oidGenerico) {
        this.oidGenerico = oidGenerico;
    }


    public Long getOidGenerico() {
        return oidGenerico;
    }


    public void setOidSuperGenerico(Long oidSuperGenerico) {
        this.oidSuperGenerico = oidSuperGenerico;
    }


    public Long getOidSuperGenerico() {
        return oidSuperGenerico;
    }


    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }


    public Long getOidProducto() {
        return oidProducto;
    }


    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }


    public Long getOidCanal() {
        return oidCanal;
    }


    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }


    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }


    public void setOidCicloVida(Long oidCicloVida) {
        this.oidCicloVida = oidCicloVida;
    }


    public Long getOidCicloVida() {
        return oidCicloVida;
    }
}