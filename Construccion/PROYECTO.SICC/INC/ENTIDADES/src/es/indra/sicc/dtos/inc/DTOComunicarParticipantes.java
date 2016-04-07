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
 */
package es.indra.sicc.dtos.inc;
import es.indra.sicc.util.DTOBelcorp;

/**
 * 
 * @author Mariano Rodriguez
 * @fecha 20/07/2005
 */
public class DTOComunicarParticipantes extends DTOBelcorp {

    private Long oidConcurso;
    private Long[] clientes;
    private Long oidNivelPremiacion;
    private Long[] posicion;
    private Long oidTipoPremio;
  
  
    public void setOidConcurso(Long oidConcurso) {
      this.oidConcurso = oidConcurso;
    }
  
    public Long getOidConcurso() {
      return oidConcurso;
    }
  
    public void setClientes(Long[] clientes) {
      this.clientes = clientes;
    }
  
    public Long[] getClientes() {
      return clientes;
    }
  
    public void setOidNivelPremiacion(Long oidNivelPremiacion) {
      this.oidNivelPremiacion = oidNivelPremiacion;
    }

    public Long getOidNivelPremiacion() {
      return oidNivelPremiacion;
    }

    public Long[] getPosicion()
    {
        return posicion;
    }

    public void setPosicion(Long[] posicion)
    {
        this.posicion = posicion;
    }

    public Long getOidTipoPremio()
    {
        return oidTipoPremio;
    }

    public void setOidTipoPremio(Long oidTipoPremio)
    {
        this.oidTipoPremio = oidTipoPremio;
    }
  
}