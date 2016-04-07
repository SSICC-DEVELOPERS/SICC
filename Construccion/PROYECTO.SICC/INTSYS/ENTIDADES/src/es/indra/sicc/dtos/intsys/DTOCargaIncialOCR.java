package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.Date;

public class DTOCargaIncialOCR extends DTOBelcorp  {
  private String codPais;
  private String codPeriodo;
  private String codCliente;
  private String tipoSolicitud;
  private String tipoDespacho;
  private Integer numClie;
  private Integer acceFisi;
  private Date fecha;
  private String proceso;
  private String codSubacceso; 
  
  //cambio nº2
  private Long docuOri; 
  private String codCana; 
  private String codAcc; 
  private String codSubacc; 
  private Long docuRefe; 
  
  public DTOCargaIncialOCR() {  
  }
  
  public String getCodPais()
  {
      return codPais;
  }

  public void setCodPais(String codPais)
  {
      this.codPais = codPais;
  }

  public String getCodPeriodo()
  {
      return codPeriodo;
  }

  public void setCodPeriodo(String codPeriodo)
  {
      this.codPeriodo = codPeriodo;
  }

  public String getCodCliente()
  {
      return codCliente;
  }

  public void setCodCliente(String codCliente)
  {
      this.codCliente = codCliente;
  }

  public String getTipoSolicitud()
  {
      return tipoSolicitud;
  }

  public void setTipoSolicitud(String tipoSolicitud)
  {
      this.tipoSolicitud = tipoSolicitud;
  }

  public Integer getNumClie()
  {
      return numClie;
  }

  public void setNumClie(Integer numClie)
  {
      this.numClie = numClie;
  }

  public Integer getAcceFisi()
  {
      return acceFisi;
  }

  public void setAcceFisi(Integer acceFisi)
  {
      this.acceFisi = acceFisi;
  }

  public Date getFecha()
  {
      return fecha;
  }

  public void setFecha(Date fecha)
  {
      this.fecha = fecha;
  }
  
  public String getProceso()
  {
      return proceso;
  }

  public void setProceso(String proceso)
  {
      this.proceso = proceso;
  }

  public String getCodSubacceso()
  {
      return codSubacceso;
  }

  public void setCodSubacceso(String codSubacceso)
  {
      this.codSubacceso = codSubacceso;
  }


  public void setDocuOri(Long docuOri) {
    this.docuOri = docuOri;
  }


  public Long getDocuOri() {
    return docuOri;
  }


  public void setCodCana(String codCana) {
    this.codCana = codCana;
  }


  public String getCodCana() {
    return codCana;
  }


  public void setCodAcc(String codAcc) {
    this.codAcc = codAcc;
  }


  public String getCodAcc() {
    return codAcc;
  }


  public void setCodSubacc(String codSubacc) {
    this.codSubacc = codSubacc;
  }


  public String getCodSubacc() {
    return codSubacc;
  }


  public void setDocuRefe(Long docuRefe) {
    this.docuRefe = docuRefe;
  }


  public Long getDocuRefe() {
    return docuRefe;
  }


  public void setTipoDespacho(String tipoDespacho) {
    this.tipoDespacho = tipoDespacho;
  }


  public String getTipoDespacho() {
    return tipoDespacho;
  }

}







  