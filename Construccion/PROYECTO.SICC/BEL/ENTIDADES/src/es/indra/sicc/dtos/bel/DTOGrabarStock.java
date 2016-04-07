package es.indra.sicc.dtos.bel;
import es.indra.sicc.util.DTOBelcorp;
import java.util.HashMap;

public class DTOGrabarStock extends DTOBelcorp  {
  DTOMovimientoAlmacen dtoMovimientoAlmacen;
  DTOReportePedidos dtoReportePedidos;
  DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen;
  HashMap hashOperacion1;
  HashMap hashOperacion2;
  Integer numeroOperacion;

  public DTOGrabarStock() {
  }

  public DTOMovimientoAlmacen getDtoMovimientoAlmacen() {
    return dtoMovimientoAlmacen;
  }

  public void setDtoMovimientoAlmacen(DTOMovimientoAlmacen dtoMovimientoAlmacen) {
    this.dtoMovimientoAlmacen = dtoMovimientoAlmacen;
  }

  public DTOReportePedidos getDtoReportePedidos() {
    return dtoReportePedidos;
  }

  public void setDtoReportePedidos(DTOReportePedidos dtoReportePedidos) {
    this.dtoReportePedidos = dtoReportePedidos;
  }

  public DTOTipoMovimientoAlmacen getDtoTipoMovimientoAlmacen() {
    return dtoTipoMovimientoAlmacen;
  }

  public void setDtoTipoMovimientoAlmacen(DTOTipoMovimientoAlmacen dtoTipoMovimientoAlmacen) {
    this.dtoTipoMovimientoAlmacen = dtoTipoMovimientoAlmacen;
  }

  public HashMap getHashOperacion1() {
    return hashOperacion1;
  }

  public void setHashOperacion1(HashMap hashOperacion1) {
    this.hashOperacion1 = hashOperacion1;
  }

  public HashMap getHashOperacion2() {
    return hashOperacion2;
  }

  public void setHashOperacion2(HashMap hashOperacion2) {
    this.hashOperacion2 = hashOperacion2;
  }

  public Integer getNumeroOperacion() {
    return numeroOperacion;
  }

  public void setNumeroOperacion(Integer numeroOperacion) {
    this.numeroOperacion = numeroOperacion;
  }
}