package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosRegiones extends DTOBelcorp  {
    private String codigoRegion;
    private String descripcionRegion;

    public DTODatosRegiones() {
    }

    public String getCodigoRegion() {
        return codigoRegion;
    }

    public void setCodigoRegion(String codigoRegion) {
        this.codigoRegion = codigoRegion;
    }

    public String getDescripcionRegion() {
        return descripcionRegion;
    }

    public void setDescripcionRegion(String descripcionRegion) {
        this.descripcionRegion = descripcionRegion;
    }
}
