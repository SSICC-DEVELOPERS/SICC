/** 
 * Copyright 2003 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Cochabamba 2552 8� Piso
 * Capital Federal, Buenos Aires
 * Argentina
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 */

public class LPGenerarLiquidacionComisionesCobranza extends LPSICCBase {

              
    public LPGenerarLiquidacionComisionesCobranza() {      
         super();
    }

    public void inicio() throws Exception { 
         
    }

    public void ejecucion() throws Exception{
                  
      try{
		   //this.rastreo();

		   conectorAction("LPConsultarSimulacionLiquidacion");
		   conectorActionParametro("accion","generarLiquidacion");

	   } catch(Exception e){
			lanzarPaginaError(e);
       }
          
    }                      
    
}

