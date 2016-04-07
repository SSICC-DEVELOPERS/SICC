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
    $Id: LPInsertaSecuenciaProcesos.java,v 1.1 2009/12/03 18:40:34 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         
 * Componente:        LPInsertaSecuenciaProcesos.java
 * Fecha:             13/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-P0018
 * @version           1.0
 * @autor             Andrés Pollitzer
 */


public class LPInsertaSecuenciaProcesos extends LPSICCBase  {

  public LPInsertaSecuenciaProcesos()  {
		super();
	}


	public void inicio() throws Exception  {
	}


  public void ejecucion() throws Exception  {
    setTrazaFichero();

    try  {
      rastreo();
        traza("Caso de Uso = Insertar Secuencia Procesos");
      conectorAction("LPMantieneSecuenciaProcesos");
      conectorActionParametro("hCasoDeUso", "Insertar");
    }
    catch ( Exception e )  {
      e.printStackTrace();
      lanzarPaginaError(e);
    }

  }



}//fin clase

/***************************************************************************************************
1.2 LPInsertaSecuenciaProcesos.java
***********************************
Operation --Not Named-- ejecucion (), in Class LPInsertaSecuenciaProcesos
Si accion = ""{
Invoca a LPMantieneSecuenciaProcesos cambiando la accion = "muestraInsercion"
}
***************************************************************************************************/
