/** 28108 Alcobendas, Madrid
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
 * Fecha:             16/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificación del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            idedough
 */

public class LPAceptarModificacion extends LPSICCBase 
{
	public LPAceptarModificacion() { super(); }
	public void inicio() throws Exception { }    
    
	/*accion == "" { 
		Se llama a LPMantenimientoComisiones con accion = "AceptarModificacion" 
		}
	*/
	public void ejecucion() throws Exception 
	{     
		setTrazaFichero();
	    try  {
		  this.rastreo();
	      traza("*********** Entre a LPAceptarModificacion");  	      
		  conectorAction("LPMantenimientoComisiones");
	      //conectorActionParametro("opcionMenu", "eliminar"); 
          conectorActionParametro("accion", "AceptarModificacion"); 
		  //conectorActionParametro("casoDeUso", "eliminar"); 
		}
	    catch ( Exception e )  {
		  traza("Exception en LPAceptarModificacion");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
	    }
	}     
}
