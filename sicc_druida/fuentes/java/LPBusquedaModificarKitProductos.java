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
    $Id: LPBusquedaModificarKitProductos.java,v 1.1 2009/12/03 18:38:52 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            MAE
 * Subm�dulo:         
 * Componente:        LP
 * Fecha:             16/02/2004
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DMCO-MAE-201-304
 
 * @version           1.0
 * @autor             Matias Dolce
 */ 

import LPSICCBase;

public class LPBusquedaModificarKitProductos extends LPSICCBase {

	public LPBusquedaModificarKitProductos() {
		super();
	}


	public void inicio() throws Exception {

	}
  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      rastreo();
      traza("Caso de Uso = Modificar");
      conectorAction("LPBusquedaKit");
      conectorActionParametro("casoDeUso", "modificar");
    }
    catch ( Exception e )  {
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}
