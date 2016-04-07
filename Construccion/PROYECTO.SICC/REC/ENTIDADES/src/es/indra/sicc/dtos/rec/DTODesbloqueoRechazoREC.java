package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTODesbloqueoRechazoREC extends DTOBelcorp  {

    private ArrayList oids;     
    private ArrayList oidsOperacion;   //BELC300014319
    private Long oidMotivo;   

    public DTODesbloqueoRechazoREC() {
    }

    public Long getOidMotivo() {
        return oidMotivo;
    }

    public void setOidMotivo(Long oidMotivo) {
        this.oidMotivo = oidMotivo;
    }

    public ArrayList getOids() {
        return oids;
    }

    public void setOids(ArrayList oids) {
        this.oids = oids;
    }

    public ArrayList getOidsOperacion() {
        return oidsOperacion;
    }

    public void setOidsOperacion(ArrayList oidsOperacion) {
        this.oidsOperacion = oidsOperacion;
    }
}