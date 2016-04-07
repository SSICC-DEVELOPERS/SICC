package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.math.BigDecimal;

public class DTODatosGenMsgMetasVenta extends DTOBelcorp {   
    private String numeroConcurso;
    private String mensaje;
    private String periodoDesdeConc;
    private String periodoHastaConc;
    private String periodoDesdeCali;
    private String periodoHastaCali;
    private BigDecimal factorConversion;
    private Integer numeroPuntos;
    
    public String getNumeroConcurso() {
        return this.numeroConcurso;   
    }
    
    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }
    
    public String getMensaje() {
        return this.mensaje;
    }
    
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
    
    public String getPeriodoDesdeConc() {
        return this.periodoDesdeConc;
    }
    
    public void setPeriodoDesdeConc(String periodoDesdeConc) {
        this.periodoDesdeConc = periodoDesdeConc;
    }
    
    public String getPeriodoHastaConc() {
        return this.periodoHastaConc;
    }
    
    public void setPeriodoHastaConc(String periodoHastaConc) {
        this.periodoHastaConc = periodoHastaConc;
    }
    
    public String getPeriodoDesdeCali() {
        return this.periodoDesdeCali;
    }
    
    public void setPeriodoDesdeCali(String periodoDesdeCali) {
        this.periodoDesdeCali = periodoDesdeCali;
    }
    
    public String getPeriodoHastaCali() {
        return this.periodoHastaCali;
    }
    
    public void setPeriodoHastaCali(String periodoHastaCali) {
        this.periodoHastaCali = periodoHastaCali;
    }
    
    public BigDecimal getFactorConversion() {
        return this.factorConversion;
    }
    
    public void setFactorConversion(BigDecimal factorConversion) {
        this.factorConversion = factorConversion;
    }
    
    public Integer getNumeroPuntos() {
        return this.numeroPuntos;
    }
    
    public void setNumeroPuntos(Integer numeroPuntos) {
        this.numeroPuntos = numeroPuntos;
    }   
}