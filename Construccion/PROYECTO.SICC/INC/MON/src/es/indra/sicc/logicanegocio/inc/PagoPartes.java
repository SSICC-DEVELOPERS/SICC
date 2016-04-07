package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.math.BigDecimal;

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
public class PagoPartes implements Serializable {
    private Integer numeroPago;
    private BigDecimal porcentajePremio;
    private Periodo periodoControl;
    private Long oidGanadora;

    public PagoPartes() {  }
    
    public Long getOidGanadora() {
      return this.oidGanadora;
    }
    
    public void setOidGanadora(Long oidGanadora) {
      this.oidGanadora = oidGanadora;
    }

    public void setNumeroPago(Integer numeroPago) {
        this.numeroPago = numeroPago;
    }

    public Integer getNumeroPago() {
        return numeroPago;
    }

    public void setPeriodoControl(Periodo periodoControl) {
        this.periodoControl = periodoControl;
    }

    public Periodo getPeriodoControl() {
        return periodoControl;
    }

    public void setPorcentajePremio(BigDecimal porcentajePremio) {
        this.porcentajePremio = porcentajePremio;
    }

    public BigDecimal getPorcentajePremio() {
        return porcentajePremio;
    }
}
