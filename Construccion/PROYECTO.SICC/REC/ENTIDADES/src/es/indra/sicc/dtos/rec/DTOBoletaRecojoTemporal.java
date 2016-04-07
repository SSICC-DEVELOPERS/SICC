package es.indra.sicc.dtos.rec;
import es.indra.sicc.dtos.zon.DTOUsuario;
import java.util.Date;

public class DTOBoletaRecojoTemporal extends DTOUsuario  {
  private Long numeroBoleta;
  private Long ordenIngreso;
  private Date fechaCaptura;
  private Long oid;
  private Long oidEstado;
  private String validacion;
  private String textoValidacion;
  private String tipoOperacion;
  private String preValidado;

  public DTOBoletaRecojoTemporal() {
  }

  public Long getNumeroBoleta() {
    return numeroBoleta;
  }

  public void setNumeroBoleta(Long numeroBoleta) {
    this.numeroBoleta = numeroBoleta;
  }

  public Long getOrdenIngreso() {
    return ordenIngreso;
  }

  public void setOrdenIngreso(Long ordenIngreso) {
    this.ordenIngreso = ordenIngreso;
  }

  public Date getFechaCaptura() {
    return fechaCaptura;
  }

  public void setFechaCaptura(Date fechaCaptura) {
    this.fechaCaptura = fechaCaptura;
  }

  public Long getOid() {
    return oid;
  }

  public void setOid(Long oid) {
    this.oid = oid;
  }

  public Long getOidEstado() {
    return oidEstado;
  }

  public void setOidEstado(Long oidEstado) {
    this.oidEstado = oidEstado;
  }

  public String getValidacion() {
    return validacion;
  }

  public void setValidacion(String validacion) {
    this.validacion = validacion;
  }

  public String getTextoValidacion() {
    return textoValidacion;
  }

  public void setTextoValidacion(String textoValidacion) {
    this.textoValidacion = textoValidacion;
  }

  public String getTipoOperacion() {
    return tipoOperacion;
  }

  public void setTipoOperacion(String tipoOperacion) {
    this.tipoOperacion = tipoOperacion;
  }

  public String getPreValidado() {
    return preValidado;
  }

  public void setPreValidado(String preValidado) {
    this.preValidado = preValidado;
  }
}