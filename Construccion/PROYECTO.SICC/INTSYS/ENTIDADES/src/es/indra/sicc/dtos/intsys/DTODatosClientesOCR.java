package es.indra.sicc.dtos.intsys;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTODatosClientesOCR extends DTOBelcorp  {
  private Long oidCliente;
  private Long oidTipoCliente;
  private String codPais;
  private String codClte;
  private Long oidDestino;
  private Long oidTipoDocumento;
  private ArrayList listaOidTipoCliente;

  public DTODatosClientesOCR() {
  }
  
  public Long getOidCliente() {
      return oidCliente;
  }

  public void setOidCliente(Long oidCliente) {
      this.oidCliente = oidCliente;
  }

  public Long getOidTipoCliente() {
      return oidTipoCliente;
  }

  public void setOidTipoCliente(Long oidTipoCliente) {
      this.oidTipoCliente = oidTipoCliente;
  }


  public void setCodPais(String codPais) {
    this.codPais = codPais;
  }


  public String getCodPais() {
    return codPais;
  }


  public void setCodClte(String codClte) {
    this.codClte = codClte;
  }


  public String getCodClte() {
    return codClte;
  }

  public Long getOidDestino()
  {
    return oidDestino;
  }

  public void setOidDestino(Long oidDestino)
  {
    this.oidDestino = oidDestino;
  }

  public Long getOidTipoDocumento()
  {
    return oidTipoDocumento;
  }

  public void setOidTipoDocumento(Long oidTipoDocumento)
  {
    this.oidTipoDocumento = oidTipoDocumento;
  }

  public ArrayList getListaOidTipoCliente()
  {
    return listaOidTipoCliente;
  }

  public void setListaOidTipoCliente(ArrayList listaOidTipoCliente)
  {
    this.listaOidTipoCliente = listaOidTipoCliente;
  }


}