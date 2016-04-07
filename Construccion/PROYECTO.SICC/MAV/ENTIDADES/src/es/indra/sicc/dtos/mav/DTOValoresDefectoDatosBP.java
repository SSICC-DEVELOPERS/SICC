package es.indra.sicc.dtos.mav;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOValoresDefectoDatosBP extends DTOBelcorp  {
    private Long oidActividad;
    private ArrayList valoresDefecto;

    public DTOValoresDefectoDatosBP() {
    }

    public Long getOidActividad() {
        return oidActividad;
    }

    public void setOidActividad(Long oidActividad) {
        this.oidActividad = oidActividad;
    }

    public ArrayList getValoresDefecto() {
        return valoresDefecto;
    }

    public void setValoresDefecto(ArrayList valoresDefecto) {
        this.valoresDefecto = valoresDefecto;
    }
}