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
    $Id: LPConsultarMatricesCodigosAlternativos.java 
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            PRE
 * Submódulo:         
 * Componente:        LP
 */ 

import LPSICCBase;

public class LPConsultarMatricesCodigosAlternativos extends LPSICCBase {

	public LPConsultarMatricesCodigosAlternativos() {
		super();
	}


	public void inicio() throws Exception {

	}

  public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      //rastreo();
      traza("Caso de Uso = Consultar");
      
      conectorAction("LPBuscarMatrizCodigosAlternativos");
      conectorActionParametro("casoDeUso", "consultar");
      traza("despues de setar lp");
      
      
    }
    catch ( Exception e )  {
      traza("entro en el catch de buscar consultar");
      e.printStackTrace();     
      lanzarPaginaError(e);
    }

  }

}
