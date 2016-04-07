package es.indra.sicc.dtos.mae;
import es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion;
/**
 * Sistema:       Belcorp
 * Modulo:           MAE
 * Submódulo:       Mantenimiento de Materiales
 * Componente:      DTO's
 * Fecha:             11/12/2003
 * Observaciones: 
 *
 *
 * @author Luciana C. Garcia Mari
 * @version 1.0
 */
public class DTOBusquedaConfiguracionCampo extends DTOSiccPaginacion  {

  private Long campo;
  private Long subtipoCliente;
  private Long tipoCliente;
  private Boolean obligatorio;
  private Boolean modificable;
  private String valorDefecto;
  private Boolean indClienteProducto;
  
  public DTOBusquedaConfiguracionCampo() {
  }
  public Long getCampo() {
    return campo;
  }

  public void setCampo(Long newCampo) {
    campo = newCampo;
  }

  public Long getSubtipoCliente() {
    return subtipoCliente;
  }

  public void setSubtipoCliente(Long newSubtipoCliente) {
    subtipoCliente = newSubtipoCliente;
  }

  public Boolean getObligatorio() {
    return obligatorio;
  }

  public void setObligatorio(Boolean newObligatorio) {
    obligatorio = newObligatorio;
  }

  public Boolean getModificable() {
    return modificable;
  }

  public void setModificable(Boolean newModificable) {
    modificable = newModificable;
  }

  public String getValorDefecto() {
    return valorDefecto;
  }

  public void setValorDefecto(String newValorDefecto) {
    valorDefecto = newValorDefecto;
  }

  public Boolean getIndClienteProducto() {
    return indClienteProducto;
  }

  public void setIndClienteProducto(Boolean newIndClienteProducto) {
    indClienteProducto = newIndClienteProducto;
  }

  public Long getTipoCliente() {
    return tipoCliente;
  }

  public void setTipoCliente(Long newTipoCliente) {
    tipoCliente = newTipoCliente;
  }
}