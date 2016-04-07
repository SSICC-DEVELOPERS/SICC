package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.ArrayList;
import java.util.Date;
import es.indra.sicc.util.DTOBelcorp;
import java.util.HashMap;

public class DTOFACDocumentoContableCabecera extends DTOBelcorp
{

  //incidencia 12311  
  private Long tipoDocumento;
  private Long oidCabecera;
  private String idFiscalSociedadVentas;
  private String codCliente;
  private String apellido1;
  private String apellido2;
  private String nombre1;
  private String nombre2;
  private String nombreVia;
  private Long numero;
  private Long numeroDocOrigen;
  private Long oidUbigeo;
  private Date fechaFacturacion;
  private Float precioCatSinImpTotLoc;
  private Float precioContSinImpTotLoc;
  private Float importeFleteSinImpuestosTotalLocal;
  private Float importeImpuestosTotalLocal;
  private Float totalAPagarLocal;
  private String descripcionTotalAPagar;
  private Float subTotal;
  private String descripcionUbigeo;
  private Long oidTipoVia;
  private String tipoVia;
  private Long oidPeriodo;
  private String nombrePeriodo;
  private String numeroPrograma;
  private Date descripPeriodo;
  private String valPeriodo;
  private Long oidZona;
  private String codTerritorio;
  private String codZona;
  private String DNI;
  private Integer numDocContableInterno;
  private Long numConsolidado;
  private Integer numUnidadesAtendidas;
  private Float precioCataTotaLocal;
  private Float precioContTotaLocal;
  private Float totalValVentaCata;
  private Float importeDescuentoTotaLocal;
  private Float totalDescuentoFlete;
  private String numDocReferencia;
  private String codPeriodoRefe;
  private Long oidTipoSolicitud;
  private String descripTipoSolicitud;
  private String glosa;
  private Integer numeroSecuenciaFacturacionDiaria;
  private Integer unidadesFueraCaja;
  private Integer unidadesEnBolsa;
  private Long numeroSolicitud;
  private Date fechaSolicitud;
  private String codRegion;
  private Long oidRegion;
  private Long oidSeccion;
  private String codSeccion;
  private String telefono;
  private Long oidCabeceraSolicitud;
  private Float saldoAnterior;
  private String codPeriodo;
  private String moneda;
  private Long pais;
  private Long oidCliente;
  
  // Eliminado el numIdentificacionFiscal por BELC300018205
  // y vuelto a crear por BELC300021209
  private String numIdentificacionFiscal;
  
  private boolean mostrarFechaVencimiento;
  
  //Añadidos por incidencia BELC300021757
  private Float impDesc1SinImpTotLocal;
  private Float impDesc3TotalLocal;
  //fin añadido 21757
  
  private Date fechaVencimiento;
  private String rutinaDiseñoFormulario;
  
  //añadido por incidencia 22488
  private Float importeFleteTotalLocal;
  private Float impDesc3SinImpTotalLocal;
  
  // SICC-GCC-FAC-002 - dmorello, 17/10/2006
  private Float tasaImpuestoPercepcion;
  private ArrayList listaDetalle;
  private Boolean indImprimirPercepcion;
  
  //    Agregado por HRCS - Fecha 24/04/2007 - Incidencia Sicc20070208
  private Float impDesc1TotLocal;
    private Long oidTipoProgramaConcurso;
    private String codigoTipoProgramaConcurso;
    private String periodoInicioConcurso;
    private String periodoFinConcurso;
    private String numeroConcurso;
    private Integer unidadesPremiosCaja;
    private ArrayList listaPremiosBD;
    private HashMap hashDatosPremios;
    private Float tasaImpuestoFlete;
    private Float tasaImpuesto;
    private String codigoBarras;
    private String serieDocumentoLegal;
    private Long numeroDocumentoLegal;
    private String telefonoFijo;
    private String telefonoCelular;
    private String barrio;
    private String municipio;
    private String departamento;
    private String primerPedido;
    private ArrayList listaSolicitudes;
    private Boolean indPedidoServicio;
    private Date fechaEntrega;
    private Long idSpool;
    private Long diasCruce;
    private Boolean indicadorReimpresion = Boolean.FALSE;
    private Integer numeroDecimales;
    private Long indicadorRevision;
    private Float importeRedondeoLocal;
    private Float ivaAsumidoEmpresa;
    
    // Cambio 20090900 - dmorello, 19/06/2009
    private Boolean indImpresionProdFueraCajaBolsa;
    
    // Cambio 20080765 - dmorello, 21/08/2009
    private Long oidBoletaRecojoConsolidado;
  
  public DTOFACDocumentoContableCabecera()
  {
    
  }


public String getTelefono()
{
  return telefono;
}

public void setTelefono(String entrada)
{
  telefono=entrada;
}

public String getCodSeccion()
{
  return codSeccion;
}


public void setCodSeccion(String entrada)
{
  codSeccion=entrada;
}






public Long getOidSeccion()
{
  return oidSeccion;
}

public void setOidSeccion(Long entrada)
{
  oidSeccion=entrada;
}





public String getCodRegion()
{
  return codRegion;
}


public void setCodRegion(String entrada)
{
  codRegion=entrada;
}

public Long getOidRegion()
{
  return oidRegion;
}

public void setOidRegion(Long entrada)
{
  oidRegion=entrada;
}

public Date getFechaSolicitud()
{
  return fechaSolicitud;
}

public void setFechaSolicitud(Date entrada)
{
  fechaSolicitud=entrada;
}


public Long getNumeroSolicitud()
{
  return numeroSolicitud;
}

public void setNumeroSolicitud(Long entrada)
{
  numeroSolicitud=entrada;
}

public Integer getUnidadesFueraCaja()
{
  return unidadesFueraCaja;
}

public void setUnidadesFueraCaja(Integer entrada)
{
  unidadesFueraCaja=entrada;
}

public Integer getUnidadesEnBolsa()
{
  return unidadesEnBolsa;
}

public void setUnidadesEnBolsa(Integer entrada)
{
  unidadesEnBolsa=entrada;
}

public Integer getNumeroSecuenciaFacturacionDiaria()
{
  return numeroSecuenciaFacturacionDiaria;
}


public void setNumeroSecuenciaFacturacionDiaria(Integer entrada)
{
  numeroSecuenciaFacturacionDiaria=entrada;
}

public String getGlosa()
{
  return glosa;
}

public void setGlosa(String entrada)
{
  glosa=entrada;
}

 public Long getOidTipoSolicitud()
 {
   return oidTipoSolicitud;
 }

public void setOidTipoSolicitud(Long entrada)
{
  oidTipoSolicitud=entrada;
}


public String getDescripTipoSolicitud()
{
  return descripTipoSolicitud;
}

public void setDescripTipoSolicitud(String entrada)
{
  descripTipoSolicitud=entrada;
}


 public String getNumDocReferencia()
 {
    return numDocReferencia;
 }
 
 public void setNumDocReferencia(String numDocReferencia)
 {
    this.numDocReferencia = numDocReferencia;
 }
 
 public String getCodPeriodoRefe()
 {
    return codPeriodoRefe;
 } 

 public void setCodPeriodoRefe(String codPeriodoRefe)
 {
    this.codPeriodoRefe = codPeriodoRefe;
 }
 
 public String getCodTerritorio()
 {
   return codTerritorio;
 }
 
 public void setCodTerritorio(String entrada)
 {
   codTerritorio=entrada;
 }
 
 
 public Float getTotalDescuentoFlete()
 {
   return totalDescuentoFlete;
 }
 
 public void setTotalDescuentoFlete(Float entrada)
 {
   totalDescuentoFlete=entrada;
 }
 
 public Float getImporteDescuentoTotaLocal()
 {
   return importeDescuentoTotaLocal;
 }
 
 public void setImporteDescuentoTotaLocal(Float entrada)
 {
   importeDescuentoTotaLocal=entrada;
 }
 
 public Integer getNumUnidadesAtendidas()
 {
   return numUnidadesAtendidas;
 }
 
 
 public void setNumUnidadesAtendidas(Integer entrada)
 {
   numUnidadesAtendidas=entrada;
 }
 
  public Float getPrecioContTotaLocal()
  {
    return precioContTotaLocal;
  }

  public void setPrecioContTotaLocal(Float entrada)
  {
    precioContTotaLocal=entrada;
  }

public Float getTotalValVentaCata ()
  {
    return totalValVentaCata;
  }

  public void setTotalValVentaCata (Float entrada)
  {
    totalValVentaCata=entrada;
  }


  public Float getPrecioCataTotaLocal()
  {
    return precioCataTotaLocal;
  }
  
  public void setPrecioCataTotaLocal(Float entrada)
  {
    precioCataTotaLocal=entrada;
  }
  
  public Integer getNumDocContableInterno()
  {
    return numDocContableInterno;
  }

  public void setNumDocContableInterno(Integer entrada)
  {
    numDocContableInterno=entrada;
  }

  public Long getNumConsolidado()
  {
    return numConsolidado;
  }

  public void setNumConsolidado(Long entrada)
  {
    numConsolidado=entrada;
  }
  public String getDNI()
  {
    return DNI;
  }

  public void setDNI(String entrada)
  {
    DNI=entrada;
  }


  public Long getOidZona()
  {
    return oidZona;
  }
  
  public void setOidZona(Long entrada)
  {
    oidZona=entrada;
  }
  
  public String getCodZona()
  {
    return codZona;
  }
  
  public void setCodZona(String entrada)
  {
    codZona=entrada;
  }
  
  
  public Date getDescripPeriodo()
  {
    return descripPeriodo;
  }
  
  public void setDescripPeriodo(Date entrada)
  {
    descripPeriodo=entrada;
  }
  
  
  
  public String getNumeroPrograma()
  {
    return numeroPrograma;
  }

  

  public void setNumeroPrograma(String entrada)
  {
    numeroPrograma=entrada;
  }


  public void setOidPeriodo(Long entrada)
  {
    oidPeriodo= entrada;
  }

  public Long getOidPeriodo()
  {
    return oidPeriodo;
  }

  public void setNombrePeriodo(String entrada)
  {
    nombrePeriodo=entrada;
  }

  public String getNombrePeriodo()
  {
    return nombrePeriodo;
  }

  public void setOidCabecera(Long entrada)
  {
    oidCabecera=entrada;
  }
  
  public Long getOidCabecera()
  {
    return oidCabecera;
  }

  public void setDescripcionTotalAPagar(String entrada)
  {
    descripcionTotalAPagar=entrada;
  }

  public String getDescripcionTotalAPagar()
  {
    return descripcionTotalAPagar;
  }


  public void setOidTipoVia(Long entrada)
  {
    oidTipoVia=entrada;
  }

  public Long getOidTipoVia()
  {
    return oidTipoVia;
  }


  public void setTipoVia(String entrada)
  {
    tipoVia=entrada;
  }

  public String getTipoVia()
  {
    return tipoVia;
  }


  public void setNumeroDocOrigen(Long entrada)
  {
   numeroDocOrigen=entrada;
  }

  public Long getNumeroDocOrigen()
  {
    return numeroDocOrigen;
  }
 
 
 
 
  public void setPrecioCatSinImpTotLoc(Float entrada)
  {
    precioCatSinImpTotLoc=entrada;
  }
  
  public Float getPrecioCatSinImpTotLoc()
  {
    return precioCatSinImpTotLoc;
  }
  
  
  public void setPrecioContSinImpTotLoc(Float entrada)
  {
    precioContSinImpTotLoc=entrada;
  }
  
  public Float getPrecioContSinImpTotLoc()
  {
    return precioContSinImpTotLoc;
  }
  
  
  public void setTotalAPagarLocal(Float entrada)
  {
    totalAPagarLocal=entrada;
  }
  
  public Float getTotalAPagarLocal()
  {
    return totalAPagarLocal;
  }
  
  public void setSubTotal(Float entrada)
  {
    subTotal=entrada;
  }
  
  public Float getSubTotal()
  {
    return subTotal;
  }
  
  public void setImporteFleteSinImpuestosTotalLocal(Float entrada)
  {
    importeFleteSinImpuestosTotalLocal=entrada;
  }

  public Float getImporteFleteSinImpuestosTotalLocal()
  {
    return importeFleteSinImpuestosTotalLocal;
  }


  public void setImporteImpuestosTotalLocal(Float entrada)
  {
    importeImpuestosTotalLocal=entrada;
  }

  public Float getImporteImpuestosTotalLocal()
  {
    return importeImpuestosTotalLocal;
  }

  public Date getFechaFacturacion()
  {
    return fechaFacturacion;
  }

  public void setFechaFacturacion(Date entrada)
  {
    fechaFacturacion=entrada;
  }



  

  public String getIdFiscalSociedadVentas()
  {
    return idFiscalSociedadVentas;
  }


  public void setIdFiscalSociedadVentas(String entrada)
  {
    idFiscalSociedadVentas=entrada;
  }


  public String getCodCliente()
  {
    
    return codCliente;
  }


  public void setCodCliente(String entrada)
  {
    codCliente=entrada;
  }


  public String getNombre1()
  {
    return nombre1;
  }
  
  
  public void setNombre1(String entrada)
  {
    nombre1=entrada;
  }

  public String getNombre2()
  {
    return nombre2;
  }
  
   public void setNombre2(String entrada)
  {
    nombre2=entrada;
  }
  
  
  public String getApellido1()
  {
    return apellido1;
  }


  public void setApellido1(String entrada)
  {
    apellido1=entrada;
  }


  public String getApellido2()
  {
    return apellido2;
  }

  public void setApellido2(String entrada)
  {
    apellido2=entrada;
  }



 

  public String getNombreVia()
  {
    return nombreVia;
  }
  
  public void setNombreVia(String entrada)
  {
    nombreVia=entrada;
  }

  public Long getNumero()
  {
    return numero;
  }


  public void setNumero(Long entrada)
  {
    numero=entrada;
  }

  public Long getOidUbigeo()
  {
    return oidUbigeo;
  }

  public void setOidUbigeo(Long entrada)
  {
    oidUbigeo=entrada;
  }


   public void setDescripcionUbigeo(String entrada)
  {
    descripcionUbigeo=entrada;
  }

  public String getDescripcionUbigeo()
  {
    return descripcionUbigeo;
  }

  public Float getSaldoAnterior()
  {
    return saldoAnterior;
  }

  public void setSaldoAnterior(Float newSaldoAnterior)
  {
    saldoAnterior = newSaldoAnterior;
  }

  public boolean getMostrarFechaVencimiento()
  {
    return mostrarFechaVencimiento;
  }

  public void setMostrarFechaVencimiento(boolean newMostrarFechaVencimiento)
  {
    mostrarFechaVencimiento = newMostrarFechaVencimiento;
  }

  public Date getFechaVencimiento()
  {
    return fechaVencimiento;
  }

  public void setFechaVencimiento(Date newFechaVencimiento)
  {
    fechaVencimiento = newFechaVencimiento;
  }

  public String getValPeriodo()
  {
    return valPeriodo;
  }

  public void setValPeriodo(String newValPeriodo)
  {
    valPeriodo = newValPeriodo;
  }



  public Long getOidCabeceraSolicitud()
  {
    return oidCabeceraSolicitud;
  }

  public void setOidCabeceraSolicitud(Long newOidCabeceraSolicitud)
  {
    oidCabeceraSolicitud = newOidCabeceraSolicitud;
  }

  public String getCodPeriodo()
  {
    return codPeriodo;
  }

  public void setCodPeriodo(String newCodPeriodo)
  {
    codPeriodo = newCodPeriodo;
  }

  public String getMoneda()
  {
    return moneda;
  }

  public void setMoneda(String newMoneda)
  {
    moneda = newMoneda;
  }

  public Long getPais()
  {
    return pais;
  }

  public void setPais(Long newPais)
  {
    pais = newPais;
  }

  public Long getOidCliente()
  {
    return oidCliente;
  }

  public void setOidCliente(Long newOidCliente)
  {
    oidCliente = newOidCliente;
  }

	public String getRutinaDiseñoFormulario() {
		return rutinaDiseñoFormulario;
	}

	public void setRutinaDiseñoFormulario(String newRutinaDiseñoFormulario) {
		rutinaDiseñoFormulario = newRutinaDiseñoFormulario;
	}

    public Long getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(Long tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumIdentificacionFiscal()
    {
        return numIdentificacionFiscal;
    }

    public void setNumIdentificacionFiscal(String numIdentificacionFiscal)
    {
        this.numIdentificacionFiscal = numIdentificacionFiscal;
    }

    public Float getImpDesc1SinImpTotLocal()
    {
        return impDesc1SinImpTotLocal;
    }

    public void setImpDesc1SinImpTotLocal(Float impDesc1SinImpTotLocal)
    {
        this.impDesc1SinImpTotLocal = impDesc1SinImpTotLocal;
    }

    public Float getImpDesc3TotalLocal()
    {
        return impDesc3TotalLocal;
    }

    public void setImpDesc3TotalLocal(Float impDesc3TotalLocal)
    {
        this.impDesc3TotalLocal = impDesc3TotalLocal;
    }

    public Float getImporteFleteTotalLocal()
    {
        return importeFleteTotalLocal;
    }

    public void setImporteFleteTotalLocal(Float importeFleteTotalLocal)
    {
        this.importeFleteTotalLocal = importeFleteTotalLocal;
    }

  public Float getImpDesc3SinImpTotalLocal()
  {
    return impDesc3SinImpTotalLocal;
  }

  public void setImpDesc3SinImpTotalLocal(Float impDesc3SinImpTotalLocal)
  {
    this.impDesc3SinImpTotalLocal = impDesc3SinImpTotalLocal;
  }

  public Float getTasaImpuestoPercepcion()
  {
    return tasaImpuestoPercepcion;
  }

  public void setTasaImpuestoPercepcion(Float tasaImpuestoPercepcion)
  {
    this.tasaImpuestoPercepcion = tasaImpuestoPercepcion;
  }

  public ArrayList getListaDetalle()
  {
    return listaDetalle;
  }

  public void setListaDetalle(ArrayList listaDetalle)
  {
    this.listaDetalle = listaDetalle;
  }

  public Boolean getIndImprimirPercepcion()
  {
    return indImprimirPercepcion;
  }

  public void setIndImprimirPercepcion(Boolean indImprimirPercepcion)
  {
    this.indImprimirPercepcion = indImprimirPercepcion;
  }


    public void setImpDesc1TotLocal(Float impDesc1TotLocal) {
        this.impDesc1TotLocal = impDesc1TotLocal;
    }

    public Float getImpDesc1TotLocal() {
        return impDesc1TotLocal;
    }

    public Long getOidTipoProgramaConcurso() {
        return oidTipoProgramaConcurso;
    }

    public void setOidTipoProgramaConcurso(Long oidTipoProgramaConcurso) {
        this.oidTipoProgramaConcurso = oidTipoProgramaConcurso;
    }

    public String getCodigoTipoProgramaConcurso() {
        return codigoTipoProgramaConcurso;
    }

    public void setCodigoTipoProgramaConcurso(String codigoTipoProgramaConcurso) {
        this.codigoTipoProgramaConcurso = codigoTipoProgramaConcurso;
    }

    public String getPeriodoInicioConcurso() {
        return periodoInicioConcurso;
    }

    public void setPeriodoInicioConcurso(String periodoInicioConcurso) {
        this.periodoInicioConcurso = periodoInicioConcurso;
    }

    public String getPeriodoFinConcurso() {
        return periodoFinConcurso;
    }

    public void setPeriodoFinConcurso(String periodoFinConcurso) {
        this.periodoFinConcurso = periodoFinConcurso;
    }

    public String getNumeroConcurso() {
        return numeroConcurso;
    }

    public void setNumeroConcurso(String numeroConcurso) {
        this.numeroConcurso = numeroConcurso;
    }

    public Integer getUnidadesPremiosCaja() {
        return unidadesPremiosCaja;
    }

    public void setUnidadesPremiosCaja(Integer unidadesPremiosCaja) {
        this.unidadesPremiosCaja = unidadesPremiosCaja;
    }

    public ArrayList getListaPremiosBD() {
        return listaPremiosBD;
    }

    public void setListaPremiosBD(ArrayList listaPremiosBD) {
        this.listaPremiosBD = listaPremiosBD;
    }

    public HashMap getHashDatosPremios() {
        return hashDatosPremios;
    }

    public void setHashDatosPremios(HashMap hashDatosPremios) {
        this.hashDatosPremios = hashDatosPremios;
    }

    public Float getTasaImpuestoFlete() {
        return tasaImpuestoFlete;
    }

    public void setTasaImpuestoFlete(Float tasaImpuestoFlete) {
        this.tasaImpuestoFlete = tasaImpuestoFlete;
    }

    public Float getTasaImpuesto() {
        return tasaImpuesto;
    }

    public void setTasaImpuesto(Float tasaImpuesto) {
        this.tasaImpuesto = tasaImpuesto;
    }
    
        public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public String getSerieDocumentoLegal() {
        return serieDocumentoLegal;
    }

    public void setSerieDocumentoLegal(String serieDocumentoLegal) {
        this.serieDocumentoLegal = serieDocumentoLegal;
    }

    public Long getNumeroDocumentoLegal() {
        return numeroDocumentoLegal;
    }

    public void setNumeroDocumentoLegal(Long numeroDocumentoLegal) {
        this.numeroDocumentoLegal = numeroDocumentoLegal;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getPrimerPedido() {
        return primerPedido;
    }

    public void setPrimerPedido(String primerPedido) {
        this.primerPedido = primerPedido;
    }

    public ArrayList getListaSolicitudes() {
        return listaSolicitudes;
    }

    public void setListaSolicitudes(ArrayList listaSolicitudes) {
        this.listaSolicitudes = listaSolicitudes;
    }

    public Boolean getIndPedidoServicio() {
        return indPedidoServicio;
    }

    public void setIndPedidoServicio(Boolean indPedidoServicio) {
        this.indPedidoServicio = indPedidoServicio;
    }

    public Date getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public Long getIdSpool() {
        return idSpool;
    }

    public void setIdSpool(Long idSpool) {
        this.idSpool = idSpool;
    }

    public Long getDiasCruce() {
        return diasCruce;
    }

    public void setDiasCruce(Long diasCruce) {
        this.diasCruce = diasCruce;
    }

    public Boolean getIndicadorReimpresion() {
        return indicadorReimpresion;
    }

    public void setIndicadorReimpresion(Boolean indicadorReimpresion) {
        this.indicadorReimpresion = indicadorReimpresion;
    }

    public Integer getNumeroDecimales() {
        return numeroDecimales;
    }

    public void setNumeroDecimales(Integer numeroDecimales) {
        this.numeroDecimales = numeroDecimales;
    }

    public Long getIndicadorRevision() {
        return indicadorRevision;
    }

    public void setIndicadorRevision(Long indicadorRevision) {
        this.indicadorRevision = indicadorRevision;
    }

    public Float getImporteRedondeoLocal() {
        return importeRedondeoLocal;
    }

    public void setImporteRedondeoLocal(Float importeRedondeoLocal) {
        this.importeRedondeoLocal = importeRedondeoLocal;
    }


    public Float getIvaAsumidoEmpresa() {
        return ivaAsumidoEmpresa;
    }

    public void setIvaAsumidoEmpresa(Float ivaAsumidoEmpresa) {
        this.ivaAsumidoEmpresa = ivaAsumidoEmpresa;
    }

    public void setIndImpresionProdFueraCajaBolsa(Boolean indImpresionProdFueraCajaBolsa) {
        this.indImpresionProdFueraCajaBolsa = indImpresionProdFueraCajaBolsa;
    }

    public Boolean getIndImpresionProdFueraCajaBolsa() {
        return indImpresionProdFueraCajaBolsa;
    }

    public void setOidBoletaRecojoConsolidado(Long oidBoletaRecojoConsolidado) {
        this.oidBoletaRecojoConsolidado = oidBoletaRecojoConsolidado;
    }

    public Long getOidBoletaRecojoConsolidado() {
        return oidBoletaRecojoConsolidado;
    }
}
