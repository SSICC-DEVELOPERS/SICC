package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOBusquedaClienteCalificado extends DTOBelcorp {
    private Long oidMarca; 
    private Long oidCanal; 
    private Long oidTipoCliente;
    private Boolean indParticipantesCompleto;
    private ArrayList listaParticipantesCalificacion;
    private ArrayList listaAmbitosGeograficos;
    private Boolean indAmbitoGeograficoCompleto;
    private Long oidAgrugacion;

  public Long getOidMarca()
  {
    return oidMarca;
  }

  public void setOidMarca(Long oidMarca)
  {
    this.oidMarca = oidMarca;
  }
  
  public Long getOidCanal()
  {
    return oidCanal;
  }

  public void setOidCanal(Long oidCanal)
  {
    this.oidCanal = oidCanal;  
  }  
  
  public Long getOidTipoCliente()
  {
    return oidTipoCliente;
  }

  public void setOidTipoCliente(Long oidTipoCliente)
  {
    this.oidTipoCliente = oidTipoCliente;  
  }  

  public Boolean getIndParticipantesCompleto()
  {
    return indParticipantesCompleto;
  }

  public void setIndParticipantesCompleto(Boolean indParticipantesCompleto)
  {
    this.indParticipantesCompleto = indParticipantesCompleto;  
  }  

  public ArrayList getListaParticipantesCalificacion()
  {
    return listaParticipantesCalificacion;
  }

  public void setListaParticipantesCalificacion(ArrayList listaParticipantesCalificacion)
  {
    this.listaParticipantesCalificacion = listaParticipantesCalificacion;
  }
  
  public ArrayList getListaAmbitosGeograficos()
  {
    return listaAmbitosGeograficos;
  }

  public void setListaAmbitosGeograficos(ArrayList listaAmbitosGeograficos)
  {
    this.listaAmbitosGeograficos = listaAmbitosGeograficos;
  }  

  public Boolean getIndAmbitoGeograficoCompleto()
  {
    return indAmbitoGeograficoCompleto;
  }

  public void setIndAmbitoGeograficoCompleto(Boolean indAmbitoGeograficoCompleto)
  {
    this.indAmbitoGeograficoCompleto = indAmbitoGeograficoCompleto;  
  }  
  
  public void setOidAgrugacion(Long oidAgrugacion)
  {
    this.oidAgrugacion = oidAgrugacion;
  }
  
  public Long getOidAgrugacion()
  {
    return oidAgrugacion;
  }
  
}


