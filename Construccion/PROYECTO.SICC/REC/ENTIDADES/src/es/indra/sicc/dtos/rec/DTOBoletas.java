package es.indra.sicc.dtos.rec;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import java.util.Date;

public class DTOBoletas extends DTOBelcorp  {
  private ArrayList boletas;
  private Date fechaCaptura;
  private Long estado;
  private boolean indProcesar;

  public DTOBoletas() {
  }

  public ArrayList getBoletas() {
    return boletas;
  }

  public void setBoletas(ArrayList boletas) {
    this.boletas = boletas;
  }

  public Date getFechaCaptura() {
    return fechaCaptura;
  }

  public void setFechaCaptura(Date fechaCaptura) {
    this.fechaCaptura = fechaCaptura;
  }

  public Long getEstado() {
    return estado;
  }

  public void setEstado(Long estado) {
    this.estado = estado;
  }

  public boolean getIndProcesar() {
    return indProcesar;
  }

  public void setIndProcesar(boolean indProcesar) {
    this.indProcesar = indProcesar;
  }
}