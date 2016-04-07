/**
 * Copyright 2007 � por Indra Sistemas,S.A.. Todos los derechos reservados.
 * Avda. de Bruselas, 35
 * Parque Empresarial Arroyo de la Vega
 * 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * Autor: SPLATAS
 */

public class LPGestionarVerAsigProdAnaqueles extends LPSICCBase {

    public LPGestionarVerAsigProdAnaqueles() {	 
        super();
    }

    public void inicio() throws Exception { 
    }

    public void ejecucion() throws Exception {
        traza("     LPGestionarVerAsigProdAnaqueles.ejecucion(): Entrada ");    
        
        try {
            pagina("contenido_versiones_asignacion_anaqueles_gestionar");
            
            conectorAction("LPMantenerVerAsigProdAnaqueles");
            conectorActionParametro("accion", "");
            conectorActionParametro("opcionMenu", "gestionarVersiones");
           
        
        } catch (Exception e){   
          
          traza("       -SAP601: Pinch�....." + e);      
          this.lanzarPaginaError(e);
      
        }
      
        traza("     LPGestionarVerAsigProdAnaqueles.ejecucion(): Salida ");    
    }
   
}
