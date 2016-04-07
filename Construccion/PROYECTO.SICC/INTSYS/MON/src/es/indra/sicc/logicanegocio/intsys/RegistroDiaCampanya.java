package es.indra.sicc.logicanegocio.intsys;
import java.util.Date;

public class RegistroDiaCampanya  {
    
    private String codPeriodoActual;
    private Date fecha; 
    private String codCanal;
    private String codPeriodoOrigen; 
    private String anyo;
    private String codPeriodo; 
    private Boolean fechaInicio;
    private Boolean fechaFin;
    private Boolean laboral;
    private Boolean feriado;
    private String trimestre;   
    private String estacion;
    private String semestre;
    private String diaSemana;
    private String mes;
    private Integer numSemana;
    
    
    public RegistroDiaCampanya() {
    }
//Date fechaDia, String codCanalOrigen, String codPeriodoOrigen, String anyoPeriodoCorporativo, String codPeriodoFecha, Boolean inicioPeriodo, Boolean finPeriodo    
    public RegistroDiaCampanya(Date fechaDia, 
                                String codCanalOrigen, 
                                String codPeriodoOrigen, 
                                String anyoPeriodoCorporativo, 
                                String codPeriodoFecha, 
                                Boolean inicioPeriodo, 
                                Boolean finPeriodo    ) {
                                
        codPeriodoActual=codPeriodoOrigen;
        fecha=fechaDia;
        codCanal=codCanalOrigen;
        anyo=anyoPeriodoCorporativo;
        trimestre= UtilidadCalendarioCampanya.obtenerTrimestre(fechaDia);
        codPeriodo=codPeriodoFecha;
        estacion= UtilidadCalendarioCampanya.obtenerEstacion(fechaDia);
        semestre= UtilidadCalendarioCampanya.obtenerSemestre(fechaDia); 
        diaSemana= UtilidadCalendarioCampanya.obtenerDiaSemana(fechaDia);
        mes= UtilidadCalendarioCampanya.obtenerMes(fechaDia);
        numSemana= UtilidadCalendarioCampanya.obtenerNumeroSemana(fechaDia);
        feriado=Boolean.FALSE;
        laboral=Boolean.TRUE;
        fechaInicio=inicioPeriodo;
        fechaFin=finPeriodo;
        
        
    }

    public String getAnyo() {
        return anyo;
    }

    public void setAnyo(String anyo) {
        this.anyo = anyo;
    }

    public String getCodCanal() {
        return codCanal;
    }

    public void setCodCanal(String codCanal) {
        this.codCanal = codCanal;
    }

    public String getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getCodPeriodoActual() {
        return codPeriodoActual;
    }

    public void setCodPeriodoActual(String codPeriodoActual) {
        this.codPeriodoActual = codPeriodoActual;
    }

    public String getCodPeriodoOrigen() {
        return codPeriodoOrigen;
    }

    public void setCodPeriodoOrigen(String codPeriodoOrigen) {
        this.codPeriodoOrigen = codPeriodoOrigen;
    }

    public String getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(String diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getEstacion() {
        return estacion;
    }

    public void setEstacion(String estacion) {
        this.estacion = estacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Boolean getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Boolean fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Boolean getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Boolean fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Boolean getFeriado() {
        return feriado;
    }

    public void setFeriado(Boolean feriado) {
        this.feriado = feriado;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public Boolean getLaboral() {
        return laboral;
    }

    public void setLaboral(Boolean laboral) {
        this.laboral = laboral;
    }

    public Integer getNumSemana() {
        return numSemana;
    }

    public void setNumSemana(Integer numSemana) {
        this.numSemana = numSemana;
    }

    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }
    
    
}