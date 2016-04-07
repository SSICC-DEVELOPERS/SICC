package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOSecuenciacionClienteAPP extends DTOBelcorp  {
    private String codigoPais;
    private String codigoCliente;
    private String codigoZona;
    private String codigoSecuencia;

    public DTOSecuenciacionClienteAPP() {
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getCodigoSecuencia() {
        return codigoSecuencia;
    }

    public void setCodigoSecuencia(String codigoSecuencia) {
        this.codigoSecuencia = codigoSecuencia;
    }
}