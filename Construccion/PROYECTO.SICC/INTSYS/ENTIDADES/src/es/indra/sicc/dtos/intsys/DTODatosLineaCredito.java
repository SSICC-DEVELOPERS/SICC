package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTODatosLineaCredito extends DTOBelcorp  {
    private Long oidCliente;
    private String codCliente;
    private String nivelRiesgo;
    private BigDecimal lineaCredito;

    public DTODatosLineaCredito() {
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(String codCliente) {
        this.codCliente = codCliente;
    }

    public String getNivelRiesgo() {
        return nivelRiesgo;
    }

    public void setNivelRiesgo(String nivelRiesgo) {
        this.nivelRiesgo = nivelRiesgo;
    }

    public BigDecimal getLineaCredito() {
        return lineaCredito;
    }

    public void setLineaCredito(BigDecimal lineaCredito) {
        this.lineaCredito = lineaCredito;
    }
}