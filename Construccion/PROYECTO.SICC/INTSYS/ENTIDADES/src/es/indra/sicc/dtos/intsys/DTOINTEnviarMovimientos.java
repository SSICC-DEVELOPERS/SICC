package es.indra.sicc.dtos.intsys;
import es.indra.sicc.cmn.negocio.interfaces.comun.InterfazInfo;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOINTEnviarMovimientos extends DTOBelcorp  {
    public DTOINTEnviarMovimientos() {
    }
    private Long canal;
    private Long acceso;
    private ArrayList subaccesos;
    private String numeroLote;
    private String observaciones;
    private InterfazInfo interfaz;
    private ArrayList tipoMovimientos;
    
    public ArrayList getTipoMovimientos() {
        return this.tipoMovimientos;
    }
    
    public void setTipoMovimientos(ArrayList newTipoMovimientos) {
        this.tipoMovimientos = newTipoMovimientos;
    }    

    public Long getAcceso() {
        return acceso;
    }

    public void setAcceso(Long acceso) {
        this.acceso = acceso;
    }

    public Long getCanal() {
        return canal;
    }

    public void setCanal(Long canal) {
        this.canal = canal;
    }

    public InterfazInfo getInterfaz() {
        return interfaz;
    }

    public void setInterfaz(InterfazInfo interfaz) {
        this.interfaz = interfaz;
    }

    public String getNumeroLote() {
        return numeroLote;
    }

    public void setNumeroLote(String numeroLote) {
        this.numeroLote = numeroLote;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public ArrayList getSubaccesos() {
        return this.subaccesos;
    }

    public void setSubaccesos(ArrayList newSubaccesos) {
        this.subaccesos = newSubaccesos;
    }    
}