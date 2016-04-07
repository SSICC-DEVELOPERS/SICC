package es.indra.sicc.dtos.ccc;
import es.indra.mare.common.mii.services.jdbcservice.RecordSet;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.sql.Date;

public class DTORepConsultaCCC extends DTOAuditableSICC{
  private String apenom;
  private Date fechaIngreso;
  private String tipoCodigoTipoDocumento;
  private String numeroDocumento;
  private String sgv;
  private String region;
  private String zona;
  private String codNivelRiesgo;
  private String importeLineaCredito;
  private String statusCliente;
  private String deudaTotal;
  private String lineaDisponible;
  private RecordSet datosCC;
  private Long oidCliente;
  
  //    Agregado por HRCS - Fecha 02/04/2007 - Incidencia Sicc20070176
  private String territorio;
    
    // Agregado por Ravael Romero - 09/04/2007 - Incidencia SiCC20070177
    private String direccion;
    private Date fechaNacimiento;
    
    //jrivas 22/7/2008 CCC-004
    private String pagoSaldoVencido;
    private String saldoPorVencer;
    
  
  public DTORepConsultaCCC(){
  }

  public String getApenom(){
    return apenom;
  }

  public void setApenom(String apenom){
    this.apenom = apenom;
  }

  public Date getFechaIngreso(){
    return fechaIngreso;
  }

  public void setFechaIngreso(Date fechaIngreso){
    this.fechaIngreso = fechaIngreso;
  }

  public String getNumeroDocumento(){
    return numeroDocumento;
  }

  public void setNumeroDocumento(String numeroDocumento){
    this.numeroDocumento = numeroDocumento;
  }

  public String getRegion(){
    return region;
  }

  public void setRegion(String region){
    this.region = region;
  }

  public String getSgv(){
    return sgv;
  }

  public void setSgv(String sgv){
    this.sgv = sgv;
  }

  public String getTipoCodigoTipoDocumento(){
    return tipoCodigoTipoDocumento;
  }

  public void setTipoCodigoTipoDocumento(String tipoCodigoTipoDocumento){
    this.tipoCodigoTipoDocumento = tipoCodigoTipoDocumento;
  }

  public String getZona(){
    return zona;
  }

  public void setZona(String zona){
    this.zona = zona;
  }

  public String getCodNivelRiesgo() {
    return codNivelRiesgo;
  }

  public void setCodNivelRiesgo(String codNivelRiesgo) {
    this.codNivelRiesgo = codNivelRiesgo;
  }

  public String getImporteLineaCredito() {
    return importeLineaCredito;
  }

  public void setImporteLineaCredito(String importeLineaCredito) {
    this.importeLineaCredito = importeLineaCredito;
  }

  public String getStatusCliente() {
    return statusCliente;
  }

  public void setStatusCliente(String statusCliente) {
    this.statusCliente = statusCliente;
  }

  public String getLineaDisponible() {
    return lineaDisponible;
  }

  public void setLineaDisponible(String lineaDisponible) {
    this.lineaDisponible = lineaDisponible;
  }

  public String getDeudaTotal() {
    return deudaTotal;
  }

  public void setDeudaTotal(String deudaTotal) {
    this.deudaTotal = deudaTotal;
  }

  public RecordSet getDatosCC() {
    return datosCC;
  }

  public void setDatosCC(RecordSet datosCC) {
    this.datosCC = datosCC;
  }

  public Long getOidCliente() {
    return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
    this.oidCliente = oidCliente;
  }


    public void setTerritorio(String territorio) {
        this.territorio = territorio;
    }


    public String getTerritorio() {
        return territorio;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    public void setSaldoPorVencer(String saldoPorVencer) {
        this.saldoPorVencer = saldoPorVencer;
    }

    public String getSaldoPorVencer() {
        return saldoPorVencer;
    }
    
    public void setPagoSaldoVencido(String pagoSaldoVencido) {
        this.pagoSaldoVencido = pagoSaldoVencido;
    }

    public String getPagoSaldoVencido() {
        return pagoSaldoVencido;
    }    
    

}