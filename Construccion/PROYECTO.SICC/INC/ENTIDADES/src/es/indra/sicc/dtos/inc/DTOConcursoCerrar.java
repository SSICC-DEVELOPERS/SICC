package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.sql.Date;

public class DTOConcursoCerrar extends DTOBelcorp  {
    private Long oidConcurso;
    private Long oidEstado;
    private Long oidConcursoOrigen;
    private Integer periodosEvaluar;
    private Integer periodosObtencion;
    private Long oidPeriodoDespacho;
    private Long oidPeriodoPremiacion;
    private Integer periodosSobreCalculo;
    private Date fechaActual;
    private Long oidPeriodoHasta;
    private String numeroConcurso;
    //jrivas 9/1/2009 20080804
    private Integer periodosRecomendadas;
    

    public DTOConcursoCerrar() {
    }

    public Long getOidConcurso() {
        return oidConcurso;
    }

    public void setOidConcurso(Long oidConcurso) {
        this.oidConcurso = oidConcurso;
    }

    public Long getOidEstado() {
        return oidEstado;
    }

    public void setOidEstado(Long oidEstado) {
        this.oidEstado = oidEstado;
    }

    public Long getOidConcursoOrigen() {
        return oidConcursoOrigen;
    }

    public void setOidConcursoOrigen(Long oidConcursoOrigen) {
        this.oidConcursoOrigen = oidConcursoOrigen;
    }

    public Integer getPeriodosEvaluar() {
        return periodosEvaluar;
    }

    public void setPeriodosEvaluar(Integer periodosEvaluar) {
        this.periodosEvaluar = periodosEvaluar;
    }

    public Integer getPeriodosObtencion() {
        return periodosObtencion;
    }

    public void setPeriodosObtencion(Integer periodosObtencion) {
        this.periodosObtencion = periodosObtencion;
    }

    public Long getOidPeriodoDespacho() {
        return oidPeriodoDespacho;
    }

    public void setOidPeriodoDespacho(Long oidPeriodoDespacho) {
        this.oidPeriodoDespacho = oidPeriodoDespacho;
    }

    public Long getOidPeriodoPremiacion() {
        return oidPeriodoPremiacion;
    }

    public void setOidPeriodoPremiacion(Long oidPeriodoPremiacion) {
        this.oidPeriodoPremiacion = oidPeriodoPremiacion;
    }

    public Integer getPeriodosSobreCalculo() {
        return periodosSobreCalculo;
    }

    public void setPeriodosSobreCalculo(Integer periodosSobreCalculo) {
        this.periodosSobreCalculo = periodosSobreCalculo;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public Long getOidPeriodoHasta() {
        return oidPeriodoHasta;
    }

    public void setOidPeriodoHasta(Long oidPeriodoHasta) {
        this.oidPeriodoHasta = oidPeriodoHasta;
    }

    public String getNumeroConcurso()
    {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso)
    {
        this.numeroConcurso = numeroConcurso;
    }
    
    public Integer getPeriodosRecomendadas()
    {
        return periodosRecomendadas;
    }

    public void setPeriodosRecomendadas(Integer periodosRecomendadas)
    {
        this.periodosRecomendadas = periodosRecomendadas;
    }    
}