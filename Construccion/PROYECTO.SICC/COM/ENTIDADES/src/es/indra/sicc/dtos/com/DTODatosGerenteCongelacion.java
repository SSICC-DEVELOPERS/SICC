package es.indra.sicc.dtos.com;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
import java.math.BigDecimal;
import java.util.Date;

public class DTODatosGerenteCongelacion extends DTOSiccPaginacion{

private Date fechaDesde;
private Date fechaHasta;
private Boolean descongelacion;
private String codigoCliente;
private Long oidCliente;
private Long codCongelado;
private Long oidCongelado;
private Boolean vigente;
private BigDecimal importe;
private String formatoFecha;

  public DTODatosGerenteCongelacion(){
  }


  public void setFechaDesde(Date fechaDesde){
    this.fechaDesde = fechaDesde;
  }


  public Date getFechaDesde(){
    return fechaDesde;
  }


  public void setFechaHasta(Date fechaHasta){
    this.fechaHasta = fechaHasta;
  }


  public Date getFechaHasta(){
    return fechaHasta;
  }


  public void setDescongelacion(Boolean descongelacion){
    this.descongelacion = descongelacion;
  }


  public Boolean getDescongelacion(){
    return descongelacion;
  }


  public void setCodigoCliente(String codigoCliente){
    this.codigoCliente = codigoCliente;
  }


  public String getCodigoCliente(){
    return codigoCliente;
  }


  public void setOidCliente(Long oidCliente){
    this.oidCliente = oidCliente;
  }


  public Long getOidCliente(){
    return oidCliente;
  }


  public void setCodCongelado(Long codCongelado){
    this.codCongelado = codCongelado;
  }


  public Long getCodCongelado(){
    return codCongelado;
  }


  public void setOidCongelado(Long oidCongelado){
    this.oidCongelado = oidCongelado;
  }


  public Long getOidCongelado(){
    return oidCongelado;
  }


  public void setVigente(Boolean vigente){
    this.vigente = vigente;
  }


  public Boolean getVigente(){
    return vigente;
  }


  public void setImporte(BigDecimal importe){
    this.importe = importe;
  }


  public BigDecimal getImporte(){
    return importe;
  }


  public void setFormatoFecha(String formatoFecha)
  {
    this.formatoFecha = formatoFecha;
  }


  public String getFormatoFecha()
  {
    return formatoFecha;
  }


}