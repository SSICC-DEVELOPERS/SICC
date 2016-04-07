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
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTODatosServiciosPostVenta extends DTOBelcorp  {
    public DTODatosServiciosPostVenta() {
    }
    
    private String codCliente;
    private String codOperacion;
    private String codProducto;
    private Long indAtendido;
    private Long estadoOperacion;
    private BigDecimal importeAbono;
    private BigDecimal importeCargo;
    private String codPeriodo;
    private String codMotivoRechazo;
    private String codIVR;
    private String descripcionProducto;
    private Long numeroReclamo;

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getCodIVR() {
        return codIVR;
    }

    public void setCodIVR(String codIVR) {
        this.codIVR = codIVR;
    }

    public String getCodMotivoRechazo() {
        return codMotivoRechazo;
    }

    public void setCodMotivoRechazo(String codMotivoRechazo) {
        this.codMotivoRechazo = codMotivoRechazo;
    }

    public String getCodOperacion() {
        return codOperacion;
    }

    public void setCodOperacion(String codOperacion) {
        this.codOperacion = codOperacion;
    }

    public String getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getCodProducto() {
        return codProducto;
    }

    public void setCodProducto(String codProducto) {
        this.codProducto = codProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public Long getEstadoOperacion() {
        return estadoOperacion;
    }

    public void setEstadoOperacion(Long estadoOperacion) {
        this.estadoOperacion = estadoOperacion;
    }

    public BigDecimal getImporteAbono() {
        return importeAbono;
    }

    public void setImporteAbono(BigDecimal importeAbono) {
        this.importeAbono = importeAbono;
    }

    public BigDecimal getImporteCargo() {
        return importeCargo;
    }

    public void setImporteCargo(BigDecimal importeCargo) {
        this.importeCargo = importeCargo;
    }

    public Long getIndAtendido() {
        return indAtendido;
    }

    public void setIndAtendido(Long indAtendido) {
        this.indAtendido = indAtendido;
    }

    public Long getNumeroReclamo() {
        return numeroReclamo;
    }

    public void setNumeroReclamo(Long numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }
    
    
}