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
/**
 * Sistema:           Belcorp
 * Modulo:            ZON
 * Submódulo:         Zonificación
 * Componente:        LP
 * Fecha:             25/8/2004
 * Observaciones:     
 * @version           
 * @autor             Viviana Bongiovanni
 */

//$Id: LPCrearUnidadesAdministrativas.java,v 1.1 2009/12/03 18:39:21 pecbazalar Exp $

import LPSICCBase;


public class LPCrearUnidadesAdministrativas extends LPSICCBase{


	public LPCrearUnidadesAdministrativas()  {
		super();
	}  

	public void inicio() throws Exception {
					
	}

    public void ejecucion() throws Exception{
		
      try{
			this.rastreo();

			conectorAction("LPCargaFichero");
			conectorActionParametro("accion","");		
			conectorActionParametro("casoDeUso","crearUnidadesAdministrativas");	

		} catch(Exception e){
             lanzarPaginaError(e);
        }
         
	 }
		 
}
