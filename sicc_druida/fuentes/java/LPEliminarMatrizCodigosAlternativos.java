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
    $Id: LPEliminarMatrizCodigosAlternativos.java,v 1.1 2009/12/03 18:40:07 pecbazalar Exp $
    DESC
 */ 

import LPSICCBase;

public class LPEliminarMatrizCodigosAlternativos extends LPSICCBase {

	public LPEliminarMatrizCodigosAlternativos() {
		super();
	
	}

 public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
			conectorAction("LPSeleccionarMF");	
			conectorParametroSesion("UltimaLP","LPBuscarMatrizCodigosAlternativos");
			
   }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}
