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
 * Autor : Dante Castiglione
 */

package es.indra.sicc.dtos.inc;

import es.indra.sicc.util.DTOBelcorp;
import java.util.ArrayList;

public class DTOListaAmbitosGeograficos extends DTOBelcorp
{
  //private DTOIncAmbitoGeografico[] ambitoGeografico;
  private ArrayList ambitoGeografico; // arrayList de DTOIncAmbitoGeografico

  public DTOListaAmbitosGeograficos()
  {
    super();
  }

  public ArrayList getAmbitoGeografico()
  {
    return ambitoGeografico;
  }

  public void setAmbitoGeografico(ArrayList ambitoGeografico)
  {
    this.ambitoGeografico = ambitoGeografico;
  }
}