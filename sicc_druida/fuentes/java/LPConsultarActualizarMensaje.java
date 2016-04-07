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

//import LPSICCBase;

import es.indra.mare.common.exception.MareException;
import es.indra.druida.DruidaConector;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


public class LPConsultarActualizarMensaje extends LPSICCBase
{
    public LPConsultarActualizarMensaje(){
			super();
	} 
	
	 public void inicio() throws Exception {
        }

	 public void ejecucion() throws Exception {
        this.rastreo();
        setTrazaFichero();
		 try
		 {

			//Llama a la LPMensaje con 
			//- accion="Consultar Mensaje"
			conectorAction("LPMensaje");
            conectorActionParametro("accion","Consultar Mensaje");

		 }
		 catch (Exception ex)
             {
				 ex.printStackTrace();
                 this.lanzarPaginaError(ex);
             }
	 }
	 
}
