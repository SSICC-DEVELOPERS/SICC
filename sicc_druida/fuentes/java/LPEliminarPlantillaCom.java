//$Id: LPEliminarPlantillaCom.java,v 1.1 2009/12/03 18:41:28 pecbazalar Exp $

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
 * Modulo:            COM
 * Subm�dulo:         Comisiones
 * Componente:        LP
 * Fecha:             03/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 */
 public class LPEliminarPlantillaCom extends LPSICCBase {

	public LPEliminarPlantillaCom() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPEliminarPlantillaCom");
		  conectorAction("LPPlantillaComisiones");
	      conectorActionParametro("opcionMenu", "eliminar"); 
  	      conectorActionParametro("accion", "eliminar"); 
		  conectorActionParametro("casoDeUso", "eliminar"); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPEliminarPlantillaCom");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}