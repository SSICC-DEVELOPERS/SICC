package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

/**
 * 
 * @author Mariano Rodriguez
 * @fecha 20/07/2005
 */
public class DTOEntregaPremios extends DTOBelcorp {

    private Long oidCliente;
    private Long oidPais;
    private Long oidMarca;
    private Long oidCanal;
    private Long oidConcurso;
    private Long oidDirigidoA;
    private Long codEmpleado;
    private Long oidPeridodo;
    private Long oidNivelPremiacion;
    private String descTipoPremio;
    //jrivas BLO-001
    private Boolean clienteBloqueado;

    public void setOidCliente(Long oidCliente) {
      this.oidCliente = oidCliente;
    }
  
    public Long getOidCliente() {
      return oidCliente;
    }
  
    public void setOidPais(Long oidPais) {
      this.oidPais = oidPais;
    }
  
    public Long getOidPais() {
      return oidPais;
    }
  
    public void setOidMarca(Long oidMarca) {
      this.oidMarca = oidMarca;
    }
  
    public Long getOidMarca() {
      return oidMarca;
    }
  
    public void setOidCanal(Long oidCanal) {
      this.oidCanal = oidCanal;
    }
  
    public Long getOidCanal() {
      return oidCanal;
    }
  
    public void setOidConcurso(Long oidConcurso) {
      this.oidConcurso = oidConcurso;
    }
  
    public Long getOidConcurso() {
      return oidConcurso;
    }
  
    public void setOidDirigidoA(Long oidDirigidoA) {
      this.oidDirigidoA = oidDirigidoA;
    }
  
    public Long getOidDirigidoA() {
      return oidDirigidoA;
    }
  
    public void setCodEmpleado(Long codEmpleado) {
      this.codEmpleado = codEmpleado;
    }
  
    public Long getCodEmpleado() {
      return codEmpleado;
    }
  
    public void setOidPeridodo(Long oidPeridodo) {
      this.oidPeridodo = oidPeridodo;
    }
  
    public Long getOidPeridodo() {
      return oidPeridodo;
    }
  
    public void setOidNivelPremiacion(Long oidNivelPremiacion) {
      this.oidNivelPremiacion = oidNivelPremiacion;
    }
  
    public Long getOidNivelPremiacion() {
      return oidNivelPremiacion;
    }

  // vbongiov -- 26/07/2006 -- inc DBLG500000906
  public String getDescTipoPremio() {
    return descTipoPremio;
  }

  public void setDescTipoPremio(String descTipoPremio) {
    this.descTipoPremio = descTipoPremio;
  }

    public Boolean getClienteBloqueado()
    {
        return clienteBloqueado;
    }

    public void setClienteBloqueado(Boolean clienteBloqueado)
    {
        this.clienteBloqueado = clienteBloqueado;
    }

    
}