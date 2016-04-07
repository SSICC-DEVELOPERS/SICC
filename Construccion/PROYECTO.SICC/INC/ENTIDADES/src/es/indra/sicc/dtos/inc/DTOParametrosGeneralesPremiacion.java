package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

public class DTOParametrosGeneralesPremiacion extends DTOBelcorp 
{
  private Long oidParamGralesPremiacion;
  private Long oidTipoPremiacion;
  private Boolean indPeriodoDespacho;
  private Long oidPeriodo;
  private Integer nroPeriodosObtencion;
  private Boolean indComunicacion;
  private String mensaje;
  private Integer nroNiveles;
  private Boolean indPremiosAcumulativosNiveles;
  private Integer hastaNivel;
  private Boolean indNivelesRotativos;
  private Integer nroRotaciones;
  private Boolean indAccesoNivelPremioSuperior;
  private Boolean indPremiosElectivos;
  private Long oidTipoEleccion;
  private Integer numeroPremio;
  
  // vbongiov -- Cambio 20080811 -- 26/08/2009
   private Integer cantidadNumerosAOtorgar;
   private String codProducto;
   private Long oidProducto;

  // sapaza -- PER-SiCC-2010-0210 -- 23/04/2010
  private Long oidPeriodoInicio;
  
  // sapaza -- PER-SiCC-2011-0857 -- 23/01/2012
  private Boolean indSinPremioPorDefecto;

  public Long getOidParamGralesPremiacion()
  {
    return oidParamGralesPremiacion;
  }

  public void setOidParamGralesPremiacion(Long oidParamGralesPremiacion)
  {
    this.oidParamGralesPremiacion = oidParamGralesPremiacion;
  }

  public Long getOidTipoPremiacion()
  {
    return oidTipoPremiacion;
  }

  public void setOidTipoPremiacion(Long oidTipoPremiacion)
  {
    this.oidTipoPremiacion = oidTipoPremiacion;
  }

  public Boolean getIndPeriodoDespacho()
  {
    return indPeriodoDespacho;
  }

  public void setIndPeriodoDespacho(Boolean indPeriodoDespacho)
  {
    this.indPeriodoDespacho = indPeriodoDespacho;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setOidPeriodo(Long oidPeriodo)
  {
    this.oidPeriodo = oidPeriodo;
  }

  public Integer getNroPeriodosObtencion()
  {
    return nroPeriodosObtencion;
  }

  public void setNroPeriodosObtencion(Integer nroPeriodosObtencion)
  {
    this.nroPeriodosObtencion = nroPeriodosObtencion;
  }

  public Boolean getIndComunicacion()
  {
    return indComunicacion;
  }

  public void setIndComunicacion(Boolean indComunicacion)
  {
    this.indComunicacion = indComunicacion;
  }

  public String getMensaje()
  {
    return mensaje;
  }

  public void setMensaje(String mensaje)
  {
    this.mensaje = mensaje;
  }

  public Integer getNroNiveles()
  {
    return nroNiveles;
  }

  public void setNroNiveles(Integer nroNiveles)
  {
    this.nroNiveles = nroNiveles;
  }

  public Boolean getIndPremiosAcumulativosNiveles()
  {
    return indPremiosAcumulativosNiveles;
  }

  public void setIndPremiosAcumulativosNiveles(Boolean indPremiosAcumulativosNiveles)
  {
    this.indPremiosAcumulativosNiveles = indPremiosAcumulativosNiveles;
  }

  public Integer getHastaNivel()
  {
    return hastaNivel;
  }

  public void setHastaNivel(Integer hastaNivel)
  {
    this.hastaNivel = hastaNivel;
  }

  public Boolean getIndNivelesRotativos()
  {
    return indNivelesRotativos;
  }

  public void setIndNivelesRotativos(Boolean indNivelesRotativos)
  {
    this.indNivelesRotativos = indNivelesRotativos;
  }

  public Integer getNroRotaciones()
  {
    return nroRotaciones;
  }

  public void setNroRotaciones(Integer nroRotaciones)
  {
    this.nroRotaciones = nroRotaciones;
  }

  public Boolean getIndAccesoNivelPremioSuperior()
  {
    return indAccesoNivelPremioSuperior;
  }

  public void setIndAccesoNivelPremioSuperior(Boolean indAccesoNivelPremioSuperior)
  {
    this.indAccesoNivelPremioSuperior = indAccesoNivelPremioSuperior;
  }

  public Boolean getIndPremiosElectivos()
  {
    return indPremiosElectivos;
  }

  public void setIndPremiosElectivos(Boolean indPremiosElectivos)
  {
    this.indPremiosElectivos = indPremiosElectivos;
  }

  public Long getOidTipoEleccion()
  {
    return oidTipoEleccion;
  }

  public void setOidTipoEleccion(Long oidTipoEleccion)
  {
    this.oidTipoEleccion = oidTipoEleccion;
  }
  
  public Integer getNumeroPremio(){
    return this.numeroPremio;
  }
  
  public void setNumeroPremio(Integer numeroPremio){
    this.numeroPremio = numeroPremio;
  }
  
  
  public Integer getCantidadNumerosAOtorgar(){
    return this.cantidadNumerosAOtorgar;
  }
    
  public void setCantidadNumerosAOtorgar(Integer cantidadNumerosAOtorgar){
    this.cantidadNumerosAOtorgar = cantidadNumerosAOtorgar;
  }
    
  public String getCodProducto(){
    return this.codProducto;
  }
    
  public void setCodProducto(String codProducto){
    this.codProducto = codProducto;
  }
  
  public Long getOidProducto(){
    return this.oidProducto;
  }
    
  public void setOidProducto(Long oidProducto) {
    this.oidProducto = oidProducto;
  }

  public void setOidPeriodoInicio(Long oidPeriodoInicio) {
    this.oidPeriodoInicio = oidPeriodoInicio;
  }

  public Long getOidPeriodoInicio() {
    return oidPeriodoInicio;
  }

  public void setIndSinPremioPorDefecto(Boolean indSinPremioPorDefecto) {
    this.indSinPremioPorDefecto = indSinPremioPorDefecto;
  }

  public Boolean getIndSinPremioPorDefecto() {
    return indSinPremioPorDefecto;
  }
  
}
