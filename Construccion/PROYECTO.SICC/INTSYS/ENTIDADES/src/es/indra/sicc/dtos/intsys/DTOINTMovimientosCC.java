/**
* Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
* Avda. de Bruselas, 35
* Parque Empresarial Arroyo de la Vega
* 28108 Alcobendas, Madrid
* España
*
* Privado y Confidencial.
* La información contenida en este documento es propiedad de Indra sistemas.
* Para uso exclusivo de empleados autorizados no permitiéndose
* la distribución de este código sin permiso expreso.
*/
package es.indra.sicc.dtos.intsys;

import java.math.BigDecimal;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOINTMovimientosCC extends DTOBelcorp {
    
    private Long cliente;     
    private String codigoCliente;      
    private BigDecimal importePendiente;     
    /* mdolce
     * 21/06/2006
     * Se modifica el atributo numero identificador de cuota porque se le concateno
     * el VAL_EJER_CUOT y si lo dejo Integer pierde el 0 de adelante
     * */
    private String numeroIdentificadorCuota;     
    private String codigoTipoPeriodo;     
    private String codigoPeriodo;     
    private Date fechaDocumento;     
    private Date fechaVencimiento;     
    private String  medioPago;    
    private String referenciaNumeroDocumentoExterno;   
    
    public DTOINTMovimientosCC() {
        super();
    }

    public Long getCliente() {
        return cliente;
    }

    public void setCliente(Long cliente) {
        this.cliente = cliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoPeriodo() {
        return codigoPeriodo;
    }

    public void setCodigoPeriodo(String codigoPeriodo) {
        this.codigoPeriodo = codigoPeriodo;
    }

    public String getCodigoTipoPeriodo() {
        return codigoTipoPeriodo;
    }

    public void setCodigoTipoPeriodo(String codigoTipoPeriodo) {
        this.codigoTipoPeriodo = codigoTipoPeriodo;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public BigDecimal getImportePendiente() {
        return importePendiente;
    }

    public void setImportePendiente(BigDecimal importePendiente) {
        this.importePendiente = importePendiente;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getNumeroIdentificadorCuota() {
        return numeroIdentificadorCuota;
    }

    public void setNumeroIdentificadorCuota(String numeroIdentificadorCuota) {
        this.numeroIdentificadorCuota = numeroIdentificadorCuota;
    }

    public String getReferenciaNumeroDocumentoExterno() {
        return referenciaNumeroDocumentoExterno;
    }

    public void setReferenciaNumeroDocumentoExterno(String referenciaNumeroDocumentoExterno) {
        this.referenciaNumeroDocumentoExterno = referenciaNumeroDocumentoExterno;
    }
    
}