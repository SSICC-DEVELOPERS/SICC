package es.indra.sicc.logicanegocio.fac.generaciondocumentos;

import java.util.Date;
import es.indra.sicc.util.DTOBelcorp;

import java.math.BigDecimal;

public class DTOFACDocumentoContableDetalle extends DTOBelcorp
{
  private String codigoVenta;
  private String codigoProducto;
  private boolean detalleNoImprimible;
  private String descripcionProd;
  private Long unidadesAtendidas;
  private Float precioUnitario;
  private Float valorVenta;
  private Float totalPagarLocal;
  private Float precioCatalUnitLocal;
  private Float precioContUnitLocal;
  private Float precioCatalTotLocal;
  private Float precioContTotLocal;
  private Float precioFactUnitLocal;
  private Float precioFactTotalLocal;
  private Float precioSinImpuUnitLocal;
  private Float precioSinImpuTotalLocal;
  private Long periodo;
  private String codigoCompleto;
  //private boolean dentroCaja; Eliminado por incidencia 19926
  private boolean noImprimible;
  private String indicadorDentroFueraCajaBolsa;
  
  //CCC
  private Date fechaDeMovimiento;
  private String codigoProceso;
  private String descripcionTipoCargoAbono;
  private String numeroIdentificadorCuota;
  private Float importeMovimiento;
  private String indicadorParaConsultas;
  
  //Añadido por incidencia BELC300021757
  private Float precioNetoTotalLocal;
  private Float precioNetoUnitarioLocal;
  
  //    Agregado por HRCS - Fecha 06/06/2007 - Cambio Sicc20070274
  private String codPeriodo;
  private Long codigoVentaFicticio;
  private String codAgrupCatalogo;
  private Long unidadesSolicitadas;
  private Float importeDescTotaLocal;
  private Float porcentajeDescuento;
  private Long oidFormaPago;
  
  // dmorello, 09/06/2009, Cambio 20090922
  private BigDecimal importeImpuestoProductoNacional;

  
  
  public DTOFACDocumentoContableDetalle()
  
  {
  
  }

  public String getIndicadorDentroFueraCajaBolsa()
  {
    return indicadorDentroFueraCajaBolsa;
  }


  public void setIndicadorDentroFueraCajaBolsa(String entrada)
  {
    indicadorDentroFueraCajaBolsa=entrada;
  }

  public Float getPrecioSinImpuUnitLocal()
  {
    return precioSinImpuUnitLocal;
  }

  public void setPrecioSinImpuUnitLocal(Float entrada)
  {
    precioSinImpuUnitLocal=entrada;
  }

  public Float getPrecioSinImpuTotalLocal()
  {
    return precioSinImpuTotalLocal;
  }

  public void setPrecioSinImpuTotalLocal(Float entrada)
  {
    precioSinImpuTotalLocal=entrada;
  }


  public boolean getNoImprimible()
  {
    return noImprimible;
  }

  public void setNoImprimible(boolean entrada)
  {
    noImprimible=entrada;
  }


  public Float getPrecioFactUnitLocal()
  {
    return precioFactUnitLocal;
  }

  public void setPrecioFactUnitLocal(Float entrada)
  {
    precioFactUnitLocal=entrada;
  }

  public Float getPrecioFactTotalLocal()
  {
    return precioFactTotalLocal;
  }

  public void setPrecioFactTotalLocal(Float entrada)
  {
    precioFactTotalLocal=entrada;
  }

  public void setCodigoCompleto(String entrada)
  {
    codigoCompleto=entrada;
  }

  public String getCodigoCompleton()
  {
    return codigoCompleto;
  }

  public String getCodigoCompleto()
  {
    return codigoCompleto;
  }


  public void setPeriodo(Long entrada)
  {
    periodo=entrada;
  }
  
  public Long getPeriodo()
  {
    return periodo;
  }
  
  public void setPrecioCatalUnitLocal(Float entrada)
  {
    precioCatalUnitLocal=entrada;
  }


  public Float getPrecioCatalUnitLocal()
  {
    return precioCatalUnitLocal;
  }

  public void setPrecioContUnitLocal(Float entrada)
  {
    precioContUnitLocal=entrada;
  }

  public Float getPrecioContUnitLocal()
  {
    return precioContUnitLocal;
  }


  public void setPrecioCatalTotLocal(Float entrada)
  {
    precioCatalTotLocal=entrada;    
        
  }

  public Float getPrecioCatalTotLocal()
  {
    return precioCatalTotLocal;
  }


  public void setPrecioContTotLocal(Float entrada)
  {
    precioContTotLocal=entrada;
  }

  public Float getPrecioContTotLocal()
  {
    return precioContTotLocal;
  }


  public void setCodigoVenta(String entrada)
  {
  codigoVenta=entrada;
  }
  
  public String getCodigoVenta()
  {
    return codigoVenta;
  }
  
  public void setCodigoProducto(String entrada)
  {
    codigoProducto=entrada;
  }
  
  public String getCodigoProducto()
  {
    return codigoProducto;
  }
  
  public void setDetalleNoImprimible(boolean entrada)
  {
    detalleNoImprimible=entrada;
  }
  
  
  public boolean getDetalleNoImprimible()
  {
    return detalleNoImprimible;
  }
  
  public void setDescripcionProd(String entrada)
  {
    descripcionProd=entrada;
  }
  
  public String getDescripcionProd()
  {
    return descripcionProd;
  }
  
  public void setUnidadesAtendidas(Long entrada)
  {
    unidadesAtendidas=entrada;
  }
  
  public Long getUnidadesAtendidas()
  {
    return unidadesAtendidas;
  }
  
  public void setPrecioUnitario (Float entrada)
  {
     precioUnitario=entrada;
  }
  
  public Float getPrecioUnitario()
  {
    return precioUnitario;
  }
  
  public void setValorVenta (Float entrada)
  {
     valorVenta=entrada;
  }
  
  
  public Float getValorVenta()
  {
    return valorVenta;
  }
  
  public void setTotalPagarLocal (Float entrada)
  {
     totalPagarLocal=entrada;
  }
  
  public Float getTotalPagarLocal()
  {
    return totalPagarLocal;
  }

  public Date getFechaDeMovimiento()
  {
    return fechaDeMovimiento;
  }

  public void setFechaDeMovimiento(Date newFechaDeMovimiento)
  {
    fechaDeMovimiento = newFechaDeMovimiento;
  }

  public String getCodigoProceso()
  {
    return codigoProceso;
  }

  public void setCodigoProceso(String newCodigoProceso)
  {
    codigoProceso = newCodigoProceso;
  }

  public String getDescripcionTipoCargoAbono()
  {
    return descripcionTipoCargoAbono;
  }

  public void setDescripcionTipoCargoAbono(String newDescripcionTipoCargoAbono)
  {
    descripcionTipoCargoAbono = newDescripcionTipoCargoAbono;
  }

  public String getNumeroIdentificadorCuota()
  {
    return numeroIdentificadorCuota;
  }

  public void setNumeroIdentificadorCuota(String newNumeroIdentificadorCuota)
  {
    numeroIdentificadorCuota = newNumeroIdentificadorCuota;
  }

  public Float getImporteMovimiento()
  {
    return importeMovimiento;
  }

  public void setImporteMovimiento(Float newImporteMovimiento)
  {
    importeMovimiento = newImporteMovimiento;
  }

  public String getIndicadorParaConsultas()
  {
    return indicadorParaConsultas;
  }

  public void setIndicadorParaConsultas(String newIndicadorParaConsultas)
  {
    indicadorParaConsultas = newIndicadorParaConsultas;
  }

    public Float getPrecioNetoTotalLocal()
    {
        return precioNetoTotalLocal;
    }

    public void setPrecioNetoTotalLocal(Float precioNetoTotalLocal)
    {
        this.precioNetoTotalLocal = precioNetoTotalLocal;
    }

    public Float getPrecioNetoUnitarioLocal()
    {
        return precioNetoUnitarioLocal;
    }

    public void setPrecioNetoUnitarioLocal(Float precioNetoUnitarioLocal)
    {
        this.precioNetoUnitarioLocal = precioNetoUnitarioLocal;
    }


    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }


    public String getCodPeriodo() {
        return codPeriodo;
    }

    public Long getCodigoVentaFicticio() {
        return codigoVentaFicticio;
    }

    public void setCodigoVentaFicticio(Long codigoVentaFicticio) {
        this.codigoVentaFicticio = codigoVentaFicticio;
    }

    public String getCodAgrupCatalogo() {
        return codAgrupCatalogo;
    }

    public void setCodAgrupCatalogo(String codAgrupCatalogo) {
        this.codAgrupCatalogo = codAgrupCatalogo;
    }

    public Long getUnidadesSolicitadas() {
        return unidadesSolicitadas;
    }

    public void setUnidadesSolicitadas(Long unidadesSolicitadas) {
        this.unidadesSolicitadas = unidadesSolicitadas;
    }

    public Float getImporteDescTotaLocal() {
        return importeDescTotaLocal;
    }

    public void setImporteDescTotaLocal(Float importeDescTotaLocal) {
        this.importeDescTotaLocal = importeDescTotaLocal;
    }

    public Float getPorcentajeDescuento() {
        return porcentajeDescuento;
    }

    public void setPorcentajeDescuento(Float porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    public Long getOidFormaPago() {
        return oidFormaPago;
    }

    public void setOidFormaPago(Long oidFormaPago) {
        this.oidFormaPago = oidFormaPago;
    }

    public void setImporteImpuestoProductoNacional(BigDecimal importeImpuestoProductoNacional) {
        this.importeImpuestoProductoNacional = importeImpuestoProductoNacional;
    }

    public BigDecimal getImporteImpuestoProductoNacional() {
        return importeImpuestoProductoNacional;
    }
}


