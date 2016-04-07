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
/**
 * Sistema:           Belcorp
 * Modulo:            ZON
 * Subm�dulo:         Zonificaci�n
 * Componente:        LP
 * Fecha:             25/8/2004
 * Observaciones:     
 * @version           
 * @autor             Viviana Bongiovanni
 */

//$Id: LPEliminarUnidadesAdministrativas.java,v 1.1 2009/12/03 18:38:01 pecbazalar Exp $

import LPSICCBase;


public class LPEliminarUnidadesAdministrativas extends LPSICCBase{


	public LPEliminarUnidadesAdministrativas()  {
		super();
	}  

	public void inicio() throws Exception {
					
	}

    public void ejecucion() throws Exception{
		
      try{
			this.rastreo();

			conectorAction("LPCargaFichero");
			conectorActionParametro("accion","");		
			conectorActionParametro("casoDeUso","eliminarUnidadesAdministrativas");	

		} catch(Exception e){
             lanzarPaginaError(e);
        }
         
	 }
		 
}
