package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOINTInfoCampania extends DTOBelcorp  {
    private BigDecimal montoMinimo;
    private Long numeroClientes;
    private Long numeroPedidos;
    private Long numeroOrdenesCompra;
    private BigDecimal tipoCambio;
    private String codigoEmpresa;

    public DTOINTInfoCampania() {
    }

    public BigDecimal getMontoMinimo() {
        return montoMinimo;
    }

    public void setMontoMinimo(BigDecimal montoMinimo) {
        this.montoMinimo = montoMinimo;
    }

    public Long getNumeroClientes() {
        return numeroClientes;
    }

    public void setNumeroClientes(Long numeroClientes) {
        this.numeroClientes = numeroClientes;
    }

    public Long getNumeroPedidos() {
        return numeroPedidos;
    }

    public void setNumeroPedidos(Long numeroPedidos) {
        this.numeroPedidos = numeroPedidos;
    }

    public Long getNumeroOrdenesCompra() {
        return numeroOrdenesCompra;
    }

    public void setNumeroOrdenesCompra(Long numeroOrdenesCompra) {
        this.numeroOrdenesCompra = numeroOrdenesCompra;
    }

    public BigDecimal getTipoCambio() {
        return tipoCambio;
    }

    public void setTipoCambio(BigDecimal tipoCambio) {
        this.tipoCambio = tipoCambio;
    }

    public String getCodigoEmpresa() {
        return codigoEmpresa;
    }

    public void setCodigoEmpresa(String codigoEmpresa) {
        this.codigoEmpresa = codigoEmpresa;
    }
}