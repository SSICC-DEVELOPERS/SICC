package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTDocumentoIdendidad  extends DTOBelcorp {

    private String codigoCliente;
    private String numeroDocumentoIdentidad;
    private String codigoUnidadGeografica1;
    private String codigoUnidadGeografica2;
    private String codigoUnidadGeografica3;
    private String descripcionUnidadGeografica1;
    private String descripcionUnidadGeografica2;
    private String descripcionUnidadGeografica3;
    private String telefono;

    public DTOINTDocumentoIdendidad() {
    }


    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }


    public String getCodigoCliente() {
        return codigoCliente;
    }


    public void setNumeroDocumentoIdentidad(String numeroDocumentoIdentidad) {
        this.numeroDocumentoIdentidad = numeroDocumentoIdentidad;
    }


    public String getNumeroDocumentoIdentidad() {
        return numeroDocumentoIdentidad;
    }


    public void setCodigoUnidadGeografica1(String codigoUnidadGeografica1) {
        this.codigoUnidadGeografica1 = codigoUnidadGeografica1;
    }


    public String getCodigoUnidadGeografica1() {
        return codigoUnidadGeografica1;
    }


    public void setCodigoUnidadGeografica2(String codigoUnidadGeografica2) {
        this.codigoUnidadGeografica2 = codigoUnidadGeografica2;
    }


    public String getCodigoUnidadGeografica2() {
        return codigoUnidadGeografica2;
    }


    public void setCodigoUnidadGeografica3(String codigoUnidadGeografica3) {
        this.codigoUnidadGeografica3 = codigoUnidadGeografica3;
    }


    public String getCodigoUnidadGeografica3() {
        return codigoUnidadGeografica3;
    }


    public void setDescripcionUnidadGeografica1(String descripcionUnidadGeografica1) {
        this.descripcionUnidadGeografica1 = descripcionUnidadGeografica1;
    }


    public String getDescripcionUnidadGeografica1() {
        return descripcionUnidadGeografica1;
    }


    public void setDescripcionUnidadGeografica2(String descripcionUnidadGeografica2) {
        this.descripcionUnidadGeografica2 = descripcionUnidadGeografica2;
    }


    public String getDescripcionUnidadGeografica2() {
        return descripcionUnidadGeografica2;
    }


    public void setDescripcionUnidadGeografica3(String descripcionUnidadGeografica3) {
        this.descripcionUnidadGeografica3 = descripcionUnidadGeografica3;
    }


    public String getDescripcionUnidadGeografica3() {
        return descripcionUnidadGeografica3;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


    public String getTelefono() {
        return telefono;
    }
}