/**
 * Copyright 2005 © por Indra Sistemas,S.A.. Todos los derechos reservados.
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
 *
 * Sistema:         Belcorp
 * Modulo:          EDU
 * Componente:      DTO
 * Fecha:           05/12/2003
 * Observaciones:     
 *                    
 * @version         1.0
 * @autor           Vanesa Conte
 */
 
package es.indra.sicc.dtos.edu;
import es.indra.sicc.util.DTOBelcorp;

public class DTOParticipantesValidados extends DTOBelcorp 
{
  private DTOParticipante[] validos;
  private DTOParticipante[] noValidos;

  public DTOParticipantesValidados()
  {
  }

 
  public DTOParticipante[] getValidos()
  {
    return validos;
  }

  public void setValidos(DTOParticipante[] validos)
  {
    this.validos = validos;
  }

  public DTOParticipante[] getNoValidos()
  {
    return noValidos;
  }

  public void setNoValidos(DTOParticipante[] noValidos)
  {
    this.noValidos = noValidos;
  }
}