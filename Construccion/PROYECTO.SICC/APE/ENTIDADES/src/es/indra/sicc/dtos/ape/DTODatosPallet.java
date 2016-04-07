package es.indra.sicc.dtos.ape;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

/**
 * @author Rafael Romero
 * @date 22/03/2007
 */
public class DTODatosPallet extends DTOBelcorp {

    private Long oid;
    private Long anaquel;
    private Long unidadesProducto;
    private Long numeroPallet;
    private String codigoProducto;
    private String descripcionProdu;
    private Long codigoPosicion;
    private BigDecimal valorLinea;
    private String indicadorImpresion;
    private String nombrePicador;
    private Long unidadesPicadas;
    private Long unidadesChequeadas;
    private String nombreChequeador;
    private Long oidCabecera;
    private Long oidTipoCajaEmbalaje;
    private Long oidMapaCentroDistribucionDetalle;
    private Long oidSistemaPicado;
    private Long oidProducto;

    public DTODatosPallet() {
    
    }

    public void setOid(Long oid) {
        this.oid = oid;
    }


    public Long getOid() {
        return oid;
    }


    public void setCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
    }


    public String getCodigoProducto() {
        return codigoProducto;
    }


    public void setDescripcionProdu(String descripcionProdu) {
        this.descripcionProdu = descripcionProdu;
    }


    public String getDescripcionProdu() {
        return descripcionProdu;
    }


    public void setAnaquel(Long anaquel) {
        this.anaquel = anaquel;
    }


    public Long getAnaquel() {
        return anaquel;
    }


    public void setUnidadesProducto(Long unidadesProducto) {
        this.unidadesProducto = unidadesProducto;
    }


    public Long getUnidadesProducto() {
        return unidadesProducto;
    }


    public void setNumeroPallet(Long numeroPallet) {
        this.numeroPallet = numeroPallet;
    }


    public Long getNumeroPallet() {
        return numeroPallet;
    }

    public Long getCodigoPosicion() {
        return codigoPosicion;
    }

    public void setCodigoPosicion(Long codigoPosicion) {
        this.codigoPosicion = codigoPosicion;
    }

    public BigDecimal getValorLinea() {
        return valorLinea;
    }

    public void setValorLinea(BigDecimal valorLinea) {
        this.valorLinea = valorLinea;
    }

    public String getIndicadorImpresion() {
        return indicadorImpresion;
    }

    public void setIndicadorImpresion(String indicadorImpresion) {
        this.indicadorImpresion = indicadorImpresion;
    }

    public String getNombrePicador() {
        return nombrePicador;
    }

    public void setNombrePicador(String nombrePicador) {
        this.nombrePicador = nombrePicador;
    }

    public Long getUnidadesPicadas() {
        return unidadesPicadas;
    }

    public void setUnidadesPicadas(Long unidadesPicadas) {
        this.unidadesPicadas = unidadesPicadas;
    }

    public Long getUnidadesChequeadas() {
        return unidadesChequeadas;
    }

    public void setUnidadesChequeadas(Long unidadesChequeadas) {
        this.unidadesChequeadas = unidadesChequeadas;
    }

    public String getNombreChequeador() {
        return nombreChequeador;
    }

    public void setNombreChequeador(String nombreChequeador) {
        this.nombreChequeador = nombreChequeador;
    }

    public Long getOidCabecera() {
        return oidCabecera;
    }

    public void setOidCabecera(Long oidCabecera) {
        this.oidCabecera = oidCabecera;
    }

    public Long getOidTipoCajaEmbalaje() {
        return oidTipoCajaEmbalaje;
    }

    public void setOidTipoCajaEmbalaje(Long oidTipoCajaEmbalaje) {
        this.oidTipoCajaEmbalaje = oidTipoCajaEmbalaje;
    }

    public Long getOidMapaCentroDistribucionDetalle() {
        return oidMapaCentroDistribucionDetalle;
    }

    public void setOidMapaCentroDistribucionDetalle(Long oidMapaCentroDistribucionDetalle) {
        this.oidMapaCentroDistribucionDetalle = oidMapaCentroDistribucionDetalle;
    }

    public Long getOidSistemaPicado() {
        return oidSistemaPicado;
    }

    public void setOidSistemaPicado(Long oidSistemaPicado) {
        this.oidSistemaPicado = oidSistemaPicado;
    }

    public Long getOidProducto() {
        return oidProducto;
    }

    public void setOidProducto(Long oidProducto) {
        this.oidProducto = oidProducto;
    }
    
    
    
}