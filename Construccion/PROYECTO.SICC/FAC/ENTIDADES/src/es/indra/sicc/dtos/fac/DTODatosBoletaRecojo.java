package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTODatosBoletaRecojo extends DTOBelcorp {
    
    private String numeroBoleta;
    private String descripcionRecojo;
    private String codigoOperacion;
    private Long numeroReclamo;
    private String codigoTerritorial;

    public DTODatosBoletaRecojo() {
        super();
    }

    public String getNumeroBoleta() {
        return numeroBoleta;
    }

    public void setNumeroBoleta(String numeroBoleta) {
        this.numeroBoleta = numeroBoleta;
    }

    public String getDescripcionRecojo() {
        return descripcionRecojo;
    }

    public void setDescripcionRecojo(String descripcionRecojo) {
        this.descripcionRecojo = descripcionRecojo;
    }

    public String getCodigoOperacion() {
        return codigoOperacion;
    }

    public void setCodigoOperacion(String codigoOperacion) {
        this.codigoOperacion = codigoOperacion;
    }

    public Long getNumeroReclamo() {
        return numeroReclamo;
    }

    public void setNumeroReclamo(Long numeroReclamo) {
        this.numeroReclamo = numeroReclamo;
    }

    public String getCodigoTerritorial() {
        return codigoTerritorial;
    }

    public void setCodigoTerritorial(String codigoTerritorial) {
        this.codigoTerritorial = codigoTerritorial;
    }
    
    
}