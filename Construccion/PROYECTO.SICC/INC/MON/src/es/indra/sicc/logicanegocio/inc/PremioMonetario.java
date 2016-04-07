package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;

/**
 * <p>Copyright 2005 © por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * España<br>
 * <p>Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * @date 25/04/2005
 * @author Gustavo Viñales
 */
public class PremioMonetario
        extends Premio
        implements Serializable {
    private boolean pagoEnPartes;
    private boolean descontarPagosAnticipados;
    private Long oidFormaPago;
    private BigDecimal importePremio;
    private Long tipoPremioMonetario;
    private BigDecimal porcentajePago;
    private ArrayList pagosEnPartes;

    public PremioMonetario() {
        super();
    }

    public void setDescontarPagosAnticipados(boolean descontarPagosAnticipados) {
        this.descontarPagosAnticipados = descontarPagosAnticipados;
    }

    public boolean getDescontarPagosAnticipados() {
        return descontarPagosAnticipados;
    }

    public void setImportePremio(BigDecimal importePremio) {
        this.importePremio = importePremio;
    }

    public BigDecimal getImportePremio() {
        return importePremio;
    }

    public void setOidFormaPago(Long oidFormaPago) {
        this.oidFormaPago = oidFormaPago;
    }

    public Long getOidFormaPago() {
        return oidFormaPago;
    }

    public void setPorcentajePago(BigDecimal porcentajePago) {
        this.porcentajePago = porcentajePago;
    }

    public BigDecimal getPorcentajePago() {
        return porcentajePago;
    }

    public void setTipoPremioMonetario(Long tipoPremioMonetario) {
        this.tipoPremioMonetario = tipoPremioMonetario;
    }

    public Long getTipoPremioMonetario() {
        return tipoPremioMonetario;
    }

    public ArrayList getPagosEnPartes() {
        return pagosEnPartes;
    }

    public void setPagosEnPartes(ArrayList pagosEnPartes) {
        this.pagosEnPartes = pagosEnPartes;
    }

    public boolean getPagoEnPartes() {
        return pagoEnPartes;
    }

    public void setPagoEnPartes(boolean pagoEnPartes) {
        this.pagoEnPartes = pagoEnPartes;
    }
}
