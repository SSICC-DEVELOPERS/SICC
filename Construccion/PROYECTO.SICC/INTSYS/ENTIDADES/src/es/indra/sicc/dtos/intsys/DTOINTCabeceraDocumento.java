package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.util.Date;

public class DTOINTCabeceraDocumento extends DTOBelcorp  {
  private Long oidCabecera;
  private String codigoEmpresa;
  private String numeroPedido;
  private String codigoCliente;
  private Date fechaPedido;
  private String indicadorPedidoAChequear;
  private Integer totalItemsPedido;
  private Integer totalUnidadesPedido;
  private String indicadorPedidoExpress;
  private Date fechaCita;
  private String horaCita;
  private String claseSolicitud;
  private String tipoSolicitud;
  private ArrayList listaPosiciones;

  public DTOINTCabeceraDocumento() {
  }

  public Long getOidCabecera() {
    return oidCabecera;
  }

  public void setOidCabecera(Long oidCabecera) {
    this.oidCabecera = oidCabecera;
  }

  public String getCodigoEmpresa() {
    return codigoEmpresa;
  }

  public void setCodigoEmpresa(String codigoEmpresa) {
    this.codigoEmpresa = codigoEmpresa;
  }

  public String getNumeroPedido() {
    return numeroPedido;
  }

  public void setNumeroPedido(String numeroPedido) {
    this.numeroPedido = numeroPedido;
  }

  public String getCodigoCliente() {
    return codigoCliente;
  }

  public void setCodigoCliente(String codigoCliente) {
    this.codigoCliente = codigoCliente;
  }

  public Date getFechaPedido() {
    return fechaPedido;
  }

  public void setFechaPedido(Date fechaPedido) {
    this.fechaPedido = fechaPedido;
  }

  public String getIndicadorPedidoAChequear() {
    return indicadorPedidoAChequear;
  }

  public void setIndicadorPedidoAChequear(String indicadorPedidoAChequear) {
    this.indicadorPedidoAChequear = indicadorPedidoAChequear;
  }

  public Integer getTotalItemsPedido() {
    return totalItemsPedido;
  }

  public void setTotalItemsPedido(Integer totalItemsPedido) {
    this.totalItemsPedido = totalItemsPedido;
  }

  public Integer getTotalUnidadesPedido() {
    return totalUnidadesPedido;
  }

  public void setTotalUnidadesPedido(Integer totalUnidadesPedido) {
    this.totalUnidadesPedido = totalUnidadesPedido;
  }

  public String getIndicadorPedidoExpress() {
    return indicadorPedidoExpress;
  }

  public void setIndicadorPedidoExpress(String indicadorPedidoExpress) {
    this.indicadorPedidoExpress = indicadorPedidoExpress;
  }

  public Date getFechaCita() {
    return fechaCita;
  }

  public void setFechaCita(Date fechaCita) {
    this.fechaCita = fechaCita;
  }

  public String getHoraCita() {
    return horaCita;
  }

  public void setHoraCita(String horaCita) {
    this.horaCita = horaCita;
  }

  public String getClaseSolicitud() {
    return claseSolicitud;
  }

  public void setClaseSolicitud(String claseSolicitud) {
    this.claseSolicitud = claseSolicitud;
  }

  public String getTipoSolicitud() {
    return tipoSolicitud;
  }

  public void setTipoSolicitud(String tipoSolicitud) {
    this.tipoSolicitud = tipoSolicitud;
  }

  public ArrayList getListaPosiciones() {
    return listaPosiciones;
  }

  public void setListaPosiciones(ArrayList listaPosiciones) {
    this.listaPosiciones = listaPosiciones;
  }
}