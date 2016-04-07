//$Id: LPConsultarPlantillaCom.java,v 1.1 2009/12/03 18:41:20 pecbazalar Exp $

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
 * Modulo:            COM
 * Submódulo:         Comisiones
 * Componente:        LP
 * Fecha:             03/02/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            Marta Aurora Montiel
 */

 public class LPConsultarPlantillaCom extends LPSICCBase {

	public LPConsultarPlantillaCom() {	super(); }

    public void inicio() throws Exception {	}
  
	public void ejecucion() throws Exception {
    
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPConsultarPlantillaCom");
		  conectorAction("LPPlantillaComisiones");
	      conectorActionParametro("opcionMenu", "consultar"); 
  	      conectorActionParametro("accion", "consultar"); 
		  conectorActionParametro("casoDeUso", "consultar"); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPConsultarPlantillaCom");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}
}