package es.indra.sicc.dtos.ped;
import es.indra.sicc.util.DTOBelcorp;

public class DTOPEDBloqueosClientes extends DTOBelcorp  {
    private Boolean indicadorEjecMM;
    private Boolean indicadorEjecRN;
    private Integer nivelGravedadBloqueo;

    public DTOPEDBloqueosClientes() {
    }

    public Boolean getIndicadorEjecMM() {
        return indicadorEjecMM;
    }

    public void setIndicadorEjecMM(Boolean indicadorEjecMM) {
        this.indicadorEjecMM = indicadorEjecMM;
    }

    public Boolean getIndicadorEjecRN() {
        return indicadorEjecRN;
    }

    public void setIndicadorEjecRN(Boolean indicadorEjecRN) {
        this.indicadorEjecRN = indicadorEjecRN;
    }

    public Integer getNivelGravedadBloqueo() {
        return nivelGravedadBloqueo;
    }

    public void setNivelGravedadBloqueo(Integer nivelGravedadBloqueo) {
        this.nivelGravedadBloqueo = nivelGravedadBloqueo;
    }
}