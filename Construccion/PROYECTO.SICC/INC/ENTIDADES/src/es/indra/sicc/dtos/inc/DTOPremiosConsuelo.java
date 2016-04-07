/**
 * Copyright 2003 © por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 * 
 * Autor : Paola Cabrera
 */
 


package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;
import es.indra.sicc.util.DTOOIDs;
import es.indra.sicc.util.DTOOID;
import java.util.HashMap;


public class DTOPremiosConsuelo extends DTOBelcorp
{
    private HashMap lstPremiosConsuelo;
    private Long enviarA;
    private Integer unidades;
    private Long motivo;
    private String observaciones;
    private Boolean despachaArticulo;
    private Boolean comunicacion;
    private String codMensaje;
    private DTOOIDs clientesSeleccionados;    
    private DTOOID nroConcursoSeleccionados;
    private ArrayList clientesFicheroSeleccionados;
    private ArrayList lstPremiosDetalles;

    public DTOPremiosConsuelo()
    {
    }
    
    public HashMap getLstPremiosConsuelo()
    {
        return lstPremiosConsuelo;
    }

    public void setLstPremiosConsuelo(HashMap lstPremiosConsuelo)
    {
        this.lstPremiosConsuelo = lstPremiosConsuelo;
    }
    
    public Long getEnviarA()
    {
        return enviarA;
    }

    public void setEnviarA(Long enviarA)
    {
        this.enviarA = enviarA;
    }
    
    public Integer getUnidades()
    {
        return unidades;
    }

    public void setUnidades(Integer unidades)
    {
        this.unidades = unidades;
    }
    
    public Long getMotivo()
    {
        return motivo;
    }

    public void setMotivo(Long motivo)
    {
        this.motivo = motivo;
    }
    
    public String getObservaciones()
    {
        return observaciones;
    }

    public void setObservaciones(String observaciones)
    {
        this.observaciones = observaciones;
    }
    
    public Boolean getDespachaArticulo()
    {
        return despachaArticulo;
    }

    public void setDespachaArticulo(Boolean despachaArticulo)
    {
        this.despachaArticulo = despachaArticulo;
    }
    
    public Boolean getComunicacion()
    {
        return comunicacion;
    }

    public void setComunicacion(Boolean comunicacion)
    {
        this.comunicacion = comunicacion;
    }
    
    public String getCodMensaje()
    {
        return codMensaje;
    }

    public void setCodMensaje(String codMensaje)
    {
        this.codMensaje = codMensaje;
    }
    
    public DTOOIDs getClientesSeleccionados()
    {
      return this.clientesSeleccionados;
    }

    public void setClientesSeleccionados(DTOOIDs clientesSeleccionados)
    {
      this.clientesSeleccionados = clientesSeleccionados;
    }
    
    public DTOOID getNroConcursoSeleccionados()
    {
      return this.nroConcursoSeleccionados;
    }

    public void setNroConcursoSeleccionados(DTOOID nroConcursoSeleccionados)
    {
      this.nroConcursoSeleccionados = nroConcursoSeleccionados;
    }

    public ArrayList getClientesFicheroSeleccionados() {
        return clientesFicheroSeleccionados;
    }

    public void setClientesFicheroSeleccionados(ArrayList clientesFicheroSeleccionados) {
        this.clientesFicheroSeleccionados = clientesFicheroSeleccionados;
    }

  public ArrayList getLstPremiosDetalles() {
    return lstPremiosDetalles;
  }

  public void setLstPremiosDetalles(ArrayList lstPremiosDetalles) {
    this.lstPremiosDetalles = lstPremiosDetalles;
  }
       
    
}
