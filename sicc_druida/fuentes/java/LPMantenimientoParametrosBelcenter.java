
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;
import es.indra.sicc.dtos.bel.DTOCopiarParametrosBelcenter;
import es.indra.druida.DruidaConector;
import es.indra.sicc.util.DTOOID;
import java.util.Vector;
import es.indra.sicc.util.DTOBoolean;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;


public class LPMantenimientoParametrosBelcenter extends LPSICCBase {		

	public LPMantenimientoParametrosBelcenter() {	 
     super();
  }

	public void inicio() throws Exception { 
     //pagina("contenido_territorio_seleccionar"); 
  }

	public void ejecucion() throws Exception {		
     String accion = conectorParametroLimpia("accion","", true);
     setTrazaFichero();
     try {
        traza("la accion es " + accion);
        if(accion.equals("")){
           cargarPagina();
        }

        if(accion.equals("copiar")){
           copiar();  
        }

        if(accion.equals("copiarOk")){
           copiarOk();
           cargarPagina();

        }

     } catch (Exception ex) {

				ByteArrayOutputStream stack = new ByteArrayOutputStream();
				PrintStream out = new PrintStream(stack);
				ex.printStackTrace(out);
				traza("EXCEPCION:" + stack.toString());
				lanzarPaginaError(ex);

     }

     getConfiguracionMenu();
  }

  private void cargarPagina() throws Exception{
     pagina("contenido_parametros_belcenter_copiar");
     
     DTOBelcorp dtoe = new DTOBelcorp();

     dtoe.setOidPais( UtilidadesSession.getPais( this ) );
     dtoe.setOidIdioma( UtilidadesSession.getIdioma( this ) );
        
     ComposerViewElementList lista = new ComposerViewElementList();
    
     ComposerViewElement elem = null;
     elem = new ComposerViewElement();
     elem.setIDBusiness("SEGConsultaCanales");
     elem.setDTOE( dtoe );
     lista.addViewElement( elem );

     ConectorComposerView conector = null;
     DruidaConector resultados = null;
       
     conector = new ConectorComposerView(lista, this.getRequest());
     conector.ejecucion();

     resultados = null;
     resultados = conector.getConector();

     asignar("COMBO", "cbCanal", resultados, "SEGConsultaCanales");
     asignarAtributo("VAR", "hIdioma", "valor", UtilidadesSession.getIdioma( this ).toString());
     asignarAtributo("VAR", "hPais", "valor", UtilidadesSession.getPais( this ).toString());
  }

  private void copiar()throws Exception{
     pagina("salidaGenerica");

     DTOOID dto = new DTOOID();
     DTOBoolean dtob = null;
     
     String sbacDestino = conectorParametroLimpia("cbSubaccesoDestino", "", true);
     DruidaConector con = null;
     
     dto.setOid(new Long(sbacDestino));
     dto.setOidPais(UtilidadesSession.getPais(this));
     
     MareBusinessID id = new MareBusinessID("BELComprobarParametrizacionSubacceso");
     
     Vector param = new Vector();
     
     param.add(dto);
     param.add(id);
     
     con = conectar("ConectorComprobarParametrizacionSubacceso",param);
     
     if( con != null ){
        dtob = (DTOBoolean)con.objeto( "DTOSalida" );

        if(dtob.getValor()){
           asignarAtributo("VAR", "ejecutar", "valor", "confirmarCopia()");
        }else{
           copiarOk();
		   asignarAtributo("VAR", "ejecutar", "valor", "limpiarPagina()");
        }
     }
  }

  private void copiarOk() throws Exception{
     String sbacOrigen  = conectorParametroLimpia("cbSubaccesoOrigen", "", true);
     String sbacDestino = conectorParametroLimpia("cbSubaccesoDestino", "", true);
     DruidaConector con = null;

     MareBusinessID id = new MareBusinessID("BELCopiarParametrosBelcenter");

     DTOCopiarParametrosBelcenter dto = new DTOCopiarParametrosBelcenter();

     dto.setOidSubaccesoOrigen(new Long(sbacOrigen));
     dto.setOidSubaccesoDestino(new Long(sbacDestino));
     dto.setOidPais(UtilidadesSession.getPais(this));

     Vector param = new Vector();

     param.add(dto);
     param.add(id);

     traza("antes de ir a copiar");
     traza("el dto " + dto);
     con = conectar("ConectorCopiarParametrosBelcenter",param);

     traza("despues de copiar");
     
  }
    
}
