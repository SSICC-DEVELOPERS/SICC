package es.indra.sicc.dtos.fac;

import es.indra.sicc.util.DTOBelcorp;

public class DTOUnidAdimClienteHelper extends DTOBelcorp {
    private String codigoRegion;
    private String codigoZona;
    private String codigoSeccion;
    private String codigoTerritorio;

    public DTOUnidAdimClienteHelper(){
    }

    public String getCodigoRegion(){
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion){
        this.codigoRegion = codigoRegion;
    }

    public String getCodigoZona() {
        return codigoZona;
    }

    public void setCodigoZona(String codigoZona) {
        this.codigoZona = codigoZona;
    }

    public String getCodigoSeccion() {
        return codigoSeccion;
    }

    public void setCodigoSeccion(String codigoSeccion) {
        this.codigoSeccion = codigoSeccion;
    }

    public String getCodigoTerritorio(){
        return codigoTerritorio;
    }

    public void setCodigoTerritorio(String codigoTerritorio){
        this.codigoTerritorio = codigoTerritorio;
    }
}