package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOINTAptaCurso extends DTOBelcorp  {
    private String codigoCliente;
    private Date fechaAsistencia;
    private String indicadorInvitada;
    private Integer numeroConvocatoria;
    private String periodo;
    private String codigoTipoCurso;
    private String codigoCanalVenta;
    private Date fechaCapacitacion;
    private String indicadorAsistencia;
    private String flagExtemporanea;
    private String flagApta;
    private Integer opcion;
    private Boolean indicadorFF;
    private Date fechaFinCurso;

    //agregado por Sapaza, fecha 18-09-2007, cambio Sicc20070392
    private Long oidAptaCurso;

    public DTOINTAptaCurso() {
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public Date getFechaAsistencia() {
        return fechaAsistencia;
    }

    public void setFechaAsistencia(Date fechaAsistencia) {
        this.fechaAsistencia = fechaAsistencia;
    }

    public String getIndicadorInvitada() {
        return indicadorInvitada;
    }

    public void setIndicadorInvitada(String indicadorInvitada) {
        this.indicadorInvitada = indicadorInvitada;
    }

    public Integer getNumeroConvocatoria() {
        return numeroConvocatoria;
    }

    public void setNumeroConvocatoria(Integer numeroConvocatoria) {
        this.numeroConvocatoria = numeroConvocatoria;
    }

    public String getPeriodo() {
        return periodo;
    }

    public String getCodigoTipoCurso() {
        return codigoTipoCurso;
    }

    public void setCodigoTipoCurso(String codigoTipoCurso) {
        this.codigoTipoCurso = codigoTipoCurso;
    }

    public String getCodigoCanalVenta() {
        return codigoCanalVenta;
    }

    public void setCodigoCanalVenta(String codigoCanalVenta) {
        this.codigoCanalVenta = codigoCanalVenta;
    }

    public Date getFechaCapacitacion() {
        return fechaCapacitacion;
    }

    public void setFechaCapacitacion(Date fechaCapacitacion) {
        this.fechaCapacitacion = fechaCapacitacion;
    }

    public String getIndicadorAsistencia() {
        return indicadorAsistencia;
    }

    public void setIndicadorAsistencia(String indicadorAsistencia) {
        this.indicadorAsistencia = indicadorAsistencia;
    }

    public String getFlagExtemporanea() {
        return flagExtemporanea;
    }

    public void setFlagExtemporanea(String flagExtemporanea) {
        this.flagExtemporanea = flagExtemporanea;
    }

    public String getFlagApta() {
        return flagApta;
    }

    public void setFlagApta(String flagApta) {
        this.flagApta = flagApta;
    }

    public Integer getOpcion() {
        return opcion;
    }

    public void setOpcion(Integer opcion) {
        this.opcion = opcion;
    }

    public Boolean getIndicadorFF() {
        return indicadorFF;
    }

    public void setIndicadorFF(Boolean indicadorFF) {
        this.indicadorFF = indicadorFF;
    }

    public Date getFechaFinCurso() {
        return fechaFinCurso;
    }

    public void setFechaFinCurso(Date fechaFinCurso) {
        this.fechaFinCurso = fechaFinCurso;
    }

    public void setPeriodo(String periodo)
    {
        this.periodo = periodo;
    }


    public void setOidAptaCurso(Long oidAptaCurso)
    {
        this.oidAptaCurso = oidAptaCurso;
    }


    public Long getOidAptaCurso()
    {
        return oidAptaCurso;
    }
}