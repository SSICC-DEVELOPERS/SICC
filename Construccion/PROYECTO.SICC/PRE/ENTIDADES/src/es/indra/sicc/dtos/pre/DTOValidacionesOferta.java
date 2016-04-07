package es.indra.sicc.dtos.pre;

import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;

import java.math.BigDecimal;

 // sapaza -- PER-SiCC-2014-0580 -- 17/09/2014
public class DTOValidacionesOferta extends DTOAuditableSICC {
    
    private Long oidTipoOferta;
    private String codigoProducto;
    private Long oidEstrategia;
    private BigDecimal precioCatalogo;
    private BigDecimal precioPosicionamiento;

    public void setOidTipoOferta(Long oidTipoOferta) {
        this.oidTipoOferta = oidTipoOferta;
    }

    public Long getOidTipoOferta() {
        return oidTipoOferta;
    }

    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getCodigoProducto() {
        return codigoProducto;
    }

    public void setOidEstrategia(Long oidEstrategia) {
        this.oidEstrategia = oidEstrategia;
    }

    public Long getOidEstrategia() {
        return oidEstrategia;
    }

    public void setPrecioCatalogo(BigDecimal precioCatalogo) {
        this.precioCatalogo = precioCatalogo;
    }

    public BigDecimal getPrecioCatalogo() {
        return precioCatalogo;
    }

    public void setPrecioPosicionamiento(BigDecimal precioPosicionamiento) {
        this.precioPosicionamiento = precioPosicionamiento;
    }

    public BigDecimal getPrecioPosicionamiento() {
        return precioPosicionamiento;
    }
}
