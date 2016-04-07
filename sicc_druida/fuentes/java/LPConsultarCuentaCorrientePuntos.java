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
 * Componente:        LPConsultarCuentaCorrientePuntos
 * Fecha:             20/04/2005
 * Observaciones:     
 * @version           1.0
 * @author            Igor Dedoukh
 * ult. modif.:       
 */

public class LPConsultarCuentaCorrientePuntos extends LPSICCBase {

	public LPConsultarCuentaCorrientePuntos() {

		super();
	}

    public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {
        
		setTrazaFichero();
	    try { 
		    this.rastreo();
	        traza("*********** Entre a LPConsultarCuentaCorrientePuntos");  	      
		    conectorAction("LPMantenerCuentaCorrientePuntos");
	        conectorActionParametro("opcionMenu", 
                                    "Consultar Cuenta Corriente Puntos"); 
            conectorActionParametro("accion", ""); 
		} catch ( Exception e ) { 
		    traza("Exception en LPConsultarCuentaCorrientePuntos");
	        e.printStackTrace();     
		    lanzarPaginaError(e);
	    }			
	}
}