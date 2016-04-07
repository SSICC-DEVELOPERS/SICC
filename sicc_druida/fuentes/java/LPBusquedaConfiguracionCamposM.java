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
    $Id: LPBusquedaConfiguracionCamposM.java,v 1.1 2009/12/03 18:34:35 pecbazalar Exp $
    DESC
 */
/**
 * Sistema:           Belcorp
 * Modulo:            MAE
 * Submódulo:         
 * Componente:        LP
 * Fecha:             22/01/2004
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes SICC-DMCO-MAE-201-303
 *                    (Subido al portal el 23/12/2003)
 * @version           1.0
 * @autor             Andrés Pollitzer
 */ 

import LPSICCBase;

public class LPBusquedaConfiguracionCamposM extends LPSICCBase {

	public LPBusquedaConfiguracionCamposM() {
		super();
	}


	public void inicio() throws Exception {
		pagina("contenido_campos_parametrizables_modificar");
	}

	public void ejecucion() throws Exception {
    setTrazaFichero();
    try  {
      rastreo();
        traza("Caso de Uso = Modificar");
      conectorAction("LPBusquedaConfiguracionCampos");
      conectorActionParametro("hCasoDeUso", "Modificar");
    }
    catch ( Exception e )  {
      e.printStackTrace();
      lanzarPaginaError(e);
    }

  }



}//fin clase
