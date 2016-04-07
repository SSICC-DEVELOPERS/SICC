/** 28108 Alcobendas, Madrid
 * España
 *
 * Privado y Confidencial.
 * La información contenida en este documento es propiedad de Indra sistemas.
 * Para uso exclusivo de empleados autorizados no permitiéndose
 * la distribución de este código sin permiso expreso.
 *
 * Sistema:           Belcorp
 * Modulo:            INC
 * Submódulo:         ###
 * Componente:        LPMantenerCuentaCorrientePuntos
 * Fecha:             20/04/2005
 * Observaciones:     
 * @version           1.0
 * @author            Igor Dedoukh
 * ult. modif.:       
 */
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import es.indra.sicc.dtos.inc.DTOBuscarNumConcurso;

public class LPMantenerCuentaCorrientePuntos extends LPSICCBase {    
	private String accion = null;
	private String sPais = null;     
	private String sIdioma = null;
	private String sDescPais = null;     
	private Long lIdioma = null;
	private Long lPais = null;
	
	public LPMantenerCuentaCorrientePuntos() {  super(); }

    public void inicio() throws Exception {}
	
	public void ejecucion() throws Exception {        
		setTrazaFichero();
	    try { 
		    this.rastreo();
	        traza("*********** Entre a LPMantenerCuentaCorrientePuntos"); 

			accion = conectorParametroLimpia("accion", "", true);
		    lIdioma = UtilidadesSession.getIdioma(this);
		    lPais = UtilidadesSession.getPais(this);

   		    traza("************ accion: " + accion); 
   		    traza("************ lIdioma: " + lIdioma); 
   		    traza("************ lPais: " + lPais); 
		    
			if (accion != null && accion.length() == 0) {
			    cargarPantalla();
		    }
		}
		catch ( Exception e )	{ 
		    traza("Exception en LPMantenerCuentaCorrientePuntos");
		    ByteArrayOutputStream pila = new ByteArrayOutputStream();
		    PrintStream out = new PrintStream(pila);
		    e.printStackTrace(out);
		    traza("EL STACK ES COMO SIGUE : " +  pila.toString());
	        e.printStackTrace();
		    e.getMessage();
		    lanzarPaginaError(e);
	    }
		getConfiguracionMenu();
	}

	public void cargarPantalla() throws Exception {          
	    pagina("contenido_cuenta_corriente_puntos_consultar");                

		asignarAtributo("VAR", "accion", "valor", accion);
		asignarAtributo("VAR", "oidPais", "valor", lPais.toString());
		asignarAtributo("VAR", "oidIdioma", "valor", lIdioma.toString());
		
		//Modificado por Cristian Valenzuela 11/7/2005
		//INC 19746
		DTOBuscarNumConcurso dtobn = new DTOBuscarNumConcurso();
		dtobn.setOidPais(lPais);
		dtobn.setOidIdioma(lIdioma);
		//dtobn.setIndActivo(new Integer(2));
		//Agregado por Cristian Valenzuela 18/8/2005
		//dtobn.setIndRanking(new Integer(2));
		//Agregado por Cristian Valenzuela 18/8/2005
		
		ComposerViewElementList cvel = new ComposerViewElementList();
		ComposerViewElement cve = new ComposerViewElement();
		cve.setIDBusiness("INCCargarNroConcurso");
		cve.setDTOE(dtobn);
		cvel.addViewElement(cve);
		
		ConectorComposerView conector = new ConectorComposerView(cvel, this.getRequest());
        conector.ejecucion();
		DruidaConector con = conector.getConector();

        asignar("COMBO", "cbNumeroConcurso", con, "INCCargarNroConcurso");
    }
}