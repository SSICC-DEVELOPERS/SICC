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
 */
 /*
    INDRA/CAR/PROY
    $Id: LPEliminarLote.java,v 1.1 2009/12/03 18:32:59 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            CCC
 * Submódulo:         
 *
 */ 

import LPSICCBase;

public class LPEliminarLote extends LPSICCBase {

	public LPEliminarLote() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      //rastreo();
      traza("Caso de Uso = Eliminar");
      
      conectorAction("LPBorrarLotesTrabajo");
      conectorActionParametro("casoDeUso", "eliminar");
      
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}
