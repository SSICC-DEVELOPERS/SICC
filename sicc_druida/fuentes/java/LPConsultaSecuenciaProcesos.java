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
    $Id: LPConsultaSecuenciaProcesos.java,v 1.1 2009/12/03 18:34:07 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Subm�dulo:         
 * Componente:        LPConsultaSecuenciaProcesos.java
 * Fecha:             13/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-P0018
 * @version           1.0
 * @autor             Andr�s Pollitzer
 */

import LPSICCBase;


public class LPConsultaSecuenciaProcesos extends LPSICCBase  {

	public LPConsultaSecuenciaProcesos()  {
		super();
	}


	public void inicio() throws Exception  {
	}


  public void ejecucion() throws Exception  {
    setTrazaFichero();

    try  {
      rastreo();
        traza("Caso de Uso = Consultar Secuencia Procesos");
      conectorAction("LPMantieneSecuenciaProcesos");
      conectorActionParametro("hCasoDeUso", "Consultar");
    }
    catch ( Exception e )  {
      e.printStackTrace();
      lanzarPaginaError(e);
    }

  }



}//fin clase

/***************************************************************************************************
1.4 LPConsultaSecuenciaProcesos.java
************************************
Operation --Not Named-- ejecucion (), in Class LPConsultaSecuenciaProcesos
Si accion = ""{
Invoca a LPMantieneSecuenciaProcesos cambiando la accion = "muestraConsulta"
}
***************************************************************************************************/
