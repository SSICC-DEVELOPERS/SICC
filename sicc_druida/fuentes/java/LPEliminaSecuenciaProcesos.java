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
    $Id: LPEliminaSecuenciaProcesos.java,v 1.1 2009/12/03 18:35:30 pecbazalar Exp $
    DESC
 */

/**
 * Sistema:           Belcorp
 * Modulo:            PED
 * Submódulo:         
 * Componente:        LPEliminaSecuenciaProcesos.java
 * Fecha:             13/07/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-PED-201-354-P0018
 * @version           1.0
 * @autor             Andrés Pollitzer
 */

import LPSICCBase;


public class LPEliminaSecuenciaProcesos extends LPSICCBase  {

  public LPEliminaSecuenciaProcesos()  {
    super();
  }


  public void inicio() throws Exception  {
  }


  public void ejecucion() throws Exception  {
    setTrazaFichero();

    try  {
      rastreo();
        traza("Caso de Uso = Eliminar Secuencia Procesos");
      conectorAction("LPMantieneSecuenciaProcesos");
      conectorActionParametro("hCasoDeUso","Eliminar"); 
    }
    catch ( Exception e )  {
      e.printStackTrace();
      lanzarPaginaError(e);
    }

  }



}//finclase

/***************************************************************************************************
1.5 LPEliminaSecuenciaProcesos.java
***********************************
Operation --Not Named-- ejecucion (), in Class LPEliminaSecuenciaProcesos
Si accion = ""{
Invoca a LPMantieneSecuenciaProcesos cambiando la accion = "muestraBorrado"
}
***************************************************************************************************/
