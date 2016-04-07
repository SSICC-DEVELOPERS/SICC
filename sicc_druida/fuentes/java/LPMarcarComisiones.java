/** 28108 Alcobendas, Madrid
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
 * Fecha:             16/03/2005
 * Observaciones:     Componente construido de acuerdo a la especificaci�n del
 *                    Modelo de Componentes
 *
 * @version           1.0
 * @author            idedough
 */

public class LPMarcarComisiones extends LPSICCBase 
{
	private String accion = null;
	public LPMarcarComisiones() { super(); }

	public void inicio() throws Exception { }  
      
	/*accion == "" { 
		Se llama a LPMantenimientoComisiones con accion = "MarcarComisiones" 
	 }
	*/
	public void ejecucion() throws Exception 
	{     
		setTrazaFichero();    
  		traza("************ Entre a LPMarcarComisiones");
		//accion = conectorParametroLimpia("accion", "", true);	    
		try
		{
			this.rastreo();
			traza("caso de uso = MarcarComisiones");
			//if("".equals(accion))
			//{
				conectorAction("LPMantenimientoComisiones");	
				conectorActionParametro("accion", "MarcarComisiones"); 
			//}
		}
		catch(Exception e)  {
		  traza("Exception en LPMarcarComisiones");
	      e.printStackTrace();     
		  lanzarPaginaError(e);
		} 
	}     
}
