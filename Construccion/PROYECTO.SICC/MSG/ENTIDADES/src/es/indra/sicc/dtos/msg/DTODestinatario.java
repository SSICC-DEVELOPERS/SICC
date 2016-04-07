package es.indra.sicc.dtos.msg;
import es.indra.sicc.cmn.negocio.auditoria.DTOAuditableSICC;
import java.util.Vector;

public class DTODestinatario extends DTOAuditableSICC 
{
  private Long oidMensaje;
  private Boolean pedido;
  private Vector unidadAdministrativa;                //vector de DTOMensajeUnidadAdministrativa
  private Vector tipoCliente;                         //vector de DTOMensajeTipoCliente
  private Vector codigoVenta;                         //vector de DTOMensajeTipoCliente  
  private Vector cliente;                             //vector de DTOMensajeTipoCliente 
  //private DTOMensajePrograma programaAsociado;
  private Vector marca;                               //vector de DTOMensajeTipoCliente
  private Boolean consultoras; 

  public Long getOidMensaje()
  {
    return oidMensaje;
  }

  public void setOidMensaje(Long newOidMensaje)
  {
    oidMensaje = newOidMensaje;
  }

  public Boolean getPedido()
  {
    return pedido;
  }

  public void setPedido(Boolean newPedido)
  {
    pedido = newPedido;
  }

  public Vector getUnidadAdministrativa() {
    return unidadAdministrativa;
  }

  public void setUnidadAdministrativa(Vector newUnidadAdministrativa) {
    unidadAdministrativa = newUnidadAdministrativa;
  }

  public Vector getTipoCliente() {
    return tipoCliente;
  }

  public void setTipoCliente(Vector newTipoCliente) {
    tipoCliente = newTipoCliente;
  }

  public Vector getCodigoVenta() {
    return codigoVenta;
  }

  public void setCodigoVenta(Vector newCodigoVenta) {
    codigoVenta = newCodigoVenta;
  }

  public Vector getCliente() {
    return cliente;
  }

  public void setCliente(Vector newCliente) {
    cliente = newCliente;
  }

  public Vector getMarca() {
    return marca;
  }

  public void setMarca(Vector newMarca) {
    marca = newMarca;
  }

  public Boolean getConsultoras() {
    return consultoras;
  }

  public void setConsultoras(Boolean newConsultoras) {
    consultoras = newConsultoras;
  }

  /*public DTOMensajePrograma getProgramaAsociado() {
    return programaAsociado;
  }

  public void setProgramaAsociado(DTOMensajePrograma newProgramaAsociado) {
    programaAsociado = newProgramaAsociado;
  }*/
}