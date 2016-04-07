package es.indra.sicc.logicanegocio.inc;

import java.io.Serializable;

import java.math.BigDecimal;

/**
 * <p>Copyright 2005 � por Indra Sistemas,S.A - Todos los derechos reservados.<br>
 * Avda. de Bruselas, 35<br>
 * Parque Empresarial Arroyo de la Vega<br>
 * 28108 Alcobendas, Madrid<br>
 * Espa�a<br>
 * <p>Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * @date 26/04/2005
 * @author Gustavo Vi�ales
 */
public class PremioPuntos
        extends Premio
        implements Serializable {
    private Long oidTipoPremioPuntos;
    private Long oidConcursoDestino;
    private BigDecimal porcentajePago;
    private BigDecimal importePremio;

    public PremioPuntos() {
        super();
    }

    public void setOidTipoPremioPuntos(Long oidTipoPremioPuntos) {
        this.oidTipoPremioPuntos = oidTipoPremioPuntos;
    }

    public Long getOidTipoPremioPuntos() {
        return oidTipoPremioPuntos;
    }

    public void setOidConcursoDestino(Long oidConcursoDestino) {
        this.oidConcursoDestino = oidConcursoDestino;
    }

    public Long getOidConcursoDestino() {
        return oidConcursoDestino;
    }

    // Modificado por Sergio Platas - 24/05/2005

    // Modificado por Sergio Platas - 24/05/2005

    public BigDecimal getPorcentajePago() {
        return porcentajePago;
    }

    public void setPorcentajePago(BigDecimal porcentajePago) {
        this.porcentajePago = porcentajePago;
    }

    public BigDecimal getImportePremio() {
        return importePremio;
    }

    public void setImportePremio(BigDecimal importePremio) {
        this.importePremio = importePremio;
    }
}
