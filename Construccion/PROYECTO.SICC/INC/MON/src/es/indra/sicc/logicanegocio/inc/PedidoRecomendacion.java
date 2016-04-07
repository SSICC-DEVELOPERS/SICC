package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.<br>
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 25/04/2005
 * @author Gustavo Viñales
 */
public class PedidoRecomendacion implements Serializable {
    private BigDecimal montoPedido;
    private Long unidadesPedido;
    private boolean valido;
    
    // sapaza -- PER-SiCC-2013-0044 -- 28/01/2013
    private Integer secuencia;
    
    //jrivas 8/9/2006 Inc. Aceptacion (F3 Inc. 5)
    private Periodo periodo;
    
    // sapaza -- PER-SiCC-2012-0712 -- 06/05/2013
    private BigDecimal montoRetail;

    public PedidoRecomendacion() {
        valido = true;
    }

    public void setMontoPedido(BigDecimal montoPedido) {
        this.montoPedido = montoPedido;
    }

    public BigDecimal getMontoPedido() {
        return montoPedido;
    }

    public void setUnidadesPedido(Long unidadesPedido) {
        this.unidadesPedido = unidadesPedido;
    }

    public Long getUnidadesPedido() {
        return unidadesPedido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public boolean getValido() {
        return valido;
    }

    public Periodo getPeriodo()
    {
        return periodo;
    }

    public void setPeriodo(Periodo periodo)
    {
        this.periodo = periodo;
    }

    public void setSecuencia(Integer secuencia) {
        this.secuencia = secuencia;
    }

    public Integer getSecuencia() {
        return secuencia;
    }

    public void setMontoRetail(BigDecimal montoRetail) {
        this.montoRetail = montoRetail;
    }

    public BigDecimal getMontoRetail() {
        return montoRetail;
    }
}
