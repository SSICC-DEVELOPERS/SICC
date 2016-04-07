package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;

public class DTODatosTipoSolicitudOCR extends DTOBelcorp  {

  private Long oidTipoSolicitud;
  private Long oidTipoSolicitudPais;
  private Long oidMarca;
  private Long oidAcceso;
  private Long oidCanal;
  private Long oidTipoCliente;
  private Long oidPeriodo;
  private Long oidMoneda;
  private String valGlosa;
  private Long oidTipoDocumento;
  private Long oidFormaPago;
  private Long oidClaseSolicitud;
  private Boolean indOrdenCompra;
  private Boolean indPermiteUnion;
  private Boolean indPedidoPrueba;
  private Long oidTipoConsolidado;
  private Long oidSociedad;
  private Long oidSubacceso;
  private Long numUnidadesAlarma;
  private Boolean indSolicitudNega;
  private Long oidAlmacen;
  
  //cbio. nº2
  private Long oidSolicitudReferenciada;
  private Long oidProceso;
  private Boolean indOnLine;
  private String codigoSubacceso;
  
  public DTODatosTipoSolicitudOCR() {
  }
  
 
    public Long getOidTipoSolicitud() {
        return oidTipoSolicitud;
    }

    public void setOidTipoSolicitud(Long oidTipoSolicitud) {
        this.oidTipoSolicitud = oidTipoSolicitud;
    }

    public Long getOidTipoSolicitudPais() {
        return oidTipoSolicitudPais;
    }

    public void setOidTipoSolicitudPais(Long oidTipoSolicitudPais) {
        this.oidTipoSolicitudPais = oidTipoSolicitudPais;
    }

    public Long getOidMarca() {
        return oidMarca;
    }

    public void setOidMarca(Long oidMarca) {
        this.oidMarca = oidMarca;
    }

    public Long getOidAcceso() {
        return oidAcceso;
    }

    public void setOidAcceso(Long oidAcceso) {
        this.oidAcceso = oidAcceso;
    }

    public Long getOidCanal() {
        return oidCanal;
    }

    public void setOidCanal(Long oidCanal) {
        this.oidCanal = oidCanal;
    }

    public Long getOidTipoCliente() {
        return oidTipoCliente;
    }

    public void setOidTipoCliente(Long oidTipoCliente) {
        this.oidTipoCliente = oidTipoCliente;
    }

    public Long getOidPeriodo() {
        return oidPeriodo;
    }

    public void setOidPeriodo(Long oidPeriodo) {
        this.oidPeriodo = oidPeriodo;
    }

    public Long getOidMoneda() {
        return oidMoneda;
    }

    public void setOidMoneda(Long oidMoneda) {
        this.oidMoneda = oidMoneda;
    }

    public String getValGlosa() {
        return valGlosa;
    }

    public void setValGlosa(String valGlosa) {
        this.valGlosa = valGlosa;
    }

    public Long getOidTipoDocumento() {
        return oidTipoDocumento;
    }

    public void setOidTipoDocumento(Long oidTipoDocumento) {
        this.oidTipoDocumento = oidTipoDocumento;
    }

    public Long getOidFormaPago() {
        return oidFormaPago;
    }

    public void setOidFormaPago(Long oidFormaPago) {
        this.oidFormaPago = oidFormaPago;
    }

    public Long getOidClaseSolicitud() {
        return oidClaseSolicitud;
    }

    public void setOidClaseSolicitud(Long oidClaseSolicitud) {
        this.oidClaseSolicitud = oidClaseSolicitud;
    }

    public Boolean getIndOrdenCompra() {
        return indOrdenCompra;
    }

    public void setIndOrdenCompra(Boolean indOrdenCompra) {
        this.indOrdenCompra = indOrdenCompra;
    }

    public Boolean getIndPermiteUnion() {
        return indPermiteUnion;
    }

    public void setIndPermiteUnion(Boolean indPermiteUnion) {
        this.indPermiteUnion = indPermiteUnion;
    }

    public Boolean getIndPedidoPrueba() {
        return indPedidoPrueba;
    }

    public void setIndPedidoPrueba(Boolean indPedidoPrueba) {
        this.indPedidoPrueba = indPedidoPrueba;
    }

    public Long getOidTipoConsolidado() {
        return oidTipoConsolidado;
    }

    public void setOidTipoConsolidado(Long oidTipoConsolidado) {
        this.oidTipoConsolidado = oidTipoConsolidado;
    }

    public Long getOidSociedad() {
        return oidSociedad;
    }

    public void setOidSociedad(Long oidSociedad) {
        this.oidSociedad = oidSociedad;
    }

    public Long getOidSubacceso() {
        return oidSubacceso;
    }

    public void setOidSubacceso(Long oidSubacceso) {
        this.oidSubacceso = oidSubacceso;
    }

    public Long getNumUnidadesAlarma() {
        return numUnidadesAlarma;
    }

    public void setNumUnidadesAlarma(Long numUnidadesAlarma) {
        this.numUnidadesAlarma = numUnidadesAlarma;
    }

    public Boolean getIndSolicitudNega() {
        return indSolicitudNega;
    }

    public void setIndSolicitudNega(Boolean indSolicitudNega) {
        this.indSolicitudNega = indSolicitudNega;
    }

    public Long getOidAlmacen() {
        return oidAlmacen;
    }

    public void setOidAlmacen(Long oidAlmacen) {
        this.oidAlmacen = oidAlmacen;
    }


  public void setOidSolicitudReferenciada(Long oidSolicitudReferenciada) {
    this.oidSolicitudReferenciada = oidSolicitudReferenciada;
  }


  public Long getOidSolicitudReferenciada() {
    return oidSolicitudReferenciada;
  }

  public Long getOidProceso()
  {
    return oidProceso;
  }

  public void setOidProceso(Long oidProceso)
  {
    this.oidProceso = oidProceso;
  }

  public Boolean getIndOnLine()
  {
    return indOnLine;
  }

  public void setIndOnLine(Boolean indOnLine)
  {
    this.indOnLine = indOnLine;
  }

    public String getCodigoSubacceso() {
        return codigoSubacceso;
    }

    public void setCodigoSubacceso(String codigoSubacceso) {
        this.codigoSubacceso = codigoSubacceso;
    }
}
