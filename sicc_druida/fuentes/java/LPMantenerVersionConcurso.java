/** 28108 Alcobendas, Madrid
 * Espa�a
 *
 * Privado y Confidencial.
 * La informaci�n contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permiti�ndose
 * la distribuci�n de este c�digo sin permiso expreso.
 *
 * Sistema:           Belcorp
 * Modulo:            INC
 * Subm�dulo:         ###
 * Componente:        LPMantenerVersionConcurso
 * Fecha:             20/04/2005
 * Observaciones:     
 * @version           1.00 20 abr 2005
 * @author            Igor Dedoukh
 * ult. modif.:       
 */

public class LPMantenerVersionConcurso extends LPSICCBase {

	public LPMantenerVersionConcurso() {

		super();
	}

    public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {
        
		setTrazaFichero();
	    try	{ 
		    this.rastreo();
	        traza("*********** Entre a LPMantenerVersionConcurso");  	      
		    conectorAction("LPMantenimientoVersiones");
	        conectorActionParametro("opcionMenu", "Mantener Version"); 
            conectorActionParametro("accion", ""); 
		} catch ( Exception e ) { 
		    traza("Exception en LPMantenerVersionConcurso");
	        e.printStackTrace();     
		    lanzarPaginaError(e);
	    }			
	}
}