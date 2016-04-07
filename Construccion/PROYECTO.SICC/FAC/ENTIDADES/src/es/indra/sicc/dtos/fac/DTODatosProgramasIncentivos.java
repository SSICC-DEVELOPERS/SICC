package es.indra.sicc.dtos.fac;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosProgramasIncentivos extends DTOBelcorp  {
    private Long oidSolicitudCabecera;
    private String numeroConcurso;
    private String nombreConcurso;
    private Float importeTipoPrograma;
    private String DNI;

    public DTODatosProgramasIncentivos() {
    }

    public Long getOidSolicitudCabecera() {
        return oidSolicitudCabecera;
    }

    public void setOidSolicitudCabecera(Long oidSolicitudCabecera) {
        this.oidSolicitudCabecera = oidSolicitudCabecera;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public String getNombreConcurso() {
        return nombreConcurso;
    }

    public void setNombreConcurso(String nombreConcurso) {
        this.nombreConcurso = nombreConcurso;
    }

    public Float getImporteTipoPrograma() {
        return importeTipoPrograma;
    }

    public void setImporteTipoPrograma(Float importeTipoPrograma) {
        this.importeTipoPrograma = importeTipoPrograma;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
}