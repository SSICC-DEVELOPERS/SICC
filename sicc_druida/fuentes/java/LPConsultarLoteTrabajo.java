/**
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */
 /*
    INDRA/CAR/PROY
    $Id: LPConsultarLoteTrabajo.java,v 1.1 2009/12/03 18:34:15 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            CCC
 * Subm�dulo:         
 *
 */ 

import LPSICCBase;

public class LPConsultarLoteTrabajo extends LPSICCBase {

	public LPConsultarLoteTrabajo() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      //rastreo();
      traza("Caso de Uso = consultar");
      
      conectorAction("LPBorrarLotesTrabajo");
      conectorActionParametro("casoDeUso", "consultar");
      
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}
