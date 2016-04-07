package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTOINTCliente extends DTOBelcorp  {
    private Long oidCliente;
    private String codigoCliente;
    private Long codigoTerritorio;

    public DTOINTCliente() {
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

    public Long getCodigoTerritorio() {
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(Long codigoTerritorio) {
        this.codigoTerritorio = codigoTerritorio;
    }
}