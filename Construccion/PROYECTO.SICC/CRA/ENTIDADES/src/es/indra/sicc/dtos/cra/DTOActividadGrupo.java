/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 */
package es.indra.sicc.dtos.cra;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;
import java.sql.Timestamp;

public class DTOActividadGrupo extends DTOAuditableSICC  {
  private Long fecha0;
  private Date fechaFinal;
  private Integer fechaMedia;
  private Timestamp fechaPrevista;
  private Long oid;
  private Boolean tipoDias;
  private Long actividad;
  //Inc. 5635
  //private Long actividadOrigen;
  private Integer actividadOrigen;
  private Long grupo;
  private Long periodo;
  private Long tipoFacturacion;
  private Date fechaIniPeriodo;
  private Date fechaFinPeriodo;
  private Integer idVista;
  private String textoGrupo;
  private String textoActividad;
  private String codigo;
  private Boolean indFija;
    
    //CRA-003 jrivas 26/11/2007
    private Integer diasDesplazamiento;
    private Boolean indPendienteOrigen;
    private Long periodoReferencia;
    private Long oidActividadOrigen;

    //CRA-01
    private String nombrePeriodoReferencia;
    private String codigoActividadOrigen;
    private String nombreActividadOrigen;
    private Integer tipoActividad;
    private Integer idVistaOrigenOtroPeriodo;

  public DTOActividadGrupo() {
  }

  public Long getFecha0() {
    return fecha0;
  }

  public void setFecha0(Long newFecha0) {
    fecha0 = newFecha0;
  }

  public Date getFechaFinal() {
    return fechaFinal;
  }

  public void setFechaFinal(Date newFechaFinal) {
    fechaFinal = newFechaFinal;
  }

  public Integer getFechaMedia() {
    return fechaMedia;
  }

  public void setFechaMedia(Integer newFechaMedia) {
    fechaMedia = newFechaMedia;
  }

  public Timestamp getFechaPrevista() {
    return fechaPrevista;
  }

  public void setFechaPrevista(Timestamp newFechaPrevista) {
    fechaPrevista = newFechaPrevista;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long newOid) {
    oid = newOid;
  }

  public Boolean getTipoDias() {
    return tipoDias;
  }

  public void setTipoDias(Boolean newTipoDias) {
    tipoDias = newTipoDias;
  }

  public Long getActividad() {
    return actividad;
  }

  public void setActividad(Long newActividad) {
    actividad = newActividad;
  }

  public Integer getActividadOrigen() {
    return actividadOrigen;
  }

  public void setActividadOrigen(Integer newActividadOrigen) {
    actividadOrigen = newActividadOrigen;
  }

  public Long getGrupo() {
    return grupo;
  }

  public void setGrupo(Long newGrupo) {
    grupo = newGrupo;
  }

  public Long getPeriodo() {
    return periodo;
  }

  public void setPeriodo(Long newPeriodo) {
    periodo = newPeriodo;
  }

  public Long getTipoFacturacion() {
    return tipoFacturacion;
  }

  public void setTipoFacturacion(Long newTipoFacturacion) {
    tipoFacturacion = newTipoFacturacion;
  }

  public Date getFechaIniPeriodo() {
    return fechaIniPeriodo;
  }

  public void setFechaIniPeriodo(Date newFechaIniPeriodo) {
    fechaIniPeriodo = newFechaIniPeriodo;
  }

  public Date getFechaFinPeriodo() {
    return fechaFinPeriodo;
  }

  public void setFechaFinPeriodo(Date newFechaFinPeriodo) {
    fechaFinPeriodo = newFechaFinPeriodo;
  }

  public Integer getIdVista() {
    return idVista;
  }

  public void setIdVista(Integer newIdVista) {
    idVista = newIdVista;
  }

  public String getTextoGrupo() {
    return textoGrupo;
  }

  public void setTextoGrupo(String newTextoGrupo) {
    textoGrupo = newTextoGrupo;
  }

  public String getTextoActividad() {
    return textoActividad;
  }

  public void setTextoActividad(String newTextoActividad) {
    textoActividad = newTextoActividad;
  }

  public String getCodigo() {
    return codigo;
  }

  public void setCodigo(String newCodigo) {
    codigo = newCodigo;
  }

  public Boolean getIndFija() {
    return indFija;
  }

  public void setIndFija(Boolean newIndFija) {
    indFija = newIndFija;
  }

    public Integer getDiasDesplazamiento()
    {
        return diasDesplazamiento;
    }

    public void setDiasDesplazamiento(Integer diasDesplazamiento)
    {
        this.diasDesplazamiento = diasDesplazamiento;
    }

    public Boolean getIndPendienteOrigen()
    {
        return indPendienteOrigen;
    }

    public void setIndPendienteOrigen(Boolean indPendienteOrigen)
    {
        this.indPendienteOrigen = indPendienteOrigen;
    }

    public Long getPeriodoReferencia()
    {
        return periodoReferencia;
    }

    public void setPeriodoReferencia(Long periodoReferencia)
    {
        this.periodoReferencia = periodoReferencia;
    }

    public Long getOidActividadOrigen()
    {
        return oidActividadOrigen;
    }

    public void setOidActividadOrigen(Long oidActividadOrigen)
    {
        this.oidActividadOrigen = oidActividadOrigen;
    }

    public String getNombrePeriodoReferencia()
    {
        return nombrePeriodoReferencia;
    }

    public void setNombrePeriodoReferencia(String nombrePeriodoReferencia)
    {
        this.nombrePeriodoReferencia = nombrePeriodoReferencia;
    }

    public String getCodigoActividadOrigen()
    {
        return codigoActividadOrigen;
    }

    public void setCodigoActividadOrigen(String codigoActividadOrigen)
    {
        this.codigoActividadOrigen = codigoActividadOrigen;
    }

    public String getNombreActividadOrigen()
    {
        return nombreActividadOrigen;
    }

    public void setNombreActividadOrigen(String nombreActividadOrigen)
    {
        this.nombreActividadOrigen = nombreActividadOrigen;
    }

    public Integer getTipoActividad()
    {
        return tipoActividad;
    }

    public void setTipoActividad(Integer tipoActividad)
    {
        this.tipoActividad = tipoActividad;
    }

    public Integer getIdVistaOrigenOtroPeriodo()
    {
        return idVistaOrigenOtroPeriodo;
    }

    public void setIdVistaOrigenOtroPeriodo(Integer idVistaOrigenOtroPeriodo)
    {
        this.idVistaOrigenOtroPeriodo = idVistaOrigenOtroPeriodo;
    }
}