
import es.indra.druida.DruidaConector;
import es.indra.mare.common.mln.MareBusinessID;
import es.indra.sicc.util.DTOBelcorp;
import es.indra.sicc.util.DTOOID;
import es.indra.sicc.util.DTOSalida;
import es.indra.sicc.util.UtilidadesBelcorp;
import es.indra.sicc.util.UtilidadesSession;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.StringTokenizer;
import es.indra.sicc.dtos.ape.DTOChequeos;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElement;
import es.indra.sicc.cmn.cargaInicial.ComposerViewElementList;
import es.indra.sicc.cmn.cargaInicial.presentacion.ConectorComposerView;


public class LPLevantamientoChequeo extends LPSICCBase {        
    public LPLevantamientoChequeo () { super(); }
         private String accion = null;
         private Long pais = null;     
         private Long idioma = null;
         public void inicio() throws Exception { }
  
    public void ejecucion() throws Exception {
                  setTrazaFichero();
                  traza("LPLevantamientoChequeo.ejecucion() - Entrada");

         accion = conectorParametroLimpia("accion", "", true);
             pais = UtilidadesSession.getPais(this);
                  idioma = UtilidadesSession.getIdioma(this);

                  traza("**** accion : " + accion);
                  traza("**** pais : " + pais);
                  traza("**** idioma : " + idioma);
             
                  try  {			
                           if (accion.equals("")) {
                                    cargarPagina(); 
                           }else if(accion.equals("levantar")) {
                                    traza("accion levantar");         
                                    levantar();
                           }	
                           
                           
                           traza("LPLevantamientoChequeo.ejecucion() - Salida");
                  }
                  catch ( Exception e )  {			
							e.printStackTrace();
                           traza("Exception en LPLevantamientoChequeo");
                           traza(e);
                           lanzarPaginaError(e);
             }
         }

         public void cargarPagina() throws Exception {
                  traza("LPLevantamientoChequeo.cargarPagina() - Entrada");		
                  pagina("contenido_levantamiento_chequeo"); 
                  this.getFormatosValidaciones();
            
                     DTOBelcorp dtoBel = new DTOBelcorp();
                     dtoBel.setOidPais(pais);
                     dtoBel.setOidIdioma(idioma);
                     
                     ComposerViewElementList cv = new ComposerViewElementList();
            
                     ComposerViewElement cbMarca = new ComposerViewElement();
                     cbMarca.setIDBusiness("SEGConsultaMarcas");
                     cbMarca.setDTOE(dtoBel);
            
                     ComposerViewElement cbCanales = new ComposerViewElement();
                     cbCanales.setIDBusiness("SEGConsultaCanales");
                     cbCanales.setDTOE(dtoBel);
                     
                     cv.addViewElement(cbMarca);
                     cv.addViewElement(cbCanales);   
                     
            
                     ConectorComposerView conector = new ConectorComposerView(cv, this.getRequest());
                     conector.ejecucion();
                     DruidaConector resultados = conector.getConector();
            
                     this.asignarAtributoPagina("cod","3150");
                     this.getConfiguracionMenu("LPLevantamientoChequeo");
                     this.asignar("COMBO","cbMarca",resultados,"SEGConsultaMarcas");                  
                     this.asignar("COMBO","cbCanal",resultados,"SEGConsultaCanales");
         
                  

                  asignarAtributo("VAR", "accion", "valor", accion);
                  asignarAtributo("VAR", "pais", "valor", pais.toString());
                  asignarAtributo("VAR", "idioma", "valor", idioma.toString());
                  traza("LPLevantamientoChequeo.cargarPagina() - Salida");		
         }
         
      public void levantar() throws Exception {
              traza("LPLevantamientoChequeo.levantar() - Entrada");		

             pagina("salidaGenerica");
; 

    		try{		 
             pais = Long.valueOf(conectorParametroLimpia("pais", "", true));
             idioma = Long.valueOf(conectorParametroLimpia("idioma", "", true));
             traza("pais "+pais+" idioma "+idioma);		
             DTOChequeos dtoC = new DTOChequeos();
			
			 dtoC.setUsuario(UtilidadesSession.getIdUsuario(this));

             String nroConsolidado = conectorParametroLimpia("hConsolidado", "", true);
             traza("nroConsolidado "+nroConsolidado);		
             if(!nroConsolidado.equals("")){
                dtoC.setNroConsolidado(new Long(nroConsolidado));
             }
             String oidCanal = conectorParametroLimpia("hCanal", "", true);
             traza("oidCanal "+oidCanal);	
             if(!oidCanal.equals("")){
                dtoC.setOidCanal(new Long(oidCanal));
             }
             String  oidMarca = conectorParametroLimpia("hMarca", "", true);
             traza("oidMarca "+oidMarca);	
             if(!oidMarca.equals("")){
                dtoC.setOidMarca(new Long(oidMarca));
             }
             String oidRegion = conectorParametroLimpia("hRegion", "", true);
             traza("oidRegion "+oidRegion);
             if(!oidRegion.equals("")){
                dtoC.setOidRegion(new Long(oidRegion));
             }
             String oidZona = conectorParametroLimpia("hZona", "", true);
             traza("oidZona "+oidZona);
             if(!oidZona.equals("")){
                dtoC.setOidZona(new Long(oidZona));
             }
             String oidSeccion = conectorParametroLimpia("hSeccion", "", true);
             traza("oidSeccion "+oidSeccion);
             if(!oidSeccion.equals("")){
                dtoC.setOidSeccion(new Long(oidSeccion));
             }
             String manual = conectorParametroLimpia("hManual", "", true);
             traza("manual "+manual);
             dtoC.setManual(manual.toString().equals("S")?Boolean.TRUE:Boolean.FALSE);
             
             String pedido = conectorParametroLimpia("hPedido", "", true);
             traza("pedido "+pedido);
             dtoC.setPedido(pedido.toString().equals("S")?Boolean.TRUE:Boolean.FALSE);
             
             String reclamo = conectorParametroLimpia("hReclamo", "", true);
             traza("reclamo "+reclamo);
             dtoC.setReclamo(reclamo.toString().equals("S")?Boolean.TRUE:Boolean.FALSE);
             
             dtoC.setOidIdioma(idioma);
             dtoC.setOidPais(pais);

			     
				 Vector params = new Vector();
				 params.add(dtoC);
				 params.add(new MareBusinessID("APERealizarLevantamientoChequeo"));
				 traza("LPLevantamientoChequeo.levantar(): Invocamos a Levantar");
				 DruidaConector conector = conectar("ConectorRealizarLevantamientoChequeo", params);

			}catch ( Exception e )  {			
				e.printStackTrace();
			   traza("Exception en LPLevantamientoChequeo");
			   traza(e);
			   lanzarPaginaError(e);
			   asignarAtributo("VAR", "ejecutar", "valor", "mostrarError();");
            }
			asignar("VAR", "ejecutar", "flimpiar();");

            traza("LPLevantamientoChequeo.levantar() - Salida");		
       }
         

}
