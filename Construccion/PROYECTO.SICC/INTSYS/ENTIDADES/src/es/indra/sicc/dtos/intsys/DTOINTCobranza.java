package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTOINTCobranza extends DTOBelcorp  {
    private String codigoZona;
    private BigDecimal montoDeudaPendiente;
    private BigDecimal totalCargosDirectos;
    private BigDecimal totalAjustesNotasCreditos;
    private BigDecimal totalDepuraciones;
    private BigDecimal abonosMonetarios21Dias;
    private BigDecimal abonosMonetarios31Dias;
    private BigDecimal abonosMonetarios42Dias;
    private BigDecimal abonosMonetarios63Dias;
    private BigDecimal abonosMonetariosMayores63Dias;
    private String codigoPais;
    private Long oidCliente;
    private String codigoCliente;

    public DTOINTCobranza() {
    }





    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public BigDecimal getMontoDeudaPendiente() {
        return montoDeudaPendiente;
    }

    public void setMontoDeudaPendiente(BigDecimal montoDeudaPendiente) {
        this.montoDeudaPendiente = montoDeudaPendiente;
    }

    public BigDecimal getTotalCargosDirectos() {
        return totalCargosDirectos;
    }

    public void setTotalCargosDirectos(BigDecimal totalCargosDirectos) {
        this.totalCargosDirectos = totalCargosDirectos;
    }

    public BigDecimal getTotalAjustesNotasCreditos() {
        return totalAjustesNotasCreditos;
    }

    public void setTotalAjustesNotasCreditos(BigDecimal totalAjustesNotasCreditos) {
        this.totalAjustesNotasCreditos = totalAjustesNotasCreditos;
    }

    public BigDecimal getTotalDepuraciones() {
        return totalDepuraciones;
    }

    public void setTotalDepuraciones(BigDecimal totalDepuraciones) {
        this.totalDepuraciones = totalDepuraciones;
    }

    public BigDecimal getAbonosMonetarios21Dias() {
        return abonosMonetarios21Dias;
    }

    public void setAbonosMonetarios21Dias(BigDecimal abonosMonetarios21Dias) {
        this.abonosMonetarios21Dias = abonosMonetarios21Dias;
    }

    public BigDecimal getAbonosMonetarios31Dias() {
        return abonosMonetarios31Dias;
    }

    public void setAbonosMonetarios31Dias(BigDecimal abonosMonetarios31Dias) {
        this.abonosMonetarios31Dias = abonosMonetarios31Dias;
    }

    public BigDecimal getAbonosMonetarios42Dias() {
        return abonosMonetarios42Dias;
    }

    public void setAbonosMonetarios42Dias(BigDecimal abonosMonetarios42Dias) {
        this.abonosMonetarios42Dias = abonosMonetarios42Dias;
    }

    public BigDecimal getAbonosMonetarios63Dias() {
        return abonosMonetarios63Dias;
    }

    public void setAbonosMonetarios63Dias(BigDecimal abonosMonetarios63Dias) {
        this.abonosMonetarios63Dias = abonosMonetarios63Dias;
    }

    public BigDecimal getAbonosMonetariosMayores63Dias() {
        return abonosMonetariosMayores63Dias;
    }

    public void setAbonosMonetariosMayores63Dias(BigDecimal abonosMonetariosMayores63Dias) {
        this.abonosMonetariosMayores63Dias = abonosMonetariosMayores63Dias;
    }

    public String getCodigoPais() {
        return codigoPais;
    }

    public void setCodigoPais(String codigoPais) {
        this.codigoPais = codigoPais;
    }

    public Long getOidCliente() {
        return oidCliente;
    }

    public void setOidCliente(Long oidCliente) {
        this.oidCliente = oidCliente;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }
}